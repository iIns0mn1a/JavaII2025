package FinalProject;

import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Main Class, holds Main Screen GUI and Universal Array
 */
public class MainGUI extends JFrame {

    private ArrayList<KeyRetrieval> uniArray = new ArrayList<>();

   /** 
    * Main GUI windows constructor
    */
    public MainGUI()
    {
        uniArray = new ArrayList<>();

        setTitle("College Records");
        setSize(500,250);
        mainScreen();    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Main Menu JPanel creation method
     */
    public void mainScreen()
    {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        
        

        JLabel title = new JLabel("Welcome to CT State's Record System. Please choose from the following options:");
        
        p.setBackground(Color.CYAN);
        
        JButton c1 = new JButton("1. Upload Records from File");
        JButton c2 = new JButton("2. Add New Student");
        JButton c3 = new JButton("3. Download Statistics");
        JButton c4 = new JButton("4. Find Information");
        JButton c5 = new JButton("5. Exit Program");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,1));
        buttonPanel.add(c1);
        buttonPanel.add(c2);
        buttonPanel.add(c3);
        buttonPanel.add(c4);
        buttonPanel.add(c5);

        c1.addActionListener(new Option1Button());
        c2.addActionListener(new Option2Button());
        c3.addActionListener(new Option3Button());
        c4.addActionListener(new Option4Button());
        c5.addActionListener(new Option5Button());


        p.add(title, BorderLayout.NORTH);
        p.add(buttonPanel, BorderLayout.CENTER);

        add(p);

    }

    /**
     * Button Action Listener for Option 1
     */
    public class Option1Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            Option1 o1 = new Option1(uniArray);
        }
    }

       /**
     * Button Action Listener for Option 2
     */
    public class Option2Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
           Option2 o2 = new Option2(uniArray);
        }
    }

       /**
     * Button Action Listener for Option 3
     */
    public class Option3Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
           Option3 o3 = new Option3(uniArray);
        }
    }

       /**
     * Button Action Listener for Option 4
     */
    public class Option4Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
           Option4 o4 = new Option4(uniArray);
        }
    }

       /**
     * Button Action Listener for Option 5
     */
    public class Option5Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
           System.exit(0);
        }
    }



    public static void main(String[] args) {
        MainGUI m = new MainGUI();
    }
}
