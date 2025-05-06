import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class App extends JFrame{

    JRadioButton daytime;
    JRadioButton evening;
    JRadioButton offpeak;
    ButtonGroup timeGroup;
    
    JLabel minLabel;
    JTextField minutes;
    JButton calcButton;
    JButton exitButton;

    public App()
    {
        setTitle("Call Minute Calculator");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makeWindow();

        setVisible(true);
    }


    public void makeWindow()
    {


        JPanel p = new JPanel();

        daytime = new JRadioButton("Daytime (6 am to 5:59 pm): 7 cents a minute.");
        evening = new JRadioButton("Evening (6 pm to 11:59 pm): 12 cents a minute.");
        offpeak = new JRadioButton("Off-peak (12 am to 5:59 am): 5 cents a minute.");

        minLabel = new JLabel("Minutes:");
        minutes = new JTextField(15);
        calcButton = new JButton("Calculate Price");
        exitButton = new JButton("Exit Program");

        calcButton.addActionListener(new CalcButton());
        exitButton.addActionListener(new ExitButton());
        p.setBackground(Color.magenta);


        timeGroup = new ButtonGroup();
        timeGroup.add(daytime);
        timeGroup.add(evening);
        timeGroup.add(offpeak);

        p.add(minLabel);
        p.add(minutes);
        p.add(daytime);
        p.add(evening);
        p.add(offpeak);
        p.add(calcButton);
        p.add(exitButton);

        add(p);

   
    }

    public class CalcButton implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(daytime.isSelected())
            {
                double fine = Double.parseDouble(minutes.getText()) * .07; 
                String message = String.format("Cost of this call will be: $%.2f", fine); //was messing around with arguments, and got the symbols to change
                JOptionPane.showMessageDialog(null, message, "Call Calculation", 2);
            }
            else if (evening.isSelected()) 
            {
                double fine = Double.parseDouble(minutes.getText()) * .12; 
                String message = String.format("Cost of this call will be: $%.2f", fine);
                JOptionPane.showMessageDialog(null, message, "Call Calculation", 2);
            }
            else if (offpeak.isSelected()) 
            {
                double fine = Double.parseDouble(minutes.getText()) * .05; 
                String message = String.format("Cost of this call will be: $%.2f", fine);
                JOptionPane.showMessageDialog(null, message, "Call Calculation", 2);
            }
                
            
        }
    }

    public class ExitButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        App a = new App();
    }


}
