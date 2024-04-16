package bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // URL của cơ sở dữ liệu MySQL. 
            String url = "jdbc:mysql://localhost:3306/danhsach";

            // Thay đổi tên người dùng và mật khẩu của bạn tương ứng với cơ sở dữ liệu MySQL của bạn.
            String username = "root";
            String password = "12345";

            // Tạo kết nối
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối với MySQL đã được thiết lập!");

        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy MySQL JDBC Driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại! Vui lòng kiểm tra lại thông tin kết nối.");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
