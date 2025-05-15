import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Option3 extends JFrame{

    public Option3()
    {
        setTitle("Option 1: Upload from File");
        setSize(350,150);
        option3Screen();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
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
}
