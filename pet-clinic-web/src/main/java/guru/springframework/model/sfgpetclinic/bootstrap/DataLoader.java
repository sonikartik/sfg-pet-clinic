package guru.springframework.model.sfgpetclinic.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.model.service.OwnerService;
import guru.springframework.model.service.PetTypeService;
import guru.springframework.model.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
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

        //v2.setId(2L);
        v2.setFirstName("Sangal");
        v2.setLastName("Sam");

        vetService.save(v1);
        vetService.save(v2);

        System.out.println("Loaded Vet...");

    }
}
