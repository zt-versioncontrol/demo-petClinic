package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Visit;
import demo.springframework.demopetclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
            visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){

            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }
}
