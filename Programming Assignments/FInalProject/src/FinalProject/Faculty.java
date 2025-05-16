package FinalProject;

/**
 * Faculty record class
 */
public class Faculty extends Person{

    /**
     * List of faculty types
     */
    enum FacultyType {Professor, Adjunct}
    private FacultyType facultyType;
    private String department;

    public Faculty(String lastName, String firstName, String email, String pass,  int bannerID, String facType, String dept) throws Exception
    {
        super(lastName, firstName, pass, email, bannerID);
        facultyType = FacultyType.valueOf(facType);
        department = dept;
    }

    public FacultyType getFacultyType()
    {
        return facultyType;
    }

    public String getFacultyTypeString()
    {
        return facultyType.toString();
    }

    public String getDepartment()
    {
        return department;
    }

    public String toString()
    {
        // return super.getFirstName() + " " + super.getLastName();
        return String.format("%s: %s, %d, %s, %s",super.getFirstName() + " " + super.getLastName(), super.getEmail(), super.getBannerID(), getFacultyTypeString(), getDepartment());
    }

    public int getKey()
    {
        return super.getBannerID();
    }

    /**
     * checks if banner ids are the same
     */
    public boolean sameKey(int other)
    {
        if(super.getBannerID() == other)
            return true;
        else
            return false;
    }
}
