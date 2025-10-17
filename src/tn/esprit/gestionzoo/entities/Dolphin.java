package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    // Instruction 20 : Attribut privé
    private float swimmingSpeed;

    // Instruction 22 : Constructeur paramétré
    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat); // Appel du constructeur parent
        setSwimmingSpeed(swimmingSpeed); // Utiliser le setter pour la validation
    }

    // Instruction 22 : Constructeur par défaut
    public Dolphin() {
        super(); // Appel du constructeur parent par défaut
        this.swimmingSpeed = 0.0f;
    }

    // Getters et Setters avec validation
    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
        // Validation : vitesse ne peut pas être négative
        if (swimmingSpeed >= 0) {
            this.swimmingSpeed = swimmingSpeed;
        } else {
            System.out.println("Erreur : La vitesse de nage ne peut pas être négative!");
            this.swimmingSpeed = 0.0f;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingSpeed=" + swimmingSpeed;
    }
}