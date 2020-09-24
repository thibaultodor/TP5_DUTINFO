package fr.umontpellier.iut;

public class GestionEmployes {

    public static void main(String[] args) {
        Employe Jorge,Brigitte,Julien;

        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(2.0)
                .setNbHeures(5.0)
                .createEmploye();

        Brigitte = new EmployeBuilder()
                .setNrINSEE("0B0")
                .setNom ("Brigitte")
                .setEchelon(5)
                .setBase(8.0)
                .setNbHeures(15.2)
                .createEmploye();

        Julien = new EmployeBuilder()
                .setNrINSEE("0C0")
                .setNom ("Julien")
                .setEchelon(5)
                .setBase(151.2)
                .setNbHeures(5.0)
                .createEmploye();

        System.out.println(Jorge.toString());
        System.out.println(Brigitte.toString());
        System.out.println(Julien.toString());

        Commercial Loic = new Representant("0D0","Loic",5,5.0,10,85.2,0.5);
        Fabricant Xavier = new FabricantBuilder().setNrINSEE("0E0").setNom("Xavier").setEchelon(8).setBase(3.0).setNbHeures(10).setNbUnitesProduites(80).setTauxCommissionUnite(0.5).createFabricant();
        Technicien Alexandre = new TechnicienBuilder().setNrINSEE("0F0").setNom("Alexandre").setEchelon(7).setBase(5).setNbHeures(10).createTechnicien();

        Loic.negocierTransaction();
        Xavier.fabriquerProduit();
        Alexandre.effectuerTacheTechnique();

        Employe Rémy;
        Rémy = new FabricantBuilder().setNrINSEE("0G0").setNom("Rémy").setEchelon(8).setBase(3.0).setNbHeures(10).setNbUnitesProduites(80).setTauxCommissionUnite(0.5).createFabricant();
        System.out.println(Rémy.getSalaireBrut());
        System.out.println(Rémy.getSalaireNet());

        Representant Luc = new RepresentantBuilder().setNrINSEE("0H0").setNom("Luc").setEchelon(7).setBase(5).setNbHeures(10).createReprésentant();
        System.out.println(Luc.getSalaireBrut());
        System.out.println(Luc.getSalaireNet());
        Luc.representerEntreprise();

        Vendeur Nicolas = new VendeurBuilder().setNrINSEE("0I0").setNom("Nicolas").setEchelon(7).setBase(5).setNbHeures(10).createVendeur();
        System.out.println(Nicolas.getSalaireBrut());
        System.out.println(Nicolas.getSalaireNet());
        Nicolas.vendreProduit();
    }

}
