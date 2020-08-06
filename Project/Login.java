/*
   NAME: LEVANNYAH RAJASEGARAN
   MATRIC NO.: BI19160337
   COURSE: KK14203 OBJECT ORIENTED PROGRAMMING - SECTION 1 (SEMESTER 2, 2019/2020)
   LECTURER: DR MOHD SHAMRIE SAININ
   PROJECT TITLE: COURSE GRADE FOR HC00
*/

//To login, Username: Admin, Password: Admin
class Login{
   private boolean LOGGED = false;
   private int attempt = 0;

   //constructor
   public Login(){
      
   }   
   
   public boolean checkLogin(){
      if(LOGGED){
         return true;
      }      
      return false;      
   }
   
   public boolean doLogin(String username, String password){
      if(attempt <= 4){
         
         return true;      
      }
      return false;       
   }
   
   public int getAttempt(){
      return attempt;
   }
}