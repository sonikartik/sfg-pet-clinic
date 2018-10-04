package guru.springframework.model.service.map;

import guru.springframework.model.Pet;
import guru.springframework.model.service.CrudService;
import guru.springframework.model.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService<Pet, Long> {
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
        return super.save(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
