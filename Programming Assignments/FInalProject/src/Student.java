
/**
 * need to implement sorting method, will use comparable, i dont wanna write another interface lol
 */
public class Student extends Person{

    enum StudentType {NoMajor, FullTime, PartTime} 

    private StudentType studentType;
    private String major;
    private float balance;

    public Student(String firstName, String lastName, String email, String pass,  int bannerID, String stuType, String major, float balance) throws Exception
    {
        super(firstName, lastName, pass, email, bannerID);
        studentType = StudentType.valueOf(stuType);
        this.major = major;
        this.balance = balance;
    }
    public Student(String firstName, String lastName, String email, String pass,  int bannerID, String stuType, float balance) throws Exception
    {
        super(firstName, lastName, pass, email, bannerID);
        studentType = StudentType.valueOf(stuType);
        this.balance = balance;
    }
    public Student(String firstName, String lastName, String pass, String stuType, String major, float balance) throws Exception
    {
        super(firstName, lastName, pass);
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

    //need to implement sort, probably gonna just implement comparable<student>? might have to make it keyretrieval so it works with everyting tho. tho.

}
