package uni.lab8.repository;

import BookShop.Interfaces.IPaperLit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




/**
 * OrderRepository class that allows to access order data in database.
 * */
public class OrderRepository {


    /**
     * Sql query to get user with specified email
     * */
    private static String GET_USER = "select id_user from users where email = ? order by id_user desc limit 1;";


    /**
     * Sql query to add new order
     * */
    private static String ADD_NEW_ORDER = "insert into orders (id_user, card, cvv) values (?, ?, ?);";


    /**
     *      Sql query to get added order
     * */
    private static String GET_ADDED_ORDER = "select id_order from orders, users where ( orders.id_user = users.id_user and users.email = ?) order by id_order desc limit 1;";


    /**
     *      Sql query to add selected
     * */
    private static String ADD_SELECTED = "insert into selected(id_order, id_lit) values(?, ?) ;";


    /**
     * Adds selected Literature to order
     * */
    public void addSelected (Connection con, final int addedOrderId, ArrayList<IPaperLit> cart) throws SQLException {
        for (IPaperLit paper:
                cart) {
            try (PreparedStatement s1 = con.prepareStatement(ADD_SELECTED)){
                s1.setInt(1, addedOrderId);
                s1.setInt(2, paper.getId());
                s1.executeUpdate();
            }
        }
    }



    /**
     *      Creates new order
     * */
    public void create(Connection con, final String mail, ArrayList<IPaperLit> cart, int card, int cvv) throws SQLException {
        int addedOrderId = 0,
                id_user = 0;
        try (PreparedStatement s1 = con.prepareStatement(GET_USER)){
            s1.setString(1, mail);
            ResultSet set = s1.executeQuery();
            if (set.next())
                id_user = set.getInt(1); // id_order
        }
        try (PreparedStatement s1 = con.prepareStatement(ADD_NEW_ORDER)){
            s1.setInt(1, id_user);
            s1.setInt(2, card);
            s1.setInt(3, cvv);
            s1.executeUpdate();
        }
        try (PreparedStatement s1 = con.prepareStatement(GET_ADDED_ORDER)){
            s1.setString(1, mail);
            ResultSet set = s1.executeQuery();
            if (set.next())
                addedOrderId = set.getInt(1); // id_order
        }
        addSelected(con, addedOrderId, cart);

    }


}
