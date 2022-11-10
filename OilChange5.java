import java.util.Scanner;
  
  public class OilChange5 {
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    System.out.print("\nOil Change Service");
    do{ // beginning of loop
    System.out.print("\nEnter Lincense Plate Number: ");
    String lincense = input.nextLine();
    System.out.print("Enter Vehicle Make: ");
    String make = input.nextLine();
    System.out.print("Enter Vehicle Model: ");
    String model = input.nextLine();
    System.out.print("Enter Vehicle Year: ");
    double year = input.nextDouble();
    System.out.print("Enter Vehicle Color: ");
    String color = input.next();
    System.out.print("Enter Vehicle Mileage: ");
    double mileage = input.nextDouble();
    
    System.out.print("Select a service package:");
    System.out.print("\n1. Conventional Oil");
    System.out.print("\n2. High-Mileage Oil");
    System.out.print("\n3. Synthetic Oil\n");
    double spackage = input.nextDouble();
    
    
    if(spackage== 1){
      double sfee = 31.99;
      double taxfee = 0.1 * sfee;
      double staxfee = sfee + taxfee;
      double nextservice = mileage + 3000;
      System.out.print("\nVehicle Information:");
      System.out.printf("\nLincense Plate: %s", lincense);
      System.out.printf("\nMake/Model: %s %s", make, model);
      System.out.printf("\nYear: %.0f", year);
      System.out.printf("\nColor: %s", color);
      System.out.printf("\nMileage: %.1f", mileage);
      System.out.printf("\nYour Service Fee (Tax included): $%.2f", staxfee);
      System.out.printf("\nYour Next Service Due: %.1f", nextservice);
     }
    else if(spackage== 2){
      double sfee = 49.99;
      double taxfee = 0.1 * sfee;
      double sstaxfee = sfee + taxfee;
      double nextservice = mileage + 5000;
      System.out.print("\nVehicle Information:");
      System.out.printf("\nLincense Plate: %s", lincense);
      System.out.printf("\nMake/Model: %s %s", make, model);
      System.out.printf("\nYear: %.0f", year);
      System.out.printf("\nColor: %s", color);
      System.out.printf("\nMileage: %.1f", mileage);
      System.out.printf("\nYour Service Fee (Tax included): $%.2f", sstaxfee);
      System.out.printf("\nYour Next Service Due: %.1f", nextservice);
    }
    else if(spackage== 3){
      double sfee = 75.99;
      double taxfee = 0.1 * sfee;
      double ssstaxfee = sfee + taxfee;
      double nextservice = mileage + 7000;
      double gtotal = ssstaxfee + sstaxfee;
      System.out.print("\nVehicle Information:");
      System.out.printf("\nLincense Plate: %s", lincense);
      System.out.printf("\nMake/Model: %s %s", make, model);
      System.out.printf("\nYear: %.0f", year);
      System.out.printf("\nColor: %s", color);
      System.out.printf("\nMileage: %.1f", mileage);
      System.out.printf("\nYour Service Fee (Tax included): $%.2f", ssstaxfee); 
      System.out.printf("\nYour Next Service Due: %.1f", nextservice);
    }
     // end of loop
   input.nextLine (); //clear buffer
   
   System.out.print("\nAnother Vehicle? Enter 1 to Continue : 0 TO Exit\n");
   double choice = input.nextDouble();
   input.nextLine (); //clear buffer
   if(choice==1){
     continue;
   }
   else if(choice==0){
     System.out.printf("Grand Total Fee: $%.2f", gtotal);
     System.out.print("\nThank you and have a nice day.");
     break;
     
   }
   
    } while(true);
  }
}