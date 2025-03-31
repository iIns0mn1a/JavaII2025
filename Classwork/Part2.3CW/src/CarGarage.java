import java.util.*;

public class CarGarage{

    private ArrayList<Car> cars = new ArrayList<>();

    public void finalize()
    {
        cars.clear();
        cars = null;
    }

    public void addCar(Car c)
    {
        cars.add(c);
    }

    public Car getCar(int i)
    {
        return cars.get(i);
    }

    public ArrayList<Car> getlist()
    {
        return cars;
    }

    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarGarage forgor = new CarGarage(); 

        System.out.println("Enter color of car 1: ");
        String col1 = sc.nextLine().toUpperCase();
        System.out.println("Enter type of car 1: ");
        String typ1 = sc.nextLine().toUpperCase();
        forgor.addCar(new Car(col1, typ1));

        System.out.println("Enter color of car 2: ");
        String col2 = sc.nextLine().toUpperCase();
        System.out.println("Enter type of car 2: ");
        String typ2 = sc.nextLine().toUpperCase();
        forgor.addCar(new Car(col2, typ2));

        System.out.println("Enter color of car 3: ");
        String col3 = sc.nextLine().toUpperCase();
        System.out.println("Enter type of car 3: ");
        String typ3 = sc.nextLine().toUpperCase();
        forgor.addCar(new Car(col3, typ3));

        forgor.addCar(new Car(forgor.getCar(0)));
        forgor.addCar(new Car(forgor.getCar(1)));
        forgor.addCar(new Car(forgor.getCar(2)));
        
    

        System.out.println("The cars that are in the garage are: /\n" + forgor.getlist());

        for(int i = 0; i<3; i++)
        {
            forgor.getCar(i).setColor("red");
        }
        System.out.println("The cars that are in the garage are: \n" + forgor.getlist());
    }
}