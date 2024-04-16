package bl;

import java.io.*;
import java.sql.*;
import java.util.*;

//Class để quản lý danh sách nhân viên và các chức năng CRUD
class EmployeeManager {
 private List<Employee> employees = new ArrayList<>();

 // Thêm nhân viên mới vào danh sách
 public void addEmployee(Employee employee) {
     employees.add(employee);
 }

 // Hiển thị thông tin của tất cả nhân viên
 public void displayAllEmployees() {
     for (Employee employee : employees) {
         employee.showInfo();
         System.out.println();
     }
 }

 // Ghi danh sách nhân viên vào file
 public void writeToFile(String filename) {
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
         for (Employee employee : employees) {
             employee.writeToFile(writer);
         }
     } catch (IOException e) {
         System.err.println("Error writing to file: " + e.getMessage());
     }
 }

 // Ghi danh sách nhân viên vào database
 public void writeToDatabase(String url, String username, String password) {
     try (Connection connection = DriverManager.getConnection(url, username, password)) {
         for (Employee employee : employees) {
             employee.writeToDatabase(connection);
         }
     } catch (SQLException e) {
         System.err.println("Error writing to database: " + e.getMessage());
     }
 }
}
