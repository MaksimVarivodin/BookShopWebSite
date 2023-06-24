package BookShop.Interfaces;

import java.io.Serializable;

public interface IComics extends IPaperLit, Serializable {
    /**
     *      получение страниц
     * */
    int getPages() ;

    /**
     *      получение иллюстратора
     * */
    String getIllustrator();

    /**
     *      сеттер для страниц
     * */
    void setPages(int pages);

    /**
     *      сеттер для иллюстратора
     * */
    void setIllustrator(String illustrator);


}
