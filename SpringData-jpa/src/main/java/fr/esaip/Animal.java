package fr.esaip;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date birth;
    private String couleur;

    @ManyToOne
    private PetStore petStore;

    public Animal() {}

    public Animal(Date birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getBirth() { return birth; }
    public void setBirth(Date birth) { this.birth = birth; }

    public String getCouleur() { return couleur; }
    public void setCouleur(String couleur) { this.couleur = couleur; }

    public PetStore getPetStore() { return petStore; }
    public void setPetStore(PetStore petStore) { this.petStore = petStore; }
}