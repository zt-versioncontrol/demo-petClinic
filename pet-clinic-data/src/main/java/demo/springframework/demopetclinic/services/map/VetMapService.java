package demo.springframework.demopetclinic.services.map;

import demo.springframework.demopetclinic.model.Specialty;
import demo.springframework.demopetclinic.model.Vet;
import demo.springframework.demopetclinic.services.SpecialtyService;
import demo.springframework.demopetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet){

        if (vet != null) {
            if (vet.getSpecialties() != null) {
                Consumer<Specialty> consumer = (specialty) -> {
                    if (specialty.getId() == null) {
                        specialtyService.save(specialty);
                    }
                };

                vet.getSpecialties().forEach(consumer);
            }

        }
        return super.save(vet);
    }
}