package guru.springframework.model.guru.springframework.service.map;

import guru.springframework.model.Vet;
import guru.springframework.model.guru.springframework.service.CrudService;

import java.util.Set;

public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet t) {
       super.delete(t);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}