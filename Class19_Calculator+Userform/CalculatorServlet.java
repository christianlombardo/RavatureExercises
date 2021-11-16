import javafx.scene.input.DataFormat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculatorServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.println("<h1>Welcome to Calculator Servlet<h1>");

        NumberFormat df = DecimalFormat.getInstance();
        df.setMaximumFractionDigits(2);
        double number1 = Double.parseDouble(request.getParameter("number1"));
        double number2 = Double.parseDouble(request.getParameter("number2"));
        String operation = request.getParameter("operation");

        System.out.println("operation = " + operation);
        double result=0;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            default:
                System.out.println("Oooopps an error occurred!");
                break;
        }


        //out.println("The output " + number1 + " " + operation + " " + number2 + " = " + result);

        PrintWriter pw = response.getWriter();
        pw.print("<html>");
        pw.print("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Calculator Form</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "</head>");
        pw.print("<div class=\"position-absolute top-50 start-50 translate-middle p-3 mb-2 bg-primary \">" +
                "<h1 >result = " + df.format(result) +
                "</h1></div>");
        pw.println("<body");
        pw.print("<h1></h1>");
        pw.print("</body></html>");

    }

}
