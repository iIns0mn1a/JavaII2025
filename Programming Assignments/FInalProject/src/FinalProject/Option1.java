package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class for Option 1
 */
public class Option1 extends JFrame {

    private ArrayList<KeyRetrieval> localArray; 

    /**
     * Constructor for Option1 GUI window
     * @param uni
     */
    public Option1(ArrayList<KeyRetrieval> uni)
    {
        localArray = uni;
        setTitle("Option 1: Upload from File");
        setSize(350,150);
        option1Screen();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    }

private JTextField inputFile;

    /**
     * Method for making JPanel for option 1 
     */
    public void option1Screen()
    {

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        // setBackground(Color.orange); tried to make look good
        JLabel title = new JLabel("Upload Records from File", JLabel.CENTER);

        p.add(title, BorderLayout.NORTH);

        JPanel mid = new JPanel();
        JLabel boxText = new JLabel("Enter input file: ");
        inputFile = new JTextField(15);
        JButton enter = new JButton("Enter");

        mid.add(boxText);
        mid.add(inputFile);
        p.add(enter, BorderLayout.SOUTH);

        enter.addActionListener(new Option1Action());

        p.add(mid, BorderLayout.CENTER);

        add(p);

    }

    /**
     * ActionListener Class for enter button in option1Screen() 
     */
    public class Option1Action implements ActionListener
    {
        /**
         * button action for ent
         */
        public void actionPerformed(ActionEvent a)
        {
        option1Logic(inputFile.getText());

            System.out.println("Local Array after button press: " + localArray);

            for (KeyRetrieval ah : localArray) {
                if (ah instanceof Faculty) {
                    System.out.println("teacher name: " + ah);
                }
            }
        }
    }

    /**
     * returns local array as ArrayList obj
     * was made to be used to return local array to MainGUI's universal array
     * @return class's local array
     */
    public ArrayList<KeyRetrieval> getNewArray(){return localArray;}


    /**
     * actual logic for option 1
     * 
     * takes file as input, goes line by line in the file and adds valid lines to localArray,
     * 
     * invalid lines are collected and shown as a message to the user after fully read. 
     * @param filename inputted fileName as String
     * 
     */
    public void option1Logic(String filename)
    { 
        
        try
        {
        File f = new File(filename);
        Scanner inFile = new Scanner(f);

        ArrayList<String> errorArr= new ArrayList<>();
        
       
            while (inFile.hasNext()) 
            {
                    String in = inFile.nextLine();
                    String[] inArr = in.split(", ");
                try
                {
                    System.out.println("Show current line as array: " + Arrays.toString(inArr)); //debug line
                    if (inArr.length == 3) 
                    {
                        Course c = new Course(Integer.parseInt(inArr[0]), inArr[1], Integer.parseInt(inArr[2]));
                        localArray.add(c);
                            System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                    }
                    else if(inArr.length == 7)
                    {
                        if(inArr[5].equals("NoMajor"))
                        {
                            localArray.add(new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], Float.parseFloat(inArr[6])));
                                System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                        }
                        else
                        {
                            localArray.add(new Faculty(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], inArr[6]));
                                System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                        }
                    }
                    else if(inArr.length == 8)
                    {
                         
                        System.out.println(String.format("%s%s", inArr[5].substring(0,4), inArr[5].substring(5)));
                
                        localArray.add(new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), String.format("%s%s", inArr[5].substring(0,4), inArr[5].substring(5)), inArr[6], Float.parseFloat(inArr[7]))) ;   
                        
                        System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                    }
                    else
                        throw new BadLineException("Invalid Line");
               
                    }
                catch(Exception a)
                {
                    System.out.println("previous person was misisng something, error message: " + a.getMessage()); //debug line to view actual exception message
                    
                errorArr.add(in);
                    
                }
                
            }

                if(errorArr.size()>0)
                {
                    String msg = "The following lines have errors: ";

                    for(String s : errorArr)
                    {
                        msg += String.format("\n\"%s\"", s);
                    }
                    JOptionPane.showMessageDialog(null, "Success?",msg, 0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Import Successful");
                }
                // JOptionPane.showMessageDialog(null, "Testing",Integer.toString(localArray.size()), JOptionPane.PLAIN_MESSAGE);
        }
        catch (IOException a)
        {
            JOptionPane.showMessageDialog(null, "Error","File Reading error: File not found", 0);
        }
       


    }

}
