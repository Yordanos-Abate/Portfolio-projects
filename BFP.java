import java.util.Scanner;
public class BFP{
  
  public void getInput(){
   Scanner input = new Scanner(System.in);
    System.out.print("Enter Weight in Pounds (lbs): ");
    double weight = input.nextDouble();
    System.out.print("Enter Height in Feet: ");
    double height = input.nextDouble();
    System.out.print("Enter Age: ");
    double age = input.nextDouble();
    System.out.print("Enter Gender (M for Male : F for Female : B for Boy: G for Girl) :");
    String gender = input.next();
 
    double heightt = height * 12;
    double heighttt = heightt * heightt;
    double BMII = weight / heighttt; 
    double BMI = BMII * 703;
    
    double MB = 1.20 * BMI;
    double MBB = 0.23 * age;
    double MBFP = MB + MBB - 16.2;
    
    double FB = 1.20 * BMI;
    double FBB = 0.23 * age;
    double FBFP = FB + FBB - 5.4;
    
    double bB = 1.51 * BMI;
    double bBB = 0.70 * age;
    double bBFP = bB + bBB - 2.2;
    
    double gB = 1.51 * BMI;
    double gBB = 0.70 * age;
    double gBFP = gB + gBB - 1.4;
    
    if(gender.equals("M")){
      System.out.printf("Your BFP is: %.1f", MBFP);
    }
    else if(gender.equals("F")){
      System.out.printf("Your BFP is: %.1f", FBFP);
    }
    else if(gender.equals("B")){
      System.out.printf("Your BFP is: %.1f", bBFP);
  }
   else if(gender.equals("G")){
      System.out.printf("Your BFP is: %.1f", gBFP);
  } 
  }
}