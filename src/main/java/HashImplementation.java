
import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;

import java.util.Scanner;


public class HashImplementation {



    public static void main(String[] args) throws IOException {

        HashMap<String, String> keyAndValue = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ведите букву:"
                    + "C-create,"
                    + "D-delete,"
                    + "G-get,"
                    + "S-set,"
                    + "Du-dump,"
                    + "L-load!");
            String value = scanner.nextLine();
            switch (value) {
                case "C":
                    //create
                    String keyС = scanner.nextLine();
                    String valueMap = scanner.nextLine();
                    keyAndValue.put(keyС, valueMap);
                    System.out.println("Вы создали запись " + keyAndValue);
                    break;
                case "G":
                    //get
                    String keyG = scanner.nextLine();
                    if (keyAndValue.get(keyG) != null) {
                        System.out.println("Вы запросили запись по номером : " + keyG);
                        System.out.println(keyAndValue.get(keyG));
                    }else {
                        System.out.println("Запись отсутствует!");
                    }
                    break;
                case "S":
                    //set
                    String keyS = scanner.nextLine();
                    String valueMapS = scanner.nextLine();
                    if (keyAndValue.get(keyS) != null) {
                        keyAndValue.put(keyS, valueMapS);
                    } else {
                        keyAndValue.get(keyS);
                    }
                    System.out.println("Вы заменили запись по номером :");
                    break;
                case "D":
                    //delete
                    String keyD = scanner.nextLine();
                    keyAndValue.remove(keyD);
                    System.out.println("Вы удалили запись под номеном :" + keyD);
                    break;
                case "Du":
                    //create file
                    try(FileWriter writer = new FileWriter("notes3.txt", false))
                    {
                        keyAndValue.forEach((key, v) -> {
                            try {
                                String s = key  + " : " +  v;
                                writer.write(s + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "L":
                    //load file
                    FileReader fileReader = new FileReader("notes3.txt");
                    Scanner scan = new Scanner(fileReader);
                    keyAndValue = new HashMap<String, String>();
                    while (scan.hasNextLine()) {
                        String[] parts = scan.nextLine().split(" : ");
                        String key = parts[0];
                        String val = parts[1];
                        keyAndValue.put(key, val);
                        System.out.println(keyAndValue);

                    }
                    fileReader.close();
            }
            //System.out.println(keyAndValue);

        }
    }
}


