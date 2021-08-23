import entity.Adres;
import repository.AdresRepository;

import java.util.List;
import java.util.Scanner;


public class ShopExample {
    public static void main(String[] args) {

        AdresRepository adresRepository = new AdresRepository();
        Scanner scanner = new Scanner(System.in);

        int option;
        int id;
        do {
            System.out.println("1 - save");
            System.out.println("2 - get by id");
            System.out.println("3 - remove");
            System.out.println("4 - find by street");
            System.out.println("5 - get all");
            System.out.println("-1 - exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("save");
                    Adres adres = new Adres("Fioletowa", "22", 4, "23-123", "Dąbrowa");

                    adresRepository.save(adres);
                    break;
                case 2:
                    System.out.println("get by id");
                    System.out.println("Id: ");
                    id = scanner.nextInt();

                    System.out.println(adresRepository.getById(id));
                    break;
                case 3:
                    System.out.println("remove by id");
                    System.out.println("Id: ");
                    id = scanner.nextInt();

                    adresRepository.remove(id);
                    break;
                case 4:
                    System.out.println("street: ");
                    String street = scanner.nextLine();

//                    adres = adresRepository.findByStreet(street);
//                    System.out.println(adres);
                    break;
                case 5:
                    List<Adres> addresses = adresRepository.getAll();
                    System.out.println(addresses);
            }
        } while(option != -1);
    }
}
