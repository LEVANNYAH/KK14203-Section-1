/*
   NAME: LEVANNYAH RAJASEGARAN
   MATRIC NO.: BI19160337
   COURSE: KK14203 OBJECT ORIENTED PROGRAMMING (SEMESTER 2, 2019/2020)
   LECTURER: DR MOHD SHAMRIE SAININ
   PROJECT TITLE: COURSE GRADE FOR HC00
*/

//To login, Username: Admin, Password: Admin
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

public class Login implements ActionListener{
   private static JLabel lbl_user;
   private static JTextField userText;
   private static JLabel lbl_password;
   private static JPasswordField passwordText;
   private static JButton button;
   private static JLabel success;
    
    public static void main(String[] args) { 
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Login");   
        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        
        lbl_user = new JLabel("User");
        lbl_user.setBounds(10, 20, 80, 25);
        panel.add(lbl_user);
        
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        lbl_password = new JLabel("Password");
        lbl_password.setBounds(10, 50, 80, 25);
        panel.add(lbl_password);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        
        button = new JButton("Login");
        button.setBounds(185, 80, 80, 25);
        button.addActionListener(new Login());
        panel.add(button);
        
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        frame.setVisible(true);      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String user = userText.getText();
      String password = passwordText.getText();
     
         if (user.equals("Admin") && password.equals("Admin")) {
            success.setText("Login successful! Welcome, " + user + ".");
       } else {
            success.setText("Invalid username and password!");
         }
     }
 }