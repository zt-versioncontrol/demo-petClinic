package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Specialty;
import demo.springframework.demopetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMapService extends AbstractMapService<Specialty> implements SpecialtyService {
}
