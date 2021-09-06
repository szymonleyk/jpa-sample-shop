package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "zamowienie")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_zamowienia", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataZamowienia;

    @ManyToOne
    @JoinColumn(name = "id_klient", referencedColumnName = "id")
    private Klient klient;

    public Zamowienie() {}

    public Zamowienie(LocalDateTime dataZamowienia, Klient klient) {
        this.dataZamowienia = dataZamowienia;
        this.klient = klient;
    }
}
