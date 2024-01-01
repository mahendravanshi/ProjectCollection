package com.postgres;

import java.sql.*;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws SQLException {

        System.out.println("Please enter order_id of order to search for data");
        Scanner sc = new Scanner(System.in);
        Integer order_id = sc.nextInt();
        String query = "select price,user_id from orders where order_id=?";
        String url = "jdbc:postgresql://localhost:5432/orders";
        String username = "postgres";
        String password = "root";

        Connection con = DriverManager.getConnection(url,username,password);

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1,order_id);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){

            int price = rs.getInt("price");
            int user_id = rs.getInt("user_id");

            System.out.println("Price is "+price+" and user_id is "+user_id+" for order_id "+order_id);
        }
        else{
            System.out.println("No data for order_id "+order_id);
        }

        con.close();

    }
}
