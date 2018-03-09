
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ActivityDAO {
    
    String url = "jdbc:mysql://localhost:3306/navin";
    String username = "root";
    String password = "admin";
    public boolean sumbit(String aname, String acourse){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url, username,password);
            String sql = "insert into activity values('"+aname +"','"+acourse+"');";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
            st.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
}
