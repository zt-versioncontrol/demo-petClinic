package demo.springframework.demopetclinic.bootstrap;

import demo.springframework.demopetclinic.model.Owner;
import demo.springframework.demopetclinic.model.Vet;
import demo.springframework.demopetclinic.services.OwnerService;
import demo.springframework.demopetclinic.services.VetService;
import demo.springframework.demopetclinic.services.map.OwnerServiceMap;
import demo.springframework.demopetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Vets...");
        Vet vet1 = new Vet();
        vet1.setFirstName("vet1 firstName");
        vet1.setLastName("vet1 lastName");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet2 firstName");
        vet2.setLastName("vet2 lastName");
        vetService.save(vet2);
        System.out.println("Finished Loading Vets");


        System.out.println("Loading Owners...");
        Owner owner1 = new Owner();
        owner1.setFirstName("owner1 firstName");
        owner1.setLastName("owner1 lastName");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("owner2 firstName");
        owner2.setLastName("owner2 lastName");
        ownerService.save(owner2);
        System.out.println("Finished Loading Owners");
    }
}