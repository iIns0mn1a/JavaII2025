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

        while(input.hasNext())
        {
            
            String first = input.next();
            String last = "";
            float grade = 0;
            try {
                last = input.next();
            }
            
            catch (InputMismatchException e) {
                System.out.println("this was caught");
            }
            
           
            try {
            grade = input.nextFloat();    
            } catch (InputMismatchException e) {
                System.out.println("This was also caught");
            }
            

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

    }
}
