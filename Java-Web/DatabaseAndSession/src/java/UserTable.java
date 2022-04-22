/**
 *
 * @author dsp
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable {

    private String tableName;
    private DBConnection connection;

    public UserTable() throws Exception {
        this.tableName = "user";
        this.connection = new DBConnection();
        if (!this.connection.setDatabaseConnection()) {
            throw new Exception();
        }
    }

    public boolean insert(User userdata) throws SQLException {
        Statement statement = this.connection.getDatabaseConnection().createStatement();
        String query = "INSERT INTO public.users("
                + "full_name, gender, \"Phone_number\", \"Address\", \"Hobbies\", username, password)\n"
                + "VALUES (" + userdata.getFullName() + "," + userdata.getGender() + "," + userdata.getPhoneNumber() + "," + userdata.getAddress() + ", " + userdata.getHobbies() + ", " + userdata.getUsername() + ", " + userdata.getPassword() + ");";
        try {
            if (statement.execute(query)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
