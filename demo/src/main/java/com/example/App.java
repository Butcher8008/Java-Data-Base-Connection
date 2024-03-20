package com.example;
import java.sql.*;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "8008");
            Statement st= connect.createStatement();
            // st.executeUpdate("create table developer(devId int(3), name varchar(20), salary float(20))");
            // st.executeUpdate("insert into developer values (1,'osama',200000)");
            // st.executeUpdate("insert into developer values (2,'areesha',30000)");
            // st.executeUpdate("insert into developer values (3,'ramsha',10000)");
            // st.executeUpdate("insert into developer values (4,'awais',1231313)");
            ResultSet rs1=st.executeQuery("select * from developer where salary > 200000");
            // st.executeUpdate("drop table if exists developer");
            // ResultSet rs=st.executeQuery("select * from developer");
            while (rs1.next()) {
                System.out.println(rs1.getInt("devId")+" "+rs1.getString("name")+" "+rs1.getFloat("salary"));
            }
            connect.close();
            st.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
