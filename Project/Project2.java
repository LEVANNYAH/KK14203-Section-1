/*
   NAME: LEVANNYAH RAJASEGARAN
   MATRIC NO.: BI19160337
   COURSE: KK14203 OBJECT ORIENTED PROGRAMMING - SECTION 1 (SEMESTER 2, 2019/2020)
   LECTURER: DR MOHD SHAMRIE SAININ
   PROJECT TITLE: COURSE GRADE FOR HC00
*/

public class Project2{
    
    private double totalMarks = 0.0;
    private String grade;
    private String gradeStatus;
    private double courseGp = 0.0;
    
    public Project2(){
    }
    
    //Accessors and Mutators
    public double getTotalMarks(){
       return totalMarks;
    }
    
    public void setTotalMarks(double totalMarks){
       this.totalMarks = totalMarks;
    }
    
    public String getGrade(){
       return grade;
    }
    
    public void setGrade(String grade){
       this.grade = grade;
    }
    
    public String getGradeStatus(){
       return gradeStatus;
    }
    
    public void setGradeStatus(String gradeStatus){
       this.gradeStatus = gradeStatus;
    }
    
    public double getCourseGp(){
       return courseGp;
    }
    
    public void setCourseGpa(double courseGp){
       this.courseGp = courseGp;
    }
    
    //calculate total marks entered
    public double calculateMarks(int assignment, int quizzes, int midterm, int finalexam){
       totalMarks = (assignment * 0.3) + (quizzes * 0.1) + (midterm * 0.2) + (finalexam * 0.4);
       return totalMarks;
    }
    
    //get grade based on total marks
    public String getGrade(double totalMarks){
       if (totalMarks >= 80.0){
            grade = "A";
       }else if (totalMarks >= 75.0){
            grade = "A-";
       }else if (totalMarks >= 70.0){
            grade = "B+";
       }else if (totalMarks >= 65.0){
            grade = "B";
       }else if (totalMarks >= 60.0){
            grade = "B-";
       }else if (totalMarks >= 55.0){
            grade = "C+";
       }else if (totalMarks >= 50.0){
            grade = "C";
       }else if (totalMarks >= 45.0){
            grade = "C-";
       }else if (totalMarks >= 40.0){
            grade = "D+";
       }else if (totalMarks >= 35.0){
            grade = "D";
       }else {
            grade = "E";
       }

        return grade;
     }
     
       //get grade status based on grade obtained
       public String getGradeStatus(String grade){
         if (grade == "A" || grade == "A-"){
             gradeStatus = "PASS WITH A DISTINCTION";
         }else if (grade == "B+" || grade == "B" || grade == "B-"){
             gradeStatus = "PASS WITH A CREDIT";
         }else if (grade == "C+" || grade == "C" || grade == "C-" || grade == "D+" || grade == "D"){
             gradeStatus = "PASS";
         }else {
             gradeStatus = "FAIL";
          }
          
          return gradeStatus;
       }
       
       //get grade points for course based on grade
        public double getCourseGp(double totalMarks) {
          if (totalMarks >= 80.0){
            courseGp = 4.00;
          }else if (totalMarks >= 75.0){
            courseGp = 3.67;
          }else if (totalMarks >= 70.0){
            courseGp = 3.33;
          }else if (totalMarks >= 65.0){
            courseGp = 3.00;
          }else if (totalMarks >= 60.0){
            courseGp = 2.67;
          }else if (totalMarks >= 55.0){
            courseGp = 2.33;
          }else if (totalMarks >= 50.0){
            courseGp = 2.00;
          }else if (totalMarks >= 45.0){
            courseGp = 1.67;
          }else if (totalMarks >= 40.0){
             courseGp = 1.33;
          }else if (totalMarks >= 35.0){
            courseGp = 1.00;
          }else {
            courseGp = 0.00;
        }

        return courseGp;
    }
}
