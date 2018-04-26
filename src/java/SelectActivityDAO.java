
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
            File dir = new File(System.getProperty("user.dir") + "/solFile/selectedFile");
            cleanDirectory(dir);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM activity WHERE name='" + saname + "';";
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("solution");
                InputStream inputStream = blob.getBinaryStream();
                File dir2 = new File(System.getProperty("user.dir") + "/solFile/sol/");
                new File(System.getProperty("user.dir") + "/solFile/sol/").mkdirs();
                cleanDirectory(dir2);
                OutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/solFile/sol/" + saname + "_sol.txt");
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
                System.out.println("File saved: " + System.getProperty("user.dir") + "/solFile/sol/" + saname + "_sol.txt");

                Blob blob2 = result.getBlob("script");
                InputStream inputStream2 = blob2.getBinaryStream();
                OutputStream outputStream2 = new FileOutputStream(System.getProperty("user.dir") + "/solFile/selectedFile/" + "aa_" + saname + "_wscript.m");
                int bytesRead2 = -1;
                byte[] buffer2 = new byte[BUFFER_SIZE];
                while ((bytesRead2 = inputStream2.read(buffer2)) != -1) {
                    outputStream2.write(buffer2, 0, bytesRead2);
                }
                inputStream2.close();
                outputStream2.close();
                System.out.println("File saved: " + System.getProperty("user.dir") + "/solFile/selectedFile/" + "aa_" + saname + "_wscript.m");

                Blob blob3 = result.getBlob("data");
                String fileName = result.getString("fname");
                InputStream inputStream3 = blob3.getBinaryStream();
                OutputStream outputStream3 = new FileOutputStream(System.getProperty("user.dir") + "/solFile/selectedFile/" + fileName);
                int bytesRead3 = -1;
                byte[] buffer3 = new byte[BUFFER_SIZE];
                while ((bytesRead3 = inputStream3.read(buffer3)) != -1) {
                    outputStream3.write(buffer3, 0, bytesRead3);
                }
                inputStream3.close();
                outputStream3.close();
                System.out.println("File saved: " + System.getProperty("user.dir") + "/solFile/selectedFile/" + fileName);
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
