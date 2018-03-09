
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DeleteActivityDAO {
    
    String url = "jdbc:mysql://localhost:3306/navin";
    String username = "root";
    String password = "admin";
    public boolean sumbit(String daname){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url, username,password);
            String sql = "DELETE FROM activity WHERE name='"+daname +"';";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
}
