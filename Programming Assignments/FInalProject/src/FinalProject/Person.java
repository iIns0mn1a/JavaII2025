package FinalProject;

/**
 * Class for People, students or faculty
 */
public abstract class Person implements KeyRetrieval {

   private static int nextBannerID;
   private String firstName;
   private String lastName;
   private String password;
   private String email;
   private int bannerID;


   /**
    * main constructor
    * @param firstName
    * @param lastName
    * @param pass
    * @param email
    * @param bannerID
    */
   public Person(String lastName, String firstName, String email, String pass,  int bannerID) throws Exception
   {
      this.firstName = firstName;
    this.lastName = lastName;
    password = pass;
    this.email = email;
    this.bannerID = bannerID;   
   
  
    if(bannerID >= nextBannerID)
        nextBannerID = bannerID + 1;
   }

   
   public Person(String lastName, String firstName, String pass) throws Exception
   {
    this.firstName = firstName;
    this.lastName = lastName;
    password = pass;

   }

   public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getBannerID() {
        return bannerID;
    }

    public static int getNextBannerID()
    {
        return nextBannerID;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    
    /**
     * checks to see if password is valid
     * @param pass
     * @return true if password passes validation
     */
    public static boolean validPass(String pass)
    {
        return true;
    }

    /**
     * forced implementation of getKey method
     */
    public abstract int getKey();

    /**
     * Forced implementation of sameKey method
     */
    public abstract boolean sameKey(int k);

}
