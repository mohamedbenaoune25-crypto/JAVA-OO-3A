package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic {
    // Instruction 20 : Attribut privé
    private float swimmingDepth;

    // Instruction 22 : Constructeur paramétré
    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat); // Appel du constructeur parent
        setSwimmingDepth(swimmingDepth); // Utiliser le setter pour la validation
    }

    // Instruction 22 : Constructeur par défaut
    public Penguin() {
        super(); // Appel du constructeur parent par défaut
        this.swimmingDepth = 0.0f;
    }

    // Getters et Setters avec validation
    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        // Validation : profondeur ne peut pas être négative
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