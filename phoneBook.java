import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class phoneBook {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String phoneNum, String name) {
        if (map.containsKey(name)) {
            List<String> phoneNumbers = map.get(name);
            phoneNumbers.add(phoneNum);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            map.put(name, phoneNumbers);
        }
    }

    String getPhoneNum(String phoneNum) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> phoneNumbers = entry.getValue();
            if (phoneNumbers.contains(phoneNum)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" : ");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    String getByName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.containsKey(name)) {
            List<String> phoneNumbers = map.get(name);
            for (String phoneNumber : phoneNumbers) {
                stringBuilder.append(phoneNumber);
                stringBuilder.append(" : ");
                stringBuilder.append(name);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args)
    {
        phoneBook Book=new phoneBook();
        boolean exit=false;
        while(!exit)
        {
            System.out.println("Введите цифру, для выбора действия: 1. Добавить номер телефона, 2. Найти по номеру телефона абонента, 3. Найти номер по имени абонента, 4. Отобразить всех абонентов, 5. Выйти из программы");
            Scanner iScanner = new Scanner(System.in);
            String s = iScanner.nextLine();
            switch(s)
            {
                case "1":
                    System.out.println("Введите номер:");
                    iScanner=new Scanner(System.in);
                    String _number=  iScanner.nextLine();
                    System.out.println("Введите имя:");
                    iScanner=new Scanner(System.in);
                    String _name=  iScanner.nextLine();
                    Book.add(_number,_name);
                break;
                case "2":
                    System.out.println("Введите номер:");
                    iScanner=new Scanner(System.in);
                    String _number2=  iScanner.nextLine();
                    Book.getPhoneNum(_number2);
                break;
                case "3":
                    System.out.println("Введите имя:");
                    iScanner=new Scanner(System.in);
                    String _name3=  iScanner.nextLine();
                    Book.getByName(_name3);
                break;
                case "4":
                System.out.println(Book.getAll());
                break;
                case "5":
                    exit=true;
                break;

            }

        }

    }
}
