package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "produkt")
@Entity
public class Produkt {

    @Id
    private int id;

    private String nazwa;
    private double cena;
    private int ilosc;
}
