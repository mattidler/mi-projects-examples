/*
 * Name:       Matt Idler
 *
 * Filename:   PersonMI.java
 *
 * Course:     CS-12, Fall 2013
 *
 * Date:       12/9/13
 *
 * Purpose:    Program 28 Integration Assignment -- Person File
 *    
 */

import java.util.Calendar;
 
public class Person1MI {

   // instance variables
   protected String strFirstName;
   protected String strLastName;
   private double personHeight;
   private double personWeight;   
   protected SimpleDate birthDate;
   public int personAge;
    
   private Calendar today; 
   private int month;
   private int day;
   private int year;

   // has no accessor/mutator, not part of toString or print
   protected int foo = 100;
        
   // default constructor
   public Person1MI() {
      strFirstName = "";
      strLastName = "";
      personHeight = 0.0;
      personWeight = 0.0;
      birthDate = new SimpleDate ();
      }
      
   //calculate person's age
   protected int calculatePersonAge (SimpleDate birthDate) {
      
      //sets up a current date
      Calendar today = Calendar.getInstance();
 
      //retrieves birthdate from SimpleDate class
      month = birthDate.getMonth();
      day = birthDate.getDay();
      year = birthDate.getYear();
      
      //If birth year is same year as today, or a date in future, returns age as 0.
      if ((today.get(Calendar.YEAR) - birthDate.getYear()) <=0 ) {
         personAge = 0;
         }
      else {
         //Calculate age in years
         //if current month is greater than birth month, birthday has passed, personAge will be calculated correctly
         personAge = today.get(Calendar.YEAR) - birthDate.getYear();  

         //Calculate if birthDate Month is before today's month to return right age in years
         if (today.get(Calendar.MONTH) + 1 < birthDate.getMonth()) {
            personAge--;  
            } 
        
        //Calculate if birthDate Month is equal to this month before today's day to return right age in years 
         else if (today.get(Calendar.MONTH) + 1 > birthDate.getMonth()) {
            }
         else { 
            if(today.get(Calendar.DATE) < birthDate.getDay()) {
               personAge--;
               }

         //Calculate if birthDate Month is equal to this month before today's day to return right age in years 
         else if (today.get(Calendar.DATE) + 1 > birthDate.getMonth()) {
            }
         }
      } 
      this.personAge = personAge;
      return personAge;  
   }

    // full constructor
    public Person1MI( double personHeight, double personWeight, String strFirstName, String strLastName, SimpleDate birthDate) {
      this();    
      }

   //accessor for birthDate, etc
   public SimpleDate getBirthDate () {
      return birthDate;
      }

   public void setBirthDate ( SimpleDate birthDate) {
      this.birthDate = birthDate;
      }
        
   public int getPersonAge() {
	   return calculatePersonAge(this.birthDate);
      }

   public void setPersonHeight(double personHeight) {
      this.personHeight = personHeight;
      }
  
   public double getPersonHeight() {
      return personHeight;
      }
   
   public void setPersonWeight(double personWeight) {
      this.personWeight = personWeight;
      }
    
   public double getPersonWeight() {
      return personWeight;
      }
    
   public void setStrFirstName(String strFirstName) {
      this.strFirstName = strFirstName;
      }
 
   public String getStrFirstName() {
      return ((strFirstName == "") ? "<unknown>" : strFirstName);
      }
    
   public void setStrLastName(String strLastName) {
      this.strLastName = strLastName;
      }
    
   public String getStrLastName() {
      return ((strLastName == "") ? "<unknown>" : strLastName);
    }
   
   // string version of object data
   public String toString() {
      return personAge + ", " + 
             personHeight + ", " +
             personWeight + ", " + 
             strFirstName + 
             strLastName;
      }

   // formatted version of object data
   public void print() {
      if (birthDate != null) {
         System.out.println("personAge:\t" + calculatePersonAge(birthDate));
         }
      else {
         // For default constructor with no birthdate
         System.out.println("personAge:\t" + personAge);
         }
      System.out.println("birthDate:\t" + birthDate);
      System.out.println("personHeight:\t" + personHeight);
      System.out.println("personWeight:\t" + personWeight);
      System.out.println("strFirstName:\t" + strFirstName);
      System.out.println("strLastName:\t" + strLastName);
      }
    
   // overloaded print version, adds a header
   public void print(String message) {
      System.out.println(message);
      print();
      }

   // check equality of two objects
   public boolean equals(Object obj) {
      // comparing same type of objects?
      if (obj instanceof Person1MI) {
         // cast, then check field-by-field
         Person1MI temp = (Person1MI) obj;
         boolean c = ( (temp.personAge == this.personAge) &&
                       (Math.abs(temp.personHeight - this.personHeight) <= 0.001) &&
                       (Math.abs(temp.personWeight - this.personWeight) <= 0.001) &&
                       (temp.strFirstName.equals(this.strFirstName)) ) &&
                       (temp.strLastName.equals(this.strFirstName));
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
      //test default constructor
      Person1MI temp1 = new Person1MI();
      System.out.println(temp1);
      temp1.print("default constructor:");
      System.out.println("temp1 equals temp1? " + temp1.equals(temp1));
      System.out.println();
    
      // test full constructor
      Person1MI temp2 = new Person1MI( 68.5, 175.0, "Matt", "Idler", new SimpleDate(10, 28, 1974));
        
      //temp2 setcalculatePersonAge;
      temp2.setBirthDate(new SimpleDate(10, 28, 1974));
      temp2.setPersonHeight(175.0);
      temp2.setPersonWeight(68.5);
      temp2.setStrFirstName("Matt");
      temp2.setStrLastName("Idler");
        
      System.out.println(temp2);
      temp2.print("full constructor:");
      System.out.println("temp1 equals temp2? " + temp1.equals(temp2));
      System.out.println();

    
      // test alt constructor
      Person1MI temp3 = new Person1MI( 66.2, 150, "Sarah", "Himmelmann", new SimpleDate(11, 26, 1978));
      temp3.setBirthDate(new SimpleDate(11, 26, 1978));
      temp3.setPersonHeight(150.0);
      temp3.setPersonWeight(66.2);
      temp3.setStrFirstName("Sarah");
      temp3.setStrLastName("Himmelmann");

      System.out.println(temp3);
      temp3.print("alt constructor");
      System.out.println("temp2 equals temp3? " + temp2.equals(temp3));
      System.out.println();        
        
   }//end main

} //end class   
