package BookShop.Realizations;

public class ContainerException extends Exception{
    private final int exceptionValue;
    public ContainerException(final int ind){
        exceptionValue = ind;
    }
    public String toString(){
        return this.getClass().getName()+":\t"+ Float.toString(exceptionValue);
    }

}
