package DBandSession;

/**
 *
 * @author DSP
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable {

    private String tableName;
    private DBConnection connection;
    private final String QUERY = "INSERT INTO users(full_name, gender, phone_number, address, hobbies, username, password)"
            + "VALUES (?,?,?, ?, ?, ?, ?);";

    public UserTable() throws Exception {
        this.tableName = "users";
        this.connection = new DBConnection();
        if (!this.connection.setDatabaseConnection()) {
            throw new Exception();
        }
    }

    public int insert(User userdata) throws SQLException {
        try {
            PreparedStatement statement = this.connection.getDatabaseConnection().prepareStatement(QUERY);
            statement.setString(1, userdata.getFullName());
            statement.setString(2, userdata.getGender());
            statement.setString(3, userdata.getPhoneNumber());
            statement.setString(4, userdata.getAddress());
            statement.setString(5, userdata.getHobbies());
            statement.setString(6, userdata.getUsername());
            statement.setString(7, userdata.getPassword());

            return statement.executeUpdate();
        } 
        catch (SQLException e) {
            this.printSQLException(e);
            return 0;
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    

    public ResultSet select(String columnName, String whereClause) throws SQLException {
        columnName = (columnName.equals("") || columnName == null) ? "*" : columnName;

        Statement statement = this.connection.getDatabaseConnection().createStatement();
        String query = "SELECT " + columnName + " FROM " + this.tableName;

        if (whereClause != null && !whereClause.equals("")) {
            query += " WHERE " + whereClause;
        }

        query += ";";

        return statement.executeQuery(query);
    }
}
