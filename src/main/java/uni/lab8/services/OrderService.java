package uni.lab8.services;

import BookShop.Interfaces.IPaperLit;
import uni.lab8.repository.OrderRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderService {

    TransactionManager transactionManager;
    OrderRepository orderRepository;

    public OrderService(TransactionManager transactionManager, OrderRepository orderRepository) {
        this.transactionManager = transactionManager;
        this.orderRepository = orderRepository;
    }

    public Void create(String email, ArrayList<IPaperLit> cart, int card, int cvv) throws SQLException {
        return transactionManager.doInTransaction(new TransactionOperation<Void>() {
            @Override
            public Void operation(Connection con) throws SQLException {
                orderRepository.create(con, email, cart, card, cvv);
                return null;
            }
        });
    }
}
