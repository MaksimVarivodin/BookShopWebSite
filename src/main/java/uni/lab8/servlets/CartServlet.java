package uni.lab8.servlets;

import BookShop.Interfaces.IPaperLit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<IPaperLit> cart = (ArrayList<IPaperLit>) request.getSession().getAttribute(Constants.ATTRIBUTE_CART.toString());
        double price = 0;
        int count = 0;
        if (cart!= null)
            for (IPaperLit p:
                    cart) {
                count++;
                price += p.getPrice();
            }
        request.setAttribute(Constants.ATTRIBUTE_CART_COST.toString(), price);
        request.setAttribute(Constants.ATTRIBUTE_CART_SIZE.toString(), count);
        request.getServletContext().getRequestDispatcher("/getpage?pagename=cart.jsp").forward(request, response);
    }

}