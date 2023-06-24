package uni.lab8.services;

import BookShop.Realizations.User;
import uni.lab8.repository.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    TransactionManager transactionManager;
    UserRepository userRepository;

    public UserService(TransactionManager transactionManager, UserRepository userRepository) {
        this.transactionManager = transactionManager;
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        return transactionManager.doInTransaction(new TransactionOperation<Boolean>() {
            @Override
            public Boolean operation(Connection con) throws SQLException {
                User user = userRepository.findByEmail(con, email);
                boolean notNull = user!= null;
                boolean passNotNull = user.getPassword() != null;
                boolean equals = user.getPassword().equals(password);
                return notNull && passNotNull && equals;
            }
        });
    }

    public boolean exists(String email) {
        return transactionManager.doInTransaction(new TransactionOperation<Boolean>() {
            @Override
            public Boolean operation(Connection con) throws SQLException {
                User user = userRepository.findByEmail(con, email);
                return user != null;
            }
        });
    }

    public Void add(String email, String password, String name) {
        return transactionManager.doInTransaction(new TransactionOperation<Void>() {
            @Override
            public Void operation(Connection con) throws SQLException {
                userRepository.create(con, new User(name, email, password));
                return null;
            }
        });
    }
}
