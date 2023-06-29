package BookShop.Realizations;



/**
 * ProductException class for price exceptions
 * */

public class ProductException extends Exception{


    /**
     *      field - Exception value
     * */
    private final float exceptionValue;


    /**
     *      Default constructor
     * */
    public ProductException(final float a){
        exceptionValue = a;
    }


    /**
     *      Conversion of ProductException to String
     * */
    public String toString(){
        return this.getClass().getName()+":\t"+ exceptionValue;
    }


}
