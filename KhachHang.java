import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
class KhachHang {
    private String id;
    private String name;
    private String email;
    private String phone;

    public KhachHang(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
