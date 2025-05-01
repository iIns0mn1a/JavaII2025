import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * PSA: notes are just me making sense of what i just wrote.
 */
public class App extends JFrame{
//initializing actual panel "parts"
    private JLabel distance;
    private JLabel convDistance;
    private JTextField dist;
    private JTextField convDist;
    private JButton kmConvert;
    private JButton mileConvert;

    private JRadioButton mileUnit;
    private JRadioButton kmUnit;
    private JCheckBox sameUnit;


    /**
     * constructor makes actual JFrame, and calls void method to actually form the window,
     */
    public App()
    {
        setSize(350, 250);
        setTitle("Distance Conversion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeWindow();
        setVisible(true);

        
    }

    //method makes panel, that makes window content. probably can make multiple panels. (look at it like the html box model maybe?)
    public void makeWindow()
    {
        JPanel panel = new JPanel();

        distance = new JLabel("Distance");
        convDistance = new JLabel("Converted Distance");
        dist = new JTextField(15);
        convDist = new JTextField(15);
        kmConvert = new JButton("Convert to KM");
        mileConvert = new JButton("Convert to Miles");

        mileUnit = new JRadioButton("Miles");
        kmUnit = new JRadioButton("KM");
        sameUnit = new JCheckBox("Allow same unit conversion");

        ButtonGroup unitGroup = new ButtonGroup();

        unitGroup.add(mileUnit);
        unitGroup.add(kmUnit);



        kmConvert.addActionListener(new KmActions());
        mileConvert.addActionListener(new MileActions());


        panel.add(distance);
        panel.add(dist);
        panel.add(mileUnit);
        panel.add(kmUnit);
        panel.add(convDistance);
        panel.add(convDist);
        panel.add(kmConvert);
        panel.add(mileConvert);
        panel.setBackground(Color.cyan);
        kmConvert.setForeground(Color.blue);
        mileConvert.setForeground(Color.blue);

        add(panel);

    }

    public class MileActions implements ActionListener //convert from km to miles
    {
        public void actionPerformed(ActionEvent a)
        {
            double input = Double.parseDouble(dist.getText());

            double output = input * .62;
            
            convDist.setText(Double.toString(output));
        }
    }

    public class KmActions implements ActionListener  //convert from miles to km
    {
        public void actionPerformed(ActionEvent a)
        {
            double input = Double.parseDouble(dist.getText());

            double output = input * 1.6;
            
            convDist.setText(Double.toString(output));
        }
    }
    public static void main(String[] args) throws Exception {
        App a = new App();
    }
    }
