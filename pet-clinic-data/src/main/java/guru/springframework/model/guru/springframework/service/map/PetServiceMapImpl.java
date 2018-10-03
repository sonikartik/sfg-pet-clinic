package guru.springframework.model.guru.springframework.service.map;

import guru.springframework.model.Pet;
import guru.springframework.model.guru.springframework.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet t) {
        super.delete(t);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
