package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Pet;
import demo.springframework.demopetclinic.repositories.PetRepository;
import demo.springframework.demopetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetJpaService extends AbstractJpaService<Pet> implements PetService{

    PetJpaService(PetRepository petRepository){
        super(petRepository);
    }
}
