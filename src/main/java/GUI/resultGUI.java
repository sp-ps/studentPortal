package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class resultGUI extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button;

    private JComboBox<String> year;
    private JComboBox<String> Semester;

    private JLabel yearLabel;
    private JLabel semesterLabel;

    private JFrame frame;
    private JPanel panel;

    // button for back to the main menu
    private JButton backButton;


    public resultGUI(HashMap<String, String> propertiesMap , Map<Integer, ArrayList<ArrayList<String>>> coursesMap) {

        // create frame named "Result"
        frame = new JFrame("Result");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        // create panel
        panel = new JPanel();
        // set size of panel
        panel.setSize(500,500);
        //set layout of panel
        panel.setLayout(null);
        // add panel to frame
        frame.add(panel);

        // create label
        label = new JLabel("Result");
        // set size of label
        label.setSize(50,50);
        // set location of label
        label.setLocation(10,10);
        // add label to panel
        panel.add(label);

        // create year label
        yearLabel = new JLabel("Year");
        // set size of year label
        yearLabel.setSize(100,50);
        // set location of year label
        yearLabel.setLocation(10,50);

        // add year label to panel
        panel.add(yearLabel);


        // create year comboBox
        year = new JComboBox<String>();
        // iterate through the coursesMap
        Set<String> years = new HashSet<>();
        for (Map.Entry<Integer, ArrayList<ArrayList<String>>> entry : coursesMap.entrySet()) {
            Integer y = entry.getKey() / 10;
            years.add(y.toString());
        }
        // add years to comboBox
        for (String y : years) {
            year.addItem(y);
        }
        // set size of year comboBox
        year.setSize(100,30);
        // set location of year comboBox in right side of year label
        year.setLocation(120,50);
        // add year comboBox to panel
        panel.add(year);

        // create semester label
        semesterLabel = new JLabel("Semester");
        // set size of semester label
        semesterLabel.setSize(100,50);
        // set location of semester label
        semesterLabel.setLocation(10,100);
        // add semester label to panel
        panel.add(semesterLabel);

        // create semester comboBox
        Semester = new JComboBox<String>();
        boolean  evenExist = false;
        boolean oddExist = false;
        // iterate through the coursesMap
        for (Map.Entry<Integer, ArrayList<ArrayList<String>>> entry : coursesMap.entrySet()) {
            Integer s = entry.getKey() % 10;
            if( s == 0)
                evenExist = true;
            else
                oddExist = true;
        }
        if(evenExist)
            Semester.addItem("Even");
        if(oddExist)
            Semester.addItem("Odd");
        // set size of semester comboBox
        Semester.setSize(100,30);
        // set location of semester comboBox in right side of semester label
        Semester.setLocation(120,100);
        // add semester comboBox to panel
        panel.add(Semester);





        // create button
        button = new JButton(new AbstractAction("Search") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the selected item from year comboBox
                String selectedYear = (String) year.getSelectedItem();
                // get the selected item from semester comboBox
                String selectedSemester = (String) Semester.getSelectedItem();
                if( selectedSemester.equals("Even") )
                    selectedSemester = "0";
                else
                    selectedSemester = "1";
                // create new resultGUI
                Integer key = Integer.parseInt(selectedYear) * 10 + Integer.parseInt(selectedSemester);
                // if coursesMap contains the selected year and semester
                if(!coursesMap.containsKey(key))
                    JOptionPane.showMessageDialog(null, "No course taken in this session");
                else
                {
                    // get courses from coursesMap
                    ArrayList<ArrayList<String>> courses = coursesMap.get(key);
                    new gradeScreen(propertiesMap.get("hasName"), propertiesMap.get("hasRollNo"), courses);
                }

            }

        });
        // set size of button
        button.setSize(100,40);
        // set location of button
        button.setLocation(10,150);
        // add button to panel
        panel.add(button);

        // create exit button

        backButton = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new facilities(propertiesMap, coursesMap);
            }
        });
        backButton.setSize(100,40);
        backButton.setLocation(100,150);
        panel.add(backButton);




    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
