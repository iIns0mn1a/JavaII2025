public abstract class Person implements KeyRetrieval {

   private static int nextBannerID;
   private String firstName;
   private String lastName;
   private String password;
   private String email;
   private int bannerID;


   /**
    * remeber to make throw exception.
    * @param firstName
    * @param lastName
    * @param pass
    * @param email
    * @param bannerID
    */
   public Person(String firstName, String lastName, String email, String pass,  int bannerID) throws Exception
   {
      this.firstName = firstName;
    this.lastName = lastName;
    password = pass;
    this.email = email;
    this.bannerID = bannerID;   
   
  
    if(bannerID > nextBannerID)
        nextBannerID = bannerID + 1;
   }

   
   public Person(String firstName, String lastName, String pass) throws Exception
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
    
    /**
     * checks to see if password is valid
     * @param pass
     * @return true if password passes validation
     */
    public boolean validPass(String pass)
    {
        return true;
    }

    public abstract int getKey();

    public abstract boolean sameKey(int k);

}
