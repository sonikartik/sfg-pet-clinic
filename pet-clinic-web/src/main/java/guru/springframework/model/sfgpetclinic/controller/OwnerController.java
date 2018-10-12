package guru.springframework.model.sfgpetclinic.controller;

import guru.springframework.model.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOfOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
    @RequestMapping({"/find", "/find/"})
    public String findOwner(Model model) {
        return "notImplementedYet";
    }
}
