public class Customer extends Person
{
    private int customerID;
    private boolean isMailing;

    public Customer(String name, int id, String address, String phoneNumber, Boolean isMailing)
    {
        super(name, address, phoneNumber);
        customerID = id;
        this.isMailing = isMailing;
    }

    public Customer(String name, int id)
    {
        super(name);
        customerID = id;
        isMailing = false;
    }

    public int getCustomerID(){return customerID;}
    public boolean getMailingStatus(){return isMailing;}

    public void setCustomerID(int customerID){this.customerID = customerID;}
    public void setMailingStatus(boolean isMailing){this.isMailing = isMailing;}

    @Override
    public String toString()
    {
        String st = super.toString();
        st+= "\nCustomer ID: " + customerID;
        st += "\nMailing List: " + isMailing;
        return st;
    }
    



}
