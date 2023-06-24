package uni.lab8.servlets;

import BookShop.Interfaces.IPaperLit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uni.lab8.services.ItemService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
    private ItemService itemService;


    @Override
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        itemService = (ItemService) cfg.getServletContext().getAttribute(Constants.ATTRIBUTE_ITEM_SERVICE.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<IPaperLit> cart = (ArrayList<IPaperLit>) request.getSession().getAttribute(Constants.ATTRIBUTE_CART.toString());

        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        if (cart == null)
            cart = new ArrayList<IPaperLit>();
        else
            for (IPaperLit p :
                    cart) {
                if (p.getId() == id) {
                    response.setStatus(406);
                    return;
                }
            }
        IPaperLit paper = itemService.getById(id);
        if (paper != null) {
            cart.add(paper);
            request.getSession().setAttribute(Constants.ATTRIBUTE_CART.toString(), cart);
        }
    }
}