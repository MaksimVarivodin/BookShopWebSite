package uni.lab8.servlets;

import BookShop.Interfaces.IPaperLit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/delfromcart")
public class DeleteFromCart extends HttpServlet {

    public DeleteFromCart() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<IPaperLit> cart = (ArrayList<IPaperLit>) request.getSession().getAttribute(Constants.ATTRIBUTE_CART.toString());
        if (cart!= null)
            cart = new ArrayList<IPaperLit>();
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        cart.removeIf(a -> (a.getId() == id));
        request.getSession().setAttribute(Constants.ATTRIBUTE_CART.toString(), cart);

    }
}