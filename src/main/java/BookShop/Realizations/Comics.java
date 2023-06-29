package BookShop.Realizations;

import BookShop.Interfaces.IComics;

import java.io.Serializable;

/**
 *        Printed Comics Literature
 */
public class Comics extends PaperLiterature implements IComics, Serializable {


    /**
     *        field - Pages
     */
    private int pages;


    /**
     *        field - Illustrator
     */
    private String Illustrator;


    /**
     *        Constructor with Parameters
     * */
    public Comics (final int id,final String name, final float price, final String Illustrator, final int pages) throws ProductException {
        super.setId(id);
        super.setPrice(price);
        super.setName(name);
        this.Illustrator = Illustrator;
        this.pages = pages;
    }


    /**
     *        Default constructor
     */
    public Comics() {
    }


    /**
     *        Returns the number of pages
     */
    public int getPages() {
        return pages;
    }


    /**
     *        Returns the Illustrator name
     */
    public String getIllustrator() {
        return Illustrator;
    }


    /**
     *        Sets the number of pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }


    /**
     *        Sets the Illustrator name
     */
    public void setIllustrator(String illustrator) {
        this.Illustrator = illustrator;
    }


    /**
     * Converts Comics object to String
     */
    @Override
    public String toString() {
        return super.toString() + "|\t" + pages + " pages, Illustrator: " + Illustrator;
    }
}
