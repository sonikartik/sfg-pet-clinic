package guru.springframework.service.map;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.service.OwnerService;
import guru.springframework.service.PetService;
import guru.springframework.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMapImpl(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner t) {
        super.delete(t);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null) {
            if(owner.getPets() != null && !owner.getPets().isEmpty()) {
                owner.getPets().forEach(pet -> {
                    if(pet.getPetType() != null) {
                        if(pet.getPetType().getId() != null) {
                            pet.setPetType((PetType) petTypeService.save(pet.getPetType()));

                        }
                    } else {
                        throw new RuntimeException("PEt Type is required.");
                    }
                    if(pet.getId() == null) {
                        Pet savedPet = (Pet) petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        }
        return super.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return this.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
