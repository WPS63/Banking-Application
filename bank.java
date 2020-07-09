import java.util.Scanner;

public class bank {
    public static void main(String[] args)
    {
        String user = "";
        int id = 0;
        System.out.println("Please enter your Username");
        
        Scanner scanner1 = new Scanner(System.in);
        user = scanner1.next();
        
        System.out.println("Please enter your account number");
        
        Scanner scanner2 = new Scanner(System.in);
        id = scanner2.nextInt();
        
        bankAccount acc1 = new bankAccount(user, id);
        acc1.showMenu();
        
    }
}

class bankAccount
{
    //class variables
    String userName;
    int userID;
    int balance;
    int previousTrans;
    //deposit
    bankAccount(String user, int ID)
    {
        userName = user;
        userID = ID;
        balance = 0;
        previousTrans = 0;
        
    }
    void deposit(int amount)
    {
        if(amount < 0){System.out.println("Enter a valid amount");}
        else
        {
        balance = balance + amount;
        previousTrans = amount;
        }
    }
    //withdraw
    void withdraw(int amount)
    {
        if(amount < 0){System.out.println("Enter a valid amount");}
        else if(amount > balance){System.out.println("You don't have that much money");}
        else
        {
            balance -= amount;
            previousTrans = -amount;
        }
    }
    //check previous transaction
    void prevTrans()
    {
        if(previousTrans == 0){System.out.println("No previous transaction");}
        else if (previousTrans > 0){System.out.println("Your previous transaction was a deposit of " + previousTrans);}
        else{System.out.println("Your previous transaction was a withdrawal of " + previousTrans);}
    }
    void hideMenu()
    {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        
        choice = scanner.nextInt();
        if(choice == 1)
        {
            System.out.println("Your balance is " + balance);
        }
        else if(choice == 2)
        {
            int dep = 0;
            System.out.println("Enter amount to deposit ");
            Scanner scan2 = new Scanner(System.in);
            dep = scan2.nextInt();
            deposit(dep);
            System.out.println("You have deposited " + dep);
        }
        else if(choice == 3)
        {
            int wd = 0;
            System.out.println("Enter amount to withdraw ");
            Scanner scan3 = new Scanner(System.in);
            wd = scan3.nextInt();
            withdraw(wd);
            System.out.println("You have withdrawn " + wd);
        }
        else if(choice == 4)
        {
            prevTrans();
            
        }
        else if(choice == 5)
        {
            System.exit(0);
        }
        else{System.out.println("Please select a valid choice");}
        System.out.println("What next?");
        hideMenu();
    }
    void showMenu()
    {
        //enter menu text here
        int choice = 0;
        System.out.println("Welcome " + userName);
        System.out.println("Account Number " + userID);
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Previous Transaction");
        System.out.println("5. Exit");
        
        Scanner scanner = new Scanner(System.in);
        
        choice = scanner.nextInt();
        if(choice == 1)
        {
            System.out.println("Your balance is " + balance);
        }
        else if(choice == 2)
        {
            int dep = 0;
            System.out.println("Enter amount to deposit ");
            Scanner scan2 = new Scanner(System.in);
            dep = scan2.nextInt();
            deposit(dep);
            System.out.println("You have deposited " + dep);
        }
        else if(choice == 3)
        {
            int wd = 0;
            System.out.println("Enter amount to withdraw ");
            Scanner scan3 = new Scanner(System.in);
            wd = scan3.nextInt();
            withdraw(wd);
            System.out.println("You have withdrawn " + wd);  
        }
        else if(choice == 4)
        {
            prevTrans();
        }
        else if(choice == 5)
        {
            System.exit(0);
        }
        else{System.out.println("Please select a valid choice");}
        System.out.println("What next?");
        hideMenu();
    }
}