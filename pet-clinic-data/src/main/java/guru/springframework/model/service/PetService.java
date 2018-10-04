package guru.springframework.model.service;

import guru.springframework.model.Pet;

public interface PetService<Pet, Long> extends CrudService<Pet, Long> {
}
