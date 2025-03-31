public class PreferredCustomer extends Customer {

    private float amtSpent;
    private float discount;
    
    public PreferredCustomer(String name, int id){
        super(name,id);
    }

    public PreferredCustomer(String name, int id, float amtSpent){
        super(name,id);
        this.amtSpent = amtSpent;
        if(amtSpent>=500)
            discount = .1f;
        else
            discount = .05f;
    }

    public String toString()
    {
        return super.toString() + "\nAmount Spent: $" + amtSpent + "\nDiscount: " + discount*100 + "%"; //not done, might have to format float. 
    }

}
