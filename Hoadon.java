import java.util.List;

abstract class HoaDon {
    private List<SanPham> danhSachSanPham;
    private double tongGia;

    public HoaDon(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
        this.tongGia = 0.0;
    }

    public double tinhTongGia() {
        for (SanPham sanPham : danhSachSanPham) {
            tongGia += sanPham.getGia() * sanPham.getSoLuong();
        }
        return tongGia;
    }



   public void ThongTinKhachHang() {

    }


}
