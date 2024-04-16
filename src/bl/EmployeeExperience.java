package bl;

//Class EmployeeExperience kế thừa từ Employee và mở rộng với các thuộc tính mới
class EmployeeExperience extends Employee {
 private int expInYear;
 private String proSkill;

 // Constructor
 public EmployeeExperience(String ID, String fullName, String birthDay, String phone, String email,
         int expInYear, String proSkill) {
     super(ID, fullName, birthDay, phone, email, "Experience");
     this.expInYear = expInYear;
     this.proSkill = proSkill;
 }

 // Override phương thức showInfo để hiển thị thông tin của EmployeeExperience
 @Override
 public void showInfo() {
     super.showInfo();
     System.out.println("Experience in Year: " + expInYear);
     System.out.println("Professional Skill: " + proSkill);
 }
}
