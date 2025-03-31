


import java.util.*;

// version 1.4  FINAL

public class Part1PA {
    
    /**
     * Returns how many words are in the 'str' sentence
     * @param str inputted string
     * @return num of words in sentence
     */
    public static int wordCounter(String str)
    {
        int count = 1;
        int spaceIndex = str.indexOf(" ");
        while(spaceIndex != -1)
        {
            spaceIndex = str.indexOf(" ", spaceIndex+1);
            count++;
        }
        return count;
    }

    /**
     * takes an array of characters and makes it into a string. 
     * @param chs
     * @return
     */
    public static String convertToString(ArrayList<Character> chs)
    {
        StringBuilder ss = new StringBuilder();
        
        for(char a : chs)
        {
            ss.append(a);
        }
       

        return ss.toString();
    }


    public static String convertToSentence(String s)
    {
        StringBuilder ss = new StringBuilder(s);
        for(int i = 1; i <ss.length(); i++)
        {
            char ch = ss.charAt(i);

            if(Character.isUpperCase(ch))
            {   
                ss.setCharAt(i, Character.toLowerCase(ch));
                ss.insert(i, ' ');
                i++;
            }
        }

        return ss.toString();
    }

    public static String replacePart(String original, String toReplace, String replaceWith)
    {
        StringBuilder ss = new StringBuilder(original);
        
        int i = ss.indexOf(toReplace);
        while(i != -1)
        {
            ss.replace(ss.indexOf(toReplace), ss.indexOf(toReplace)+toReplace.length(), replaceWith);
            i = ss.indexOf(toReplace);
        }
        return ss.toString();
    }
    

    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);

       System.out.println("Enter a String:");
       String input = sc.nextLine();

       System.out.println("Enter string to replace:");
       String replace = sc.nextLine();

       System.out.println("Enter string to replace with:");
       String replacement = sc.nextLine();

       System.out.println("The sentence is: " + convertToSentence(input));
       String newSent = convertToSentence(input); 

       System.out.printf("The number of words in '%s'': %d\n", newSent, wordCounter(newSent));

       System.out.println("New string after replacement: " + replacePart(newSent, replace, replacement));

       System.out.println("Enter a series of characters, each character on a line. When done, enter .");

       ArrayList<Character> sigh = new ArrayList<>();
    
       Character a = sc.nextLine().charAt(0); 
       while(a != '.')
       {
        sigh.add(a);
        a = sc.nextLine().charAt(0);

       }

       String sas = convertToString(sigh);
       System.out.println(sas);
       System.out.println(sas.toUpperCase());




    }

}
