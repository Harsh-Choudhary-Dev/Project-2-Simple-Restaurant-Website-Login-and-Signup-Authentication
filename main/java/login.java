import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;


@WebServlet(name = "loginServlet", value = "/login-servlet")
public class login extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Table_queries tq;
        PrintWriter out = response.getWriter();

        {
            try {
                tq = new Table_queries();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        response.setContentType("text/html");
        System.out.println("hii");
        String emailID = request.getParameter("userEmail");
        System.out.println(emailID);
        String password = request.getParameter("userPassword");
        System.out.println(password);
        try {
            String value = tq.check_user(emailID,password);
            if(value != null){
                System.out.println(value);
                request.setAttribute("name", value);
                RequestDispatcher rd=request.getRequestDispatcher("welcome_page.jsp");
                rd.forward(request, response);
            }else {
                System.out.println(value);
                out.print("<div class='alert alert-danger' role='alert'>");
                out.print (" The email or password is incorrect. If you don't have an account, please create one");
                out.print ("</div>");
                RequestDispatcher rd=request.getRequestDispatcher("login_page.html");
                rd.include(request, response);
            }
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}