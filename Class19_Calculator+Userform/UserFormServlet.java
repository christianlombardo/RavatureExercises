
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserFormServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("<h1>Welcome to User Form Register Servlet<h1>");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String movie = request.getParameter("movie");

		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <title>User Form</title>\n" +
				"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
				"</head>");
		// "<div class=\"d-flex justify-content-center row g-3\">" +
		pw.print("<body>" +
				"<div class=\"container\">" +
				"<div class=\"row g-3\">" +
				"<div class=\"col-md-12\">" +
				"	<h1>User Profile</h1>" +
				"</div>" +
				"<div class=\"col-md-12\">" +
				"<table class=\"table w-auto table-primary table-responsive\" style=\"font-family:Verdana;\">" +
				"<tr>\n" +
				"    <td>First Name:</td>\n" +
				"    <td>" +  fname + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Last Name:</td>\n" +
				"    <td>" +  lname + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>City:</td>\n" +
				"    <td>" +  city + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>State:</td>\n" +
				"    <td>" +  state + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Zip:</td>\n" +
				"    <td>" +  zip + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Phone:</td>\n" +
				"    <td>" +  phone + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Email:</td>\n" +
				"    <td>" +  email + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Username:</td>\n" +
				"    <td>" +  username + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Password:</td>\n" +
				"    <td>" +  password + "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Hobby(ies):</td>\n" +
				"    <td>" +  hobby+ "</td>\n" +
				"</tr>" +
				"<tr>\n" +
				"    <td>Movie:</td>\n" +
				"    <td>" +  movie + "</td>\n" +
				"</tr>" +
				"</table>" +
				"</div>" +
				"</div></div>");
		pw.print("</body></html>");



	}

}
