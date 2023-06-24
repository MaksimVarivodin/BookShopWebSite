package uni.lab8.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import uni.lab8.services.UserService;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService)config.getServletContext().getAttribute(Constants.ATTRIBUTE_USER_SERVICE.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  email = request.getParameter("email"),
                pass = request.getParameter("pass"),
                name = request.getParameter("name");


        if (!userService.exists(email)){
            try  {
                userService.add(email, pass,name);
            }
            catch (Exception e){
                response.setStatus(500);
            }
            HttpSession session = request.getSession();
            session.setAttribute(Constants.ATTRIBUTE_LOGIN.toString(), email);
            response.setStatus(200);
        } else
            response.setStatus(406);
    }
}