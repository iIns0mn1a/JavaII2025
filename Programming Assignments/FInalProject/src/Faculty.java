public class Faculty extends Person{

    enum FacultyType {Professor, Adjunct}
    private FacultyType facultyType;
    private String department;

    public Faculty(String firstName, String lastName, String email, String pass,  int bannerID, String facType, String dept) throws Exception
    {
        super(firstName, lastName, pass, email, bannerID);
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
        return "";
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
}
