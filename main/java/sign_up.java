import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "sign_upServlet", value = "/sign_up-servlet")
public class sign_up extends HttpServlet {

    Table_queries tq;

    {
        try {
            tq = new Table_queries();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("userName");
        String emailID = request.getParameter("userEmail");
        String password = request.getParameter("userPassword");
        try {
            tq.load_user_data(name,emailID,password);
            System.out.println("Data loaded");
            request.setAttribute("name", name);
            RequestDispatcher rd=request.getRequestDispatcher("welcome_page.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }

}