import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input string to be reversed"); //REMEMBER TO FIX THIS FOR HACKERRRANK

        String str = sc.nextLine();

        System.out.println(reverseString(str,str.length()-1));

    }

    public static String reverseString(String str, int index)
    {
        if(index == 0)
        {
            return str.substring(str.length()-1);
        }
        else
        {
            return str.substring(index-2, index-1) + reverseString(str, index-1);
        }
    }

    /*ok so, method is once again going backwards, so call method with the string length - 1?
     * base case: when at the last index, so if we're going backwards, when index == or is less than 0?
     * 
     * 
    */


}
