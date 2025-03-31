
import java.util.*;

public class Address{

    private int houseNum;
    private String street;

    public Address(String adr)
    {
        houseNum = Integer.parseInt(adr.substring(0,adr.indexOf(" ")));
        street = adr.substring(adr.indexOf(" ")+1);
    }

    public Address(Address a1)
    {
        houseNum = a1.houseNum;
        street = a1.street;
    }

    public int getHouseNum(){return houseNum;}
    public String getStreet(){return street;}

    public void setHouseNum(int houseNum){this.houseNum = houseNum;}
    public void setStreet(String street){this.street = street;}

    public String toString()
    {
        String str = houseNum + " " + street;

        return str;
    }

    public boolean equals(Address other)
    {
        if(houseNum == other.houseNum && street.equals(other.street))
        {
            return true;
        }
        else 
        return false;    
    }
    

}