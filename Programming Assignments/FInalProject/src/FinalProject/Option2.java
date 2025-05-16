package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class for Option 2
 */
public class Option2 extends JFrame {

    private ArrayList<KeyRetrieval> local;
    
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JTextField majorField;
    private JTextField accountBalanceField;

    private JRadioButton fullTime;
    private JRadioButton partTime;
    private JRadioButton noMajor;
    private JPanel p;
    private JPanel mid;

    /**
     * Constructor for Option 2 JFrame
     * @param uni
     */
    public Option2(ArrayList<KeyRetrieval> uni)
    {
        local = uni;
        setTitle("Option 2: Add Student");
        setSize(500,250);
        option2Screen();   
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Jpanel for option 2
     */
    public void option2Screen()
    {
        setSize(550, 250);
       p = new JPanel(new BorderLayout());
        
        JLabel title = new JLabel("Add New Student", JLabel.CENTER);
        p.add(title,BorderLayout.NORTH);
        
       mid = new JPanel(new GridLayout(7,2));
        
        
        //labels
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JLabel majorLabel = new JLabel("Major:");
        JLabel accountBalanceLabel = new JLabel("Account Balance:");
        
        //fieldss
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        passwordField = new JTextField(15);
        confirmPasswordField = new JTextField(15);
        majorField = new JTextField(15);
        accountBalanceField = new JTextField(15);
        
        fullTime = new JRadioButton("Full Time");
        partTime = new JRadioButton("Part Time");
        noMajor = new JRadioButton("No Major");
        
        ButtonGroup type = new ButtonGroup();
        type.add(fullTime);
        type.add(partTime);
        type.add(noMajor);
        JPanel buttons = new JPanel();
        buttons.add(fullTime);
        buttons.add(partTime);
        buttons.add(noMajor);
        JLabel typeLabel = new JLabel("Type:");
        
        
        mid.add(firstNameLabel);
        mid.add(firstNameField);
        mid.add(lastNameLabel);
        mid.add(lastNameField);
        mid.add(passwordLabel);
        mid.add(passwordField);
        mid.add(confirmPasswordLabel);
        mid.add(confirmPasswordField);
        mid.add(typeLabel);
        mid.add(buttons);
        mid.add(majorLabel);
        mid.add(majorField);
        mid.add(accountBalanceLabel);
        mid.add(accountBalanceField);
        
        p.add(mid, BorderLayout.CENTER);
        
        JButton enter = new JButton("Add Student");
        enter.addActionListener(new Option2Button());
        p.add(enter, BorderLayout.SOUTH);
     
        
        add(p);
        
    }

    /**
     * Option 2 Enter Button Listener, calls option2Logic
     */
    public class Option2Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            option2Logic();
        }
    }

    /**
     * Logic for Option 2, take inputted information and adds new student to record.
     */
    public void option2Logic()
    {
        String email = lastNameField.getText() + firstNameField.getText() + "@ctstate.edu";

        int bannerID = Student.getNextBannerID();


        if(passwordField.getText().equals(confirmPasswordField.getText()))
        {
            if(passwordField.getText().indexOf(firstNameField.getText())>-1 || passwordField.getText().indexOf(lastNameField.getText())>-1)
            {
                p.setBackground(Color.red);
                mid.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Password cannot contain first or last name", "Error", 0);
                
            }
            else
            {
                try 
                {
                    if(fullTime.isSelected())
                    {
                        p.setBackground(Color.white);
                        mid.setBackground(Color.white);
                        local.add(new Student(firstNameField.getText(), lastNameField.getText(), email, passwordField.getText(), bannerID, "FullTime", majorField.getText(), Float.parseFloat(accountBalanceField.getText())));
                        JOptionPane.showMessageDialog(null, "Success! Student Added.");
                    } 
                    else if(partTime.isSelected())
                    {
                        p.setBackground(Color.white);
                        mid.setBackground(Color.white);
                        local.add(new Student(firstNameField.getText(), lastNameField.getText(), email, passwordField.getText(), bannerID, "PartTime", majorField.getText(), Float.parseFloat(accountBalanceField.getText())));
                        JOptionPane.showMessageDialog(null, "Success! Student Added.");
                    }
                    else if(noMajor.isSelected())
                    {
                        p.setBackground(Color.white);
                        mid.setBackground(Color.white);
                        local.add(new Student(firstNameField.getText(), lastNameField.getText(), email, passwordField.getText(), bannerID, "NoMajor", Float.parseFloat(accountBalanceField.getText())));
                        JOptionPane.showMessageDialog(null, "Success! Student Added.");
                        
                    }

                } 
                catch (Exception e) 
                {
                    p.setBackground(Color.red);
                    mid.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "you broke it, good job. (you probably left something empty, or unselected)\n" + e.getMessage());

                }
               
            }
            
        }
        else
        {
            p.setBackground(Color.red);
            mid.setBackground(Color.red);
            JOptionPane.showMessageDialog(null,"Passwords do not match",  "Error", 0);
        }
        
    }
}

// local.add(new student(firstNameField.getText(), lastNameField.getText(), email, passwordField.getText(), bannerID, /*insert student type here*/, majorField.getText(), Float.parseFloat(accountBalanceField.getText()) ));   