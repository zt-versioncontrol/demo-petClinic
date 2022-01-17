package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Pet;
import demo.springframework.demopetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet> implements PetService {
}
