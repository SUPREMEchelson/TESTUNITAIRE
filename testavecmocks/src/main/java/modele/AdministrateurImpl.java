package modele;

import java.util.ArrayList;
import java.util.Collection;

public class AdministrateurImpl implements Administrateur, Etudiant {

    SystemePresence systemePresence;

    Collection<Etudiant> etudiants;

    public AdministrateurImpl() {
        etudiants = new ArrayList<>();
    }

    @Override
    public SystemePresence getSystemePresence() {
        return systemePresence;
    }

    public void setSystemePresence(SystemePresence systemePresence) {
        this.systemePresence = systemePresence;
    }

    @Override
    public Collection<Etudiant> getEtudiants() {
        return etudiants;
    }
    @Override
    public void setEtudiants(Collection<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public Collection<Etudiant> estPresent() {

        final Collection<Etudiant> Accepter = new ArrayList<Etudiant>();

        for (Etudiant e : this.getEtudiants()) {
            if ((this.getSystemePresence().Presence(e)))
                Accepter.add(e);
        }

        return Accepter;
    }



}
