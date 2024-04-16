package bl;

//Class EmployeeIntern kế thừa từ Employee và mở rộng với các thuộc tính mới
class EmployeeIntern extends Employee {
 private String majors;
 private String semester;
 private String universityName;

 // Constructor
 public EmployeeIntern(String ID, String fullName, String birthDay, String phone, String email,
         String majors, String semester, String universityName) {
     super(ID, fullName, birthDay, phone, email, "Intern");
     this.majors = majors;
     this.semester = semester;
     this.universityName = universityName;
 }

 // Override phương thức showInfo để hiển thị thông tin của EmployeeIntern
 @Override
 public void showInfo() {
     super.showInfo();
     System.out.println("Majors: " + majors);
     System.out.println("Semester: " + semester);
     System.out.println("University Name: " + universityName);
 }
}