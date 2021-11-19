import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // when user enters correct details
        if(username.equals("admin") && password.equals("123")) {
            out.println("You are successfully logged in");
            out.println("<br> Welcome " + username);

            HttpSession session = request.getSession();
            session.setAttribute("uname", username);
        }
        else {
            out.println("Sorry, invalid details.");
            RequestDispatcher rd = request.getRequestDispatcher("/viewlist.html");
            rd.include(request, response);
        }
        out.close();
    }
}
