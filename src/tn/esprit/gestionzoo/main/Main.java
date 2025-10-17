package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== INSTRUCTION 21 : INSTANCES AVEC CONSTRUCTEURS PAR DÉFAUT ===");

        // Instruction 21 : Instances avec constructeurs par défaut
        Aquatic aquaticDefault = new Aquatic();
        Terrestrial terrestrialDefault = new Terrestrial();
        Dolphin dolphinDefault = new Dolphin();
        Penguin penguinDefault = new Penguin();

        System.out.println("Animal aquatique par défaut: " + aquaticDefault);
        System.out.println("Animal terrestre par défaut: " + terrestrialDefault);
        System.out.println("Dauphin par défaut: " + dolphinDefault);
        System.out.println("Pingouin par défaut: " + penguinDefault);

        System.out.println("\n=== INSTRUCTION 22 : INSTANCES AVEC CONSTRUCTEURS PARAMÉTRÉS ===");

        // Instruction 22 : Instances avec constructeurs paramétrés
        Aquatic aquatic = new Aquatic("Poisson", "Poisson-clown", 2, false, "Océan");
        Terrestrial terrestrial = new Terrestrial("Félidé", "Lion", 5, true, 4);
        Dolphin dolphin = new Dolphin("Delphinidé", "Dauphin", 8, true, "Océan", 35.5f);
        Penguin penguin = new Penguin("Sphéniscidé", "Pingouin", 3, true, "Antarctique", 50.0f);

        System.out.println("Animal aquatique: " + aquatic);
        System.out.println("Animal terrestre: " + terrestrial);
        System.out.println("Dauphin: " + dolphin);
        System.out.println("Pingouin: " + penguin);

        System.out.println("\n=== TEST VALIDATION DES NOUVELLES CLASSES ===");

        // Test validation des nouvelles classes
        Terrestrial terrestrialInvalid = new Terrestrial("Test", "AnimalTest", 2, true, -3);
        Dolphin dolphinInvalid = new Dolphin("Test", "DauphinTest", 4, true, "Mer", -10.0f);
        Penguin penguinInvalid = new Penguin("Test", "PingouinTest", 1, true, "Pôle", -5.0f);

        System.out.println("Terrestre avec pattes négatives: " + terrestrialInvalid);
        System.out.println("Dauphin avec vitesse négative: " + dolphinInvalid);
        System.out.println("Pingouin avec profondeur négative: " + penguinInvalid);

        System.out.println("\n=== TEST AVEC LE ZOO ===");

        // Création d'un zoo et ajout des nouveaux animaux
        Zoo zooModern = new Zoo("Zoo Moderne", "Tunis", 10);

        // Ajout des animaux au zoo
        zooModern.addAnimal(aquatic);
        zooModern.addAnimal(terrestrial);
        zooModern.addAnimal(dolphin);
        zooModern.addAnimal(penguin);

        // Affichage des animaux du zoo
        zooModern.displayAnimals();

        System.out.println("\n=== TEST DES GETTERS/SETTERS ===");

        // Test des getters et setters
        dolphin.setSwimmingSpeed(40.0f);
        penguin.setSwimmingDepth(60.0f);
        terrestrial.setNbrLegs(4);

        System.out.println("Dauphin vitesse modifiée: " + dolphin.getSwimmingSpeed());
        System.out.println("Pingouin profondeur modifiée: " + penguin.getSwimmingDepth());
        System.out.println("Terrestre pattes modifiées: " + terrestrial.getNbrLegs());

        // Test validation setters
        dolphin.setSwimmingSpeed(-5.0f); // Doit afficher erreur
        terrestrial.setNbrLegs(-2); // Doit afficher erreur

        System.out.println("\n=== TEST HIÉRARCHIE DES CLASSES ===");

        // Polymorphisme : tous les animaux peuvent être traités comme Animal
        Animal[] animauxVariés = {
                new Aquatic("Reptile", "Tortue", 10, false, "Eau douce"),
                new Terrestrial("Canidé", "Chien", 3, true, 4),
                new Dolphin("Delphinidé", "Grand dauphin", 6, true, "Océan Atlantique", 30.0f),
                new Penguin("Sphéniscidé", "Pingouin royal", 4, true, "Antarctique", 45.0f)
        };

        System.out.println("Liste d'animaux variés:");
        for (Animal animal : animauxVariés) {
            System.out.println("- " + animal.getClass().getSimpleName() + ": " + animal);
        }
    }
}