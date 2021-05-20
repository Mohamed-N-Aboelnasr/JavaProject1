package Day2.Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Country {
    private int cid;
    private String name;
    private String continent;

    public Country(){

    }

    public Country(int cid, String name, String continent) {
        this.cid = cid;
        this.name = name;
        this.continent = continent;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "cid=" + cid +
                ", name='" + name +
                ", continent='" + continent +"\n" ;
    }
    public static List<Country> readCountriesFromCSV(String filename) throws IOException {
        List<Country> Countries=new LinkedList<Country>();
        BufferedReader br=new BufferedReader(new FileReader(filename));
        String line=br.readLine();
        do {
            line=br.readLine();
            if(line != null){
                String []attributes=line.split(",");
                Country c = new Country(0,null,null);
                if(!(attributes[0].isEmpty()))
                    c.setCid(Integer.parseInt(attributes[0]));
                c.setName(attributes[1]);
                c.setContinent(attributes[2]);
                Countries.add(c);
            }
        }while (line != null);
        return Countries;
    }
}
