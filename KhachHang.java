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

    public void LuuKhachHang() {
        Scanner scanner = new Scanner(System.in);
         id = -1; // Initialize id to an invalid value
        while (id < 0) {
            System.out.print("Nhập id khách hàng: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0) {
                    System.out.println("ID phải là một số không âm. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("ID phải là một số nguyên không âm. Vui lòng nhập lại.");
                scanner.next(); // Consume invalid input
            }
        }
            System.out.print("Nhập so du khach hang muon them : ");
             int change = scanner.nextInt();
             scanner.nextLine();
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
                name = resultSet.getString("ho_ten");
                updateStatement.setInt(2, change);
                updateStatement.setInt(3, id);
                changeBalance(change);

                printout(id,balance,name);

            } else {
                // Record with the given ID does not exist; insert a new record
                String insertSql = "INSERT INTO khachhang (id, ho_ten, so_du) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                System.out.println("Nhap ten khach hang ");
                name = scanner.nextLine();
                insertStatement.setInt(1, id);
                insertStatement.setString(2, name);
                insertStatement.setInt(3, balance);
                changeBalance(change);

                printout(id,balance,name);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    void printout(int id,int balance,String name){
        System.out.println("Id cua khach hang la "+id);
        System.out.println("Ten cua khach hang la "+name);
        System.out.println("So du cua khach hang la "+balance);
    }
}
