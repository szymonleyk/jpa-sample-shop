package entity;

import javax.persistence.*;

@Entity
@Table(name = "pozycje_zamowienia")
public class PozycjeZamowienia {

    @EmbeddedId
    PozycjeZamowieniaKlucz id = new PozycjeZamowieniaKlucz();

    @ManyToOne
    @MapsId("idZamowienie")
    @JoinColumn(name="id_zamowienie")
    private Zamowienie zamowienie;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("idProdukt")
    @JoinColumn(name = "id_produkt")
    private Produkt produkt;

    private int ilosc;

    public PozycjeZamowienia() { }

    public PozycjeZamowienia(Zamowienie zamowienie, Produkt produkt, int ilosc) {
        this.zamowienie = zamowienie;
        this.produkt = produkt;
        this.ilosc = ilosc;
    }

    public PozycjeZamowieniaKlucz getId() {
        return id;
    }

    public void setId(PozycjeZamowieniaKlucz id) {
        this.id = id;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
