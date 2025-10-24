package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    private float swimmingSpeed;

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        setSwimmingSpeed(swimmingSpeed);
    }

    public Dolphin() {
        super();
        this.swimmingSpeed = 0.0f;
    }

    // Instruction 28 : Implémentation de swim()
    @Override
    public void swim() {
        System.out.println("Le dauphin " + getName() + " nage rapidement à " + swimmingSpeed + " km/h");
    }

    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
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