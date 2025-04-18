package fr.esaip;

import jakarta.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //  Création des adresses
        Address addr1 = new Address("10", "Rue des Animaux", "75000", "Paris");
        Address addr2 = new Address("15", "Avenue des Chiens", "69000", "Lyon");
        Address addr3 = new Address("20", "Boulevard des Chats", "33000", "Bordeaux");

        //  Création des PetStores
        PetStore store1 = new PetStore("Animal World", "Jean Dupuis", addr1);
        PetStore store2 = new PetStore("Zanimo", "Lucie Moreau", addr2);
        PetStore store3 = new PetStore("Pet City", "Paul Bernard", addr3);

        em.persist(store1);
        em.persist(store2);
        em.persist(store3);

        // 📦 Produits (3 pour store1 uniquement)
        em.persist(new Product("P001", "Croquettes chien", ProdType.FOOD, 20.0, store1));
        em.persist(new Product("P002", "Shampooing", ProdType.CLEANING, 10.0, store1));
        em.persist(new Product("P003", "Collier lumineux", ProdType.ACCESSORY, 15.0, store1));

        em.persist(new Product("P004", "Croquettes chat", ProdType.FOOD, 22.0, store2));
        em.persist(new Product("P005", "Brosse chien", ProdType.CLEANING, 11.0, store2));
        em.persist(new Product("P006", "Harnais", ProdType.ACCESSORY, 16.0, store2));

        em.persist(new Product("P007", "Litière", ProdType.CLEANING, 9.5, store3));
        em.persist(new Product("P008", "Os à mâcher", ProdType.FOOD, 8.0, store3));
        em.persist(new Product("P009", "Jouet chat", ProdType.ACCESSORY, 5.0, store3));

        //Chats (3)
        em.persist(new Cat(new Date(), "Noir", "CHIP001", store1));
        em.persist(new Cat(new Date(), "Blanc", "CHIP002", store2));
        em.persist(new Cat(new Date(), "Gris", "CHIP003", store3));

        // Poissons (3)
        em.persist(new Fish(new Date(), "Bleu", FishLivEnv.FRESH_WATER, store1));
        em.persist(new Fish(new Date(), "Orange", FishLivEnv.SEA_WATER, store2));
        em.persist(new Fish(new Date(), "Jaune", FishLivEnv.FRESH_WATER, store3));

        em.getTransaction().commit();

        //Requête par code produit
        TypedQuery<Product> productQuery = em.createQuery(
                "SELECT p FROM Product p WHERE p.code = :code", Product.class);
        productQuery.setParameter("code", "P001");
        System.out.println("📦 Produits avec le code P001 :");
        for (Product p : productQuery.getResultList()) {
            System.out.println("→ " + p.getLabel() + " (" + p.getPrice() + "€)");
        }

        //Requête : tous les animaux d’un PetStore
        TypedQuery<Animal> animalQuery = em.createQuery(
                "SELECT a FROM Animal a WHERE a.petStore.id = :storeId", Animal.class);
        animalQuery.setParameter("storeId", store1.getId());
        System.out.println("\n🐾 Animaux du magasin " + store1.getName() + " :");
        for (Animal a : animalQuery.getResultList()) {
            System.out.println("→ Couleur : " + a.getCouleur() + ", Naissance : " + a.getBirth());
        }

        em.close();
        emf.close();
    }
}