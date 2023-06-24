package uni.lab8.servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import uni.lab8.repository.ItemRepository;
import uni.lab8.repository.OrderRepository;
import uni.lab8.repository.RepositoryException;
import uni.lab8.repository.UserRepository;
import uni.lab8.services.ItemService;
import uni.lab8.services.OrderService;
import uni.lab8.services.TransactionManager;
import uni.lab8.services.UserService;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebListener
public class ContextInitListener implements ServletContextListener {

    public ContextInitListener() {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DataSource source = null;
        try{
            source = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/shop");
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
        TransactionManager manager = new TransactionManager(source);

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(manager, userRepository);
        sce.getServletContext().setAttribute(Constants.ATTRIBUTE_USER_SERVICE.toString(), userService);

        ItemRepository itemRepository = new ItemRepository();
        ItemService itemService = new ItemService(manager, itemRepository);
        sce.getServletContext().setAttribute(Constants.ATTRIBUTE_ITEM_SERVICE.toString(), itemService);

        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(manager, orderRepository);
        sce.getServletContext().setAttribute(Constants.ATTRIBUTE_ORDER_SERVICE.toString(), orderService);


    }
}
