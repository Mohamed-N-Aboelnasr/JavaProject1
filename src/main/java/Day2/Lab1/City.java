package Day2.Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class City {
    private int id;
    private int cid;
    private String name;
    private Boolean capital;
    private double surfaceArea;
    private double population;

    public City(){

    }

    public City(int id, int cid, String name, Boolean capital, double surfaceArea, double population) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.capital = capital;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", cid=" + cid +
                ", name='" + name +
                ", capital=" + capital +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +"\n";
    }

    public static List<City> readCitiesFromCSV(String filename) throws IOException {
        List<City> Cities=new LinkedList<City>();
        BufferedReader br=new BufferedReader(new FileReader(filename));
        String line=br.readLine();
        do {
            line=br.readLine();
            if(line != null){
                String []attributes=line.split(",");
                City c = new City(0,0,null,false,0.0,0.0);
                if(!(attributes[0].isEmpty()))
                    c.setId(Integer.parseInt(attributes[0]));
                if(!(attributes[1].isEmpty()))
                    c.setCid(Integer.parseInt(attributes[1]));
                c.setName(attributes[2]);
                if(attributes[3].equalsIgnoreCase("yes"))
                    c.setCapital(true);
                if(!(attributes[4].isEmpty()))
                    c.setSurfaceArea(Integer.parseInt(attributes[4]));
                if(!(attributes[5].isEmpty()))
                    c.setPopulation(Integer.parseInt(attributes[5]));
                Cities.add(c);
            }
        }while (line != null);
        return Cities;
    }
}