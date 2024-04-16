package bl;

//Class EmployeeFresher kế thừa từ Employee và mở rộng với các thuộc tính mới
class EmployeeFresher extends Employee {
 private String graduationDate;
 private String graduationRank;
 private String education;

 // Constructor
 public EmployeeFresher(String ID, String fullName, String birthDay, String phone, String email,
         String graduationDate, String graduationRank, String education) {
     super(ID, fullName, birthDay, phone, email, "Fresher");
     this.graduationDate = graduationDate;
     this.graduationRank = graduationRank;
     this.education = education;
 }

 // Override phương thức showInfo để hiển thị thông tin của EmployeeFresher
 @Override
 public void showInfo() {
     super.showInfo();
     System.out.println("Graduation Date: " + graduationDate);
     System.out.println("Graduation Rank: " + graduationRank);
     System.out.println("Education: " + education);
 }
}