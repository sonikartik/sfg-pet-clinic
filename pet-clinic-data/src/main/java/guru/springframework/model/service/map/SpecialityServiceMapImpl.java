package guru.springframework.model.service.map;

import guru.springframework.model.Speciality;
import guru.springframework.model.service.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMapImpl extends AbstractMapService<Speciality, Long> implements SpecialityService<Speciality, Long> {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality t) {
        super.delete(t);
    }

    @Override
    public Speciality save(Speciality t) {
        return super.save(t);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
