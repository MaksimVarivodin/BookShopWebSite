package BookShop.Realizations;

import  BookShop.Interfaces.IBook;

import java.io.Serializable;

/**
 *      книга (печатная)
 * */
public class Book extends PaperLiterature implements IBook, Serializable {

    /**
     *      поле страниц
     * */
    private int pages;

    /**
     *      поле количества слов
     * */
    private int words;

    /**
     *      поле ФИО автора
     * */
    private String authorName;

    public static String[] GetFieldNames()
    {
        return new String[] {"Name", "Price", "Pages", "Words", "Author Name"};
    }

    public Book(final int id, final String name, final float price, final int pages, final int words, final String authorName) throws ProductException {
        this(name, price, pages, words, authorName);
        super.setId(id);
    }
   /**
    *       конструктор с 5-ю параметрами
    * */
    public Book(final String name, final float price, final int pages, final int words, final String authorName) throws ProductException {
        /*
        *
        * в этот конструктор заход происходит из любого другого конструктора в классе,
        * что позволяет расссчитывать статические поля без отдельного метода
        *
        * */

        super.setName(name);
        super.setPrice(price);


        this.pages= pages;
        this.words = words;
        this.authorName = authorName;
    }

    public Book(final String[] fields)throws ProductException{
        if(fields.length == 5){
            super.setName(fields[0]);
            super.setPrice(Float.parseFloat(fields[1]));
            this.pages= Integer.parseInt(fields[2]);
            this.words = Integer.parseInt(fields[3]);
            this.authorName = fields[4];
        }
    }
    /**
     *      конструктор с 3-мя параметрами
     * */

    /**
     *      конструктор по умолчанию
     * */
    public Book (){
    }


    /**
     *      геттер страниц
     * */
    public int getPages() {
        return pages;
    }

    /**
     *      геттер кол-ства слов
     * */
    public int getWords() {
        return words;
    }

    /**
     *      геттер ФИО
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     *      сеттер ФИО
     * */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     *      сеттер страниц
     * */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     *      сеттер кол-ства слов
     * */
    public void setWords(int words) {
        this.words = words;
    }

    /**
     *      преобразование в строку
     * */
    @Override
    public String toString(){ return super.toString() +"|\t" + pages+ " pages, "+ words + " words, Author: "+ authorName;}

}
