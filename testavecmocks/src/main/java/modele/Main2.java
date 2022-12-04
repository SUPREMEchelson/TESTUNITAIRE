package modele;

//import javax.swing;
//import javax.swing.*;
//import javax.swing.table.;
import javax.swing.*;
import java.awt.*;

    class Main2 {
        public static void main(String args[]){
            JFrame frameE = new JFrame();

            String[] columnNames = {"Id", "Nom", "Age", "Presence"};
            Etudiant[][] testetudiant = {

            }

            Object[][] data = {
                    {new Integer(1), "E1", new Integer(20), new Boolean(false)},
                    {new Integer(2), "E2", new Integer(18), new Boolean(true)},
                    {new Integer(3), "E3", new Integer(21), new Boolean(false)},
                    {new Integer(4), "E4",new Integer(20), new Boolean(true)},
                    {new Integer(5), "E5", new Integer(19), new Boolean(true)}
            };
            JTable tableE = new JTable(data, columnNames);

            frameE.add(tableE);
            frameE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameE.setSize(400,400);
            frameE.setLocationRelativeTo(null);
            frameE.setVisible(true);

            JFrame frameA = new JFrame();

            String[] columnNamesA = {"Id", "Nom", "Ajouter", "Supprimer"};

            Object[][] dataA = {
                    {new Integer(1), "A1", new Boolean(true), new Boolean(false)},
                    {new Integer(2), "A2", new Boolean(true), new Boolean(true)},
                    {new Integer(3), "A3", new Boolean(false), new Boolean(false)},
                    {new Integer(4), "A4", new Boolean(false), new Boolean(true)},
                    {new Integer(5), "A5", new Boolean(false), new Boolean(true)}
            };
            JTable tableA = new JTable(dataA, columnNamesA);

            frameA.add(tableA);
            frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameA.setSize(400,400);
            frameA.setLocationRelativeTo(null);
            frameA.setVisible(true);
        }
}
