package guru.springframework.model.guru.springframework.service;

import guru.springframework.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet vet);
    Set<Pet> findAll();
}
