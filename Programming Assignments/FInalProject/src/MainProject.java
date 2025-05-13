import java.util.*;
import java.io.*;

public class MainProject {
    
    ArrayList<KeyRetrieval> mainArr = new ArrayList<>();

    /**
     * Ok so, it returns an arraylist of a count of errors, so that the gui can know what to do then
     * @param filename
     * @return
     * @throws IOException
     */
    public ArrayList<String> option1Logic(String filename) throws IOException
    {
        File f = new File(filename);
        Scanner inFile = new Scanner(f);

        ArrayList<String> errorCount = new ArrayList<>();

        while (inFile.hasNext()) 
        {
                String in = inFile.nextLine();
                String[] inArr = in.split(" ");
            try
            {
                
                if (inArr.length == 3) 
                {
                    Course c = new Course(Integer.parseInt(inArr[0]), inArr[1], Integer.parseInt(inArr[2]));
                    mainArr.add(c);
                }
                else if(inArr.length == 7)
                {
                    if(inArr[5].equals("NoMajor"))
                    {
                        Student noMajorStu = new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], Float.parseFloat(inArr[6]));
                        mainArr.add(noMajorStu);
                    }
                    else
                    {
                       Faculty fal = new Faculty(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], inArr[6]);
                        mainArr.add(fal);
                    }
                }
                else if(inArr.length == 8)
                {
                    Student s = new Student(inArr[0], inArr[1], inArr[2], inArr[3], Integer.parseInt(inArr[4]), inArr[5], inArr[6], Float.parseFloat(inArr[7]));                
                    mainArr.add(s);
                }
                }
            catch(Exception a)
            {
               errorCount.add(in);
                
            }
        }

        return errorCount;
    }
}
