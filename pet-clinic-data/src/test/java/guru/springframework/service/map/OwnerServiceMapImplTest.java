package guru.springframework.service.map;

import guru.springframework.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapImplTest {
    OwnerServiceMapImpl ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMapImpl(new PetTypeMapServiceImpl(), new PetServiceMapImpl());
        ownerServiceMap.save(Owner.builder().id(1L).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).build();
        Owner saveOwner = ownerServiceMap.save(owner);
        assertEquals(2L,  saveOwner.getId().longValue());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());

    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("foo");
        assertNull(owner);
    }
}