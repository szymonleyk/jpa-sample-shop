package entity;

import javax.persistence.*;

@Entity
@Table(name = "klient")
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imie;
    private String nazwisko;
    private String email;

    @Column(name = "adres_id")
    private int adresId;

    public Klient() {}

    public Klient(String imie, String nazwisko, String email, int adresId) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.adresId = adresId;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", adresId=" + adresId +
                '}';
    }
}
