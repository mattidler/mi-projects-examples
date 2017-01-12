/*
 * Name:       Matt Idler
 *
 * Filename:   Student1MI.java
 *
 * Course:     CS-12, Fall 2013
 *
 * Date:       12/9/13
 *
 * Purpose:    Program 28 Integration Assignment -- Student File
 *    
 */

import java.text.DecimalFormat;
 
public class Student1MI extends Person1MI {
    
   //instance variables -- new to subclass
   private String studentSchool;
   private int [] studentGrades;
   private Student1MI [] students;
   private int maxElements = 1;
   private int currentStudentElement = 0;
   
   // default constructor
   public Student1MI() {
            
      //calls superclass default constructor
      super();
   
      //set subclass default values     
      studentSchool = "";
      studentGrades = null;
      System.out.println();
      }

   //overloaded constructor: all subclass/superclass vars
   public Student1MI ( String strFirstName, String strLastName, int month, int date, int year,
                       String studentSchool, int [] studentGrades) {
                    
      // superclass constructor comes FIRST
      super( 0, 0, strFirstName, strLastName, new SimpleDate(month, date, year) );
      setStrFirstName(strFirstName);
      setStrLastName(strLastName);
      setstudentSchool(studentSchool);
      setBirthDate(new SimpleDate(month, date, year));
      this.studentGrades = studentGrades;
      this.maxElements = studentGrades.length;
      this.currentStudentElement = this.maxElements;
      }


   // constructor: just some superclass fields are used
   public Student1MI ( String strFirstName, String strLastName, SimpleDate birthDate,
                       String studentSchool, int [] studentGrades) {
                    
      // subclass default constructor
      super();
      setBirthDate(birthDate);
      
      // subclass instance variables
      this.studentSchool = studentSchool;
      this.studentGrades = studentGrades;        
      this.maxElements = studentGrades.length;
      this.currentStudentElement = this.maxElements;
      }
   
   //to print report of student grades into file           
   protected String getReportOutput() {
      DecimalFormat strDecimal = new DecimalFormat("##0.00");
      return getStrLastName() + ", " + getStrFirstName() + ", " + strDecimal.format(getAverageGrade());
      }

   // toString() OVERRRIDES that of its superclass
   public String toString() {
      return getStrFirstName() + ", " + getStrLastName() + ", " + birthDate + ", " + getPersonAge() + ", " +
               getstudentSchool() + ", " + getstudentGradesString() + ", " + getLetterGrade();
      }

   // print() OVERRIDES that of its superclass
   public void print() {
         DecimalFormat strDecimal = new DecimalFormat("##0.00");
         System.out.println("first name:\t" + super.getStrFirstName());
         System.out.println("last name:\t" + super.getStrLastName());
         System.out.println("birthdate:\t" + birthDate);
         System.out.println("age today:\t" + super.getPersonAge());
         System.out.println("school:\t\t" + getstudentSchool());
         System.out.println("scores:\t\t" + getstudentGradesString());
         System.out.println("high score:\t" + getHighestGrade());
         System.out.println("low score:\t" + getLowestGrade());
         System.out.println("average score:\t" + strDecimal.format(getAverageGrade()));
         System.out.println("letter grade:\t" + getLetterGrade());
      }

   //number grade conversion to letter grade
   protected String getLetterGrade() {
      double averageGrade = getAverageGrade();
      String letter = "";
      
      if (averageGrade >= 90) {
         letter = "A";
         }
      else if (averageGrade >= 80 && averageGrade < 90) {
         letter = "B";
         }     
      else if (averageGrade >= 70 && averageGrade < 80) {
         letter = "C";
         }     
      else if (averageGrade >= 60 && averageGrade < 70) {
         letter = "D";
         }     
      else {
         letter = "F";
         }     
      
      return letter;
    }
   
   //accessors and mutators
   //set/get for school
   public void setstudentSchool(String studentSchool) {
      this.studentSchool = studentSchool;
      }
  
