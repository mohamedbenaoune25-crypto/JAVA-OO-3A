package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    private String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public Aquatic() {
        super("", "", 0, false);
        this.habitat = "";
    }

    // Instruction 28 : Méthode abstraite swim()
    public abstract void swim();

    // Instruction 31 : Redéfinition de equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Aquatic aquatic = (Aquatic) obj;
        return getName().equals(aquatic.getName()) &&
                getAge() == aquatic.getAge() &&
                habitat.equals(aquatic.habitat);
    }

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