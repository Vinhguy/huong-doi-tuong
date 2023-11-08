import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class KhachHang extends MyAbstractClass {
    private int id;
    private String name;

    private static int balance;
    public int getId() {
        return id;
    }
    public String getName() {return name;}

    public Integer getBalance(){return balance;}
    public static void changeBalance(int change) {
        balance += change;
    }

    public  void LuuKhachHang() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập id khach hang : ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nhập ten khach hang: ");
             name = scanner.nextLine();

            System.out.print("Nhập so du khach hang : ");
             int change = scanner.nextInt();


        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM khachhang WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Record with the given ID exists; update it
                String updateSql = "UPDATE khachhang SET ho_ten = ?, so_du = ? WHERE id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);

                 balance = resultSet.getInt("so_du");
                changeBalance(change); // Add 'change' to the current balance
                updateStatement.setString(1, name);
                updateStatement.setInt(2, balance);
                updateStatement.setInt(3, id);

                System.out.println("Id cua khach hang la " + id);
                System.out.println("Ten cua khach hang la " + name);
                System.out.println("So du cua khach hang la " + balance);


            } else {
                // Record with the given ID does not exist; insert a new record
                String insertSql = "INSERT INTO khachhang (id, ho_ten, so_du) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, id);
                insertStatement.setString(2, name);
                insertStatement.setInt(3, change);
                System.out.println("Id cua khach hang la " + id);
                System.out.println("Ten cua khach hang la " + name);
                System.out.println("So du cua khach hang la " + balance);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
