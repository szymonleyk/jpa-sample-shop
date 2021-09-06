package entity;

import javax.persistence.*;

@Table(name = "produkt")
@Entity
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nazwa;
    private double cena;
    private int ilosc;
}
