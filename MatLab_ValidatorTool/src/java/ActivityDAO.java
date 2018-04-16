
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.InputStream;
import java.sql.DriverManager;


public class ActivityDAO {
    
    String url = "jdbc:mysql://localhost:3306/navin";
    String username = "root";
    String password = "admin";
    public boolean sumbit(String aname, String acourse, InputStream file1, InputStream file2){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(url, username,password);
            String sql = "insert into activity (name,course, solution, script) values('"+aname+"','"+acourse+"', ?, ?);";
            PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
            st.setBlob(1, file1);
            st.setBlob(2, file2);
            st.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
}
