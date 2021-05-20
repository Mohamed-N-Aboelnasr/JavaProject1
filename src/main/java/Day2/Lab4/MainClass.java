package Day2.Lab4;


import Day1.Lab2.Pyramid;
import Day1.Lab2.PyramidCSVDAO;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {


    public static void main(String[] args) {
        PyramidCSVDAO pDAO =new PyramidCSVDAO();
        List<Pyramid> pyramids= null;
        try {
            pyramids = pDAO.readPyramidsFromCSV("E:\\pyramids.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Double> sorted_list = pyramids.stream().filter(p -> p.getHeight() > 0).map(Pyramid::getHeight).sorted().collect(Collectors.toList());
        System.out.println("The List : "+sorted_list);
        Double median=getMedian(sorted_list);
        Double firstQuartile,thirdQuratile;
        if(sorted_list.size()%2==0){
            firstQuartile=getMedian(sorted_list.subList(0, sorted_list.size()/2));
            thirdQuratile=getMedian(sorted_list.subList(sorted_list.size()/2,sorted_list.size()));
        }else{
            firstQuartile=getMedian(sorted_list.subList(0, sorted_list.size()/2));
            thirdQuratile=getMedian(sorted_list.subList(sorted_list.size()/2+1,sorted_list.size()));
        }
        System.out.println("The Median= "+median+"\n"+"The FirstQuartile= "+firstQuartile+"\n"+"The ThirdQuartile= "+thirdQuratile);
    }

    public static Double getMedian(List<Double> l){
        if(l.size()%2==0){
            Double median = l.stream().skip(l.size()/2-1).limit(2).mapToDouble(Double::doubleValue).average().getAsDouble();
            return median;
        }else{
            Double median=l.stream().skip(l.size()/2).findFirst().get();
            return median;
        }
    }
}

