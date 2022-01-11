package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Specialty;
import demo.springframework.demopetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty> implements SpecialtyService {
}
