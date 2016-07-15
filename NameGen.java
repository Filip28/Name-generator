package NoToGo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Filip on 11.07.2016.
 */
public class NameGen {

    private static int random(int number){
        int r;
        Random random = new Random();
        r = random.nextInt(number);

        return r;
    }


    private static String namesFromFile(File fin)throws IOException{

            FileInputStream fis = new FileInputStream(fin);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;

            List<String> nameList = new ArrayList<String>();

            while ((line = br.readLine()) != null) {

                nameList.add(line);
            }
            br.close();
            return nameList.get(random(nameList.size()));

    }


    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);


        try {
            System.out.println("Generator imion:\n1.Meskie \n2.Zenskie");
            int chose = input.nextInt();

            switch (chose) {
                case 1:
                    File dir = new File(".");
                    File fin = new File(dir.getCanonicalPath()+ File.separator + "ManNames.txt");
                    System.out.print("Twoje wygenerowane imie meskie to " + namesFromFile(fin)+".\n");
                    break;
                case 2:
                    File mir = new File(".");
                    File kin = new File(mir.getCanonicalPath()+ File.separator + "WomanNames.txt");
                    System.out.print("Twoje wygenerowane imie zenskie to " + namesFromFile(kin)+".\n");
                    break;
                default:
                    System.out.println("Blad!!");
            }
        }
       catch (Exception e){
           System.out.println("Niepoprawnie załadowany plik źródłowy!!");
       }

    }
}
