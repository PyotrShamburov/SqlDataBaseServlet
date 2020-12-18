import java.sql.*;


public class ConnectToDataBase {
    private final String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&serverTimezone=UTC";
    private final String login = "root";
    private final String password = "Burov6011";

    private Connection connection;

    public ConnectToDataBase(){
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(driver.toString()+"\n" +
                    "Driver is register!");
        }catch (SQLException | ClassNotFoundException exception){
            System.out.println(exception.toString()+"\n" +
                    "Driver is not register!");
        }
        try {
            connection = DriverManager.getConnection(url,login,password);
            if ( connection != null ){
                System.out.println("Connection to database is successful!");
            }else {
                System.out.println("Connection to database is failed!");
            }
        }catch (SQLException exception){
            System.out.println(exception.toString());
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
