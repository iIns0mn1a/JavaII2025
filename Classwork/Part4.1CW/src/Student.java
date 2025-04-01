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

        /* Create input file for the program */
        PrintWriter pw = new PrintWriter("students.txt");
        pw.print("Minnie Mouse 98.7\nBob Builder 65.8\nMickey Mouse 95.1\nPopeye SailorMan 78.6\n");
        pw.close();
        PrintWriter pw2 = new PrintWriter("students2.txt");
        pw2.print("Donald Duck 77.77\nTweety Bird 55.555\nCharlie Brown 95.231\n");
        pw2.close();
        /* End of creating the input file */


        Scanner sc = new Scanner(System.in);
        ArrayList<Student> classroom = new ArrayList<>();
        System.out.println("Enter input file name: ");
        String inFile = sc.nextLine();

        System.out.println("Enter output file name: ");
        String outFile = sc.nextLine();

        File f = new File(inFile);
        Scanner input = new Scanner(f);

        while(input.hasNext())
        {
            String first = input.next();
            String last = input.next();
            float grade = input.nextFloat();

            classroom.add(new Student(first +" " + last, grade));
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

            /* test output file */
            Scanner testOutput = new Scanner(new File("average.txt"));
            while(testOutput.hasNext())
                System.out.println(testOutput.nextLine());
            /* end of test output file */
    }
}
