package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class gradeScreen {

    //create JFrame
    JFrame frame = new JFrame();
    //create JPanel
    JPanel panel = new JPanel();
    //create JLabel for name, roll number
    JLabel name = new JLabel("Name: ");
    JLabel roll = new JLabel("Roll Number: ");
    JButton button = new JButton();
    public gradeScreen(String studentName, String rollNumber, ArrayList<ArrayList<String>> courses)
    {
        //set JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setTitle("Grade Screen");
        //set JPanel
        panel.setLayout(null);

        //set JLabels
        name.setBounds(10, 10, 150, 30);
        roll.setBounds(10, 50, 150, 30);

        //set Button with Abstract Action
        button = new JButton("Back");
        button.setBounds(10, 300, 100, 30);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.dispose();
            }
        });

        //add JLabel to JPanel
        name.setText("Name: \t"+studentName);
        roll.setText("Roll Number: \t"+rollNumber);

        panel.add(name);
        panel.add(roll);
        //add JButton to JPanel
        panel.add(button);
        //add JPanel to JFrame
        int size = courses.size();
        //make array of JLabels of size
        JLabel[] outputs = new JLabel[size];
        String str = "";
        int pos = 0, x = 0;
        for( ArrayList<String> course : courses){
            str = course.get(0)+"   "+course.get(1)+"   "+course.get(2)+"   "+course.get(3);
            outputs[pos] = new JLabel(str);
            outputs[pos].setSize(300, 50);
            outputs[pos].setLocation(30, 100+x);
            panel.add(outputs[pos]);
            pos++;
            x += 25;

            // print the result in single line
            System.out.println(str);
        }

        frame.add(panel);


    }
}