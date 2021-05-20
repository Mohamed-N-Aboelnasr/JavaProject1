package Day2.Lab3;

import Day2.Lab1.City;
import Day2.Lab1.Country;

import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {


    public static void main(String[] args) {
        List<Country> Countries = new LinkedList<>();
        try {
            Countries = Country.readCountriesFromCSV("src\\main\\resources\\country.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<City> Cities = new LinkedList<>();
        try {
            Cities = City.readCitiesFromCSV("src\\main\\resources\\city.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Country, List<City>> countrymap = new HashMap<>();
        for (Country c : Countries) {
            List<City> cityList = new LinkedList<>();
            for (City ci : Cities) {
                if (c.getCid() == ci.getCid()) {
                    cityList.add(ci);
                }
            }
            countrymap.put(c,cityList);
        }

        //First requirement
        getHighestPopCityInCountry(Cities);
        System.out.println("================================================================");
        //Third requirement
        getHighestPopCapital(Cities);

    }

    public static void getHighestPopCityInCountry(List<City> Cities){
    //Solution using lambda expression
        Cities.stream().collect(Collectors.groupingBy(city -> city.getCid(),Collectors.maxBy((item1,item2)->(item1.getPopulation()>item2.getPopulation())?1:-1)))
                .forEach((cid,maxcity)-> System.out.println("Country id : "+cid+"\t"+"Highest population city : "+maxcity.map(City::getName).get()));
    //Another solution you can also use anonymous inner class
        /*Cities.stream().collect(Collectors.groupingBy(city -> city.getCid(),Collectors.maxBy(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                if(o1.getPopulation()>o2.getPopulation())
                    return 1;
                return -1;
            }
        }))).forEach((cid,maxcity)-> System.out.println("Country id : "+cid+"\t"+"Highest population city : "+maxcity.map(City::getName).get()));*/

    }

    public static void getHighestPopCapital(List<City> Cities){
        Double max_pop=Cities.stream().filter(c->c.getCapital()).mapToDouble(City::getPopulation).max().getAsDouble();
        Cities.stream().filter(c->c.getCapital() && c.getPopulation()==max_pop).forEach(c-> System.out.print("The highest population capital : "+c.getName()+"\t"));
        System.out.println("Population : "+max_pop);
    }

}
