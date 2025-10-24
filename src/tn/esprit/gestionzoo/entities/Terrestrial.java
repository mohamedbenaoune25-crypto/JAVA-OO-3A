package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal {
    private int nbrLegs;

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        setNbrLegs(nbrLegs);
    }

    public Terrestrial() {
        super("", "", 0, false);
        this.nbrLegs = 0;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        if (nbrLegs >= 0) {
            this.nbrLegs = nbrLegs;
        } else {
            System.out.println("Erreur : Le nombre de pattes ne peut pas être négatif!");
            this.nbrLegs = 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", nbrLegs=" + nbrLegs;
    }
}