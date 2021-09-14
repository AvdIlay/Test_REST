
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                        keyAndValue.forEach((k, v) -> {
                            try {
                                String s = k + " " + v;
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
                    FileReader fileReader = new FileReader("notes3.txt");
                    Scanner scan = new Scanner(fileReader);
                    while (scan.hasNextLine()) {
                        System.out.println(scan.nextLine());
                    }
                    fileReader.close();

            }
            //System.out.println(keyAndValue);

        }
    }
}


