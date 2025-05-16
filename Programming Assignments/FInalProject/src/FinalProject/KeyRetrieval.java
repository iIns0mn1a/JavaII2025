package FinalProject;

/**
 * Interface for getkey method
 */
public interface KeyRetrieval {

    /**
     * returns object's key
     * @return
     */
    public int getKey();

    /**
     * checks if keys is same
     * @param k
     * @return true if keys are same, false if otherwise
     */
    public boolean sameKey(int k);

}
