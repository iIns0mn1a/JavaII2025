import java.util.*;
import java.io.*;

public class ValidStrings {

    private int maxLength;
    private ArrayList<String> arr = new ArrayList<>();

    public ValidStrings(int maxLength)
    {
        this.maxLength = maxLength;
    }

    public void add(String s) throws InvalidStringException
    {
        if(s.length() > maxLength)
        {
            throw new InvalidStringException(s, maxLength);
        }
        else
        {
            for(int i = 0; i<s.length(); i++)
            {
                if(Character.isDigit(s.charAt(i)))
                {
                    throw new InvalidStringException(s);
                }
            }
        }
        
      arr.add(s);

    }

    public String toString()
    {
        String s = "";

        for(String str : arr)
        {
            s += str + " ";
        }

        return s;
    }
    public static void main(String[] args) throws Exception {
        
      

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input file name:");

        String inFile = sc.nextLine();

        System.out.println("Enter max length allowed for strings:");
        int length = sc.nextInt();

        ValidStrings v = new ValidStrings(length);

        File f = new File(inFile);
        Scanner input = new Scanner(f);

        while (input.hasNext()) {
            String str = input.next();
            try {
                v.add(str);
            } catch (InvalidStringException e) {


                System.out.printf("\'%s\' has an error\n%s\n", str, e.getMessage());
            }
        }

        System.out.println(v);

    }
}
