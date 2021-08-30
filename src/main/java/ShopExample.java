import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import entity.Adres;
import entity.Klient;
import repository.AdresRepository;
import repository.KlientRepository;

import java.util.List;
import java.util.Scanner;


public class ShopExample {
    public static void main(String[] args) {

        AdresRepository adresRepository = new AdresRepository();
        KlientRepository klientRepository = new KlientRepository();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("----- address ----");
            System.out.println("1 - add address");
            System.out.println("2 - get by id");
            System.out.println("3 - remove");
            System.out.println("4 - find by street");
            System.out.println("5 - get all");
            System.out.println("6 - remove by street");
            System.out.println("----- client -------");
            System.out.println("11 - add client");
            System.out.println("12 - get client by id");
            System.out.println("--------------------");
            System.out.println("-1 - exit");
            option = scanner.nextInt();
            scanner.nextLine();

            List<Adres> addresses;
            int id;

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

                    addresses = adresRepository.findByStreet(street);
                    System.out.println(addresses);
                    break;
                case 5:
                    addresses = adresRepository.getAll();
                    System.out.println(addresses);
                    break;
                case 6:
                    System.out.println("remove by street");
                    System.out.println("street: ");
                    street = scanner.nextLine();

                    adresRepository.removeByStreet(street);
                    break;
                case 11:
                    System.out.println("add client");
                    System.out.print("adres id:");
                    int adresId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Imie: ");
                    String imie = scanner.nextLine();

                    Klient klient = new Klient(imie, "Nowak", imie.toLowerCase()+".nowak@wp.pl", adresId);

                    klientRepository.save(klient);
                    break;
                case 12:
                    System.out.println("get klient by id");
                    System.out.println("Id: ");
                    id = scanner.nextInt();

                    System.out.println(klientRepository.getById(id));
                    break;
            }
        } while(option != -1);
    }
}
