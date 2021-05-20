package Day2.Lab1;

import java.io.IOException;
import java.util.*;

public class MainClass {


    public static void main(String[] args) {
        //First requirement
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
        Map<Integer, List<City>> countrymap = new HashMap<>();
        for (Country c : Countries) {
            List<City> cityList = new LinkedList<>();
            for (City ci : Cities) {
                if (c.getCid() == ci.getCid()) {
                    cityList.add(ci);
                }
            }
            countrymap.put(c.getCid(), cityList);
        }
        countrymap.forEach((k, v) -> System.out.println("country id= " + k + " cities= " + v));
        //Second requirement
        Scanner input=new Scanner(System.in);
        System.out.println("please enter the country code : ");
        int ccode=input.nextInt();
        countrymap.get(ccode).sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                if(o1.getPopulation() > o2.getPopulation())
                    return 1;
                return -1;
            }
        });
        System.out.println(countrymap.get(ccode));



    }


}


