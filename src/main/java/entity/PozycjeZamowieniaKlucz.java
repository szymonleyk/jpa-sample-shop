package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PozycjeZamowieniaKlucz implements Serializable {

    @Column(name = "id_zamowienie")
    private int idZamowienie;

    @Column(name = "id_produkt")
    private int idProdukt;

    public int getIdZamowienie() {
        return idZamowienie;
    }

    public void setIdZamowienie(int idZamowienie) {
        this.idZamowienie = idZamowienie;
    }

    public int getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(int idProdukt) {
        this.idProdukt = idProdukt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PozycjeZamowieniaKlucz that = (PozycjeZamowieniaKlucz) o;
        return idZamowienie == that.idZamowienie &&
                idProdukt == that.idProdukt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idZamowienie, idProdukt);
    }
}
