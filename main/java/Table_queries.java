import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table_queries {
    Connection con = null;
    Table_queries() throws ClassNotFoundException {
        Database_Connection dc=new Database_Connection();
         con = dc.connectDB("harsh");
    }
    public void load_user_data(String name ,String email ,String password) throws SQLException {
        String sql_query="INSERT INTO login_details(email,name,passwords) VALUES(?,?,?)";
        PreparedStatement p = con.prepareStatement(sql_query);
        p.setString(1,email);
        p.setString(2, name);
        p.setString(3, password);
        p.executeUpdate();
    }
    public String check_user(String email, String password) throws SQLException {
        String sql_query = "SELECT * FROM login_details WHERE email = ? AND passwords = ?";
        PreparedStatement p = con.prepareStatement(sql_query);
        p.setString(1, email);
        p.setString(2, password);
        ResultSet rs = p.executeQuery();

        if (rs.next()) {
            // Assuming the User class has a constructor that takes ResultSet
            return rs.getString("name");

        } else {
            return null;
        }
    }
    public static void main(String[] args) {

    }
}
