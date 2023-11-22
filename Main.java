import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KhachHang khachHang = new KhachHang();
        khachHang.LuuKhachHang();
        SanPham sanPham = new SanPham();
        List<SanPham> selectedProducts = new ArrayList<>();
        HangXuatKhau hangXuatKhau = new HangXuatKhau();


        while(true) {
        System.out.println("Chọn tác vụ:");
        System.out.println("1. Chọn mua sản phẩm");
        System.out.println("2. Chọn mua hàng xuất khẩu");
        System.out.println("3. Thêm sản phẩm hàng xuất khẩu");
        System.out.println("4. Xóa sản phẩm hàng xuất khẩu ");
        System.out.println("5. Chọn mua hàng mỹ phẩm");
        System.out.println("6. Thoát");


        int choice = scanner.nextInt();
        scanner.nextLine();
            switch (choice) {
                case 1:
                    selectedProducts.addAll(sanPham.chonSanpham());
                    break;
                case 2:
                    selectedProducts.addAll(hangXuatKhau.muaSanpham());
                    break;
                case 3:
                    hangXuatKhau.themSanPham();
                    break;
                case 4:
                    System.out.println("Nhập id mặt hàng cần xóa");
                    int i = scanner.nextInt();
                    hangXuatKhau.xoaSanPham(i);
                case 5:

                    break;
                case 6:
                    System.out.println("Kết thúc chương trình ");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }



    }
}