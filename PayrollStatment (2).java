import java.util.Scanner;

public class PayrollStatment {
  public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Employee's Name:");
    String en = input.nextLine();
    System.out.print("Enter number of hours worked in a week:");
    double hwkd = input.nextDouble();
    System.out.print("Enter hourly pay rate:");
    double prate = input.nextDouble();
    System.out.print("Enter federal tax withholding rate:");
    double fwrate = input.nextDouble();
    System.out.print("Enter state tax withholding rate:");
    double swrate = input.nextDouble();
    
    
    System.out.print("\nPayroll Statment\n");
    System.out.println("Employee Name: " + en);
    System.out.println("Hours Worked: " + hwkd);
    System.out.printf("Pay Rate: %.2f", prate);
    
    double mul = hwkd * prate;
    System.out.printf("\nGross Pay: %.2f", mul);
    System.out.println("\nDeductions:");
    double fwratep = (fwrate / 100);
    double fwratepp = mul * fwratep;
    System.out.printf("- Federal Withholing (%.1f) percent: $%.2f", fwrate, fwratepp);
    double swratep = (swrate / 100);
    double swratepp = mul * swratep;
    System.out.printf("\n- State Withholding (%.1f) percent: $%.2f", swrate, swratepp);
    double tdedion = fwratepp + swratepp;
    System.out.printf("\n- Total Deduction: $%.2f", tdedion);
    double npay = mul - tdedion;
    System.out.printf("\nNet Pay: $%.2f", npay);

   
    }
                                      }