   public String getstudentSchool() {
      return ((studentSchool == "") ? "<unknown>" : studentSchool);
      }
   
   // accessor for number of scores
   public int getMaximumSize() {
      return this.maxElements;
      }

   //get studentGrades
   public String getstudentGradesString() {
      String strStudentGrades = "[";
      
      if (studentGrades != null) {
         for (int i = 0; i < this.studentGrades.length; i++) {
            if (i > 0) {
               strStudentGrades += ", ";
            }
            strStudentGrades += studentGrades[i];
          }
          strStudentGrades += "]";
      }
      return strStudentGrades;
   }

	protected int[] getStudentGrades() {
		return copyArray(this.studentGrades);
	}


   // mutator(s)
   public void addstudentGrade(int grade) {
      
      if (grade < 0 || grade > 100) {
         System.out.println("ERROR: Invalid score specified. must be 1-100");
         return;
         }

      if (studentGrades == null) {
         resizeArray(1);
         }
      else {
         resizeArray(getMaximumSize()+1);
         }

      if ((currentStudentElement < this.getMaximumSize())) {
         this.studentGrades[currentStudentElement] = grade;
         currentStudentElement++;
         }
      else {
         System.out.println("ERROR: Invalid score index specified");
         }
      }

   
   //alter studentGrades
   protected void alterstudentGrade(int newGrade, int index) {
     if (index > studentGrades.length) {
        System.out.println("ERROR: Invalid score index specified");
        return;
     }
     
     if (newGrade < 0 || newGrade > 100) {
        System.out.println("ERROR: Invalid score specified, must be 0-100");
        return;
     }
     
     studentGrades[index] = newGrade;
 }      

   //add student
   public void addStudent() {
      if ((currentStudentElement < this.getMaximumSize())) {
         students[currentStudentElement] = new Student1MI();
         currentStudentElement++;
         }
      else {
         System.out.println("ERROR: Array is at capacity " + currentStudentElement + "/" + maxElements);
         }
      }
   
   //resizing arrays
   public void resizeArray(int newMaxElements) {
      int[] newArray = new int[newMaxElements];
      if (studentGrades == null) {
         newArray = new int[newMaxElements];
         }
      else {
         for (int i = 0; i < studentGrades.length; i++) {
            newArray[i] = studentGrades[i];
            }
         }       
      studentGrades = newArray;
      this.maxElements = newMaxElements;
      this.currentStudentElement = newMaxElements - 1;
      }
   
   //returning high score      
   public int getHighestGrade() {
      int maxIndex = -1;
      int highestGrade = 0;
      
      if (studentGrades != null) {
         maxIndex = 0;
         highestGrade = studentGrades[maxIndex];
         for ( int i = 1; i < studentGrades.length; i++) {
            if ( studentGrades[i] > highestGrade)
               highestGrade = studentGrades[i];
            }
         }      
         return highestGrade;
         }
   
   //returning low score
   public int getLowestGrade() {
      int minIndex = -1;
      int lowestGrade = 0;
      
      if (studentGrades != null) {
         minIndex = 0;
         lowestGrade = studentGrades[minIndex];
         for ( int i = 1; i < studentGrades.length; i++) {
            if ( studentGrades[i] < lowestGrade)
               lowestGrade = studentGrades[i];
            }
         }      
         return lowestGrade;
      }
   
   //calculating average grade
   public double getAverageGrade() {
      int totalGrades = 0;
      double averageGrades = -1.00;
      
      if (studentGrades != null) {
         for (int i = 0; i < this.studentGrades.length; i ++) {
            totalGrades += this.studentGrades[i];
            }
         averageGrades = (totalGrades/ (double) this.studentGrades.length);
         }
      
      if (averageGrades > -1.0)
         return averageGrades;
      else 
         return(0.00);
      }

   //get grades from specific index
   protected int getSingleGrade(int index) {
      int grade = 0;
      if (index > studentGrades.length) {
         System.out.println("ERROR: Invalid score index specified");
      }
      else {
         grade = studentGrades[index];
      }
      
      return grade;
   }
   
