package fr.esaip;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {}

    public Fish(Date birth, String couleur, FishLivEnv livingEnv, PetStore petStore) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    // Getters & Setters
    public FishLivEnv getLivingEnv() { return livingEnv; }
    public void setLivingEnv(FishLivEnv livingEnv) { this.livingEnv = livingEnv; }
}