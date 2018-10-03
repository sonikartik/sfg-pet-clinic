package guru.springframework.model.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"", "/index", "/index.html"})
    public String listOfOwners(){
        return "owners/index";
    }
}
