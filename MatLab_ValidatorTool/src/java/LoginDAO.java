
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class LoginDAO {
    
    String sql = "select * from login where login=? and pass=?";
    String url = "jdbc:mysql://localhost:3306/navin";
    String username = "root";
    String password = "admin";
    public boolean check(String uname, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url, username,password);
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
            st.setString(1, uname);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
}
