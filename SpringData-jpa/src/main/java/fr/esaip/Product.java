package fr.esaip;


import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private double price;

    @ManyToOne
    private PetStore petStore;

    public Product() {}

    public Product(String code, String label, ProdType type, double price, PetStore petStore) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStore = petStore;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public ProdType getType() { return type; }
    public void setType(ProdType type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public PetStore getPetStore() { return petStore; }
    public void setPetStore(PetStore petStore) { this.petStore = petStore; }
}