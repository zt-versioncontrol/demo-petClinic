package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.PetType;
import demo.springframework.demopetclinic.repositories.PetTypeReposiroty;
import demo.springframework.demopetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("springdatajpa")
public class PetTypeJpaService extends AbstractJpaService<PetType> implements PetTypeService{

    public PetTypeJpaService(PetTypeReposiroty petTypeReposiroty) {
        super(petTypeReposiroty);
    }
}
