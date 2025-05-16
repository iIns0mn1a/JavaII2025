package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.*;

/**
 * Class for Option 3
 */
public class Option3 extends JFrame{

    private ArrayList<KeyRetrieval> local;

    private JTextField inputFile;

    /**
     * Option 3 GUI Window constructor
     * @param uni
     */
    public Option3(ArrayList<KeyRetrieval> uni)
    {
        local = uni;
        setTitle("Option 1: Upload from File");
        setSize(350,150);
        option3Screen();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Option 3 Jpanel creation
     */
    public void option3Screen()
    {
        setSize(350,150);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        // setBackground(Color.orange); tried to make look good
        JLabel title = new JLabel("Download Statistics File", JLabel.CENTER);

        p.add(title, BorderLayout.NORTH);

        JPanel mid = new JPanel();
        JLabel boxText = new JLabel("Statistics File Name: ");
        inputFile = new JTextField(15);
        JButton enter = new JButton("Create Statistics File");

        mid.add(boxText);
        mid.add(inputFile);
        p.add(enter, BorderLayout.SOUTH);
        enter.addActionListener(new Option3Button());

        p.add(mid, BorderLayout.CENTER);

        add(p);

    }

    /**
     * Option 3 Button Action Listener
     */
    public class Option3Button implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            option3Logic();
        }
    }

    /**
     * Option 3 Logic, Makes record statistic list of original list, sorted students, and full sorted college record.
     */
    public void option3Logic()
    {
        try
        {
            PrintWriter output = new PrintWriter(inputFile.getText());
            ArrayList<Student> stuArr = new ArrayList<>();
            ArrayList<KeyRetrieval> copy = new ArrayList<>(local); //ngl, kinda just tried this to see if it would work, didn't think it would actually compile😭
            //original list order
            for (int i = 0; i < local.size(); i++) {
                output.println(local.get(i));

                if (local.get(i) instanceof Student) {
                    stuArr.add((Student)local.get(i));
                }
            }

            output.println();

            

            //sorted list of students w/ all info by last name
            Collections.sort(stuArr);

            for(Student s :stuArr)
            {
                output.println(s);
            }

            output.println();
            //sort all list items by key

            Collections.sort(copy, (a, b) -> a.getKey() - b.getKey());

            for(KeyRetrieval k : copy)
            {
                output.println(String.format("%d, %s", k.getKey(), k));
            }

         
            output.close();
            JOptionPane.showMessageDialog(null, "Statistics file made!");
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Output File doesn't exist," + e.getMessage());
            // ask during meeting, if a try catch method is used to catch a IOException, is there a way to still make the program create the missing file?
        }
    }
}
