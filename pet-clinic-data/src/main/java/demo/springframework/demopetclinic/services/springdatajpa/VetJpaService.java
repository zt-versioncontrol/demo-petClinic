package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Vet;
import demo.springframework.demopetclinic.repositories.VetRepository;
import demo.springframework.demopetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetJpaService extends AbstractJpaService<Vet> implements VetService{

    public VetJpaService(VetRepository vetRepository) {
        super(vetRepository);
    }
}
