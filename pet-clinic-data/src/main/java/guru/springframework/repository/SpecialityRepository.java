package guru.springframework.repository;

import guru.springframework.model.Speciality;
import org.springframework.data.repository.CrudRepository;


public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
