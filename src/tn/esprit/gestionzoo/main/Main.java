package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== INSTRUCTION 25-26 : AJOUT D'ANIMAUX AQUATIQUES ===");

        // Création d'un zoo
        Zoo zooAquatique = new Zoo("Zoo Marin", "Sousse", 15);

        // Instruction 26 : Création et ajout d'animaux aquatiques
        Dolphin dolphin1 = new Dolphin("Delphinidé", "Flipper", 5, true, "Océan Atlantique", 40.0f);
        Dolphin dolphin2 = new Dolphin("Delphinidé", "Dolly", 3, true, "Océan Pacifique", 35.5f);
        Penguin penguin1 = new Penguin("Sphéniscidé", "Pingou", 2, true, "Antarctique", 30.0f);
        Penguin penguin2 = new Penguin("Sphéniscidé", "Pinga", 4, true, "Arctique", 45.5f);
        Penguin penguin3 = new Penguin("Sphéniscidé", "Plongeur", 6, true, "Antarctique", 60.0f);
        Aquatic tortue = new Aquatic("Testudinidé", "Tortue Marine", 15, false, "Océan") {
            @Override
            public void swim() {
                System.out.println("La tortue " + getName() + " nage lentement");
            }
        };

        // Ajout des animaux aquatiques au zoo
        zooAquatique.addAquaticAnimal(dolphin1);
        zooAquatique.addAquaticAnimal(dolphin2);
        zooAquatique.addAquaticAnimal(penguin1);
        zooAquatique.addAquaticAnimal(penguin2);
        zooAquatique.addAquaticAnimal(penguin3);
        zooAquatique.addAquaticAnimal(tortue);

        // Affichage des animaux aquatiques
        zooAquatique.displayAquaticAnimals();

        System.out.println("\n=== INSTRUCTION 27 : FAIRE NAGER TOUS LES ANIMAUX AQUATIQUES ===");

        // Instruction 27 : Faire nager tous les animaux aquatiques
        zooAquatique.makeAllAquaticsSwim();

        System.out.println("\n=== INSTRUCTION 29 : PROFONDEUR MAXIMALE DES PINGOUINS ===");

        // Instruction 29 : Profondeur maximale des pingouins
        float maxDepth = zooAquatique.maxPenguinSwimmingDepth();
        System.out.println("La profondeur maximale de nage des pingouins est: " + maxDepth + " mètres");

        System.out.println("\n=== INSTRUCTION 30 : NOMBRE D'AQUATIQUES PAR TYPE ===");

        // Instruction 30 : Affichage du nombre d'aquatiques par type
        zooAquatique.displayNumberOfAquaticsByType();

        System.out.println("\n=== INSTRUCTION 31 : TEST DE LA MÉTHODE EQUALS ===");

        // Instruction 31 : Test de la méthode equals
        Aquatic aquatic1 = new Dolphin("Delphinidé", "Same", 5, true, "Océan", 30.0f);
        Aquatic aquatic2 = new Dolphin("Delphinidé", "Same", 5, true, "Océan", 35.0f); // Même nom, âge, habitat
        Aquatic aquatic3 = new Dolphin("Delphinidé", "Different", 5, true, "Océan", 30.0f); // Nom différent
        Aquatic aquatic4 = new Dolphin("Delphinidé", "Same", 3, true, "Océan", 30.0f); // Âge différent
        Aquatic aquatic5 = new Dolphin("Delphinidé", "Same", 5, true, "Mer", 30.0f); // Habitat différent

        System.out.println("aquatic1 equals aquatic2 (mêmes caractéristiques): " + aquatic1.equals(aquatic2));
        System.out.println("aquatic1 equals aquatic3 (nom différent): " + aquatic1.equals(aquatic3));
        System.out.println("aquatic1 equals aquatic4 (âge différent): " + aquatic1.equals(aquatic4));
        System.out.println("aquatic1 equals aquatic5 (habitat différent): " + aquatic1.equals(aquatic5));

        System.out.println("\n=== TEST D'AJOUT D'ANIMAUX IDENTIQUES ===");

        // Test d'ajout d'animaux identiques (doivent être considérés comme égaux)
        Aquatic dolphinCopy = new Dolphin("Delphinidé", "Flipper", 5, true, "Océan Atlantique", 40.0f);
        System.out.println("dolphin1 equals dolphinCopy: " + dolphin1.equals(dolphinCopy));

        System.out.println("\n=== TEST DE DÉPASSEMENT DE CAPACITÉ AQUATIQUE ===");

        // Test d'ajout au-delà de la capacité (10 animaux aquatiques max)
        for (int i = 0; i < 6; i++) {
            Aquatic extraAquatic = new Penguin("Sphéniscidé", "Pingouin" + i, 1, true, "Pôle", 20.0f + i);
            zooAquatique.addAquaticAnimal(extraAquatic);
        }

        System.out.println("\n=== AFFICHAGE FINAL DU ZOO ===");
        zooAquatique.displayZoo();
        zooAquatique.displayNumberOfAquaticsByType();
    }
}