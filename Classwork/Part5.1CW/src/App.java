import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a  = sc.nextInt();
        int b  = sc.nextInt();
        System.out.println(product(a,b));

        printBackwardsByTen(a);



    }

    public static int product(int x, int y)
    {
        if(y == 1)
            return x;
        else
            return x + product(x, y-1);
    }

    public static int printBackwardsByTen(int a)
    {
        if(a < 10)
        {
            System.out.println(a);
            return a;
        }
        else
        {
            System.out.println(a);
            return printBackwardsByTen(a-10);
        }
    }
}
