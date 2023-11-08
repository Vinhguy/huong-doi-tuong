import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SanPham extends MyAbstractClass implements MyInterface  {
    private int id;
    private String tenSanPham;
    private double gia;

    private int soLuong;

    public SanPham(int id, String tenSanPham, double gia, int soLuong) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }
    public SanPham(){

    }


    // Getter methods for fields
    public int getId() {
        return id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }


    public static  List<SanPham> getAllSanPham()  {
        List<SanPham> sanPhamList = new ArrayList<>();

        try {
            // Establish a database connection
            Connection connection = null;
            connection = DatabaseConnection.getConnection();
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
                SanPham sanPham = new SanPham(id, tenSanPham, gia, soLuong);
                sanPhamList.add(sanPham);

            }

            // Close resources
        } catch (Exception e) {
            e.printStackTrace();

        }
        return sanPhamList;
    }
    @Override
    public void printout(){
        System.out.println("ID: " + id);
        System.out.println("Tên Sản Phẩm: " + tenSanPham);
        System.out.println("Giá: " + gia);
    }
}

