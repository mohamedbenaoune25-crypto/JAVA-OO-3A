package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic {
    private float swimmingDepth;

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        setSwimmingDepth(swimmingDepth);
    }

    public Penguin() {
        super();
        this.swimmingDepth = 0.0f;
    }

    // Instruction 28 : Implémentation de swim()
    @Override
    public void swim() {
        System.out.println("Le pingouin " + getName() + " plonge jusqu'à " + swimmingDepth + " mètres de profondeur");
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        if (swimmingDepth >= 0) {
            this.swimmingDepth = swimmingDepth;
        } else {
            System.out.println("Erreur : La profondeur de nage ne peut pas être négative!");
            this.swimmingDepth = 0.0f;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingDepth=" + swimmingDepth;
    }
}