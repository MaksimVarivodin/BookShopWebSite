package BookShop.Interfaces;

import  BookShop.Realizations.ProductException;

public interface IPaperLit {
    int getId();

    void setId(int id);

    /**
     *      геттер цены
     * */
    float getPrice();
    /**
     *      геттер имени
     * */
    String getName();
    /**
     *      сеттер имени
     * */
    void setName(String name);

    /**
     *      сеттер цены
     * */
    void setPrice(float price) throws ProductException;
}
