package BookShop.Interfaces;

import  BookShop.Realizations.ProductException;


/**
 *      Paper Printed Literature Interface
 * */
public interface IPaperLit {


    /**
     *      Returns ID
     * */
    int getId();


    /**
     *      Sets ID
     * */
    void setId(int id);


    /**
     *      Returns price
     * */
    float getPrice();


    /**
     *      Returns name
     * */
    String getName();


    /**
     *      Sets name
     * */
    void setName(String name);


    /**
     *      Sets price
     * */
    void setPrice(float price) throws ProductException;


}
