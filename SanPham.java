import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPham {
    private int id;
    private String tenSanPham;
    private double gia;
    private String moTa;
    private int soLuong;

    public SanPham(int id, String tenSanPham, double gia, String moTa, int soLuong) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    // Getter methods for fields

    public static void getAllSanPham() {
        String jdbcURL = "jdbc:mysql://localhost:3306/cua_hang";
        String username = "root";
        String password = "choinhanh12";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Prepare and execute SQL query
            String query = "SELECT * FROM sanpham";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Process the query result and print product details
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenSanPham = resultSet.getString("ten_sanpham");
                double gia = resultSet.getDouble("gia");
                int soLuong = resultSet.getInt("so_luong");

                System.out.println("ID: " + id);
                System.out.println("Tên Sản Phẩm: " + tenSanPham);
                System.out.println("Giá: " + gia);
                System.out.println("Số Lượng: " + soLuong);
                System.out.println();
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
