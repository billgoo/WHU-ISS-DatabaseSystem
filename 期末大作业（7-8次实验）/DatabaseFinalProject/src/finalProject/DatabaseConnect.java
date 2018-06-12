package finalProject;

/**
 * Created by Lenovo on 2016/6/16.
 */
import java.sql.*;
public class DatabaseConnect {
    public Connection connection;

    public DatabaseConnect(String username, String password){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DreamHouse",username,password);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass()+":"+e.getMessage());
            System.exit(0);
        }
    }

    public void closeConnection(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
