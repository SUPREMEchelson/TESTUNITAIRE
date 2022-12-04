package modele;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class TestAdministrateur {


    private Administrateur administrateur;



    @Before
    public void setAdministrateur() {
        this.administrateur = new AdministrateurImpl();
    }



    @Test
    public void testAucunEtudiantPresent(){

        SystemePresence systemePresence;
        Collection<Etudiant> etudiants;

        Etudiant etudiant1 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant2 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant3 = EasyMock.createMock(Etudiant.class);

        systemePresence = EasyMock.createMock(SystemePresence.class);
        EasyMock.expect(systemePresence.Presence(etudiant1)).andReturn(false);
        EasyMock.expect(systemePresence.Presence(etudiant2)).andReturn(false);
        EasyMock.expect(systemePresence.Presence(etudiant3)).andReturn(false);

        EasyMock.replay(etudiant1, etudiant2, etudiant3, systemePresence);


        this.administrateur.setSystemePresence(systemePresence);
        etudiants = Arrays.asList(etudiant1, etudiant2, etudiant3);

        this.administrateur.setEtudiants(etudiants);

        Collection<Etudiant> etudiantsPresent = this.administrateur.estPresent();

        Assert.assertEquals(etudiantsPresent.size(),0);

    }
    @Test
    public void testAucunEtudiantAbsent(){

        SystemePresence systemePresence;
        Collection<Etudiant> etudiants;

        Etudiant etudiant1 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant2 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant3 = EasyMock.createMock(Etudiant.class);

        systemePresence = EasyMock.createMock(SystemePresence.class);
        EasyMock.expect(systemePresence.Presence(etudiant1)).andReturn(true);
        EasyMock.expect(systemePresence.Presence(etudiant2)).andReturn(true);
        EasyMock.expect(systemePresence.Presence(etudiant3)).andReturn(true);

        EasyMock.replay(etudiant1, etudiant2, etudiant3, systemePresence);


        this.administrateur.setSystemePresence(systemePresence);
        etudiants = Arrays.asList(etudiant1, etudiant2, etudiant3);

        this.administrateur.setEtudiants(etudiants);

        Collection<Etudiant> etudiantsPresent = this.administrateur.estPresent();

        Assert.assertNotEquals(etudiantsPresent.size(),0);
    }


    @Test
    public void testAuMoins2EtudiantPresent(){

        SystemePresence systemePresence;
        Collection<Etudiant> etudiants;

        Etudiant etudiant1 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant2 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant3 = EasyMock.createMock(Etudiant.class);

        systemePresence = EasyMock.createMock(SystemePresence.class);
        EasyMock.expect(systemePresence.Presence(etudiant1)).andReturn(true);
        EasyMock.expect(systemePresence.Presence(etudiant2)).andReturn(false);
        EasyMock.expect(systemePresence.Presence(etudiant3)).andReturn(true);

        EasyMock.replay(etudiant1, etudiant2, etudiant3, systemePresence);


        this.administrateur.setSystemePresence(systemePresence);
        etudiants = Arrays.asList(etudiant1, etudiant2, etudiant3);

        this.administrateur.setEtudiants(etudiants);

        Collection<Etudiant> etudiantsPresent = this.administrateur.estPresent();

        Assert.assertEquals(etudiantsPresent.size(),2);

    }



}
