public class Hoadon {
    private SanPham product;
    private KhachHang customer;
    private int quantity;

    public Hoadon(SanPham product, KhachHang customer, int quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public void generateBill() {
        System.out.println("Hóa đơn của bạn:");
        System.out.println("Sản phẩm: " + product.getTenSanPham());
        System.out.println("Số lượng: " + quantity);
        double totalCost = quantity * product.getGia();
        System.out.println("Thành tiền: " + totalCost);

        int currentBalance = customer.getBalance();
        System.out.println("Số dư hiện tại của khách hàng: " + currentBalance);

        if (totalCost > currentBalance) {
            System.out.println("Không đủ tiền trong tài khoản để thanh toán.");
        } else {
            int newBalance = currentBalance - (int) totalCost;
            customer.changeBalance(-1 * (int) totalCost);
            System.out.println("Số dư sau thanh toán: " + newBalance);
        }
    }
}
