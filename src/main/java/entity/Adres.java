package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="adres")
public class Adres {

    public Adres(){}

    public Adres(String ulica, String nrDomu, Integer nrMieszkania, String kodPocztowy, String miejscowosc) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ulica;

    @Column(name="nr_domu")
    private String nrDomu;

    @Column(name = "nr_mieszkania")
    private Integer nrMieszkania;

    @Column(name="kod_pocztowy")
    private String kodPocztowy;

    private String miejscowosc;

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", ulica='" + ulica + '\'' +
                ", nrDomu='" + nrDomu + '\'' +
                ", nrMieszkania=" + nrMieszkania +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                '}'+"\n";
    }
}
