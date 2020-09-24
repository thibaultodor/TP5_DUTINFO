package fr.umontpellier.iut;

public abstract class Commercial extends Employe {
    private double chiffreAffaires;
    private double tauxCommission;

    public Commercial(String nrINSEE, String nom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxCommission) {
        super(nrINSEE, nom, echelon, base, nbHeures);
        this.chiffreAffaires = chiffreAffaires;
        this.tauxCommission = tauxCommission;
    }

    void negocierTransaction(){
        System.out.println("Je négocie une transaction");
    }

    @Override
    double getSalaireBrut(){
        return super.getBase() + (chiffreAffaires * tauxCommission);
    }
}
