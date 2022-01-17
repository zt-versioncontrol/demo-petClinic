package demo.springframework.demopetclinic.services.springdatajpa;

import demo.springframework.demopetclinic.model.Visit;
import demo.springframework.demopetclinic.repositories.VisitRepository;
import demo.springframework.demopetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitJpaService extends AbstractJpaService<Visit> implements VisitService {

    public VisitJpaService(VisitRepository visitRepository) {
        super(visitRepository);
    }
}
