package BookShop.Realizations;

import BookShop.Interfaces.IPaperLit;

import java.io.Serializable;


/**
 * PaperLiterature abstract class
 */
public abstract class PaperLiterature implements IPaperLit, Serializable {


    /**
     * field - Name
     * */
    protected String name;


    /**
     *      field - Price
     * */
    protected float price;


    /**
     *      field - ID
     * */
    protected int id;


    /**
     *      Default constructor
     * */
    public PaperLiterature(){}


    /**
     *      Returns ID
     * */
    @Override
    public int getId() {
        return id;
    }


    /**
     *      Returns price
     * */
    @Override
    public float getPrice() {
        return price;
    }


    /**
     *      Returns name
     * */
    @Override
    public String getName() {
        return name;
    }


    /**
     *      Sets ID
     * */
    @Override
    public void setId(int id) {
        this.id = id;
    }


    /**
     *      Sets name
     * */
    @Override
    public void setName(String name) {
        this.name = name;
    }


    /**
     *      Sets price
     * */
    @Override
    public void setPrice(float price) throws ProductException {
        if(price < 0.0)
            throw new ProductException(price);
        this.price = price;
    }


    /**
     *      Converts PaperLiterature object to String
     * */
    @Override
    public String toString(){
        return "Price:\t"+ price + "\tName:\t"+ name+ "\t";
    }


}