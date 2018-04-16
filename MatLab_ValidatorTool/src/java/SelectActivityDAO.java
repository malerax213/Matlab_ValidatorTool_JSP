
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectActivityDAO {

    private static final int BUFFER_SIZE = 4096;
    String url = "jdbc:mysql://localhost:3306/navin";
    String username = "root";
    String password = "admin";

    public boolean sumbit(String saname, HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ClassNotFoundException, IOException {
        try {
            File dir = new File(System.getProperty("user.dir") + "/solFile/");
            cleanDirectory(dir);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM activity WHERE name='" + saname + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("solution");
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/solFile/" + saname);

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();
                System.out.println("File saved:" + System.getProperty("user.dir") + "/solFile/" + saname);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void cleanDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.getName().equals("wlog.txt")) {
                //do nothing
            } else {
                //delete file
                file.delete();
            }

        }
    }
}
