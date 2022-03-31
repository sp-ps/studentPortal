package GUI;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class studentGUI extends JFrame implements ActionListener {

    static JFrame frame;
    static JPanel panel;
    // create a label for the name
    static JLabel nameLabel;
    // create a label for the roll number
    static JLabel rollLabel;
    // create a label for the Branch
    static JLabel branchLabel;
    // create a label for the semester
    static JLabel cgpaLabel;
    // create a label for the email
    static JLabel emailLabel;

    // constructor
    public studentGUI(HashMap<String, String> propertiesMap , Map<Integer, ArrayList<ArrayList<String>>> coursesMap){
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = null;
        try {
            ontology = manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\satya\\Desktop\\s11.owl"));
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }





        // create frame of name Student Details
        frame = new JFrame("Student Details");
        // set size of frame
        frame.setSize(500,500);
        // set close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout
        frame.setLayout(null);
        // create a panel
        panel = new JPanel();
        // set size of panel
        panel.setSize(500,500);
        //set layout of panel
        panel.setLayout(null);
        // add panel to frame
        frame.add(panel);
        // create a label for the name
        nameLabel = new JLabel("Name: " + propertiesMap.get("hasName"));
        // set size of label
        nameLabel.setSize(200,20);
        // set location of label
        nameLabel.setLocation(10,10);
        // add label to panel
        panel.add(nameLabel);
        // create a label for the roll number under name
        rollLabel = new JLabel("Roll Number: " + propertiesMap.get("hasRollNo"));
        // set size of label
        rollLabel.setSize(200,20);
        // set location of label
        rollLabel.setLocation(10,40);
        // add label to panel
        panel.add(rollLabel);
        // create a label for the Branch under roll number
        branchLabel = new JLabel("Branch: " + propertiesMap.get("belongsTohasName"));
        // set size of label
        branchLabel.setSize(200,20);
        // set location of label
        branchLabel.setLocation(10,70);
        // add label to panel
        panel.add(branchLabel);
        // create a label for the semester under branch
        cgpaLabel = new JLabel("CGPA: " + propertiesMap.get("getshasCpi"));
        // set size of label
        cgpaLabel.setSize(100,20);
        // set location of label
        cgpaLabel.setLocation(10,100);
        // add label to panel
        panel.add(cgpaLabel);
        // create a label for the email under cgpa
        emailLabel = new JLabel("Email: " + propertiesMap.get("hasEmail"));
        // set size of label
        emailLabel.setSize(300,20);
        // set location of label
        emailLabel.setLocation(10,130);
        // add label to panel
        panel.add(emailLabel);

        // create a button named "Facilities"
        JButton facilitiesButton = new JButton( new AbstractAction ("Facilities") {

            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                frame.dispose();
                // create a new frame
                new resultGUI(propertiesMap, coursesMap);
            }
        });
        // set size of button
        facilitiesButton.setSize(100,20);
        // set location of button
        facilitiesButton.setLocation(10,160);
        // add event listener to button to open new window
        facilitiesButton.addActionListener( this );
        // add button to panel
        panel.add(facilitiesButton);



        // create a button
        JButton button = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // create a new frame
                new firstGUI();
            }
        });
               // set size of button
        button.setSize(100,20);
        // set location of button
        button.setLocation(10,190);
        // add action listener to button
        button.addActionListener(this);
        // add button to panel
        panel.add(button);


        // set visibility of frame
        frame.setVisible(true);



    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back")) {
            frame.dispose();
            // create a new frame
            new firstGUI();
        }
    }
}

