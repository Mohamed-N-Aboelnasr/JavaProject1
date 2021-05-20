package Day3.DatasetPrep_Lab;

import joinery.DataFrame;
import tech.tablesaw.api.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        String dataPath="src/main/resources/titanic.csv";
        try {
            //Load and print data using joinery
            System.out.println("=======Data using joinery======");
            DataFrame<Object> joinery=DataFrame.readCsv(dataPath);
            System.out.println(joinery.toString());
            System.out.println("===================================================================");
            //Load and print data using tablesaw
            System.out.println("=======Data using tablesaw======");
            Table tablesaw=Table.read().csv(dataPath);
            System.out.println(tablesaw.toString());
            //print table structure
            System.out.println("=======Table structure======");
            System.out.println(tablesaw.structure().toString());
            System.out.println("===================================================================");
            //print summary about data using joinery
            System.out.println("=======summary about data using joinery======");
            System.out.println(joinery.describe().toString());
            System.out.println("===================================================================");
            //print summary about data using tablesaw
            System.out.println("=======summary about data using tablesaw======");
            System.out.println(tablesaw.summary().toString());
            System.out.println("===================================================================");
            //adding column to data using tablesaw
            System.out.println("======adding column to data using tablesaw======");
            int rowCount=tablesaw.rowCount();
            int[] col=new int[rowCount];
            for(int i=1;i<=rowCount;i++){
                col[i-1]=i;
            }
            IntColumn fcol= IntColumn.create("Fake Id",col);
            tablesaw.insertColumn(tablesaw.columnCount(), fcol);
            System.out.println(tablesaw.toString());
            //Droping the fake column from table
            tablesaw.removeColumns("Fake Id");
            System.out.println("After removing the fake column from table");
            System.out.println(tablesaw.toString());
            System.out.println("===================================================================");
            //merging two dataframes
            List<LocalDate> dateList = new ArrayList<LocalDate> ();
            for (int i = 0; i < rowCount; i++) {
                dateList.add (LocalDate.of (2021, 5, i % 31 == 0 ? 1 : i % 31));
            }
            DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
            Table tempTable=Table.create("Temp Table",fcol,dateColumn);
            System.out.println("========The table we want to merge with Titanic table==========");
            System.out.println(tempTable.toString());
            System.out.println("=========After merging two tables==========");
            tablesaw.concat(tempTable);
            System.out.println(tablesaw);
            System.out.println("===================================================================");
            //joining two dataframes
            //at first we remove 'Fake Date' column and try to join two tables by the common column 'Fake Id'
            tablesaw.removeColumns("Fake Date");
            System.out.println("========After removing column 'Fake Date' from Titanic table==========");
            System.out.println(tablesaw);
            System.out.println("==========================After joining two tables================= ");
            Table newtablesaw=tablesaw.joinOn("Fake Id").inner(tempTable);
            System.out.println(newtablesaw);
            System.out.println("===================================================================");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }

