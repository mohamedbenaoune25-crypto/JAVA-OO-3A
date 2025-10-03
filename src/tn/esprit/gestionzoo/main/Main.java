package tn.esprit.gestionzoo.main;

// Importer les classes du package entities
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TEST INSTRUCTION 18 : VALIDATION ===");

        // Test validation Animal - âge négatif
        System.out.println("\n1. Test validation Animal (âge négatif):");
        Animal animalAgeNegatif = new Animal("Test", "TestAnimal", -5, true);
        System.out.println("Âge après tentative négative: " + animalAgeNegatif.getAge());

        // Test validation Zoo - nom vide
        System.out.println("\n2. Test validation Zoo (nom vide):");
        Zoo zooNomVide = new Zoo("", "Tunis", 10);
        System.out.println("Nom du zoo après tentative vide: " + zooNomVide.getName());

        System.out.println("\n=== TEST INSTRUCTION 17 : addAnimal avec isZooFull() ===");

        // Création d'un zoo avec capacité limitée
        Zoo petitZoo = new Zoo("Petit Zoo", "Sfax", 2);
        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal elephant = new Animal("Elephantidae", "Elephant", 10, true);
        Animal tiger = new Animal("Felidae", "Tiger", 3, true);

        // Test d'ajout avec capacité limitée
        System.out.println("\n3. Test ajout animaux avec capacité limitée:");
        petitZoo.addAnimal(lion);        // true
        petitZoo.addAnimal(elephant);    // true
        petitZoo.addAnimal(tiger);       // false - zoo plein (utilise isZooFull())

        // Test de la méthode isZooFull
        System.out.println("\n4. Test méthode isZooFull():");
        System.out.println("Le zoo est plein ? " + petitZoo.isZooFull());

        System.out.println("\n=== TEST INSTRUCTION 12 : EMPÊCHER LES DOUBLONS ===");

        // Test d'ajout d'un animal déjà présent
        Animal lionCopy = new Animal("Felidae", "Lion", 8, true);
        System.out.println("\n5. Test ajout doublon:");
        petitZoo.addAnimal(lionCopy); // Doit échouer - animal déjà présent

        System.out.println("\n=== TEST INSTRUCTION 11 : RECHERCHE ET AFFICHAGE ===");

        // Affichage des animaux
        petitZoo.displayAnimals();

        // Test de recherche
        System.out.println("\n6. Test recherche animal:");
        int indexLion = petitZoo.searchAnimal(lion);
        System.out.println("Lion trouvé à l'indice: " + indexLion);

        Animal animalInexistant = new Animal("Test", "Dragon", 100, false);
        int indexDragon = petitZoo.searchAnimal(animalInexistant);
        System.out.println("Dragon trouvé à l'indice: " + indexDragon);

        System.out.println("\n=== TEST INSTRUCTION 13 : SUPPRESSION ===");

        // Test de suppression
        System.out.println("\n7. Test suppression animal:");
        petitZoo.removeAnimal(elephant);
        petitZoo.displayAnimals();

        System.out.println("\n=== TEST INSTRUCTION 16 : COMPARAISON DE ZOOS ===");

        // Création de deux zoos pour comparaison
        Zoo zoo1 = new Zoo("Zoo Nord", "Tunis", 5);
        Zoo zoo2 = new Zoo("Zoo Sud", "Sfax", 5);

        zoo1.addAnimal(new Animal("Canidae", "Loup", 4, true));
        zoo1.addAnimal(new Animal("Ursidae", "Ours", 6, true));

        zoo2.addAnimal(new Animal("Felidae", "Chat", 2, true));

        Zoo plusGrandZoo = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("\n8. Comparaison zoos:");
        System.out.println("Zoo avec le plus d'animaux: " + plusGrandZoo.getName());

        System.out.println("\n=== TEST GETTERS/SETTERS ===");

        // Test des getters
        System.out.println("\n9. Test des getters:");
        System.out.println("Nom du zoo: " + petitZoo.getName());
        System.out.println("Ville: " + petitZoo.getCity());
        System.out.println("Nombre de cages: " + petitZoo.getNbrCages());
        System.out.println("Nombre d'animaux: " + petitZoo.getAnimalCount());

        // Test des setters avec validation
        System.out.println("\n10. Test setters avec validation:");
        petitZoo.setName(""); // Doit afficher erreur et garder ancien nom
        System.out.println("Nom après tentative vide: " + petitZoo.getName());

        Animal testAnimal = new Animal("Test", "Test", 5, true);
        testAnimal.setAge(-10); // Doit afficher erreur
        System.out.println("Âge après tentative négative: " + testAnimal.getAge());

        System.out.println("\n=== AFFICHAGE AVEC toString() ===");
        System.out.println(petitZoo);
        System.out.println(lion);
    }
}