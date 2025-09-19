import java.sql.Timestamp;

public class UserInfo
{
    private int  id;
    private String name;
    private String password;
    private Double balance;
    private Timestamp register_date;

    UserInfo (int id, String name, String password, Double balance, Timestamp register_date)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.register_date = register_date;
    }

    public int getId() {return this.id;}
    public String getName() {return this.name;}
    public String getPassword() {return this.password;}
    public Double getBalance() {return this.balance;}
    public Timestamp getRegister_date() {return this.register_date;}

    public void displayUserInfo()
    {
        System.out.println("----------------------------------------------");
        System.out.println("User Information");
        System.out.println("Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Balance: $" + this.balance);
        System.out.println("Register date: " + this.register_date);
        System.out.println("----------------------------------------------");

    }
    public void deposit(Double balance)
    {
        this.balance += balance;
        System.out.println("Deposited $" + balance);
    }

    public void withdraw(Double balance)
    {
        this.balance -= balance;
        System.out.println("Withdrawal $" + balance);
    }

    public void changeUserName(String name)
    {
        this.name = name;
        System.out.println("Changed Name to: " + name);
    }

    public void changePassword(String password)
    {
        this.password = password;
        System.out.println("Password Changed");
    }


}