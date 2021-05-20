package Day1.Lab2;

import java.io.IOException;
import java.util.List;

public class MainClass {


    public static void main(String[] args) {

        PyramidCSVDAO pDAO =new PyramidCSVDAO();
        List<Pyramid> pyramids= null;
        try {
            pyramids = pDAO.readPyramidsFromCSV("src\\main\\resources\\pyramids.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        for (Pyramid p : pyramids){
            System.out.println("#"+(i++)+p);
        }

    }
}