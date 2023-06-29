package BookShop.Interfaces;

import java.io.Serializable;

/**
 *      Printed Comics Literature Interface
 * */

public interface IBook extends IPaperLit, Serializable {


    /**
     *      Returns the number of pages
     * */
    int getPages() ;


    /**
     *      Returns the number of words
     * */
    int getWords() ;


    /**
     *      Returns the name of the author
     */
    String getAuthorName() ;


    /**
     *      Sets the name of the author
     * */
    void setAuthorName(String authorName) ;


    /**
     *      Sets the number of pages
     * */
    void setPages(int pages) ;


    /**
     *      Sets the number of words
     * */
    void setWords(int words) ;


}
