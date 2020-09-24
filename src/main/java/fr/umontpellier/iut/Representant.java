package fr.umontpellier.iut;

public class Representant extends Commercial {

    public Representant(String nrINSEE, String nom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxCommission) {
        super(nrINSEE, nom, echelon, base, nbHeures, chiffreAffaires, tauxCommission);
    }

    void representerEntreprise(){
        System.out.println("Je représente un produit");
    }

    double getSalaireBrut(){
        Technicien delégué = new TechnicienBuilder().setBase(getBase()).setEchelon(getEchelon()).setNbHeures(getNbHeures()).createTechnicien();
        return delégué.getSalaireBrut();
    }
}
