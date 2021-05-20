package Day1.Lab2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO {

    public PyramidCSVDAO() {
    }

    public List<Pyramid> readPyramidsFromCSV(String filename) throws IOException {
        List<Pyramid> pyramids = new ArrayList<Pyramid>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        do {
            Pyramid p=new Pyramid();
            line = br.readLine();
            if (line != null) {
                String[] attributes = line.split(",");
                p=this.createPyramid(attributes);
            }
            pyramids.add(p);
        } while(line !=null);
        return pyramids;
    }

    public Pyramid createPyramid(String[] metadata){
        Pyramid p = new Pyramid(0.0d,metadata[2],metadata[0],metadata[4]);
        if(!metadata[7].isEmpty()) {
            p.setHeight(Double.parseDouble(metadata[7]));
        }
        return p;
    }

}