# SimpleBankSystemUsingJavaAndMySQL
This is a simple bank program created by Java. This program stores data in the database of MySQL. <br>
The program used mysql-connector-j-9.4.0 to connect the Java program to MySQL.
Introduced the use of OOP in this project such as encapsulation and abstraction.

## How to use
To use the program you just need to enter the id and enter the password.<br>
Then you will be in the Program.

 ```
-----Welcome Admin-----
1. Check Balance.
2. Deposit Money.
3. Withdraw Money.
4. Display Account Information.
5. Change Name.
6. Change Password.
7. Exit
Enter your choice: 
```
You can choose which action you do.

## Classes 
This program contains 2 classes and a main class.<br>

### class BankSystem{}
```
void startTheBank();
int idInput();
boolean idExists(int id);
UserInfo login(int id, String password):
void updateUser(UserInfo userinfo);
```
The updateUser() function will be used to send all the userinfo in the UserInfo class after each action(update).

### class UserInfo{}
```
void displayUserInfo();
void deposit(Double balance);
void withdraw(Double balance);
void withdraw(Double balance);
void changeUserName(String name);
void changePassword(String password);
```
These are the function that you can do when you logged in.


