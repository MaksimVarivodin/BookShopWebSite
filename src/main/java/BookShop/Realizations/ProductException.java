package BookShop.Realizations;

public class ProductException extends Exception{
    private final float exceptionValue;
    public ProductException(final float a){
        exceptionValue = a;
    }
    public String toString(){
        return this.getClass().getName()+":\t"+ exceptionValue;
    }
}
