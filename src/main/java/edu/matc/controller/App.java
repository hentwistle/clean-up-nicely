package edu.matc.controller;

import edu.matc.entity.Household;
import edu.matc.entity.User;
import edu.matc.persistence.GenericServiceImpl;
import edu.matc.persistence.IGenericService;
import edu.matc.persistence.SessionFactoryProvider;
import edu.matc.utility.HibernateUtil;

public class App {
    public static void main(String[] args) {
        User user =null;
        Household household=null;

        IGenericService<User> userService = new GenericServiceImpl<User>(
                User.class, SessionFactoryProvider.getSessionFactory());
        IGenericService<Household> householdService = new GenericServiceImpl<Household>(
                Household.class, SessionFactoryProvider.getSessionFactory());
        //userService.deleteAll();

        user = new User();
        user.setUserid(1);
        user.setUsername("hentwistle2");
        userService.save(user);

        /*country=new Country();
        country.setCountryId("EGY");
        country.setCountryName("Egypt");
        country.setRegion(region);
        countryService.save(country);

        country=new Country();
        country.setCountryId("TUN");
        country.setCountryName("Tunis");
        country.setRegion(region);
        countryService.save(country);


        region = new Region();
        region.setRegionId(2);
        region.setRegionName("America");
        regionService.save(region);

        country=new Country();
        country.setCountryId("CAN");
        country.setCountryName("Canada");
        country.setRegion(region);
        countryService.save(country);

        country=new Country();
        country.setCountryId("USA");
        country.setCountryName("USA");
        country.setRegion(region);
        countryService.save(country);

        List<Country> countryList = countryService.getAll();
        if (countryList != null) {
            for (Country c : countryList) {
                System.out.println(c.toString());
            }
        } */

    }
}