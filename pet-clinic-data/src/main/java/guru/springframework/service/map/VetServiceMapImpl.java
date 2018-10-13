package guru.springframework.service.map;

import guru.springframework.model.Speciality;
import guru.springframework.model.Vet;
import guru.springframework.service.SpecialityService;
import guru.springframework.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMapImpl(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if(vet != null && !CollectionUtils.isEmpty(vet.getSpecialities())) {
            vet.getSpecialities().forEach(speciality -> {
                Speciality savedSpeciality = (Speciality) specialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
