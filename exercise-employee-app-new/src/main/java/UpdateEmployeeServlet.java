
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateEmployeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("header.html").include(request, response);

        String userid = request.getParameter("userid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");

        out.println("<section class=\"vh-100\">\n" +
                "    <form action=\"UpdateEmployeeServlet\" method=\"post\">\n" +
                "        <div class=\"container h-100\">\n" +
                "            <div class=\"row align-items-center pt-4 pb-3\">\n" +
                "                <div class=\"col-md-4\"><a href=\"index.html\" >Home</a></div>\n" +
                "            </div>\n" +
                "            <div class=\"row d-flex justify-content-center align-items-center h-100\">\n" +
                "                <div class=\"col-xl-9\">\n" +
                "\n" +
                "                    <div class=\"mb-4\" name=\"servletresult\"></div>\n" +
                "\n" +
                "                    <h1 class=\"mb-4\">Update Employee</h1>\n" +
                "                    <div class=\"card\" style=\"border-radius: 15px;\">\n" +
                "                        <div class=\"card-body\">\n" +
                "\n" +
                "                            <div class=\"row align-items-center pt-4 pb-3\">\n" +
                "                                <div class=\"col-md-3 ps-5\">\n" +
                "                                    <h6 class=\"mb-0\">Full name</h6>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-9 pe-5\">\n" +
                "                                    <input type=\"text\" class=\"form-control form-control-lg\" name=\"name\" value=\"" + name + "\" required />\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                                 <input type=\"hidden\" id=\"userid\" name=\"userid\" value=\"" + userid + "\">" +
                "\n" +
                "                            <div class=\"row align-items-center py-3\">\n" +
                "                                <div class=\"col-md-3 ps-5\">\n" +
                "                                    <h6 class=\"mb-0\">Email address</h6>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-9 pe-5\">\n" +
                "                                    <input type=\"email\" class=\"form-control form-control-lg\" placeholder=\"example@example.com\" name=\"email\" value=\"" + email + "\" required />\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "\n" +
                "                            <div class=\"row align-items-center pt-4 pb-3\">\n" +
                "                                <div class=\"col-md-3 ps-5\">\n" +
                "                                    <h6 class=\"mb-0\">Country</h6>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-9 pe-5\">\n" +
                "                                    <input type=\"text\" class=\"form-control form-control-lg\" name=\"country\" value=\"" + country + "\" required />\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "\n" +
                "                            <div class=\"row align-items-center pt-4 pb-3\">\n" +
                "                                <div class=\"col-md-3 ps-5\">\n" +
                "                                    <h6 class=\"mb-0 me-4\">Gender: </h6>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-md-9\">\n" +
                "                                    <div class=\"col-md-5 form-check form-check-inline mb-0 me-4\">\n" +
                "                                        <input\n" +
                "                                                class=\"form-check-input\"\n" +
                "                                                type=\"radio\"\n" +
                "                                                name=\"gender\"\n" +
                "                                                id=\"femaleGender\"\n" +
                "                                                value=\"female\"\n" +
                                                        (gender.equals("female") ? "checked=\"checked\" " : "") +
                "                                        />\n" +
                "                                        <label class=\"col-md-5 form-check-label\" for=\"femaleGender\">Female</label>\n" +
                "                                    </div>\n" +
                "\n" +
                "                                    <div class=\"form-check form-check-inline mb-0 me-4\">\n" +
                "                                        <input\n" +
                "                                                class=\"form-check-input\"\n" +
                "                                                type=\"radio\"\n" +
                "                                                name=\"gender\"\n" +
                "                                                id=\"maleGender\"\n" +
                "                                                value=\"male\"\n" +
                                                        (gender.equals("male") ? "checked=\"checked\" " : "") +
                "                                        />\n" +
                "                                        <label class=\"form-check-label\" for=\"maleGender\">Male</label>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "\n" +
                "                            <div class=\"px-5 py-4\">\n" +
                "                                <!--<<div class=\"row align-items-center pt-4 pb-3\">-->\n" +
                "                                <button type=\"submit\" class=\"btn btn-primary btn-block\">Update</button>\n" +
                "                            </div>\n" +
                "\n" +
                "                            <div class=\"px-5 py-4\">\n" +
                "                                <a href=\"ViewEmployeeListServlet\">View List</a>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</section>");
        request.getRequestDispatcher("footer.html").include(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

        String userid = request.getParameter("userid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");

        request.getRequestDispatcher("header.html").include(request, response);

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(userid));
        employee.setName(name);
        employee.setEmail(email);
        employee.setCountry(country);
        employee.setGender(gender);

        employeeDao.update(employee);

        out.println("<div class=\"container h-100\"><h1>Recorded updated successfully.</h1></div>");

        request.getRequestDispatcher("addemployee.html").include(request, response);
        request.getRequestDispatcher("footer.html").include(request, response);

    }
}
