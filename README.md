# 🐾 PetStore - Projet Spring Data JPA

Ce projet est une simulation d'une animalerie développée avec Java, JPA (Jakarta Persistence API), et Hibernate, sans Spring Boot.  
Il s'inscrit dans le cadre du **TP d'évaluation JPA** à l'ESAIP 2024-2025.

## 📚 Objectifs pédagogiques

- Maîtriser le **mapping JPA avec annotations**
- Utiliser les **relations entre entités** (`@OneToMany`, `@ManyToOne`, `@OneToOne`)
- Implémenter l'**héritage** avec la stratégie `JOINED`
- Manipuler une base de données via `EntityManager`
- Exécuter des **requêtes JPQL**

## 🗂 Structure du projet

```
pringData-jpa/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── fr/esaip/
│   │   │       ├── Address.java
│   │   │       ├── Animal.java
│   │   │       ├── Cat.java
│   │   │       ├── Fish.java
│   │   │       ├── FishLivEnv.java
│   │   │       ├──Main.java
│   │   │       ├── Petstore.java
│   │   │       ├── ProdType.java
│   │   │       └── Product.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
```

## 🛠 Technologies utilisées

- Java 17
- Maven
- JPA (Jakarta Persistence)
- Hibernate
- MySQL / MariaDB
- IntelliJ IDEA

## 🧪 Instructions d'exécution

1. Créer une base de données nommée `petstore` dans votre SGBD (MariaDB/MySQL).
2. Vérifier la configuration de connexion dans `persistence.xml`.
3. Exécuter la classe `Main.java`.
4. Observez les résultats dans la console ou directement en base avec :
   ```sql
   SELECT * FROM product;
   SELECT * FROM animal;
   SELECT * FROM cat;
   SELECT * FROM fish;
   SELECT * FROM petstore;
   ```

## 📌 Fonctionnalités réalisées

- [x] 10 animal
- [x] 5  adress
- [x] 15 product
- [x] 5  cat
- [x] 5  fish
- [x] Requête JPQL : produits par code
- [x] Requête JPQL : animaux d’une animalerie

## 👤 Réalisé par

**Nom :** Jennifer AWOUNOU
**Classe :** IR4 Francophone - ESAIP  
**Année :** 2024-2025

---

# TP-Eval
