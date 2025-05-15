import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Option1 extends JFrame {

    private ArrayList<KeyRetrieval> localArray; 

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

    public class Option1Action implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            localArray = option1Logic(inputFile.getText());

            System.out.println("Local Array after button press: " + localArray);
        }
    }

    public ArrayList<KeyRetrieval> getNewArray(){return localArray;}

    public ArrayList<KeyRetrieval> option1Logic(String filename)
    { 
        
        ArrayList<KeyRetrieval> newArr = new ArrayList<>();
        
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
                    System.out.println("Show split lines: " + Arrays.toString(inArr)); //debug line
                    if (inArr.length == 3) 
                    {
                        Course c = new Course(Integer.parseInt(inArr[0]), inArr[1], Integer.parseInt(inArr[2]));
                        newArr.add(c);
                            System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                    }
                    else if(inArr.length == 7)
                    {
                        if(inArr[5].equals("NoMajor"))
                        {
                            Student noMajorStu = new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], Float.parseFloat(inArr[6]));
                            newArr.add(noMajorStu);
                                System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                        }
                        else
                        {
                        Faculty fal = new Faculty(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], inArr[6]);
                            newArr.add(fal);
                                System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                        }
                    }
                    else if(inArr.length == 8)
                    {
                         
                        System.out.println(String.format("%s%s", inArr[5].substring(0,4), inArr[5].substring(5)));
                
                        newArr.add(new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), String.format("%s%s", inArr[5].substring(0,4), inArr[5].substring(5)), inArr[6], Float.parseFloat(inArr[7]))) ;   
                        
                        System.out.println(inArr[0] + " " + inArr[1] + " was added to arraylist");
                    }
                    else
                        throw new Exception();
               
                    }
                catch(Exception a)
                {
                    System.out.println("previous person was misisng something, error message: " + a.getMessage());
                    
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
                    JOptionPane.showMessageDialog(null, msg);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Import Successful");
                }
                JOptionPane.showMessageDialog(null, Integer.toString(newArr.size()));
        }
        catch (IOException a)
        {
            JOptionPane.showMessageDialog(null, "File Reading error: File not found");
        }
       

        return newArr;
    }

}
