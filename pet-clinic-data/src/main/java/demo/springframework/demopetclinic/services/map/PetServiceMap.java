package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Pet;
import demo.springframework.demopetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {
}
