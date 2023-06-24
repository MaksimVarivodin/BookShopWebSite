package uni.lab8.services;



import uni.lab8.repository.RepositoryException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    private DataSource ds;

    public TransactionManager(DataSource ds) {
        this.ds = ds;
    }

    public <T> T doInTransaction(TransactionOperation<T> op) {
        Connection con = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            T result = op.operation(con);

            con.commit();
            return result;
        } catch(Exception ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch(SQLException ex2){
                ex2.printStackTrace();
            }
            throw new RepositoryException(ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch(SQLException ex2){
                    ex2.printStackTrace();
                }
            }
        }
    }
}
