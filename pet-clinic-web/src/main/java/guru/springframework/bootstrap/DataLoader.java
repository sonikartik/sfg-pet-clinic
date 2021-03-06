package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.service.OwnerService;
import guru.springframework.service.PetTypeService;
import guru.springframework.service.SpecialityService;
import guru.springframework.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        Speciality radioligy = new Speciality();
        radioligy.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        specialityService.save(radioligy);
        specialityService.save(surgery);
        specialityService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = (PetType) petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = (PetType) petTypeService.save(cat);

        System.out.println("Loaded PetType....");

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Kartik");
        owner1.setLastName("Soni");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1223242322");

        Pet kartiksPet = new Pet();
        kartiksPet.setPetType(dog);
        kartiksPet.setOwner(owner1);
        kartiksPet.setBirthDate(LocalDate.now());
        kartiksPet.setName("Rosco");
        owner1.getPets().add(kartiksPet);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Poonam");
        owner2.setLastName("Soni");
        owner2.setAddress("360 Gran Via");
        owner2.setCity("Irving");
        owner2.setTelephone("12445323523");
        Pet poonamsPet = new Pet();
        poonamsPet.setPetType(cat);
        poonamsPet.setOwner(owner2);
        poonamsPet.setBirthDate(LocalDate.now());
        poonamsPet.setName("Mini");
        owner2.getPets().add(poonamsPet);


        Owner owner3 = new Owner();
        //owner3.setId(3L);
        owner3.setFirstName("Vrishika");
        owner3.setLastName("Soni");
        owner3.setAddress("360 Gran Via");
        owner3.setCity("Irving");
        owner3.setTelephone("12445323523");

        Pet vrishisPet = new Pet();
        vrishisPet.setPetType(dog);
        vrishisPet.setOwner(owner3);
        vrishisPet.setBirthDate(LocalDate.now());
        vrishisPet.setName("Michale");
        owner3.getPets().add(vrishisPet);

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);
        System.out.println("Loaded Owners...");

        Vet v1 = new Vet(), v2 = new Vet();
        //v1.setId(1L);
        v1.setFirstName("Sam");
        v1.setLastName("Sangal");
        v1.getSpecialities().add(radioligy);

        //v2.setId(2L);
        v2.setFirstName("Sangal");
        v2.setLastName("Sam");
        v2.getSpecialities().add(dentistry);

        vetService.save(v1);
        vetService.save(v2);

        System.out.println("Loaded Vet...");

    }
}
