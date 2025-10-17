package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal {
    // Instruction 20 : Attribut privé
    private int nbrLegs;

    // Instruction 22 : Constructeur paramétré
    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal); // Appel du constructeur parent
        setNbrLegs(nbrLegs); // Utiliser le setter pour la validation
    }

    // Instruction 22 : Constructeur par défaut
    public Terrestrial() {
        super("", "", 0, false); // Appel du constructeur parent par défaut
        this.nbrLegs = 0;
    }

    // Getters et Setters avec validation
    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        // Validation : nombre de pattes ne peut pas être négatif
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