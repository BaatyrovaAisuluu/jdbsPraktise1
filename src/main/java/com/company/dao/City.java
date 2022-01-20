package com.company.dao;

import com.company.Exaption.MyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.Util.Util.connection;

public class City implements UserDao,findCityById{
    private int id;
    private String cityName;
    private String area;

    public City() {
    }

    public City(int id, String cityName, String area) {
        this.id = id;
        this. cityName = cityName;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return
                "\nid        | " + id +'\n'+
                        "cityName  | " + cityName + '\n' +
                        "area      | " + area + '\n';
    }

    @Override
    public void AddUser() {
        String SQL="insert into city (cityName,area) values (?, ?)";
        try (Connection conn=connection();
             PreparedStatement statement=conn.prepareStatement(SQL)){
            statement .setString(1,cityName);
            statement.setString(2,area);
            statement.executeUpdate();
            System.out.println(cityName+ "баазага кошулду");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getCount() {

        String SQL= " select count(*) from city";
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
    public List<City> printAll() {
        List<City>cities=new ArrayList<>();

        String SQL = "SELECT * FROM city";
        try (Connection conn =connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                cities.add(new City(rs.getInt(1),
                        rs.getString(2),rs.getString(3)));

            }
            return cities;
        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage()); }
        return null;
    }

    @Override
    public void findCityById(int id1) throws SQLException {
     try(PreparedStatement pr =connection().prepareStatement("select *from city where id=?")){
          pr.setInt(1,id1);
          ResultSet resultSet=pr.executeQuery();
          if(resultSet.next()){
              System.out.println("id \t             |  "+resultSet.getInt(1)+
                      "\nCountryName \t |  "+resultSet.getString
                      (2)+"\narea\t         | "+resultSet.getString(3));
              System.out.println();
          }else {
              System.out.println(id1+ " деген id жок");
              System.out.println();
          }
     }catch (Exception e){
         System.out.println(e.getMessage());


     }

    }
}
