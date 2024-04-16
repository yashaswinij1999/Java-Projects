import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(JDBCConstants.DRIVER);
            con = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USERID, JDBCConstants.PASSWORD);
            return con;

        } catch (SQLException | ClassNotFoundException e) {

            // TODO: handle exception
            e.printStackTrace();
            return null;

        }

    }

    public static void close(Connection con) {

        try {

            if (con != null) {
                con.close();
                System.out.println("closed");
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public static void close(ResultSet rs) {

        try {

            if (rs != null) {
                rs.close();
                System.out.println("closed");
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public static void close(PreparedStatement ps) {

        try {

            if (ps != null) {
                ps.close();
                System.out.println("closed");
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

}
