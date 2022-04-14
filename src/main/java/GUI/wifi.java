package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// GUI for the wifi module
public class wifi extends javax.swing.JFrame{
    // Variables declaration - do not modify//GEN-BEGIN:variables

    // variables for the frame
    private javax.swing.JFrame jFrame;

    // variables for the panel
    private javax.swing.JPanel jPanel;

    // varaialbes for the userName label
    private javax.swing.JLabel userName;

    // variables for the password label
    private javax.swing.JLabel password;

    // variable for back button
    private javax.swing.JButton back;

    // GUI initialization
    public wifi(HashMap<String, String> propertiesMap , Map<Integer, ArrayList<ArrayList<String>>> coursesMap) {

        // create a new frame named "WiFi"
        jFrame = new javax.swing.JFrame("WiFi");
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

        // create a new label for the userName
        userName = new JLabel("UserName: " + propertiesMap.get("hasRollNo"));
        // set size of label
        userName.setSize(200,50);
        // set location of label
        userName.setLocation(100,100);
        // add label to panel
        jPanel.add(userName);

        // create a new label for the password
        password = new JLabel("Password: " + (propertiesMap.get("hasRollNo")).hashCode());
        // set size of label
        password.setSize(200,50);
        // set location of label
        password.setLocation(100,150);
        // add label to panel
        jPanel.add(password);

        // create a new button for back
        back = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                // create a new frame
                new facilities(propertiesMap, coursesMap);
            }
        });
        // set size of button
        back.setSize(100,50);
        // set location of button
        back.setLocation(100,200);
        // add button to panel
        jPanel.add(back);

        // set visible
        jFrame.setVisible(true);

    }

}


