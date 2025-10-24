package tn.esprit.gestionzoo.entities;

public class Zoo {
    private String name;
    private String city;
    private final int nbrCages;
    private Animal[] animals;
    private int animalCount;

    // Instruction 25 : Tableau aquaticAnimals
    private Aquatic[] aquaticAnimals;
    private int aquaticAnimalCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;

        // Instruction 25 : Initialisation du tableau aquaticAnimals (10 places)
        this.aquaticAnimals = new Aquatic[10];
        this.aquaticAnimalCount = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getAquaticAnimalCount() {
        return aquaticAnimalCount;
    }

    // Setters avec validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : Le nom du zoo ne peut pas être vide!");
            this.name = "Zoo Inconnu";
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Méthode addAnimal existante
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo " + getName() + " est plein! Impossible d'ajouter " + animal.getName());
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("L'animal " + animal.getName() + " existe déjà dans le zoo!");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        System.out.println("Animal " + animal.getName() + " ajouté avec succès!");
        return true;
    }

    // Instruction 26 : Méthode addAquaticAnimal
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquaticAnimalCount < aquaticAnimals.length) {
            aquaticAnimals[aquaticAnimalCount] = aquatic;
            aquaticAnimalCount++;
            System.out.println("Animal aquatique " + aquatic.getName() + " ajouté avec succès!");
        } else {
            System.out.println("Le zoo aquatique est plein! Impossible d'ajouter " + aquatic.getName());
        }
    }

    // Instruction 27 : Méthode pour faire nager tous les animaux aquatiques
    public void makeAllAquaticsSwim() {
        System.out.println("\n=== Tous les animaux aquatiques nagent ===");
        for (int i = 0; i < aquaticAnimalCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    // Instruction 29 : Méthode maxPenguinSwimmingDepth
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        for (int i = 0; i < aquaticAnimalCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin penguin = (Penguin) aquaticAnimals[i];
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    // Instruction 30 : Méthode displayNumberOfAquaticsByType
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;
        int otherAquaticCount = 0;

        for (int i = 0; i < aquaticAnimalCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            } else {
                otherAquaticCount++;
            }
        }

        System.out.println("\n=== Statistiques des animaux aquatiques ===");
        System.out.println("Nombre de dauphins: " + dolphinCount);
        System.out.println("Nombre de pingouins: " + penguinCount);
        System.out.println("Nombre d'autres animaux aquatiques: " + otherAquaticCount);
        System.out.println("Total animaux aquatiques: " + aquaticAnimalCount);
    }

    // Méthodes existantes
    public void displayZoo() {
        System.out.println("Nom du zoo: " + getName());
        System.out.println("Ville: " + getCity());
        System.out.println("Nombre de cages: " + getNbrCages());
        System.out.println("Nombre d'animaux actuels: " + getAnimalCount());
        System.out.println("Nombre d'animaux aquatiques: " + getAquaticAnimalCount());
    }

    public void displayAnimals() {
        System.out.println("\n=== Animaux du zoo " + getName() + " ===");
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (int i = 0; i < animalCount; i++) {
            System.out.println((i+1) + ". " + animals[i]);
        }
    }

    public void displayAquaticAnimals() {
        System.out.println("\n=== Animaux aquatiques du zoo " + getName() + " ===");
        if (aquaticAnimalCount == 0) {
            System.out.println("Aucun animal aquatique dans le zoo.");
            return;
        }
        for (int i = 0; i < aquaticAnimalCount; i++) {
            System.out.println((i+1) + ". " + aquaticAnimals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("Animal non trouvé dans le zoo!");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("Animal " + animal.getName() + " supprimé avec succès!");
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.getAnimalCount() > z2.getAnimalCount()) {
            return z1;
        } else if (z2.getAnimalCount() > z1.getAnimalCount()) {
            return z2;
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux!");
            return z1;
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + getName() + '\'' +
                ", city='" + getCity() + '\'' +
                ", nbrCages=" + getNbrCages() +
                ", animalCount=" + getAnimalCount() +
                ", aquaticAnimalCount=" + getAquaticAnimalCount() +
                '}';
    }
}