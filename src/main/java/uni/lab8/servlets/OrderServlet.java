package uni.lab8.servlets;

import BookShop.Interfaces.IPaperLit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uni.lab8.services.OrderService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OrderService orderService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        orderService = (OrderService)cfg.getServletContext().getAttribute(Constants.ATTRIBUTE_ORDER_SERVICE.toString());
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<IPaperLit> cart = (ArrayList<IPaperLit>) request.getSession().getAttribute(Constants.ATTRIBUTE_CART.toString());
        if (cart == null)
            response.sendRedirect("/Lab8/cart");
        Object email = request.getSession().getAttribute(Constants.ATTRIBUTE_LOGIN.toString());

        double price = 0;
        if (cart != null)
            for (IPaperLit v : cart) {
                price += v.getPrice();
            }
        request.setAttribute(Constants.ATTRIBUTE_CART_COST.toString(), price);
        if (email == null)
            request.setAttribute("message", "You need to login!");
        request.getServletContext().getRequestDispatcher("/getpage?pagename=order.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        ArrayList<IPaperLit> cart = (ArrayList<IPaperLit>) request.getSession().getAttribute("cart");
        int k = 0;
        if (cart != null)
            k = cart.size();
        int cvv = Integer.parseInt(request.getParameter("cvv")),
        card = Integer.parseInt(request.getParameter("card"));

        String email = request.getSession().getAttribute(Constants.ATTRIBUTE_LOGIN.toString()).toString();
        try {
            orderService.create(email, cart, card, cvv);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getSession().setAttribute(Constants.ATTRIBUTE_CART.toString(), null);
        request.setAttribute("k", k);
        request.getServletContext().getRequestDispatcher("/getpage?pagename=result.jsp").forward(request, response);
    }

}