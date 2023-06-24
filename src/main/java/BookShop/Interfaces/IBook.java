package BookShop.Interfaces;

import java.io.Serializable;

public interface IBook extends IPaperLit, Serializable {
    /**
     *      геттер страниц
     * */
    int getPages() ;

    /**
     *      геттер кол-ства слов
     * */
    int getWords() ;

    /**
     *      геттер ФИО
     */
    String getAuthorName() ;

    /**
     *      сеттер ФИО
     * */
    void setAuthorName(String authorName) ;

    /**
     *      сеттер страниц
     * */
    void setPages(int pages) ;

    /**
     *      сеттер кол-ства слов
     * */
    void setWords(int words) ;


}
