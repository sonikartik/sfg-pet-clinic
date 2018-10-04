package guru.springframework.model.guru.springframework.service;

import guru.springframework.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
