package guru.springframework.repository;

import guru.springframework.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
