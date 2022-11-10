import java.util.Scanner;

public class FamilyIncome {
  public static void main(String [] args){
    Scanner input = new Scanner (System.in);
    
    System.out.print("How many family's members do you have? ");
    int members = input.nextInt();
    
    int income [] = new int[members]; // the indexes depends on the capacity entered by the user
    for(int index = 0; index < income.length; index++) {
      System.out.print("Please enter income of family member :");
      income[index] = input.nextInt();
    }
 for(int index = 0; index < income.length; index++) {
      System.out.printf("Income of Family %d is $%d.\n", index, income[index]);
  }
    int max = income[0];
    for(int index = 0; index < income.length; index++){
      if(income[index]> max){
        max = income[index ];
      }
  }
    System.out.printf("Maximun income: $%d", max);
    
    double tmax = 0.1 * max;
    System.out.printf("\n10 percent of maximun income: $%.2f", tmax);
    
    int icount = 0;
   for(int index = 0; index < income.length; index++){
     if(income[index] <tmax){
       icount += 1;
       }
     }
   System.out.printf("\nNumber of families whose income is below 10 percent: %d", icount); 
  }
}