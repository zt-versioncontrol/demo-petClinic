package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.PetType;
import demo.springframework.demopetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {
}
