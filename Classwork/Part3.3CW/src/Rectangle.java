public class Rectangle implements Comparable{

    private float length;
    private float width;


    public int compareTo(Rectangle r1)
    {

    }
    
        public float calcArea()
        {
            return width*length;
        }
    
        public float calcPerimeter()
        {
            return (width*2) + (length*2);
        }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
