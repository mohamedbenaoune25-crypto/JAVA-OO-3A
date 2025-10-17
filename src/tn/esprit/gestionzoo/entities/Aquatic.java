package tn.esprit.gestionzoo.entities;

public class Aquatic extends Animal {
    // Instruction 20 : Attribut privé
    private String habitat;

    // Instruction 22 : Constructeur paramétré
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal); // Appel du constructeur parent
        this.habitat = habitat;
    }

    // Instruction 22 : Constructeur par défaut
    public Aquatic() {
        super("", "", 0, false); // Appel du constructeur parent par défaut
        this.habitat = "";
    }

    // Getters et Setters
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }
}