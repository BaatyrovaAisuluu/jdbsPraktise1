package com.company.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.Util.Util.connection;

public class Country implements UserDao{
    private int id ;
    private String countryName;
    private String countryMoney;

    public Country() {
    }

    public Country(int id, String countryName, String countryMoney) {
        this.id = id;
        this.countryName = countryName;
        this.countryMoney = countryMoney;
    }

    @Override
    public String toString() {
        return
                "\nid           | " + id +'\n'+
                "countryName  | " + countryName + '\n' +
                "countryMoney | " + countryMoney +'\n';
    }

    @Override
    public void AddUser() {
        String SQL = "insert into country (countryName,countryName) values (?, ?)";
        try (Connection conn = connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, countryName);
            statement.setString(2,countryMoney);
            statement.executeUpdate();
            System.out.println(countryName + "баазага кошулду");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public int getCount() {
        String SQL= " select count(*) from country";
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

    @Override
    public List<Country> printAll() {
        List<Country>count=new ArrayList<>();

        String SQL = "SELECT * FROM city";
        try (Connection conn =connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                count.add(new Country(rs.getInt(1),rs.getString(2),rs.getString(3)));

            }
            return count;
        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage()); }
        return null;
    }
}
