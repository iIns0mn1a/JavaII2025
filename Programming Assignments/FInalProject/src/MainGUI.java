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

    // private static MainProject logic = new MainProject();
    //when opeing new screens, maybe make constructor take arguement to decide screen
    public MainGUI(int i, ArrayList<KeyRetrieval> uni)
    {
        uniArray = uni;
        setTitle("College Records");
        setSize(500,250);
        
        if(i==0)
        {
            mainScreen();
        }
        else if(i == 1)
        {
            option1Screen();
        }
        else if (i == 2) {
            option2Screen();
        }
        else if(i == 3)
        {
            option3Screen();
        }
        else if (i == 4) {
            option4Screen();
        }
        
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

        c1.addActionListener(new UploadOptionButton());
    

        p.add(title, BorderLayout.NORTH);
        p.add(buttonPanel, BorderLayout.CENTER);

        add(p);

    }

    public class UploadOptionButton implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            MainGUI m1 = new MainGUI(1, uniArray) ;
        }
    }



    private JTextField inputFile;
    public void option1Screen()
    {
        setSize(350,150);
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
        enter.addActionListener(new Option1Event());
        p.add(enter, BorderLayout.SOUTH);

        p.add(mid, BorderLayout.CENTER);

        add(p);

    }

    /**
     * nested class for option 1 button
     */
    public class Option1Event implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            try {
                uniArray = option1Logic(inputFile.getText());
                

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File Issue: File doesn't exist.");
            }
            String ans = Integer.toString(uniArray.size());

          
            JOptionPane.showMessageDialog(null, uniArray);
        }
    }
    
private JTextField firstNameField;
private JTextField lastNameField;
private JTextField passwordField;
private JTextField confirmPasswordField;
private JTextField majorField;
private JTextField accountBalanceField;

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
        enter.addActionListener(new Option2Action());
        
        add(p);
        
    }

    public class Option2Action implements ActionListener
    {
        public void actionPerformed(ActionEvent a )
        {
            String email = firstNameField.getText().substring(0,1) + lastNameField.getText() +"@ctstate.edu";
            if () {
                
            }
        }
    }
    
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
        JTextField inputFile = new JTextField(15);
        JButton enter = new JButton("Create Statistics File");

        mid.add(boxText);
        mid.add(inputFile);
        p.add(enter, BorderLayout.SOUTH);

        p.add(mid, BorderLayout.CENTER);

        add(p);

    }

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
        JTextField inputFile = new JTextField(15);
        JButton enter = new JButton("Find");

        mid.add(boxText);
        mid.add(inputFile);
        p.add(enter, BorderLayout.SOUTH);

        p.add(mid, BorderLayout.CENTER);

        add(p);

    }

     public ArrayList<KeyRetrieval> option1Logic(String filename) throws IOException
    {
        File f = new File(filename);
        Scanner inFile = new Scanner(f);

        ArrayList<KeyRetrieval> newArr = new ArrayList<>();
        ArrayList<String> errorArr= new ArrayList<>();
        
        while (inFile.hasNext()) 
        {
                String in = inFile.nextLine();
                String[] inArr = in.split(", ");
            try
            {
                System.out.println(inArr[1]);
                if (inArr.length == 3) 
                {
                    Course c = new Course(Integer.parseInt(inArr[0]), inArr[1], Integer.parseInt(inArr[2]));
                    newArr.add(c);
                }
                else if(inArr.length == 7)
                {
                    if(inArr[5].equals("NoMajor"))
                    {
                        Student noMajorStu = new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], Float.parseFloat(inArr[6]));
                        newArr.add(noMajorStu);
                    }
                    else
                    {
                       Faculty fal = new Faculty(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], inArr[6]);
                        newArr.add(fal);
                    }
                }
                else if(inArr.length == 8)
                {
             
                    newArr.add(new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], inArr[6], Float.parseFloat(inArr[7]))) ;              
                }
                }
            catch(Exception a)
            {
               errorArr.add(in);
                
            }
            System.out.println(Arrays.toString(inArr));
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

        return newArr;
    }

    public static void main(String[] args) {
        MainGUI m = new MainGUI(0, new ArrayList<>());
    }
}
