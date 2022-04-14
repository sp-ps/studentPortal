package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fees extends javax.swing.JFrame{

    // Variables declaration - do not modify//GEN-BEGIN:variables

    // variables for frame
    private javax.swing.JFrame jFrame;

    // variables for panel
    private javax.swing.JPanel jPanel;

    // variables for Academic Year
    private javax.swing.JLabel jLabel1;

    // variables for Semester
    private javax.swing.JLabel jLabel2;

    // variables for AcademicFees
    private javax.swing.JLabel jLabel3;

    // variables for MessFees
    private javax.swing.JLabel jLabel4;

    // variables for back button
    private javax.swing.JButton jButton1;

    // constructor
    public fees(HashMap<String, String> propertiesMap , Map<Integer, ArrayList<ArrayList<String>>> coursesMap) {

        // create a new frame named "Fees"
        jFrame = new javax.swing.JFrame("Fees");
        // set size of frame
        jFrame.setSize(500,500);
        // set close operation
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout
        jFrame.setLayout(null);
        // create a panel
        jPanel = new JPanel();
        // set size of panel
        jPanel.setSize(500,500);
        //set layout of panel
        jPanel.setLayout(null);
        // add panel to frame
        jFrame.add(jPanel);

        // create a new label for the Academic Year
        jLabel1 = new JLabel("Academic Year: 2022");
        // set size of label
        jLabel1.setSize(200,20);
        // set location of label
        jLabel1.setLocation(10,10);
        // add label to panel
        jPanel.add(jLabel1);


        // create a new label for the Semester
        jLabel2 = new JLabel("Semester: Even");
        // set size of label
        jLabel2.setSize(200,20);
        // set location of label
        jLabel2.setLocation(10,40);
        // add label to panel
        jPanel.add(jLabel2);

        // create a new label for the Academic Fees
        jLabel3 = new JLabel("Academic Fees: Rs. 105000");
        // set size of label
        jLabel3.setSize(200,20);
        // set location of label
        jLabel3.setLocation(10,70);
        // add label to panel
        jPanel.add(jLabel3);

        // create a new label for the Mess Fees
        jLabel4 = new JLabel("Mess Fees: Rs. 12000");
        // set size of label
        jLabel4.setSize(200,20);
        // set location of label
        jLabel4.setLocation(10,100);
        // add label to panel
        jPanel.add(jLabel4);


        // create a new button for back
        jButton1 = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                // create a new frame
                new facilities(propertiesMap, coursesMap);
            }
        });
        // set size of button
        jButton1.setSize(100,20);
        // set location of button
        jButton1.setLocation(10,130);
        // add button to panel
        jPanel.add(jButton1);



        // set visible
        jFrame.setVisible(true);

    }


}
