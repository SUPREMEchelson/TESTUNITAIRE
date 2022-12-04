package modele;

import java.util.Collection;

public interface Administrateur {
    Collection<Etudiant> getEtudiants();

    void setEtudiants(Collection<Etudiant> etudiants);

    SystemePresence getSystemePresence();

    void setSystemePresence(SystemePresence systemePresence);


    Collection<Etudiant> estPresent();
}
