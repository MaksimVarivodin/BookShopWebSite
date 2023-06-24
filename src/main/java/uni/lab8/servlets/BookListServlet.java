package uni.lab8.servlets;

import BookShop.Interfaces.IPaperLit;
import BookShop.Realizations.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uni.lab8.services.ItemService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {
    private ItemService itemService;
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        itemService = (ItemService)cfg.getServletContext().getAttribute(Constants.ATTRIBUTE_ITEM_SERVICE.toString());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<IPaperLit> cart = (ArrayList<IPaperLit>) request.getSession().getAttribute("cart");
        int k = 0;
        if (cart != null)
            k = cart.size();
        ArrayList<Book> booklist  = itemService.getBooks();
        request.setAttribute("booklist", booklist);
        request.setAttribute("k", k);
        request.getServletContext().getRequestDispatcher("/getpage?pagename=booklist.jsp").forward(request, response);
    }

}