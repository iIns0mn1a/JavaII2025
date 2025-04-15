import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
      System.out.println("Enter a series of integers, each on a different line. When done, enter a period.");
        ArrayList<Integer> arr = new ArrayList<>();

        String in = sc.nextLine();

      while(!in.equals(".")) 
      {
        arr.add(Integer.parseInt(in));
        in = sc.nextLine();
      }

        System.out.println(smallestNumber(arr));
        sc.close();
    }

    public static int smallestNumber(ArrayList<Integer> arr)
    {
        return checkNum(arr, arr.size()-2, arr.get(arr.size()-1));
    }

    public static int checkNum(ArrayList<Integer> arr, int start, int small)
    {
        if (start < 0)
            return small;
        else if (small < arr.get(start))
        {
            return checkNum(arr, start - 1, small); 
        }
        else
            return checkNum(arr, start-1 , arr.get(start));
    }

    /* start array from last number, then compare that number and the one before it. 
     * each recursive call will check the smaller of the numbers and the next number in the loop. i think that'll work
     * store the smaller number, the current index, and the array
     */

}
