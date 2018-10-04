package guru.springframework.model.sfgpetclinic.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.model.service.OwnerService;
import guru.springframework.model.service.PetTypeService;
import guru.springframework.model.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Poonam");
        owner2.setLastName("Soni");

        Owner owner3 = new Owner();
        //owner3.setId(3L);
        owner3.setFirstName("Vrishika");
        owner3.setLastName("Soni");
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
