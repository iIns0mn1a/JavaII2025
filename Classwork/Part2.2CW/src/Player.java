
import java.util.*;

/*
 * Version: 1.0 
 * Last edit Location: VSC on June2in1
 */
public class Player {
    
    private String name;
    private int yearHired;
    private static int shirtNumberCount = 1;
    private int shirtNumber = 0;
    private Address address;
    
// ALL constructors
    public Player(String name, int yearHired, String address)
    {
        this.name = name;
        this.yearHired = yearHired;
        this.address = new Address(address);
        shirtNumber = shirtNumberCount;
        shirtNumberCount++;
    }

    public Player()
    {
        shirtNumber = shirtNumberCount;
        shirtNumberCount++;
    }

    public Player(Player p1)
    {
        name = p1.name;
        yearHired = p1.yearHired;
        shirtNumber = p1.shirtNumber;
        address = new Address(p1.address);
    }


// get/set methods
    public String getName(){return name;}
    public int getHiredYear(){return yearHired;}
    public int getNumber(){return shirtNumber;}
    

    public void setName(String name){this.name=name;}
    public void setHiredYear(int yearHired){this.yearHired=yearHired;}
    public void setNumber(int shirtNumber){this.shirtNumber=shirtNumber;}
    public void setAddress(String address){this.address = new Address(address);}


// other methodss    
    public boolean equals(Player other)
    {
        if(name.equals(other.name) && yearHired == other.yearHired && shirtNumber == other.shirtNumber && address.equals(other.address))
        {
            return true;
        }
        else
            return false;
    }

    public String toString()
    {
        String str = "name: " + name;
        str += "\nYear: " + yearHired;
        str += "\nShirt Number: " + shirtNumber;
        str += "\nAddress: " + address.toString();

        return str;
    }


// main method

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of Player 1:");
        String n1 = scan.nextLine();
        System.out.println("Enter year of Player 1:");
        int y1 = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter house number and street of Player 1:");
        String add1 = scan.nextLine();
        Player p1 = new Player();
        p1.setName(n1);
        p1.setHiredYear(y1);
        p1.setAddress(add1);

        System.out.println("Enter name of Player 2:");
        String n2 = scan.nextLine();
        System.out.println("Enter year of Player 2:");
        int y2 = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter house number and street of Player 2: ");
        String add2 = scan.nextLine();
        Player p2 = new Player(n2,y2,add2);

        Player copy = new Player(p2);

        System.out.println("Is Player copy equivalent to Player p2? " + copy.equals(p2));

        System.out.println("Is Player p1 equivalent to Player p2? " + p1.equals(p2));

        System.out.println("Player p1: \n" + p1);
        System.out.println("Player p2: \n" + p2);
        System.out.println("Player copy: \n" + copy);
        
    

        System.out.println("Next Available Shirt Number: " + shirtNumberCount);
        
        

    }

}
