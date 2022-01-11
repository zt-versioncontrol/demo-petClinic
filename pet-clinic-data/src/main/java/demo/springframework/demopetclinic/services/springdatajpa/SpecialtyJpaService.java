package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Specialty;
import demo.springframework.demopetclinic.repositories.SpecialtyRepository;
import demo.springframework.demopetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService extends AbstractJpaService<Specialty> implements SpecialtyService {

    public SpecialtyJpaService(SpecialtyRepository specialtyRepository) {
        super(specialtyRepository);
    }
}
