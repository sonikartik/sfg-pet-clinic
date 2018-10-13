package guru.springframework.model.service.map;

import guru.springframework.model.PetType;
import guru.springframework.model.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapServiceImpl extends AbstractMapService<PetType, Long> implements CrudService<PetType, Long> {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType t) {
        super.delete(t);
    }

    @Override
    public PetType save(PetType t) {
        return super.save(t);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
