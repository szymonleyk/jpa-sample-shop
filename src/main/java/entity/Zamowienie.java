package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "zamowienie")
public class Zamowienie {

    @Id
    private int id;

    @Column(name = "data_zamowienia", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataZamowienia;
}
