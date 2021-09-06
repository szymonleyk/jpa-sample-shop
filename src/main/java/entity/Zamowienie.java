package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "zamowienie")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_zamowienia", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataZamowienia;
}
