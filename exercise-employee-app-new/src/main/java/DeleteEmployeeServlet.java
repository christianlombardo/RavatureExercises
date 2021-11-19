
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteEmployeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

        request.getRequestDispatcher("header.html").include(request, response);

        String userid = request.getParameter("userid");
        String fullname = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(userid));
        employee.setName(fullname);
        employee.setEmail(email);
        employee.setCountry(country);
        employee.setGender(gender);

        employeeDao.delete(employee);

        out.println("<div class=\"container h-100\"><h1>Record deleted successfully.</h1></div>");

        request.getRequestDispatcher("addemployee.html").include(request, response);
        request.getRequestDispatcher("footer.html").include(request, response);

    }
}
