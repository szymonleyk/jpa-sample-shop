import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import entity.*;
import repository.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ShopExample {
    public static void main(String[] args) {

        AdresRepository adresRepository = new AdresRepository();
        KlientRepository klientRepository = new KlientRepository();
        ProduktRepository produktRepository = new ProduktRepository();
        PozycjeZamowieniaRepository pozycjeZamowieniaRepository = new PozycjeZamowieniaRepository();
        ZamowienieRepository zamowienieRepository = new ZamowienieRepository();

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
            System.out.println("13 - get all clients");
            System.out.println("14 - add client with new address");
            System.out.println("----- produkt -------");
            System.out.println("15 - add produkt");
            System.out.println("----- koszyk -------");
            System.out.println("16 - zloz zamowienie z produktami");
            System.out.println("--------------------");
            System.out.println("-1 - exit");
            option = scanner.nextInt();
            scanner.nextLine();

            List<Adres> addresses;
            List<Klient> clients;
            List<Produkt> products;
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

                    adres = adresRepository.getById(adresId);
                    scanner.nextLine();

                    System.out.print("Imie: ");
                    String imie = scanner.nextLine();

                    Klient klient = new Klient(imie, "Nowak", imie.toLowerCase()+".nowak@wp.pl", adres);

                    klientRepository.save(klient);
                    break;
                case 12:
                    System.out.println("get klient by id");
                    System.out.println("Id: ");
                    id = scanner.nextInt();

                    System.out.println(klientRepository.getById(id));
                    break;
                case 13:
                    clients = klientRepository.getAll();
                    System.out.println(clients);
                    break;
                case 14:
                    adres = new Adres("Podgórna", "1", 1, "44-111", "Gdańsk");
                    System.out.print("Imie: ");
                    imie = scanner.nextLine();

                    klient = new Klient(imie, "Nowak", imie.toLowerCase()+".nowak@wp.pl", adres);

                    klientRepository.save(klient);
                    break;
                case 15:
                    Produkt produkt = new Produkt("Mleko", 2.33, 5);
                    produktRepository.save(produkt);
                    break;
                case 16:
//                    System.out.println("Id produktu: ");
//                    int id1 = scanner.nextInt();
//
//                    System.out.println("Id produktu: ");
//                    int id2 = scanner.nextInt();

                    System.out.println("Id klienta: ");
                    int idKlienta = scanner.nextInt();
                    klient = klientRepository.getById(idKlienta);

//                    Produkt produkt1 = produktRepository.getById(id1);
//                    Produkt produkt2 = produktRepository.getById(id2);

                    Produkt produkt1 = new Produkt("A", 22.3, 2);
                    Produkt produkt2 = new Produkt("B", 3.12, 2);
                    produktRepository.save(produkt1);
                    produktRepository.save(produkt2);

                    Zamowienie zamowienie = new Zamowienie(LocalDateTime.now(), klient);
                    zamowienieRepository.save(zamowienie);

                    PozycjeZamowienia pozycja1 = new PozycjeZamowienia(zamowienie, produkt1, 2);
                    PozycjeZamowienia pozycja2 = new PozycjeZamowienia(zamowienie, produkt2, 1);

                    pozycjeZamowieniaRepository.save(pozycja1);
                    pozycjeZamowieniaRepository.save(pozycja2);

                    break;


            }
        } while(option != -1);
    }
}
