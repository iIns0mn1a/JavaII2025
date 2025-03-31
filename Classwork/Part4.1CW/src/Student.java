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
        return name + "Grade: " + grade;
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

        while(input.hasNext())
        {
            String first = input.next();
            String last = input.next();
            float grade = input.nextFloat();

            classroom.add(new Student(first +" " + last, grade));
        }

        PrintWriter pw = new PrintWriter("output.txt");

        for(Student c : classroom)
        {
            pw.println(c);
        }

        pw.close();
        input.close();
    }
}
