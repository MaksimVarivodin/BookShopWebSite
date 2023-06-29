package BookShop.Realizations;


/**
 *      Container Exception class,
 *      which returns the index which is out of bounds
 * */
public class ContainerException extends Exception{


    /**
     *      field - Exception value
     * */
    private final int exceptionValue;


    /**
     *      Constructor
     * */
    public ContainerException(final int ind){
        exceptionValue = ind;
    }


    /**
     *      Conversion of ContainerException to String
     * */
    public String toString(){
        return this.getClass().getName()+":\t"+ Float.toString(exceptionValue);
    }


}