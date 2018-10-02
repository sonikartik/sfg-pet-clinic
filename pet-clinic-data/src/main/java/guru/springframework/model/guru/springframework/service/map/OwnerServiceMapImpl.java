package guru.springframework.model.guru.springframework.service.map;

import guru.springframework.model.Owner;
import guru.springframework.model.guru.springframework.service.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

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
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findById(Long id) {
        return this.findById(id);
    }
}
