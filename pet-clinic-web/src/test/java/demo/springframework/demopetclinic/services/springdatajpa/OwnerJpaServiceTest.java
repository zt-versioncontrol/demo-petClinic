package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Owner;
import demo.springframework.demopetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LASTNAME_1 = "lastname1";
    @InjectMocks
    OwnerJpaService ownerJpaService;

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastname(){
        Owner persistedOwner = Owner.builder().id(1L).lastName(LASTNAME_1).build();

        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(persistedOwner);

        Owner owner = ownerJpaService.findByLastName(LASTNAME_1);

        assertEquals(LASTNAME_1, owner.getLastName());
        Mockito.verify(ownerRepository).findByLastName(Mockito.any());
    }

    @Test
    void findById(){
        Owner persistedOwner = Owner.builder().id(1L).build();


        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(persistedOwner));

        Owner owner = ownerJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound(){
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Owner owner = ownerJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void findAll(){
        Set<Owner> persistedOwnerSet = new HashSet<>();
        persistedOwnerSet.add(new Owner());
        persistedOwnerSet.add(new Owner());

        Mockito.when(ownerRepository.findAll()).thenReturn(persistedOwnerSet);

        Set<Owner> owners = ownerJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void save(){
        Owner newOwner = new Owner();

        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(newOwner);

        Owner savedOwner = ownerJpaService.save(newOwner);

        assertNotNull(savedOwner);
        Mockito.verify(ownerRepository).save(Mockito.any());
    }

    @Test
    void delete(){
        Owner owner = new Owner();

        ownerJpaService.delete(owner);

        //default is one 1 time, second argument is not ncessary
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById(){
        ownerJpaService.deleteById(1L);

        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
    }


}