package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    final long FIRST_ID = 1L;
    final long SECOND_ID = 2L;
    final String LASTNAME1 = "lastname1";

    OwnerMapService ownerMapService;


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        ownerMapService.save(Owner.builder().lastName(LASTNAME1).build());
    }

    @Test
    void findById(){
        Owner owner = ownerMapService.findById(FIRST_ID);
        assertEquals(FIRST_ID, owner.getId());
    }

    @Test
    void findAll(){
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void save() {
        Owner owner2 = ownerMapService.save(new Owner());
        assertEquals(SECOND_ID, owner2.getId());
    }

    @Test
    void deleteById(){
        ownerMapService.deleteById(FIRST_ID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete(){
        ownerMapService.delete(ownerMapService.findById(FIRST_ID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(LASTNAME1);
        assertEquals(LASTNAME1, owner.getLastName());
        assertEquals(1, owner.getId());
    }

    @Test
    void findByLastNameNotFound(){
        Owner owner = ownerMapService.findByLastName("xxxxx");
        assertNull(owner);
    }
}