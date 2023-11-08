import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Create a SanPham instance to fetch the product data
        SanPham sanPham = new SanPham();

        // Get the list of available products
        List<SanPham> sanPhamList = sanPham.getAllSanPham();

        // Display the available products
        System.out.println("Danh sách sản phẩm có sẵn:");
        for (SanPham product : sanPhamList) {
            System.out.println("ID: " + product.getId() + ", Tên sản phẩm: " + product.getTenSanPham() +
                    ", Giá: " + product.getGia() + ", Số lượng: " + product.getSoLuong());
        }

        // Ask the user to choose a product
        System.out.print("Nhập ID sản phẩm bạn muốn mua: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap so luong ban muon mua ");
        int quantity = scanner.nextInt();
        scanner.nextLine();


        // Find the selected product
        SanPham selectedProduct = null;
        for (SanPham product : sanPhamList) {
            if (product.getId() == productId ) {

                selectedProduct = product;
                break;
            }
            else{
                System.out.println("Vui long nhap lai ");
                System.out.print("Nhập ID sản phẩm bạn muốn mua: ");
                productId = scanner.nextInt();
                System.out.println("Nhap so luong ban muon mua ");
                quantity = scanner.nextInt();
            }
        }
        KhachHang khachHang = new KhachHang();
        khachHang.LuuKhachHang();

        Hoadon hoaDon = new Hoadon(selectedProduct, khachHang, quantity);
        hoaDon.generateBill();

        scanner.close();
            /*if (selectedProduct != null) {
                System.out.println("Hoa don cua ban la ");
                selectedProduct.printout();
                System.out.println("Tong gia thanh bang "+quantity*selectedProduct.getGia());
                System.out.println("So du moi cua ban con ");
            } else {
                System.out.println("Sản phẩm không tồn tại.");*/
    }
}


