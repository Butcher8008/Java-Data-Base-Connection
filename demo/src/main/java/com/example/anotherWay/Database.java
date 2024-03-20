package com.example.anotherWay;
/*
 * crud operations
 * create
 * delete
 * update
 * insert
 
 also if same sql command is executed then it is suggested that we can use PreparedStatement
 it means PreparedStatement are dynamic and can pass values to SQL commands
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {
    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter developer id: ");
        int devId=sc.nextInt();
        System.out.printf("Enter developer name: ");
        String devName=sc.next();
        System.out.printf("Enter developer salary: ");
        float devSalary=sc.nextFloat();
        Connection ct=null;
        PreparedStatement st=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","8008");
            st= ct.prepareStatement("insert into developer value(?,?,?)");
            st.setInt(1, devId);
            st.setString(2, devName);
            st.setFloat(3, devSalary);
            st.executeUpdate();
            ResultSet rs=ct.createStatement().executeQuery("select * from developer");
            while (rs.next()) {
                System.out.println(rs.getInt("devId")+" "+rs.getString("devName")+" "+rs.getFloat("devSalary"));
            }
            System.out.println("Inserted");
            System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (ct!=null&& st!=null) {
                ct.close();
                st.close();
            }
            sc.close();
        }
    }
}
