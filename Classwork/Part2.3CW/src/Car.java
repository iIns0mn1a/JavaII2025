public class Car {
    
    enum CarColor{RED, BLACK, BLUE, SILVER}
    enum CarType{PORSCHE, FERRARI, JAGUAR}

    private CarColor cColor;
    private CarType cType;

    public Car(String cColor, String cType)
    {
        this.cColor = CarColor.valueOf(cColor);
        this.cType = CarType.valueOf(cType);
    }


    public void setColor(String color) {this.cColor = cColor.valueOf(color.toUpperCase());}

    public Car(Car other)
    {
        cColor = other.cColor;
        cType = other.cType;
    }

    public boolean equals(Car other)
    {
        if(cColor.equals(other.cColor) && cType.equals(other.cType))
            return true;
        return false;
    }

    public String toString()
    {
        return "Car: " + cColor + " " + cType;
    }

    

}
