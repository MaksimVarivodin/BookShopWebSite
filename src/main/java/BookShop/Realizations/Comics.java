package BookShop.Realizations;

import BookShop.Interfaces.IComics;

import java.io.Serializable;

/**
 * комиксы
 */
public class Comics extends PaperLiterature implements IComics, Serializable {

    /**
     * страницы
     */
    private int pages;

    /**
     * илюстратор
     */
    private String Illustrator;

    public Comics(final String[] fields) throws ProductException {
        if (fields.length == 4) {
            super.setName(fields[0]);
            super.setPrice(Float.parseFloat(fields[1]));
            this.pages = Integer.parseInt(fields[2]);
            this.Illustrator = fields[3];
        }
    }

    public static String[] GetFieldNames() {
        return new String[]{"Name", "Price", "Pages", "Illustrator"};
    }

    public Comics (final int id,final String name, final float price, final String Illustrator, final int pages) throws ProductException {
        this(name, price, Illustrator, pages);
        super.setId(id);
    }
    /**
     * конструктор для заполнения всех полей
     */
    public Comics(final String name, final float price, final String Illustrator, final int pages) throws ProductException {

        super.setPrice(price);
        super.setName(name);
        this.Illustrator = Illustrator;
        this.pages = pages;
    }

    /**
     * конструктор по умолчанию
     */
    public Comics() {
    }

    /**
     * получение страниц
     */
    public int getPages() {
        return pages;
    }

    /**
     * получение иллюстратора
     */
    public String getIllustrator() {
        return Illustrator;
    }

    /**
     * сеттер для страниц
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * сеттер для иллюстратора
     */
    public void setIllustrator(String illustrator) {
        this.Illustrator = illustrator;
    }

    /**
     * преобразование в строку
     */
    @Override
    public String toString() {
        return super.toString() + "|\t" + pages + " pages, Illustrator: " + Illustrator;
    }


}
