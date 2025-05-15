import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Option4 extends JFrame{

    public Option4()
    {
        setTitle("Option 4: Search for Information");
        setSize(350,150);
        option4Screen();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
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
}
