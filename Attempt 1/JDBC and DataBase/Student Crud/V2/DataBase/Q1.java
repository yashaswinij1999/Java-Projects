import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        Connection con = null;
        PreparedStatement insertStd = null;
        PreparedStatement insertPhno = null;
        PreparedStatement updateStd = null;
        PreparedStatement updatePhno = null;
        PreparedStatement selectStd = null;
        PreparedStatement selectPhno = null;
        PreparedStatement deleteStd = null;
        PreparedStatement deletePhno = null;
        ResultSet rs = null;
        String sql = "";
        String name = "";
        int age = 0;
        String date = "";
        int std = 0;
        int ch = 0;
        String phonenumber = "";

        try {

            con = JDBCHelper.getConnection();
            con.setAutoCommit(false);

            while (ch != 5) {

                System.out.println("");
                System.out.println("Press 1 to Add");
                System.out.println("Press 2 to Select");
                System.out.println("Press 3 to delete");
                System.out.println("Press 4 to update");
                System.out.println("enter 5 to exit");
                System.out.println("");
                System.out.println("enter your choice ");
                ch = sc1.nextInt();

                switch (ch) {

                    case 1:
                        System.out.println(" to add ");
                        System.out.println("");

                        System.out.println("enter name ");
                        name = sc1.next();

                        System.out.println("enter age");
                        age = sc1.nextInt();

                        System.out.println("enter Dob");
                        date = sc1.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        java.util.Date d = sdf.parse(date);
                        java.sql.Date d1 = new java.sql.Date(d.getTime());

                        System.out.println("enter class");
                        std = sc1.nextInt();

                        sql = "insert into student(name,age,dob,std)values(?,?,?,?)";
                        insertStd = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
                        insertStd.setString(1, name);
                        insertStd.setInt(2, age);
                        insertStd.setDate(3, d1);
                        insertStd.setInt(4, std);
                        insertStd.execute();

                        rs = insertStd.getGeneratedKeys();
                        rs.next();
                        int slno = rs.getInt("slno");
                        System.out.println("slno = " + slno);

                        while (ch != 2) {

                            System.out.println("");
                            System.out.println(" press 1 to add ");
                            System.out.println("press 2  to exit ");
                            System.out.println("");

                            System.out.println("enter your choice ");
                            ch = sc1.nextInt();

                            switch (ch) {

                                case 1:

                                    System.out.println("enter slno ");
                                    slno = sc1.nextInt();

                                    System.out.println("enter phoneNumber");
                                    phonenumber = sc1.next();

                                    sql = "insert into phonenumber(studentsl_no,phonenumber)values(?,?)";
                                    insertPhno = con.prepareStatement(sql);

                                    insertPhno.setInt(1, slno);
                                    insertPhno.setString(2, phonenumber);
                                    insertPhno.execute();
                                    con.commit();
                                    break;

                                default:
                                    System.out.println("invalid");
                                    System.exit(0);

                                case 2:
                                    System.out.println("bye bye");

                            }

                        }

                        break;

                    case 2:
                        System.out.println("to select");
                        System.out.println("");

                        while (ch != 3) {

                            System.out.println("");
                            System.out.println("enter 1 to select form Student table");
                            System.out.println("enter 2 to select from phonenumber table");
                            System.out.println("to exit");
                            System.out.println("");
                            System.out.println("enter your choice");
                            ch = sc1.nextInt();

                            switch (ch) {

                                case 1:
                                    sql = "select * from student";
                                    selectStd = con.prepareStatement(sql);
                                    selectStd.execute();

                                    rs = selectStd.getResultSet();

                                    while (rs.next()) {

                                        name = rs.getString("name");
                                        age = rs.getInt("age");
                                        d1 = rs.getDate("dob");
                                        std = rs.getInt("std");
                                        System.out.println(
                                                " name : " + name + " age :" + age + " dob : " + d1 + " std " + std);

                                    }
                                    break;

                                case 2:
                                    System.out.println("phonenumber");

                                    sql = "select * from phonenumber";
                                    selectPhno = con.prepareStatement(sql);
                                    selectPhno.execute();
                                    rs = selectPhno.getResultSet();

                                    while (rs.next()) {

                                        slno = rs.getInt("studentsl_no");
                                        phonenumber = rs.getString("phonenumber");
                                        System.out.println(" Students_slno " + slno + " phone number : " + phonenumber);

                                    }
                                    break;

                                case 3:
                                    System.out.println("bye bye");
                                    System.exit(0);
                            }

                        }
                        break;

                    case 3:
                        System.out.println(" to delete ");

                        System.out.println("enter sl no which you want to delete");
                        slno = sc1.nextInt();

                        sql = "delete from student where slno = ?";
                        deleteStd = con.prepareStatement(sql);
                        deleteStd.setInt(1, slno);
                        deleteStd.execute();
                        con.commit();

                        break;

                    case 4:

                        System.out.println(" to update ");

                        while (ch != 3) {

                            System.out.println("");
                            System.out.println("Press 1 to update student");
                            System.out.println("Press 2 to update phonenumber");
                            System.out.println("to exit");
                            System.out.println("");

                            System.out.println("enter your choice");
                            ch = sc1.nextInt();

                            switch (ch) {

                                case 1:
                                    System.out.println(" enter slno ");
                                    slno = sc1.nextInt();

                                    System.out.println("enter updated name ");
                                    name = sc1.next();

                                    sql = "update student set name = ? where slno = ?";
                                    updateStd = con.prepareStatement(sql);
                                    updateStd.setString(1, name);
                                    updateStd.setInt(2, slno);
                                    updateStd.execute();

                                case 2:

                                    System.out.println("enter phone number");
                                    phonenumber = sc1.next();

                                    System.out.println("enter phonenumber slno ");
                                    slno = sc1.nextInt();

                                    System.out.println("enter students slno");
                                    int studentslno = sc1.nextInt();

                                    sql = "update phonenumber set phonenumber = ? where slno = ? and studentsl_no = ?";
                                    updatePhno = con.prepareStatement(sql);
                                    updatePhno.setString(1, phonenumber);
                                    updatePhno.setInt(2, slno);
                                    updatePhno.setInt(3, studentslno);
                                    updatePhno.execute();
                                    con.commit();

                                    break;

                                case 3:
                                    System.out.println("the end");
                                    System.exit(0);

                            }

                        }

                        break;

                    default:
                        System.out.println("in valid");
                        break;

                    case 5:
                        System.out.println("to exit ");

                }
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

}