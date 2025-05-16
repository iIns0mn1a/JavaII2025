package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class for Option 4
 */
public class Option4 extends JFrame{

    private JTextField inputFile;
    private ArrayList<KeyRetrieval> local;

    /**
     * Constructor for Option 4 GUI Window
     * @param uni
     */
    public Option4(ArrayList<KeyRetrieval> uni)
    {
        local = uni;
        setTitle("Option 4: Search for Information");
        setSize(350,150);
        option4Screen();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Option 4 JPanel Method
     */
    public void option4Screen()
    {
        setSize(350,150);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        // setBackground(Color.orange); tried to make look good
        JLabel title = new JLabel("Search for Information", JLabel.CENTER);

        p.add(title, BorderLayout.NORTH);

        JPanel mid = new JPanel();
        JLabel boxText = new JLabel("Input ID Key: ");
        inputFile = new JTextField(15);
        JButton enter = new JButton("Find");

        mid.add(boxText);
        mid.add(inputFile);
        p.add(enter, BorderLayout.SOUTH);
        enter.addActionListener(new Option4Button());
        p.add(mid, BorderLayout.CENTER);

        add(p);

    }

    /**
     * Option 4 enter Action Listener
     */
    public class Option4Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            option4Logic();
        }
    }

    /**
     * Option 4 logic method, searches records for inputted key
     */
    public void option4Logic()
    {
        for(int i = 0; i<local.size(); i++)
        {
            if(local.get(i).sameKey(Integer.parseInt(inputFile.getText())))
            {
                JOptionPane.showMessageDialog(null, "Information Found",String.format("%d, %s", local.get(i).getKey(), local.get(i)), 0);
                return;
            }

        }
        JOptionPane.showMessageDialog(null,"Information relating to that key could not be found.",  "ERROR",0);
    }
}
