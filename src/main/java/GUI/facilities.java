package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// GUI for the facilities which are available in the system
public class facilities extends javax.swing.JFrame {
    // facilites includes the following buttons:
    // 1. Wifi access
    // 2. Results analysis
    // 3. Fees calculation
    // 4. back button

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;

    // frame variables
    private javax.swing.JFrame jFrame;

    // panel variables
    private javax.swing.JPanel jPanel;

    // End of variables declaration//GEN-END:variables



    // Initialize the GUI
    public facilities(HashMap<String, String> propertiesMap , Map<Integer, ArrayList<ArrayList<String>>> coursesMap) {

        // create a new frame named "facilities"
        jFrame = new javax.swing.JFrame("facilities");
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

        // create a button named "Wifi access"
        jButton1 = new JButton(new AbstractAction("Wifi access") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                // create a new frame
                new wifi(propertiesMap, coursesMap);
            }
        });
        // set size of button
        jButton1.setSize(200,50);
        // set location of button
        jButton1.setLocation(100,100);
        // set text of button
        jButton1.setText("Wifi access");
        // add button to panel
        jPanel.add(jButton1);

        // create a button named "Results analysis"
        jButton2 = new JButton(new AbstractAction("Results analysis") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                // create a new frame
                new resultGUI(propertiesMap, coursesMap);
            }
        });
        // set size of button
        jButton2.setSize(200,50);
        // set location of button
        jButton2.setLocation(100,175);
        // set text of button
        jButton2.setText("Results analysis");
        // add button to panel
        jPanel.add(jButton2);


        // create a button named "Fees calculation"
        jButton3 = new JButton(new AbstractAction("Fees calculation") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                // create a new frame
                new fees(propertiesMap, coursesMap);
            }
        });
        // set size of button
        jButton3.setSize(200,50);
        // set location of button
        jButton3.setLocation(100,250);
        // set text of button
        jButton3.setText("Fees calculation");
        // add button to panel
        jPanel.add(jButton3);

        // create a button named "Back"
        jButton4 = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                // create a new frame
                new studentGUI(propertiesMap, coursesMap);
            }
        });
        // set size of button
        jButton4.setSize(200,50);
        // set location of button
        jButton4.setLocation(100,325);
        // set text of button
        jButton4.setText("Back");
        // add button to panel
        jPanel.add(jButton4);


        // set visibility of frame
        jFrame.setVisible(true);

    }

}


