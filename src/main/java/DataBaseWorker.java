
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseWorker {

    public User getUserFromDb(int numberOfUser){
        ConnectToDataBase connect = new ConnectToDataBase();
        String query = "SELECT * FROM users;";
        User user = null;
        try{
            Statement statement = connect.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                if (resultSet.getInt("id")==numberOfUser){
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setCity(resultSet.getString("city"));
                    user.setAge(resultSet.getInt("age"));
                    user.setName(resultSet.getString("name"));
                    connect.getConnection().close();
                    return user;
                }
            }
        }catch (SQLException exception){
            System.out.println(exception.toString());
        }
        return user;
    }
}
