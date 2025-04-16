import java.util.*;

public class App {

    private ArrayList<String> reversedList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Enter a series of Strings, each on a different line. When done, type \"Done\"." );
        String str = sc.nextLine();
        while(!str.equals("Done"))
        {
            arr.add(str);
            str = sc.nextLine();
        }
        if(arr.size() != 0){
        
        ArrayList<String> reversed = new ArrayList<>();

        for(String a : arr)
        {
            reversed.add(a);
        }        

        for(int i = 0; i < reversed.size(); i++)
        {
            reversed.set(i, reverseString(reversed.get(i), reversed.get(i).length()));
        }

        ArrayList<String> finalReverse = reverseArrayList(reversed);

        System.out.println("Reversed ArrayList of reversed strings:");
        for(String a : finalReverse)
        {
            System.out.println(a);
        }
        
        System.out.println("Original ArrayList:");
        for (String a : arr) 
        {
            System.out.println(a);   
        }

    }

    }

    public static String reverseString(String str, int index)
    {
        if(index == 1)
        {
            return str.substring(0, 1);
        }
        else
        {
            return str.substring(index-1, index) + reverseString(str, index-1);
        }
    }

    public static ArrayList<String> reverseArrayList(ArrayList<String> arr)
    {
        return actuallyReverse(arr, arr.size()-1);
    }


    public static ArrayList<String> actuallyReverse(ArrayList<String> arr, int index)
    {
        
        if(index < 0)
        {
            return new ArrayList<>();
        }
        else
        {
            ArrayList<String> reverse = actuallyReverse(arr, index-1);
            reverse.add(0, arr.get(index));
            return reverse;
        }
    }

    /*
     * k next method, each time, you are giving an arraylist as an arguement.
     * the way it works is it basically, takes out from the arraylist, by starting each recurive call from a lower index
     * then ending with an empty array list at the base case. from there, the calls will add to the empty list with each loop (the number it took out)? 
     * i don't know if that makes sense but it makes sense in my head and thats what matters 🙃.     */
    
    /*ok so, method is once again going backwards, so call method with the string length - 1?
     * base case: when at the last index, so if we're going backwards, when index == or is less than 0?
     * 
     * 
    */


}
