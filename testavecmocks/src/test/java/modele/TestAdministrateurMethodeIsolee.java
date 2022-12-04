package modele;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class TestAdministrateurMethodeIsolee {


    private Administrateur administrateur;



    @Before
    public void setAeroport() {
        this.administrateur = new AdministrateurImpl();
    }



    @Test
    public void testGoHomeAucunPassagerFievreux(){

        SystemePresence systemePresence;
        Collection<Etudiant> etudiants;

        Etudiant etudiant1 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant2 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant3 = EasyMock.createMock(Etudiant.class);

        systemePresence = EasyMock.createMock(SystemePresence.class);
        EasyMock.expect(systemePresence.Presence(etudiant1)).andReturn(false);
        EasyMock.expect(systemePresence.Presence(etudiant2)).andReturn(false);
        EasyMock.expect(systemePresence.Presence(etudiant3)).andReturn(false);


        etudiants = Arrays.asList(etudiant1, etudiant2, etudiant3);


        this.administrateur = EasyMock.createMockBuilder(AdministrateurImpl.class).addMockedMethod("getSystemeThermique").addMockedMethod("getPassagers").createMock();
        EasyMock.expect(administrateur.getSystemePresence()).andReturn(systemePresence);
        EasyMock.expect(administrateur.getSystemePresence()).andReturn(systemePresence);
        EasyMock.expect(administrateur.getSystemePresence()).andReturn(systemePresence);
        EasyMock.expect(administrateur.getEtudiants()).andReturn(etudiants);

        EasyMock.replay(etudiant1, etudiant2, etudiant3, systemePresence, this.administrateur);


        Collection<Etudiant> etudiantsAbsent = this.administrateur.estPresent();

        Assert.assertEquals(etudiantsAbsent.size(),0);

    }


    @Test
    public void testGoHome2PassagersFievreux(){

        SystemePresence systemePresence;
        Collection<Etudiant> etudiants;

        Etudiant etudiant1 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant2 = EasyMock.createMock(Etudiant.class);
        Etudiant etudiant3 = EasyMock.createMock(Etudiant.class);

        systemePresence = EasyMock.createMock(SystemePresence.class);
        EasyMock.expect(systemePresence.Presence(etudiant1)).andReturn(true);
        EasyMock.expect(systemePresence.Presence(etudiant2)).andReturn(false);
        EasyMock.expect(systemePresence.Presence(etudiant3)).andReturn(true);
        etudiants = Arrays.asList(etudiant1, etudiant2, etudiant3);


        this.administrateur = EasyMock.createMockBuilder(AdministrateurImpl.class).addMockedMethod("getSystemeThermique").addMockedMethod("getPassagers").createMock();
        EasyMock.expect(administrateur.getSystemePresence()).andReturn(systemePresence);
        EasyMock.expect(administrateur.getSystemePresence()).andReturn(systemePresence);
        EasyMock.expect(administrateur.getSystemePresence()).andReturn(systemePresence);

        EasyMock.expect(administrateur.getEtudiants()).andReturn(etudiants);

        EasyMock.replay(etudiant1, etudiant2, etudiant3, systemePresence, this.administrateur);


        Collection<Etudiant> etudiantsAbsent = this.administrateur.estPresent();

        Assert.assertEquals(etudiantsAbsent.size(),2);

    }



}
