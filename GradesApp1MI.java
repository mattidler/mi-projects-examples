/*
 * Name:       Matt Idler
 *
 * Filename:   GradesApp1MI.java
 *
 * Course:     CS-12, Fall 2013
 *
 * Date:       12/9/13
 *
 * Purpose:    Program 28 Integration Assignment -- GradesApp File
 *    
 */
 
import java.util.Scanner;

public class GradesApp1MI {

   
   //default constructor to instantiate ArrayList of Person1MI
   
   public static void main (String [] args ) {
      
      //declare and initalize the array
      String [] firstName = { "Kacen", "Bridgette", "Lizabella", "Zoe", "Giselle" };
      String [] lastName = { "Kenopic", "Idler", "Himmelmann", "Gregoire", "DeVaul" };
      double [] personHeight = { 62.5, 55.0, 58.2, 53.4, 38.1 };
      double [] personWeight = { 101.5, 70.0, 86.0, 65.8, 40.2 };    
      
      //prints out options for user to select from
      String [] gradesApp = {};
      Grades1MI grades = new Grades1MI();  // with default size of 100 students
      char userOption = ' '; 
      int currentGradesIndex = 0;
      
      //start loop to prompt user for options
      while (userOption != 'Q') {
         //for ( int i = 0; i < gradesApp.length; i ++ )
         System.out.println( "\nGrades Application: User Options" );
         System.out.println( "Add default student \t\t\t [D]" );
         System.out.println( "Add student from cmd line \t\t [A]" ); 
         System.out.println( "Read student data from file \t\t [F]" );                 
         System.out.println( "Number of student entries \t\t [N]" );
         System.out.println( "Print all students \t\t\t [P]" );   
         System.out.println( "Detailed info for Nth student \t\t [I]" );
         System.out.println( "Run report of all student grades \t [G]");              
         System.out.println( "Quit Application \t\t\t [Q]" );
         System.out.println ();  
  
   
         //scan's what person inputs 
         Scanner scan = new Scanner ( System.in ); 
            {
            System.out.print( "Enter option: ");
            userOption = scan.next().toUpperCase().charAt(0);
            }
         
         //allows for lowercase/uppercase entry
         switch (userOption) {

         case 'D':
         //run default constructor in Grades1MI
         grades.addStudent();    
         break;
         
         case 'A':
         //prompt person to give data on specific student to add to system
         grades.addSpecificStudent();
         break;
         
         case 'F':
         //read from file name provided
         grades.readStudentDataFile();
         break;

         case 'N':
         //prints number of student records in system.
         System.out.print("Number of student records: "); 
         System.out.print(grades.getStudentCount());
         System.out.print("/");
         System.out.println(grades.getMaximumSize());
         break;

         case 'P':
         //prints all student records
         grades.print(); 
         break;
      
         case 'I':
         //prints detailed info for student
         //prompts user for student number
         String strStudentNumber = "";
         Scanner scan3 = new Scanner( System.in );
            {
            System.out.print("\tWhich student number? ");
            strStudentNumber = scan3.next();
            }
         int intStudentNumber = Integer.parseInt(strStudentNumber);
         //prints student data
         //arrays are 0 based
         grades.print(intStudentNumber - 1);
         break;

         case 'G':
         //runs report of all grades
         grades.writeGradeReport();
         break;

         case 'Q':
         //quits application
         System.out.println("Exiting application, goodbye!");
         break;
         }
      }
   }  
}
