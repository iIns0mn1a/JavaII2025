public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public String reverseString(String str, int index)
    {
        if(index < 0)
        {
            return str.substring(0, 1);
        }
        else
        {
            return str.substring(index-1, index) + reverseString(str, index-1);
        }
    }

    /*ok so, method is once again going backwards, so call method with the string length - 1?
     * base case: when at the last index, so if we're going backwards, when index == or is less than 0?
     * 
     * 
    */


}
