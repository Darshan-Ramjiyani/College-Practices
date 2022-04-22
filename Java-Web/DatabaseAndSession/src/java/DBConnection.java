
/**
 *
 * @author dsp
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private String url, user, password;
    protected Connection dataBaseConnection;

    public DBConnection() {
        this.url = "jdbc:postgresql://localhost:5432/JavaAssignment";
        this.user = "postgres";
        this.password = "dsp@377";
    }

    public Connection getDatabaseConnection() {
        return this.dataBaseConnection;
    }

    public boolean setDatabaseConnection() {
        boolean returnValue = false;

        try {
            Class.forName("org.postgresql.Driver");
            this.dataBaseConnection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.dataBaseConnection != null) {
            returnValue = true;
        }

        return returnValue;
    }

}
