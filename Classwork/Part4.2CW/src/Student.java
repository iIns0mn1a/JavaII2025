import java.io.*;
import java.util.*;

public class Student {

    private String name;
    private float grade;


    public Student(String name, float grade)
    {
        this.grade = grade;
        this.name =name;
    }

    /**
     * tostring for testing file read
     */
    public String toString()
    {
        return name;
    }

    public static void main(String[] args) throws IOException{


        Scanner sc = new Scanner(System.in);
        ArrayList<Student> classroom = new ArrayList<>();
        System.out.println("Enter input file name: ");
        String inFile = sc.nextLine();

        System.out.println("Enter output file name: ");
        String outFile = sc.nextLine();

        File f = new File(inFile);
        Scanner input = new Scanner(f);

        while(input.hasNextLine())
        {
            String curLine = input.nextLine();

            String[] inCount = curLine.split(" ");

            if(inCount.length != 3)
            {
                System.out.printf("\"%s\" does not contain all 3 needed pieces.\n", curLine);
            }
// put everything else into an else
            else
            {
            String name = inCount[0] + " " + inCount[1];
            float grade = 0;
            try {
                grade = Float.parseFloat(inCount[2]);
           
    
                classroom.add(new Student(name, grade));
                
           } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.printf("\"%s\" contains an invalid grade. For input string: \"%s\"\n", curLine, inCount[2]);
                
           }

            

           

            }
        }

        PrintWriter pow = new PrintWriter(outFile);

        for(int i =0; i<classroom.size()-1; i++)
        {
            pow.print(classroom.get(i) + ", ");
        }

        pow.println(classroom.get(classroom.size()-1));

        float avg = 0f;
        for(Student c : classroom)
        {
            avg += c.grade;
        }

        avg /= classroom.size();

        pow.printf("\n%-15s %10.1f", "Average", avg);


        pow.close();
        input.close();
        sc.close();

    }
}
