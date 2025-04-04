public class InvalidStringException extends Exception{

    public InvalidStringException(String str, int maxLength)
    {
        super(str + " exceeds max length of " + maxLength +" allowed.\n");
        
    }

    public InvalidStringException(String str)
    {
        super(str + " contains digits which is invalid.\n");
    }

}
