package bl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();

        // Nhập thông tin từ bàn phím
        System.out.println("Enter employee information:");
        System.out.print("ID: ");
        String ID = scanner.nextLine();
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Birthday: ");
        String birthDay = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Employee Type (Experience/Fresher/Intern): ");
        String employeeType = scanner.nextLine();

        // Tạo đối tượng nhân viên tương ứng và thêm vào danh sách
        switch (employeeType.toLowerCase()) {
            case "experience":
                System.out.print("Years of Experience: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Professional Skill: ");
                String proSkill = scanner.nextLine();
                employeeManager.addEmployee(new EmployeeExperience(ID, fullName, birthDay, phone, email, expInYear, proSkill));
                break;
            case "fresher":
                System.out.print("Graduation Date: ");
                String graduationDate = scanner.nextLine();
                System.out.print("Graduation Rank: ");
                String graduationRank = scanner.nextLine();
                System.out.print("Education: ");
                String education = scanner.nextLine();
                employeeManager.addEmployee(new EmployeeFresher(ID, fullName, birthDay, phone, email, graduationDate, graduationRank, education));
                break;
            case "intern":
                System.out.print("Majors: ");
                String majors = scanner.nextLine();
                System.out.print("Semester: ");
                String semester = scanner.nextLine();
                System.out.print("University Name: ");
                String universityName = scanner.nextLine();
                employeeManager.addEmployee(new EmployeeIntern(ID, fullName, birthDay, phone, email, majors, semester, universityName));
                break;
            default:
                System.out.println("Invalid employee type.");
        }

        // Hiển thị thông tin của tất cả nhân viên
        System.out.println("-----------------");
        employeeManager.displayAllEmployees();

        // Ghi danh sách nhân viên vào file
        employeeManager.writeToFile("D:\\javaproject-2\\Gk2\\src\\employees.txt");

        // Kết nối và ghi danh sách nhân viên vào database
        String url = "jdbc:mysql://localhost:3306/danhsach";
        String username = "root";
        String password = "12345";
        employeeManager.writeToDatabase(url, username, password);

        scanner.close();
    }
}
