package entity;

import javax.persistence.*;

@Entity
public class PozycjeZamowienia {

    @EmbeddedId
    PozycjeZamowieniaKlucz id;

    @ManyToOne
    @MapsId("idZamowienie")
    @JoinColumn(name="zamowienie_id")
    private Zamowienie zamowienie;

    @ManyToOne
    @MapsId("idProdukt")
    @JoinColumn(name = "produkt_id")
    private Produkt produkt;

    private int ilosc;

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
