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

public class ItemRepository {
    private static String GET_BOOK_ALL = "select * from getbooks;";
    private static String GET_COMICS_ALL = "select * from getcomics;";
    private static String GET_BOOK = "select * from getbooks where (id_lit = ?);";
    private static String GET_COMICS = "select * from getcomics where (id_lit = ?);";

    private Book newBook(ResultSet set) throws SQLException, ProductException {
        return new Book(
                set.getInt(7), // int id,
                set.getString(2), //    String name,
                set.getFloat(3), //    float price,
                set.getInt(4), //    int pages,
                set.getInt(5), //    int words,
                set.getString(6));
    }

    private Comics newComics(ResultSet set) throws SQLException, ProductException {
        return new Comics(
                set.getInt(6), // int id,
                set.getString(2), //    String name,
                set.getFloat(3), //    float price,
                set.getString(4), //   String Illustrator,
                set.getInt(5));
    }

    private void fillBookList(ResultSet set, ArrayList<Book> list) throws SQLException, ProductException {
        while (set.next()) {
            list.add(newBook(set));
        }

    }

    private void fillComicsList(ResultSet set, ArrayList<Comics> list) throws SQLException, ProductException {
        while (set.next()) {
            list.add(newComics(set)); //    int pages
        }
    }

    public ArrayList<Book> getBooks(Connection con) throws SQLException, ProductException {
        ArrayList<Book> list = new ArrayList<Book>();
        try (PreparedStatement stmt = con.prepareStatement(GET_BOOK_ALL)) {
            fillBookList(stmt.executeQuery(), list);
        }
        return list;
    }

    public ArrayList<Comics> getComics(Connection con) throws SQLException, ProductException {
        ArrayList<Comics> list = new ArrayList<Comics>();
        try (PreparedStatement stmt = con.prepareStatement(GET_COMICS_ALL)) {
            fillComicsList(stmt.executeQuery(), list);
        }
        return list;
    }

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
