import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double checkBalance()
    {
        return balance;
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount)
    {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() 
    {
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n ATM Menu ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is rs" + account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: rs");
                    double depositAmount = scan.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount. Please enter a positive number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: rs");
                    double withdrawAmount = scan.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 4);
    }
}

 class atmiterface
 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); 
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}

