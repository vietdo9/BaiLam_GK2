package bl;

import java.io.*;
import java.sql.*;

// Interface định nghĩa phương thức showInfo
interface IEmployee {
    void showInfo();
}

// Class Employee chứa thông tin chung và các phương thức cơ bản
class Employee implements IEmployee {
    protected String ID;
    protected String fullName;
    protected String birthDay;
    protected String phone;
    protected String email;
    protected String employeeType;
    protected static int employeeCount = 0;

    // Constructor
    public Employee(String ID, String fullName, String birthDay, String phone, String email, String employeeType) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        employeeCount++;
    }

    // Phương thức showInfo hiển thị thông tin nhân viên
    @Override
    public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birthday: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + employeeType);
    }

    // Ghi thông tin nhân viên vào file
    public void writeToFile(BufferedWriter writer) throws IOException {
        writer.write(ID + "," + fullName + "," + birthDay + "," + phone + "," + email + "," + employeeType + "\n");
    }

    // Ghi thông tin nhân viên vào database
    public void writeToDatabase(Connection connection) throws SQLException {
        String query = "INSERT INTO employees (ID, fullName, birthDay, phone, email, employeeType) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, ID);
        preparedStatement.setString(2, fullName);
        preparedStatement.setString(3, birthDay);
        preparedStatement.setString(4, phone);
        preparedStatement.setString(5, email);
        preparedStatement.setString(6, employeeType);
        preparedStatement.executeUpdate();
    }
}
