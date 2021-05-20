package Day1.Lab1;

import java.io.*;

public class Console {

    public static void main(String[] args) {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
            String data ="";
            while (!(data.equalsIgnoreCase("stop"))){
                System.out.println("Enter data :");
                data = br.readLine();
                out.write(data+"\n");
                System.out.println("data is : " + data);
            }
            r.close();
            br.close();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}

