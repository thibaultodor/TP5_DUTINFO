package fr.umontpellier.iut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionEmployesTest {
    private Employe Jorge;

    @Test
    public void test_if_main_method_was_implemented() {
        assertDoesNotThrow(() -> GestionEmployes.main(new String[1]));
    }

    @Test
    public void retourne_le_salaire_brut_d_un_employé() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(2.0)
                .setNbHeures(5.0)
                .createEmploye();
        assertEquals(10,Jorge.getSalaireBrut(),0.0001);
    }

    @Test
    public void retourne_le_salaire_net_d_un_employé() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(2.0)
                .setNbHeures(5.0)
                .createEmploye();
        assertEquals(8,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_0_si_nb_heure_egale_0() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(2.0)
                .setNbHeures(0)
                .createEmploye();
        assertEquals(0,Jorge.getSalaireBrut(),0.0001);
        assertEquals(0,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_0_si_base_egale_0() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(0)
                .setNbHeures(50)
                .createEmploye();
        assertEquals(0,Jorge.getSalaireBrut(),0.0001);
        assertEquals(0,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_0_si_base_egale_null() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setNbHeures(50)
                .createEmploye();
        assertEquals(0,Jorge.getSalaireBrut(),0.0001);
        assertEquals(0,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_0_si_nbheure_egale_null() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(2)
                .createEmploye();
        assertEquals(0,Jorge.getSalaireBrut(),0.0001);
        assertEquals(0,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_0_si_nbheure_et_base_egale_null() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .createEmploye();
        assertEquals(0,Jorge.getSalaireBrut(),0.0001);
        assertEquals(0,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_le_salaire_net_d_un_employé_avec_un_salaire_net_reel() {
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(151.2)
                .setNbHeures(5.0)
                .createEmploye();
        assertEquals(604.8,Jorge.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_le_salaire_brut_d_un_commercial_ou_vendeur() {
        Employe Loic = new Vendeur("0D0","Loic",5,5.0,10,85.2,0.5);
        Jorge = new EmployeBuilder()
                .setNrINSEE("0A0")
                .setNom ("Jorge")
                .setEchelon(5)
                .setBase(151.2)
                .setNbHeures(5.0)
                .createEmploye();
        assertEquals(47.6,Loic.getSalaireBrut(),0.0001);
    }

    @Test
    public void retourne_le_salaire_net_d_un_commercial() {
        Employe Loic = new Vendeur("0D0","Loic",5,5.0,10,85.2,0.5);
        assertEquals(38.08,Loic.getSalaireNet(),0.0001);
    }


    @Test
    public void retourne_le_salaire_brut_d_un_fabricant() {
        Employe Xavier = new FabricantBuilder().setNrINSEE("0E0").setNom("Xavier").setEchelon(8).setBase(3.0).setNbHeures(10).setNbUnitesProduites(80).setTauxCommissionUnite(0.5).createFabricant();
        assertEquals(70,Xavier.getSalaireBrut(),0.0001);
    }

    @Test
    public void retourne_le_salaire_net_d_un_fabricant() {
        Employe Xavier = new FabricantBuilder().setNrINSEE("0E0").setNom("Xavier").setEchelon(8).setBase(3.0).setNbHeures(10).setNbUnitesProduites(80).setTauxCommissionUnite(0.5).createFabricant();
        assertEquals(56,Xavier.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_le_salaire_brut_d_un_technicien() {
        Employe Alexandre = new TechnicienBuilder().setNrINSEE("0F0").setNom("Alexandre").setEchelon(7).setBase(5).setNbHeures(10).createTechnicien();
        assertEquals(750,Alexandre.getSalaireBrut(),0.0001);
    }

    @Test
    public void retourne_le_salaire_net_d_un_technicien() {
        Employe Alexandre = new TechnicienBuilder().setNrINSEE("0F0").setNom("Alexandre").setEchelon(7).setBase(5).setNbHeures(10).createTechnicien();
        assertEquals(600,Alexandre.getSalaireNet(),0.0001);
    }

    @Test
    public void retourne_le_salaire_brut_d_un_représentant() {
        Employe Alexandre = new RepresentantBuilder().setNrINSEE("0F0").setNom("Alexandre").setEchelon(7).setBase(5).setNbHeures(10).createReprésentant();
        assertEquals(750,Alexandre.getSalaireBrut(),0.0001);
    }

    @Test
    public void retourne_le_salaire_net_d_un_représentant() {
        Employe Alexandre = new RepresentantBuilder().setNrINSEE("0F0").setNom("Alexandre").setEchelon(7).setBase(5).setNbHeures(10).createReprésentant();
        assertEquals(600,Alexandre.getSalaireNet(),0.0001);
    }
}