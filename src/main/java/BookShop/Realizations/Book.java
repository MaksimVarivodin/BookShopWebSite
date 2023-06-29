package BookShop.Realizations;

import  BookShop.Interfaces.IBook;

import java.io.Serializable;

/**
 *      Printed Book Literature
 * */
public class Book extends PaperLiterature implements IBook, Serializable {


    /**
     *      field - Pages
     * */
    private int pages;


    /**
     *      field - Words
     * */
    private int words;


    /**
     *      field - Author Name
     * */
    private String authorName;


    /**
     * Constructor with Parameters
     * */
    public Book(final int id, final String name, final float price, final int pages, final int words, final String authorName) throws ProductException {

        super.setId(id);
        super.setName(name);
        super.setPrice(price);


        this.pages= pages;
        this.words = words;
        this.authorName = authorName;
    }


    /**
     *      Default constructor
     * */
    public Book (){
    }


    /**
     *      Returns the number of pages
     * */
    public int getPages() {
        return pages;
    }


    /**
     *      Returns the number of words
     * */
    public int getWords() {
        return words;
    }


    /**
     *      Returns the name of the author
     */
    public String getAuthorName() {
        return authorName;
    }


    /**
     *      Sets the name of the author
     * */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    /**
     *      Sets the number of pages
     * */
    public void setPages(int pages) {
        this.pages = pages;
    }


    /**
     *      Sets the number of words
     * */
    public void setWords(int words) {
        this.words = words;
    }


    /**
     *      Converts Book object to String
     * */
    @Override
    public String toString(){ return super.toString() +"|\t" + pages+ " pages, "+ words + " words, Author: "+ authorName;}


}
