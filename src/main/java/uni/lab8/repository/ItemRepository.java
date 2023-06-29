package uni.lab8.repository;

import BookShop.Interfaces.IPaperLit;
import BookShop.Realizations.Book;
import BookShop.Realizations.Comics;
import BookShop.Realizations.ProductException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *      ItemRepository class that allows to access data in database.
 *      Has methods for getting Books and Comics or any PaperLiterature by ID.
 * */
public class ItemRepository {

    /**
     * Sql query to get all books
     * */
    private static String GET_BOOK_ALL = "select * from getbooks;";


    /**
     *      Sql query to get all comics
     * */
    private static String GET_COMICS_ALL = "select * from getcomics;";


    /**
     *      Sql query to get book by ID
     * */
    private static String GET_BOOK = "select * from getbooks where (id_lit = ?);";


    /**
     *      Sql query to get comics by ID
     */
    private static String GET_COMICS = "select * from getcomics where (id_lit = ?);";


    /**
     * Method to create one book from ResultSet
     * */
    private Book newBook(ResultSet set) throws SQLException, ProductException {
        return new Book(
                set.getInt(7), // int id,
                set.getString(2), //    String name,
                set.getFloat(3), //    float price,
                set.getInt(4), //    int pages,
                set.getInt(5), //    int words,
                set.getString(6));
    }


    /**
     *    Method to create one comics from ResultSet
     */
    private Comics newComics(ResultSet set) throws SQLException, ProductException {
        return new Comics(
                set.getInt(6), // int id,
                set.getString(2), //    String name,
                set.getFloat(3), //    float price,
                set.getString(4), //   String Illustrator,
                set.getInt(5));
    }


    /**
     * Fills ArrayList<Book> with books from ResultSet
     * */
    private void fillBookList(ResultSet set, ArrayList<Book> list) throws SQLException, ProductException {
        while (set.next()) {
            list.add(newBook(set));
        }

    }


    /**
     * Fills ArrayList with comics from ResultSet
     * */
    private void fillComicsList(ResultSet set, ArrayList<Comics> list) throws SQLException, ProductException {
        while (set.next()) {
            list.add(newComics(set)); //    int pages
        }
    }


    /**
     * Gets all books from database
     * */
    public ArrayList<Book> getBooks(Connection con) throws SQLException, ProductException {
        ArrayList<Book> list = new ArrayList<Book>();
        try (PreparedStatement stmt = con.prepareStatement(GET_BOOK_ALL)) {
            fillBookList(stmt.executeQuery(), list);
        }
        return list;
    }



    /**
     * Gets all comics from database
     * */
    public ArrayList<Comics> getComics(Connection con) throws SQLException, ProductException {
        ArrayList<Comics> list = new ArrayList<Comics>();
        try (PreparedStatement stmt = con.prepareStatement(GET_COMICS_ALL)) {
            fillComicsList(stmt.executeQuery(), list);
        }
        return list;
    }


    /**
     * Gets literature by ID
     * */
    public IPaperLit getById(Connection con, final int id) throws SQLException, ProductException {
        try (PreparedStatement stmt = con.prepareStatement(GET_BOOK)){
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            if (set.next())
                return newBook(set);
        }
        try (PreparedStatement stmt = con.prepareStatement(GET_COMICS)){
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            if (set.next())
                return newComics(set);
        }
        return null;
    }


}
