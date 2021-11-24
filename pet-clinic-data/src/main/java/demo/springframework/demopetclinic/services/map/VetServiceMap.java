package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Vet;
import demo.springframework.demopetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {
}