package fr.esaip;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Cat extends Animal {
    private String chipId;

    public Cat() {}

    public Cat(Date birth, String couleur, String chipId, PetStore petStore) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

    // Getters & Setters
    public String getChipId() { return chipId; }
    public void setChipId(String chipId) { this.chipId = chipId; }
}