import java.util.*;

public class Person {

    private String name;
    private String address;
    private String phoneNumber;

    public Person(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Person(String name)
    {
        this(name, null, null);
    }

    public final String getName(){return name;}
    public final String getAddress(){return address;}
    public final String getPhoneNumber(){return phoneNumber;}

    public final void setName(String name) {this.name = name;}
    public final void setAddress(String address) {this.address = address;}
    public final void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String toString()
    {
        String st = "Name: " + name;
        st += "\nAddress: " + address;
        st += "\nPhone Number: " + phoneNumber;
        return st;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer 1\'s name:");
        String n1 = sc.nextLine();
        System.out.println("Enter customer 1\'s id:");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter customer 2\'s name:");
        String n2 = sc.nextLine();
        System.out.println("Enter customer 2\'s id:");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter customer 2\'s address:");
        String ad2 = sc.nextLine();
        System.out.println("Enter customer 2\'s phone number:");
        String pho2 = sc.nextLine();
        System.out.println("Would customer 2 like to be added to the mailing list?");
        String choice = sc.nextLine();

        boolean mail2 = false;
        switch(choice){
            case "yes":
                mail2 = true;
                break;
            default: 
                mail2 = false;
                break;
                
        }


        Customer c1 = new Customer(n1, id1);
        Customer c2 = new Customer(n2, id2, ad2, pho2, mail2);

        System.out.println(c1);
        System.out.println(c2);

    }

    
}
