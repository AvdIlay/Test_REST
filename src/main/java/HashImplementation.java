
import java.util.HashMap;

import java.util.Scanner;


public class HashImplementation {

    public static void main(String[] args) {

        HashMap<String, String> keyAndValue = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ведите букву:"
                    + "C-create, "
                    + "D- delete,"
                    + "G-get, "
                    + "S-set!");
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
                        System.out.println("Вы запросили запись по номером :" + keyG);
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
            }
            //System.out.println(keyAndValue);
        }
    }
}

