package FinalProject;

/**
 * Class Record Course
 */
public class Course implements KeyRetrieval {

    private int crn;
    private String name;
    private int credits;

    /**
     * main constructor
     * @param crn course number
     * @param name course name
     * @param cred Number of credits
     * @throws Exception
     */
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

    /**
     * checks if crns are the same
     */
    public boolean sameKey(int other)
    {
        if(crn == other)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return name +"| Credits: " + credits;
    }
}
