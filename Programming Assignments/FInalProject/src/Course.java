public class Course implements KeyRetrieval {

    private int crn;
    private String name;
    private int credits;

    public Course(int crn, String name, int cred) throws Exception
    {
        this.crn = crn;
        this.name = name;
        credits = cred;
    }


    public int getCRN() {
        return crn;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCredits() {
        return credits;
    }

    public int getKey()
    {
        return crn;
    }

    public boolean sameKey(int other)
    {
        if(crn == other)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return "";
    }
}
