import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.*;
import java.util.Scanner;

public class BankSystem {
    static public String USERNAME = "root";
    static public String PASSWORD = "PASSWORD";

    static Connection conn;

    public void startTheBank()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SimpleBank",
                    BankSystem.USERNAME,
                    BankSystem.PASSWORD
            );
            System.out.println("Connected to database successfully");
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }

    public int idInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id: ");
        int id = sc.nextInt();
        if(idExists(id))
            return id;
        else {
            System.out.println("Id doesn't exist...");
            return idInput();
        }
    }

    public void addNewUser(String name, String password, Double balance)
    {
        String cmd = "INSERT INTO users (name, password, balance, register_date) VALUES (?, ?, ?, NOW())";
        try (PreparedStatement pstmt = BankSystem.conn.prepareStatement(cmd)){
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setDouble(3, balance);

            int count = pstmt.executeUpdate();

            System.out.println("User " + name + " Added Successfully.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean idExists(int id)
    {
        String cmd = "SELECT * FROM users WHERE id = ?";
        try(PreparedStatement pstm = BankSystem.conn.prepareStatement(cmd))
        {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e )
        {
            e.printStackTrace();
            return false;
        }


    }


    public UserInfo login(int id, String password)
    {
        String cmd = "SELECT * FROM users WHERE id = ?";
        try(PreparedStatement pstmt = BankSystem.conn.prepareStatement(cmd)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String user_password = rs.getString("password");
            if (password.equals(user_password))
            {
                UserInfo userInfo = new UserInfo(rs.getInt("id"),
                                                rs.getString("name"),
                                                rs.getString("password"),
                                                rs.getDouble("balance"),
                                                rs.getTimestamp("register_date"));
                return  userInfo;
            }
            else return null;
        } catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public void updateUserBalance(UserInfo userInfo)
    {
        String cmd = "UPDATE users SET balance = ? WHERE id = ?";

        try(PreparedStatement pstmt = BankSystem.conn.prepareStatement(cmd))
        {
            pstmt.setDouble(1, userInfo.getBalance());
            pstmt.setInt(2, userInfo.getId());
            int x =  pstmt.executeUpdate();

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void updateUser(UserInfo userInfo)
    {
        String cmd = "UPDATE users SET name = ? , password = ?, balance = ? WHERE id = ?";
        try(PreparedStatement pstmt = BankSystem.conn.prepareStatement(cmd))
        {
            pstmt.setString(1, userInfo.getName());
            pstmt.setString(2, userInfo.getPassword());
            pstmt.setDouble(3, userInfo.getBalance());
            pstmt.setInt(4, userInfo.getId());
            int x =  pstmt.executeUpdate();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void updateUserName(UserInfo userInfo)
    {
        String cmd = "UPDATE users SET name = ? WHERE id = ?";
        try(PreparedStatement pstmt = BankSystem.conn.prepareStatement(cmd))
        {
            pstmt.setString(1, userInfo.getName());
            pstmt.setInt(2, userInfo.getId());
            int x =  pstmt.executeUpdate();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void updateUserPassword(UserInfo userInfo)
    {
        String cmd = "UPDATE users SET password = ? WHERE id = ?";
        try(PreparedStatement pstmt = BankSystem.conn.prepareStatement(cmd))
        {
            pstmt.setString(1, userInfo.getPassword());
            pstmt.setInt(2, userInfo.getId());
            int x =  pstmt.executeUpdate();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}



