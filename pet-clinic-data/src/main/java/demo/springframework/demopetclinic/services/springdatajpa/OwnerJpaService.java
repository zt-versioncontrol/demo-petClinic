package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Owner;
import demo.springframework.demopetclinic.repositories.OwnerRepository;
import demo.springframework.demopetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerJpaService extends AbstractJpaService<Owner> implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerJpaService(OwnerRepository ownerRepository) {
        super(ownerRepository);
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
