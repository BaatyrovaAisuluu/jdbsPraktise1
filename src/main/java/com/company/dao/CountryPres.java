package com.company.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.Util.Util.connection;

public class CountryPres {
    private int id;
    private String name;
    private String fulName;
    private int age;

    public CountryPres() {
    }
        public CountryPres(int id, String name, String fulName, int age) {
        this.id = id;
        this.name = name;
        this.fulName = fulName;
        this.age = age;
    }


    public static int get(){
        String SQL= " select count(*) from countryPres";
        int count=0;
        try {
            Connection conn=connection();
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery(SQL);{
                resultSet.next();
                count=resultSet.getInt(1);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static void addUser(int id,String name,String fulName,int age){
        String SQL="insert into users (furst_name,last_name,age) values (?,?,?)";
        try (Connection conn=connection();
             PreparedStatement statement=conn.prepareStatement(SQL)){
            statement .setInt(1,id);
            statement.setString(2,name);
            statement.setString(2,fulName);
            statement.setInt(2,age);
            statement.executeUpdate();
            System.out.println(name+"  базага кошулду");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public static void printUsers() {
        String SQL = "SELECT * FROM countryPres";
        try (Connection conn =connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            System.out.println();
            System.out.println("id|   name  | fulName   | age   ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            while (rs.next()) {
                System.out.println(rs.getInt(1) +
                        " | " + rs.getString(2) + " | "
                        + rs.getString(3)+" | "+ rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }





}
