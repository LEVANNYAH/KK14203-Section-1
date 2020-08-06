/*
   NAME: LEVANNYAH RAJASEGARAN
   MATRIC NO.: BI19160337
   COURSE: KK14203 OBJECT ORIENTED PROGRAMMING (SEMESTER 2, 2019/2020)
   LECTURER: DR MOHD SHAMRIE SAININ
   PROJECT TITLE: COURSE GRADE FOR HC00
*/

//This program accepts marks from user and outputs total marks, grade, grade status and grade points
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;

import java.io.IOException;

 class MyPanel extends JPanel{
    private JLabel lbl_faculty;
    private JLabel lbl_programme;
    private JLabel lbl_name;
    private JTextField name;
    private JLabel lbl_session;
    private JLabel lbl_ic;
    private JTextField ic;
    private JLabel lbl_matric_no;
    private JTextField matric_no;
    private JLabel lbl_course;
    private JComboBox course;
    private JLabel lbl_marks;
    private JLabel lbl_assignment;
    private JTextField assignment;
    private JLabel lbl_quizzes;
    private JTextField quizzes;
    private JLabel lbl_midterm;
    private JTextField midterm;
    private JLabel lbl_finalexam;
    private JTextField finalexam;
    private JButton btn_submit;
    private JButton btn_clear;
    JTextArea textArea;
    JScrollPane jsp;    
    Project2 p = new Project2();
    
    String output = " ";
    String course_selection = " ";
    String filePath = "CourseGradeHC00.txt";

    public MyPanel() {
        //construct preComponents
        String[] courseItems = {"[SELECT]", "KK14203 OBJECT ORIENTED PROGRAMMING", "KT14203 COMPUTER ARCHITECTURE & ORGANISATION", "KT14403 DISCRETE STRUCTURES",
                               "UB02002 ENGLISH FOR EMPLOYMENT", "UC01202 NEGOTIATION SKILLS", "UW00102 HUBUNGAN ETNIK"};
        
        //adjust size and set layout
        setPreferredSize (new Dimension (666, 485));
        setLayout (null);

        //construct components, add components, set component bounds
        lbl_faculty = new JLabel ("FACULTY OF COMPUTING AND INFORMATICS");
        add (lbl_faculty);
        lbl_faculty.setBounds (190, -5, 300, 30);

        lbl_programme = new JLabel ("PROGRAMME: HC00 - SOFTWARE ENGINEERING");
        add (lbl_programme);
        lbl_programme.setBounds (180, 25, 300, 25);

        lbl_name = new JLabel ("NAME:");
        add (lbl_name);
        lbl_name.setBounds (15, 85, 100, 25);
        
        name = new JTextField (5);
        add (name);
        name.setBounds (95, 85, 545, 25);
        
        lbl_session = new JLabel ("SEMESTER 2 (2019/2020)");
        add (lbl_session);
        lbl_session.setBounds (245, 50, 145, 25);
        
        lbl_ic = new JLabel ("IC NO: ");
        add (lbl_ic);
        lbl_ic.setBounds (15, 115, 100, 25);
        
        ic = new JTextField (5);
        add (ic);
        ic.setBounds (95, 115, 175, 25);
        
        //TextField for ic will only accept integers
         ic.addKeyListener(new KeyAdapter(){
         public void keyTyped (KeyEvent e) 
        { 
            char c = e.getKeyChar() ;
                
            if (!((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ||  (c== KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) ||  (Character.isDigit(c)))) 
            {
               e.consume() ;
            } 
         }
       });
        
        lbl_matric_no = new JLabel ("MATRIC NO.:");
        add (lbl_matric_no);
        lbl_matric_no.setBounds (315, 115, 100, 25);

        matric_no = new JTextField (5);
        add (matric_no);
        matric_no.setBounds (400, 115, 145, 25);

        lbl_course = new JLabel ("COURSE:");
        add (lbl_course);
        lbl_course.setBounds (15, 150, 100, 25);
        
        course = new JComboBox (courseItems);
        add (course);
        course.setBounds (95, 150, 360, 25);
        
        //JComboBox action listener
        course.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            course_selection = (String) course.getSelectedItem();
         }
        }); 
        
        lbl_marks = new JLabel ("ENTER MARKS FOR:");
        add (lbl_marks);
        lbl_marks.setBounds (15, 185, 145, 25);
        
        lbl_assignment = new JLabel ("ASSIGNMENTS:");
        add (lbl_assignment);
        lbl_assignment.setBounds (15, 215, 100, 25);

        assignment = new JTextField (5);
        add (assignment);
        assignment.setBounds (115, 215, 55, 25);
        
        assignment.addKeyListener(new KeyAdapter(){
         public void keyTyped (KeyEvent e) 
        { 
            char c = e.getKeyChar() ;
                
            if (!((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ||  (c== KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) ||  (Character.isDigit(c)))) 
            {
               e.consume() ;
            } 
         }
       });

        lbl_quizzes = new JLabel ("QUIZZES:");
        add (lbl_quizzes);
        lbl_quizzes.setBounds (195, 215, 60, 25);
        
        quizzes = new JTextField (5);
        add (quizzes);
        quizzes.setBounds (255, 215, 55, 25);
        
        quizzes.addKeyListener(new KeyAdapter(){
         public void keyTyped (KeyEvent e) 
        { 
            char c = e.getKeyChar() ;
                
            if (!((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ||  (c== KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) ||  (Character.isDigit(c)))) 
            {
               e.consume() ;
            } 
         }
       });
        
        lbl_midterm = new JLabel ("MIDTERM:");
        add (lbl_midterm);
        lbl_midterm.setBounds (335, 215, 100, 25);

        midterm = new JTextField (5);
        add (midterm);
        midterm.setBounds (405, 215, 55, 25);
        
         midterm.addKeyListener(new KeyAdapter(){
         public void keyTyped (KeyEvent e) 
        { 
            char c = e.getKeyChar() ;
                
            if (!((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ||  (c== KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) ||  (Character.isDigit(c)))) 
            {
               e.consume() ;
            } 
         }
       });
        
        lbl_finalexam = new JLabel ("FINAL EXAM:");
        add (lbl_finalexam);
        lbl_finalexam.setBounds (490, 215, 100, 25);
                
        finalexam = new JTextField (5);
        add (finalexam);
        finalexam.setBounds (575, 215, 55, 25);
        
        finalexam.addKeyListener(new KeyAdapter(){
         public void keyTyped (KeyEvent e) 
        { 
            char c = e.getKeyChar() ;
                
            if (!((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) ||  (c== KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) ||  (Character.isDigit(c)))) 
            {
               e.consume() ;
            } 
         }
       });
        
        btn_submit = new JButton ("SUBMIT");
        add (btn_submit);
        btn_submit.setBounds (15, 255, 100, 25);
        
        btn_clear = new JButton ("CLEAR");
        add (btn_clear);
        btn_clear.setBounds (125, 255, 100, 25);
        
      btn_submit.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){              
            if(printOutput())
               writeInput();     
         }  
      });

     btn_clear.addActionListener(new ActionListener(){  
       public void actionPerformed(ActionEvent e){        
            textArea.setText(" ");  
            name.setText(" ");
            ic.setText(" ");
            matric_no.setText(" "); 
            course.setSelectedIndex(0);
            assignment.setText(" ");  
            quizzes.setText(" ");
            midterm.setText(" ");
            finalexam.setText(" ");
        }
     }); 
     
        textArea = new JTextArea (5, 5);
        
        //add JScrollPane
        jsp = new JScrollPane(textArea);
        jsp.setBounds(15, 290, 640, 185);
        add(jsp);
 }
 
         //print output to textArea and input validation to check for empty fields or selections
        public boolean printOutput(){
           
           if(name.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter a name. Thank you.");
             return false;
          }
           output = " NAME: " + name.getText() + "\n";
          
           if(ic.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter an IC no. Thank you.");
             return false;
          }
           output += " IC NO.: " + ic.getText() + "\n";
           
           if(matric_no.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter a matric no. Thank you.");
             return false;
          }
           output += " MATRIC NO: " + matric_no.getText() + "\n\n";
      
          if(course_selection.equals("[Select]") || course_selection.equals(" ")){
            JOptionPane.showMessageDialog(null, "Please select a course. Thank you.");
            return false;
          }
           output += " COURSE: " + course_selection + "\n\n";

           output += " MARKS ENTERED FOR: \n";
       
           if(assignment.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter marks for Assignment. Thank you.");
             return false;
          }
           output += " ASSIGNMENT: " + assignment.getText() + "\n";
         
          if(quizzes.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter marks for Quizzes. Thank you.");
             return false;
          }
          output += " QUIZZES: " + quizzes.getText() + "\n";
          
          if(midterm.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter marks for Midterm. Thank you.");
             return false;
          }
          output += " MIDTERM: " + midterm.getText() + "\n";
         
          if(finalexam.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please enter marks for Final Exam. Thank you.");
             return false;
          }
          output += " FINAL EXAM: " + finalexam.getText() + "\n\n";
         
         try{
          p.calculateMarks(Integer.parseInt(assignment.getText()), Integer.parseInt(quizzes.getText()), Integer.parseInt(midterm.getText()),
                           Integer.parseInt(finalexam.getText()));
                           
          output += " TOTAL MARKS: " + p.getTotalMarks() + "\n";
          output += " GRADE: " + p.getGrade(p.getTotalMarks()) +"\n";
          output += " GRADE STATUS: " + p.getGradeStatus(p.getGrade()) + "\n";
          output += " GRADE POINTS: " + p.getCourseGp(p.getTotalMarks()) + "\n";
        
          } catch (NumberFormatException errorMsg) {
                JOptionPane.showMessageDialog(null, "Something went wrong! Please exit the program and run again if you wish to enter a new input.");
                return false;
         }

          output += "-------------------------------------------------------------------------------------------------------------------------";   
              
          textArea.setText(output);
          jsp.getViewport().revalidate();
         
          return true;
       }
       
     //write to file
     public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
      
      //exception implementation
		try{
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(output);
         JOptionPane.showMessageDialog(null, "Input has been successfully saved.");
		} catch (IOException e) {			
         textArea.setText(e.toString());
         JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.");
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				textArea.setText(e.toString());
			}
		}
    }
 
}

