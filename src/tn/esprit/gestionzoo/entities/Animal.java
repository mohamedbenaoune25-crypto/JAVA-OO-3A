package tn.esprit.gestionzoo.entities;

public class Animal {
    // Attributs privés
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    // Constructeur avec validation
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); // Utiliser le setter pour la validation
        this.isMammal = isMammal;
    }

    // Getters
    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    // Setters avec validation
    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        // Validation : âge ne peut pas être négatif
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Erreur : L'âge ne peut pas être négatif!");
            this.age = 0; // Valeur par défaut
        }
    }

    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMammal=" + isMammal +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return name.equals(animal.name) && family.equals(animal.family);
    }
}