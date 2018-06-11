
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteActivityDAO {

    String url = "jdbc:mysql://localhost:3306/navin";
    String username = "root";
    String password = "admin";

    public boolean sumbit(String daname, String course) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            int cour = Integer.parseInt(course);
            Connection con = (Connection) DriverManager.getConnection(url, username, password);
            String sql = "DELETE FROM activity WHERE course = '" + cour + "' AND name = '" + daname + "';";
            System.out.println(daname);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
