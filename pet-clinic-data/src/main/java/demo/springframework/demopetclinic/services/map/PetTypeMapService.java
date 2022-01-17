package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.PetType;
import demo.springframework.demopetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {
}
