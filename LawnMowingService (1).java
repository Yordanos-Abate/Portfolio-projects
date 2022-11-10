import java.util.Scanner;

public class LawnMowingService {
  public static void main(String [] args){
    Scanner input = new Scanner (System.in);
    System.out.print("Lawn-mowing service");
    System.out.print("\nPlease enter the length and width of your lawn:");
    System.out.print("\nLength:");
    double lgth = input.nextDouble();
    System.out.print("Width:");
    double wdth = input.nextDouble();
    System.out.print("How would you like to set up a payment?");
    System.out.print("\n(1) once,(2) twice,(3) 20 times per year");
    double pment = input.nextDouble();
    
    double mul = lgth * wdth;
    System.out.printf("Your lawn is %.0f square feet.", mul);
    if(mul< 4000){
      double wfee = 25;
      double wkfee = wfee * 20;
      System.out.printf("\nWeekly fee: $%.2f", wfee);
      System.out.printf("\n20-week seasonal fee: $%.2f", wkfee);
      if(pment== 1){
        System.out.printf("\nYour payment is a one time fee: $%.2f", wkfee);
        }
      else if(pment== 2){
        double wkfee2 = wkfee / 2;
        System.out.printf("\nYour payment is twice a year: $%.2f", wkfee2);
      }
      else if(pment== 3){
        double wkfee3 = wkfee / 20;
        System.out.printf("\nYour payment is 20 times a year: $%.2f", wkfee3);
      }
    }
    else if(mul>= 4000 && mul< 6000){
      double wfee = 35;
      double wkkfee = wfee * 20;
      System.out.printf("\nWeekly fee: $%.2f", wfee );
      System.out.printf("\n20-week seasonal fee: $%.2f", wkkfee);
       if(pment== 1){
        System.out.printf("\nYour payment is a one time fee: $%.2f", wkkfee);
        }
      else if(pment== 2){
        double wkkfee2 = wkkfee / 2;
        System.out.printf("\nYour payment is twice a year: $%.2f", wkkfee2);
      }
      else if(pment== 3){
        double wkkfee3 = wkkfee / 20;
        System.out.printf("\nYour payment is 20 times a year: $%.2f", wkkfee3);
      }
    }
    else if(mul>= 6000){
      double wfee = 50;
      double wkkkfee = wfee * 20;
      System.out.printf("\nWeekly fee: $%.2f", wfee);
      System.out.printf("\n20-week seasonal fee: $%.2f", wkkkfee);
      if(pment== 1){
        System.out.printf("\nYour payment is a one time fee: $%.2f", wkkkfee);
        }
      else if(pment== 2){
        double wkkkfee2 = wkkkfee / 2;
        System.out.printf("\nYour payment is twice a year: $%.2f", wkkkfee2);
      }
      else if(pment== 3){
        double wkkkfee3 = wkkkfee / 20;
        System.out.printf("\nYour payment is 20 times a year: $%.2f", wkkkfee3);
      }
    }
 }
}