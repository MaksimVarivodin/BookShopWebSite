package BookShop.Interfaces;

import java.io.Serializable;

/**
 *      Printed Comics Literature Interface
 * */
public interface IComics extends IPaperLit, Serializable {


    /**
     *      Returns the number of pages
     * */
    int getPages() ;


    /**
     *      Returns the Illustrator name
     * */
    String getIllustrator();


    /**
     *      Sets the number of pages
     * */
    void setPages(int pages);


    /**
     *      Sets the Illustrator name
     * */
    void setIllustrator(String illustrator);


}
