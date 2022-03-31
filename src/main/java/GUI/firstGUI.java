package GUI;


import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.util.*;

public class firstGUI extends JFrame implements ActionListener {


    static JFrame frame;
    static JPanel panel;
    JLabel label;
    JComboBox comboBox;
    JTextField textField;
    JButton button;
    public firstGUI(){
        frame = new JFrame("Student Portal");
        label = new JLabel("Enter Roll Number");
        textField = new JTextField(10);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setSize(400,400);
        button = new JButton("Submit");
        button.addActionListener(this);

        label.setSize(140,20);
        textField.setSize(150,30);
        button.setSize(100,30);
        label.setLocation(10,30);
        textField.setLocation(170,30);
        button.setLocation(90,80);
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        String roll = textField.getText();
        HashMap<String, String> propertiesMap = new HashMap<>();

        // hashmap :: key = pair of integers , value = vector<(course,  courseId, credits , grade)>
        Map<Integer, ArrayList<ArrayList<String>>> coursesMap = new HashMap<>();



        try{
            //get list of ontologies
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File("C:\\Users\\satya\\Desktop\\s11.owl"));



            // print the individuals of the ontology
            Set<OWLNamedIndividual> individuals = ontology.getIndividualsInSignature();
            // finalIndividual
            OWLNamedIndividual finalIndividual = null;
            for (OWLNamedIndividual individual : individuals) {
                Set<OWLDataPropertyAssertionAxiom> properties=ontology.getDataPropertyAssertionAxioms(individual);


                // search for the individual with the given roll number
                for (OWLDataPropertyAssertionAxiom property : properties) {
                    OWLDataPropertyExpression propertyName = property.getProperty();
                    // get string representation of the property
                    String propertyString = propertyName.toString();
                    // get the string name of the property which is in between # and >
                    String propertyNameString = propertyString.substring(propertyString.indexOf("#") + 1, propertyString.indexOf(">"));
                    OWLLiteral propertyValue = property.getObject();
                    // get string representation of the property value
                    String propertyValueString = propertyValue.toString();
                    // get the string value of the property value which is in between " and "
                    String propertyValueStringValue = propertyValueString.substring(propertyValueString.indexOf("\"") + 1, propertyValueString.lastIndexOf("\""));

                    // search for the individual with the given roll number
                    if (propertyNameString.equals("hasRollNo") && propertyValueStringValue.equals(roll)) {
                        // get the properties of the individual
                        finalIndividual = individual;
                    }
                }
            }

            if (finalIndividual != null) {
                // get the properties of the individual
                Set<OWLDataPropertyAssertionAxiom> properties=ontology.getDataPropertyAssertionAxioms(finalIndividual);
                for (OWLDataPropertyAssertionAxiom property : properties) {
                    OWLDataPropertyExpression propertyName = property.getProperty();
                    // get string representation of the property
                    String propertyString = propertyName.toString();
                    // get the string name of the property which is in between # and >
                    String propertyNameString = propertyString.substring(propertyString.indexOf("#") + 1, propertyString.indexOf(">"));
                    OWLLiteral propertyValue = property.getObject();
                    // get string representation of the property value
                    String propertyValueString = propertyValue.toString();
                    // get the string value of the property value which is in between " and "
                    String propertyValueStringValue = propertyValueString.substring(propertyValueString.indexOf("\"") + 1, propertyValueString.lastIndexOf("\""));
                    propertiesMap.put(propertyNameString, propertyValueStringValue);
                    System.out.println(propertyNameString + " : " + propertyValueStringValue);

                }

                // get object properties of the individual
                Set<OWLObjectPropertyAssertionAxiom> objectProperties=ontology.getObjectPropertyAssertionAxioms(finalIndividual);
                for (OWLObjectPropertyAssertionAxiom objectProperty : objectProperties) {
                    OWLObjectPropertyExpression propertyName = objectProperty.getProperty();
                    // get string representation of the property
                    String propertyString = propertyName.toString();
                    // get the string name of the property which is in between # and >
                    String propertyNameString = propertyString.substring(propertyString.indexOf("#") + 1, propertyString.indexOf(">"));
                    OWLIndividual propertyValue = objectProperty.getObject();

                    if( propertyNameString.equals("hasGradeInCourse")){
                        // print property value
                        System.out.println(propertyNameString + " : " + propertyValue.toString());
                        HashMap<String, String> propertiesMap2 = new HashMap<String, String>();

                        // get object properties of the property value
                        Set<OWLObjectPropertyAssertionAxiom> objectProperties2=ontology.getObjectPropertyAssertionAxioms(propertyValue);

                        for (OWLObjectPropertyAssertionAxiom objectProperty2 : objectProperties2) {
                            OWLObjectPropertyExpression propertyName2 = objectProperty2.getProperty();
                            // get string representation of the property
                            String propertyString2 = propertyName2.toString();
                            // get the string name of the property which is in between # and >
                            String propertyNameString2 = propertyString2.substring(propertyString2.indexOf("#") + 1, propertyString2.indexOf(">"));
                            OWLIndividual propertyValue2 = objectProperty2.getObject();
                            // print property value
                            System.out.println(propertyNameString2 + " : " + propertyValue2.toString());

                            // get data properties of the propertyValue2
                            Set<OWLDataPropertyAssertionAxiom> properties2=ontology.getDataPropertyAssertionAxioms(propertyValue2);
                            // hashmap to store the properties of the propertyValue2

                            for (OWLDataPropertyAssertionAxiom property2 : properties2) {
                                OWLDataPropertyExpression propertyNam2 = property2.getProperty();
                                // get string representation of the property
                                String propertyString3 = propertyNam2.toString();
                                // get the string name of the property which is in between # and >
                                String propertyNameString3 = propertyString3.substring(propertyString3.indexOf("#") + 1, propertyString3.indexOf(">"));
                                OWLLiteral propertyValue3 = property2.getObject();
                                // get string representation of the property value
                                String propertyValueString3 = propertyValue3.toString();
                                // get the string value of the property value which is in between " and "
                                String propertyValueStringValue3 = propertyValueString3.substring(propertyValueString3.indexOf("\"") + 1, propertyValueString3.lastIndexOf("\""));
                                // print property value
                                System.out.println(propertyNameString3 + " : " + propertyValueStringValue3);
                                // add the property to the hashmap
                                propertiesMap2.put(propertyNameString3, propertyValueStringValue3);
                            }
                        }

                        // get data properties of the propertyValue
                        Set<OWLDataPropertyAssertionAxiom> dataProperties=ontology.getDataPropertyAssertionAxioms(propertyValue);
                        // hashmap to store the properties of the propertyValue
                        for (OWLDataPropertyAssertionAxiom property : dataProperties) {
                            OWLDataPropertyExpression propertyName1 = property.getProperty();
                            // get string representation of the property
                            String propertyString1 = propertyName1.toString();
                            // get the string name of the property which is in between # and >
                            String propertyNameString1 = propertyString1.substring(propertyString1.indexOf("#") + 1, propertyString1.indexOf(">"));
                            OWLLiteral propertyValue1 = property.getObject();
                            // get string representation of the property value
                            String propertyValueString1 = propertyValue1.toString();
                            // get the string value of the property value which is in between " and "
                            String propertyValueStringValue1 = propertyValueString1.substring(propertyValueString1.indexOf("\"") + 1, propertyValueString1.lastIndexOf("\""));
                            // print property value
                            System.out.println(propertyNameString1 + " : " + propertyValueStringValue1);
                            // add the property to the hashmap
                            propertiesMap2.put(propertyNameString1, propertyValueStringValue1);

                        }

                        Integer keyValue = Integer.parseInt(propertiesMap2.get("hasYear")) * 10  + Integer.parseInt(propertiesMap2.get("hasSem"));
                        ArrayList<String> values = new ArrayList<String>();
                        values.add(propertiesMap2.get("hasName"));
                        values.add(propertiesMap2.get("hasId"));
                        values.add(propertiesMap2.get("hasCredits"));
                        values.add(propertiesMap2.get("hasGrade"));

                        if (coursesMap.containsKey(keyValue)) {
                            coursesMap.get(keyValue).add(values);
                        }
                        else
                        {
                            ArrayList<ArrayList<String>> valuesList = new ArrayList<ArrayList<String>>();
                            valuesList.add(values);
                            coursesMap.put(keyValue, valuesList);
                        }

                    }


                    // find the data properties of the individual propertyValue
                    else {
                    Set<OWLDataPropertyAssertionAxiom> dataProperties=ontology.getDataPropertyAssertionAxioms(propertyValue.asOWLNamedIndividual());
                    for (OWLDataPropertyAssertionAxiom dataProperty : dataProperties) {
                        OWLDataPropertyExpression dataPropertyName = dataProperty.getProperty();
                        // get string representation of the property
                        String dataPropertyString = dataPropertyName.toString();
                        // get the string name of the property which is in between # and >
                        String dataPropertyNameString = dataPropertyString.substring(dataPropertyString.indexOf("#") + 1, dataPropertyString.indexOf(">"));
                        OWLLiteral dataPropertyValue = dataProperty.getObject();
                        // get string representation of the property value
                        String dataPropertyValueString = dataPropertyValue.toString();
                        // get the string value of the property value which is in between " and "
                        String dataPropertyValueStringValue = dataPropertyValueString.substring(dataPropertyValueString.indexOf("\"") + 1, dataPropertyValueString.lastIndexOf("\""));
                        propertiesMap.put(propertyNameString + dataPropertyNameString, dataPropertyValueStringValue);
                        System.out.println(propertyNameString + dataPropertyNameString + " : " + dataPropertyValueStringValue);
                    }
                    }


                }

                frame.dispose();

                // print the hashmap coursesMap
                for (Map.Entry<Integer, ArrayList<ArrayList<String>>> entry : coursesMap.entrySet()) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }

                studentGUI obj = new studentGUI( propertiesMap, coursesMap);
            }
            else {
                JOptionPane.showMessageDialog(null, "No such roll number exists");
            }





        }catch (Exception exp){
            exp.printStackTrace();
        }


    }

    public static void main(String[] args) {
        firstGUI gui = new firstGUI();
    }
}



