import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Option2 extends JFrame {

    public Option2()
    {
        setTitle("Option 2: Add Student");
        setSize(500,250);
        option2Screen();   
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void option2Screen()
    {
        setSize(550, 250);
        JPanel p = new JPanel(new BorderLayout());
        
        JLabel title = new JLabel("Add New Student", JLabel.CENTER);
        p.add(title,BorderLayout.NORTH);
        
        JPanel mid = new JPanel(new GridLayout(7,2));
        
        
        //labels
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JLabel majorLabel = new JLabel("Major:");
        JLabel accountBalanceLabel = new JLabel("Account Balance:");
        
        //fieldss
        JTextField firstNameField = new JTextField(15);
        JTextField lastNameField = new JTextField(15);
        JTextField passwordField = new JTextField(15);
        JTextField confirmPasswordField = new JTextField(15);
        JTextField majorField = new JTextField(15);
        JTextField accountBalanceField = new JTextField(15);
        
        JRadioButton fullTime = new JRadioButton("Full Time");
        JRadioButton partTime = new JRadioButton("Part Time");
        JRadioButton noMajor = new JRadioButton("No Major");
        
        ButtonGroup type = new ButtonGroup();
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
        p.add(enter, BorderLayout.SOUTH);
     
        
        add(p);
        
    }
}
