import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Simple Bank System");
        BankSystem bankSystem = new BankSystem();
        bankSystem.startTheBank();
        // Login
        int id = bankSystem.idInput();
        UserInfo userInfo = null;
        while(userInfo == null)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your password: ");
            String password = sc.nextLine();
            userInfo = bankSystem.login(id, password);
        }

        // Main system (Deposit, withdraw, change name, change password)
        int choice = -1;
        while (choice != 7)
        {
            System.out.println("\n-----Welcome " +  userInfo.getName() + "-----");
            System.out.println("1. Check Balance.");
            System.out.println("2. Deposit Money.");
            System.out.println("3. Withdraw Money.");
            System.out.println("4. Display Account Information.");
            System.out.println("5. Change Name.");
            System.out.println("6. Change Password.");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                     System.out.println("Your account balance is : $" + userInfo.getBalance());
                     break;
                case 2:
                    System.out.println("How many money you want to deposit money : ");
                    double deposit = sc.nextDouble();
                    userInfo.deposit(deposit);
                    break;
                case 3:
                    System.out.println("How many money you want to withdraw money : ");
                    double withdraw = sc.nextDouble();
                    userInfo.withdraw(withdraw);
                    break;
                case 4:
                    userInfo.displayUserInfo();
                    break;
                case 5:
                    System.out.println("Enter your NEW name: ");
                    Scanner sc1 = new Scanner(System.in);
                    String name = sc1.nextLine();
                    userInfo.changeUserName(name);
                    break;
                case 6:
                    while(true) {
                        System.out.println("Enter your OLD password: ");
                        Scanner sc2 = new Scanner(System.in);
                        String oldPassword = sc2.nextLine();
                        if (oldPassword.equals(userInfo.getPassword())) {
                            break;
                        }
                        System.out.println("Passwords do not match");
                    }
                    while(true) {
                        System.out.println("Enter your NEW password: ");
                        Scanner sc3 = new Scanner(System.in);
                        String newPassword = sc3.nextLine();
                        System.out.println("Please confirm your password : ");
                        Scanner sc4 = new Scanner(System.in);
                        String confirmPassword = sc4.nextLine();
                        if (confirmPassword.equals(newPassword)) {
                            userInfo.changePassword(newPassword);
                            break;
                        }
                        System.out.println("New passwords do not match");
                    }

                    break;
                case 7:
                    System.out.println("Thank you for using Simple Bank. Goodbye " + userInfo.getName());
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.out.println("Please enter 1-7");
            }
            bankSystem.updateUser(userInfo);
        }



//        bankSystem.addNewUser("Jenny", "jenny", 20.0);
    }
}