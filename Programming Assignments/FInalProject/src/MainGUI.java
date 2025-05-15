import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * ok, i think everyting is going to start in the main gui first, main method makes MainProject obj, then each screen takes that as an arguement
 */
public class MainGUI extends JFrame {

    private ArrayList<KeyRetrieval> uniArray;
    private Option1 o1;
  
    public MainGUI()
    {
        uniArray = new ArrayList<>();

        setTitle("College Records");
        setSize(500,250);
        mainScreen();    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

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


        p.add(title, BorderLayout.NORTH);
        p.add(buttonPanel, BorderLayout.CENTER);

        add(p);

    }

    public class Option1Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {

            o1 = new Option1(uniArray);
            System.out.println("UniArray before calling updateArray() (should be different form previous ouptpot ): " + uniArray);
            updateArray();
            System.out.println("UniArray after calling updateArray(): " + uniArray);
            
        }
    }

    public void updateArray()
    {
        uniArray = o1.getNewArray();
    }


    public static void main(String[] args) {
        MainGUI m = new MainGUI();
    }
}
