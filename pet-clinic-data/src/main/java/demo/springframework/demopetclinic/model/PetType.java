package demo.springframework.demopetclinic.model;

public class PetType extends BaseEntity<Long>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