class MenuActionListener implements ActionListener{
   MyPanel pan;
   public MenuActionListener(MyPanel p){
      pan = p;
   }
   
   public void actionPerformed(ActionEvent e) {
      BufferedReader reader;
       try {
			reader = new BufferedReader(new FileReader(pan.filePath));
			String line = reader.readLine();
         String output = "Data :\n";
			while (line != null) {
				output += line + "\n";
				line = reader.readLine();
			}
         output += "\n";
         pan.textArea.setText(output);
			reader.close();
		} catch (IOException io) {
			pan.textArea.setText(io.toString());
		}
	   
    }
}

class MenuActionListener2 implements ActionListener{
      MyPanel pan;
      public MenuActionListener2(MyPanel p){
      pan = p;
   }
   
  //for exit confirmation
  public void actionPerformed(ActionEvent e){  
     int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION)
        System.exit(0);
   }
}   

public class Project2_GUI{
    public static void main (String[] args) {
        
        JFrame frame = new JFrame ("Course Grade for HC00");

        MyPanel pan = new MyPanel();
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Menu");
        
        //View Data reads from file
        JMenuItem m1 = new JMenuItem("View Data");
        m1.addActionListener(new MenuActionListener(pan));
        JMenuItem m2 = new JMenuItem("Exit");
        m2.addActionListener(new MenuActionListener2(pan));
        m.add(m1);
        m.add(m2);
        mb.add(m);
        frame.setJMenuBar(mb);

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
   }
}