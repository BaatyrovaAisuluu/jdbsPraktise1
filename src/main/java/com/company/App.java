package com.company;

import com.company.Exaption.MyException;
import com.company.dao.City;
import com.company.dao.Country;
import com.company.dao.CountryPres;
import com.company.dao.commands;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private final static City CITY=new City();
    private final static Country COUNTRY=new Country();
    private final static CountryPres COUNTRY_PRES=new CountryPres();
    private final static Scanner sc=new Scanner(System.in);


    public static void main( String[] args ) throws MyException, SQLException {
      while (true){
          commands.commands();
          int number=sc.nextInt();
          if(number<=0||number>4){
              throw new MyException("Мындай тандоо жок");
          }
          switch (number){
              case 1:
                  System.out.println("     City      ♣  ");
                  System.out.println(CITY.printAll());
                  break;
              case 2:
                  System.out.println("     Country   ☻  ");
                  System.out.println(COUNTRY.printAll());
                  break;
              case 3:
                  System.out.println("     CountryPres  ☺ ");
                  CountryPres.printUsers();
              break;
              case 4:
                  System.out.println("Шаарларды id менен табыныз ♥");
                  int id=sc.nextInt();
                      CITY.findCityById(id);
                  break;
              default:
                  System.out.println();

          }

      }


    }
}
