import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DataBaseDAO implements DAO {

    Scanner sc1 = new Scanner(System.in);
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement insert = null;
    PreparedStatement update = null;
    PreparedStatement select = null;
    PreparedStatement delete = null;
    String sql = "";
    String name = "";
    int age = 0;
    String dob = "";
    int std = 0;
    {

        con = JDBCHelper.getConnection();

    }

    public void create() {

        try {

            System.out.println("enter name");
            name = sc1.next();

            System.out.println("enter age");
            age = sc1.nextInt();

            System.out.println("enter dob in DD-MM-YYYY format ");
            dob = sc1.next();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date d = sdf.parse(dob);
            java.sql.Date d1 = new java.sql.Date(d.getTime());

            System.out.println("enter class");
            std = sc1.nextInt();

            if (con != null) {

                sql = "insert into student(name,age,dob,std) values(?,?,?,?)";
                insert = con.prepareStatement(sql);

                insert.setString(1, name);
                insert.setInt(2, age);
                insert.setDate(3, d1);
                insert.setInt(4, std);
                insert.execute();

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void delete() {

        System.out.println("enter name which you want to delete");
        name = sc1.next();

        try {

            sql = "delete from student where name = ?";
            delete = con.prepareStatement(sql);

            delete.setString(1, name);
            delete.execute();

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void update() {

        System.out.println("enter existing slno");
        int slno = sc1.nextInt();

        System.out.println("enter the replaced name");
        String updatedName = sc1.next();

        try {

            sql = "update student set name = ? where slno = ?";
            update = con.prepareStatement(sql);

            update.setString(1, updatedName);
            update.setInt(2, slno);
            update.execute();

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void retrieve() {

        try {

            sql = "select * from student";
            select = con.prepareStatement(sql);
            select.execute();
            rs = select.getResultSet();

            while (rs.next()) {

                name = rs.getString("name");
                age = rs.getInt("age");
                java.sql.Date d1 = rs.getDate("dob");
                std = rs.getInt("std");

                System.out.println(" name: " + name + " age : " + age + " dob : " + dob + " std " + std);

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

}
