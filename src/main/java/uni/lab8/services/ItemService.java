package uni.lab8.services;

import BookShop.Interfaces.IPaperLit;
import BookShop.Realizations.Book;
import BookShop.Realizations.Comics;
import BookShop.Realizations.ProductException;
import uni.lab8.repository.ItemRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemService {
    TransactionManager transactionManager;
    ItemRepository itemRepository;
    public ItemService(TransactionManager transactionManager, ItemRepository itemRepository) {
        this.transactionManager = transactionManager;
        this.itemRepository = itemRepository;
    }
    public ArrayList<Book> getBooks(){
        return transactionManager.doInTransaction(
                new TransactionOperation<ArrayList<Book>>() {
                    @Override
                    public ArrayList<Book> operation(Connection con) throws SQLException, ProductException {
                        return itemRepository.getBooks(con);
                    }
                }
        );
    }
    public ArrayList<Comics> getComics(){
        return transactionManager.doInTransaction(
                new TransactionOperation<ArrayList<Comics>>() {
                    @Override
                    public ArrayList<Comics> operation(Connection con) throws SQLException, ProductException {
                        return itemRepository.getComics(con);
                    }
                }
        );
    }

    public IPaperLit getById (int id){
        return transactionManager.doInTransaction(
                new TransactionOperation<IPaperLit>() {
                    @Override
                    public IPaperLit operation(Connection con) throws SQLException, ProductException {
                        return itemRepository.getById(con, id);
                    }
                }
        );
    }
}
