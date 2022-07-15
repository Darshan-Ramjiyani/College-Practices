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
    private String QUERY;

    public UserTable() throws Exception {
        this.tableName = "\"public\".\"user\"";
        this.QUERY = "INSERT INTO "+this.tableName+" (full_name, email, password, gender, dateofbirth)"
            + " VALUES (?, ?, ?, ?, ?);";
        this.connection = new DBConnection();
        if (!this.connection.setDatabaseConnection()) {
            throw new Exception("Can not establish connection to the database.");
        }
    }

    public int insert(User userdata) throws SQLException {
        try {
            PreparedStatement statement = this.connection.getDatabaseConnection().prepareStatement(QUERY);
            statement.setString(1, userdata.getFullName());
            statement.setString(2, userdata.getEmail());
            statement.setString(3, userdata.getPassword());
            statement.setString(4, userdata.getGender());
            statement.setString(5, userdata.getDateofbirth());
            System.out.println("SQL Query : "+statement.toString());
            /*
                INSERT INTO "user" (full_name, email, password, gender, dateofbirth) 
	VALUES ('Darshan Ramjiyani', 'ahamdspatel@gmail.com', 'dsp@3770', 'Male', '2000-10-13')

            */
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
