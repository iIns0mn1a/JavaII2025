package FinalProject;
/**
 * Student record class
 */
public class Student extends Person implements Comparable<Student>{

    /**
     * List of Student types
     */
    enum StudentType {NoMajor, FullTime, PartTime} 

    private StudentType studentType;
    private String major = "None";
    private float balance;

    public Student(String lastName, String firstName, String email, String pass,  int bannerID, String stuType, String major, float balance) throws Exception
    {
        super(lastName, firstName, email, pass, bannerID);
        studentType = StudentType.valueOf(stuType);
        this.major = major;
        this.balance = balance;
    }
    public Student(String lastName, String firstName, String email, String pass,  int bannerID, String stuType, float balance) throws Exception
    {
        super(lastName, firstName, email, pass, bannerID);
        studentType = StudentType.valueOf(stuType);
        this.balance = balance;
    }
    public Student(String lastName, String firstName, String pass, String stuType, String major, float balance) throws Exception
    {
        super(lastName, firstName, pass);
        studentType = StudentType.valueOf(stuType);
        this.major = major;
        this.balance = balance;

        
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public String getStudentTypeString()
    {
        return studentType.toString();
    }

    public String getMajor()
    {
        return major; 
    }

    public int getKey()
    {
        return super.getBannerID();
    }

    public boolean sameKey(int other)
    {
        if(super.getBannerID() == other)
            return true;
        else
            return false;
    }
    public float getBalance()
    {
        return balance;
    }
    
 

    public String toString()
    {
        return String.format("%s: %s, %d, %s, %s, %.2f", super.getFirstName() + " " + super.getLastName(), super.getEmail(), super.getBannerID(), getStudentTypeString(), getMajor(), getBalance());
    }

    public int compareTo(Student other)
    {
        return super.getLastName().compareTo(other.getLastName());
    }

    //need to implement sort, probably gonna just implement comparable<student>? might have to make it keyretrieval so it works with everyting tho. tho.

}
