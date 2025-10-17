package tn.esprit.gestionzoo.entities;

public class Zoo {
    // Attributs privés
    private String name;
    private String city;
    private final int nbrCages;
    private Animal[] animals;
    private int animalCount;

    // Constructeur avec validation
    public Zoo(String name, String city, int nbrCages) {
        setName(name); // Utiliser le setter pour la validation
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
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

    // Setters avec validation
    public void setName(String name) {
        // Validation : nom ne doit pas être vide
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : Le nom du zoo ne peut pas être vide!");
            this.name = "Zoo Inconnu"; // Valeur par défaut
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Méthode addAnimal améliorée
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

    public void displayZoo() {
        System.out.println("Nom du zoo: " + getName());
        System.out.println("Ville: " + getCity());
        System.out.println("Nombre de cages: " + getNbrCages());
        System.out.println("Nombre d'animaux actuels: " + getAnimalCount());
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
                '}';
    }
}