   //update grades
   protected void updateEntireGrades(int[] newGrades) {
      studentGrades = copyArray(newGrades);   
      }
   
   //update arrays
   protected int[] copyArray(int[] srcArray) {
      if (srcArray == null) {
         return null;
         }
      int[] newArray = new int[srcArray.length];
      for (int i = 0; i < srcArray.length; i++) {
         newArray[i] = srcArray[i];
         }
      return newArray;
      }
   
   private boolean isEqual(int[] array1, int[] array2) {
      boolean isEqual = true;
      if (array1.length != array2.length) {
         isEqual = false;
         }
      else {
         for (int i = 0;(i < array1.length) && isEqual; i++) {
            if (Math.abs(array1[i] - array2[i]) > 0.001) {
               isEqual = false;
               }
            }
      }
     
   return isEqual;
   }
    
   // OVERRIDE Person1MI's equals method
   // check equality of two objects
   public boolean equals(Object obj) {
    
      // comparing same type of objects?
      if (obj instanceof Student1MI) {
        
         // cast, then check field-by-field
         Student1MI temp = (Student1MI) obj;
         boolean c = ( (temp.strFirstName.equals(this.strFirstName)) &&
                       (temp.strLastName.equals(this.strLastName)) &&
                       (temp.studentSchool.equals(this.studentSchool)) &&
                       (temp.getPersonAge() == this.getPersonAge()) &&
                       (isEqual(temp.studentGrades, this.studentGrades)));
         if (c) {
            return true;
            }
         else {
            return false;
            }
         }
      else {
         return false;
         }
        
      }
    
   // unit test driver
   public static void main(String [] args) {
      
      //find lowest/highest score
      int maxIndex = 0;
      int minIndex = 0;
      int averageGrades = 0;      
      
      //test default constructor
      Student1MI temp1 = new Student1MI();
      temp1.addstudentGrade(0);
      System.out.println("Default Student");  
      System.out.println(temp1);
      temp1.print();        
      System.out.println();

      //test full constructor -- Student 1
      int [] grades = {0};
      System.out.println("Full Student 1");
      Student1MI temp2 = new Student1MI("Rob", "Lapkass", 7, 18, 1963, "Sierra College", grades);
      temp2.addstudentGrade(100);
      temp2.addstudentGrade(95);
      temp2.addstudentGrade(90);     
      System.out.println(temp2);
      temp2.print();
      System.out.println();        
     
      // Student 2
      System.out.println("Full Student 2");
      Student1MI temp3 = temp2;
	   temp3.updateEntireGrades(temp2.getStudentGrades());
      System.out.println(temp3);
      temp3.print();
      System.out.println();
     
      System.out.println("student1 equals student1? " + temp1.equals(temp1));
      System.out.println("student1 equals student2? " + temp1.equals(temp2));
      System.out.println("student2 equals student3? " + temp2.equals(temp3));       
      
      //testing error messages
      //will print invalid score index specified when trying to change an array that doesn't exist
      temp3.alterstudentGrade(95, 4);
      //int badGrade = temp3.getSingleGrade(temp3.getMaximumSize()+4);
      
      //will print invalid score specified
      temp3.addstudentGrade(-30);
     
      System.out.println();         

      // Student 3, altered
      System.out.println("Student 3, Altered Scores");
      temp3.alterstudentGrade(100, 2);
      System.out.println(temp3);
      temp3.print();
      System.out.println();      
      
      
      // Student 3, new scores and new birthdate
      System.out.println("Student 3, new set of scores and new birthdate");
      temp3.birthDate = new SimpleDate(); 
      //temp3.birthDate = new SimpleDate(01, 01, 2000); // works same way
      int[] temp3Grades = {100, 98, 96, 32, 95, 96, 97, 100, 100};
      temp3.updateEntireGrades(temp3Grades);
      System.out.println(temp3);
      temp3.print();
      System.out.println();

  
   }//end main
}

