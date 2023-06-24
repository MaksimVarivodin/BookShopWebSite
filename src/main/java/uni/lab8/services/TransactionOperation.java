package uni.lab8.services;

import BookShop.Realizations.ProductException;

import java.sql.Connection;
import java.sql.SQLException;

public interface TransactionOperation<E> {
    public E operation(Connection con) throws SQLException, ProductException;
}
