import java.util.Scanner;
public class Bank {
 static  Scanner sc=new Scanner(System.in);
    public static void main(String [] args){
        int  correctpin=1361;
        int enteredpin = 0;
      double balance=10000;
      boolean isRunning=true;
      int choice;


        while (correctpin != enteredpin) {
            System.out.print("Enter PIN: ");
            enteredpin = sc.nextInt();

            if (correctpin == enteredpin) {
                System.out.println("YOU MAY CONTINUE");
            } else {
                System.out.println("WRONG PIN");
            }
            
        }
        while(isRunning){
            System.out.println("**************************");
            System.out.println("BANK PROGRAM");
            System.out.println("**************************");
            System.out.println("1.Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.println("Enter a choice as given: ");
            choice =sc.nextInt();
            System.out.println("**************************");
            switch(choice){
                case 1-> showBalance(balance);
                case 2-> balance += deposit();
                case 3-> balance -= withdraw(balance);
                case 4-> isRunning=false;
                default -> System.out.println("INVAILD CHOICE");
        }
        }
        System.out.println("**************************");
        System.out.println("Thanks have a nice day!");
        System.out.println("**************************");

    }
    static void showBalance(double balance){
        System.out.println("**************************");
        System.out.printf("$%.2f\n", balance);
    }
static double deposit() {
    double amount;
    System.out.println("Enter Amount you want to deposit: ");
amount =sc.nextInt();
    if(amount<0){
        System.out.println("INVALID AMOUNT");
    }
      else{
          return amount;
        }
      return 0;
     }
     static double withdraw(double balance){

        double amount;
         System.out.println("ENTER AMOUNT YOU WANT TO WITHDRAW");
         amount =sc.nextDouble();
        if(amount>balance){
            System.out.println("NO SUFFICIENT BALANCE");
        }
        else if(amount<0){
            System.out.println("INVALID AMOUNT");
        }
        else{
            return amount;
        }
        return 0;
     }
}
