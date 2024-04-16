import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCHelper {

    ResultSet rs = null;

    PreparedStatement std = null;

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(JDBCConstants.DRIVER);
            con = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USERID, JDBCConstants.PASSWORD);
            System.out.println("con = " + con);
            return con;

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();
            return null;

        }

    }

    public static void close(Connection con) {

        try {

            if (con != null) {
                con.close();
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
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }
    }

    public static void close(PreparedStatement ph) {

        try {

            if (ph != null) {
                ph.close();
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }
    }

}
