package fr.esaip;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PetStore {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String managerName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private List<Animal> animals;
    public PetStore() {}

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }
}
