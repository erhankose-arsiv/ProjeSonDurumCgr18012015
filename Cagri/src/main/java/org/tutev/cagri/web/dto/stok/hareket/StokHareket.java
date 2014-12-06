package org.tutev.cagri.web.dto.stok.hareket;

import java.util.Date;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name = "STOK_HAREKET")
public class StokHareket extends  Base implements  Serializable {

    Long id;
    Long StokKod;
    Long FisNo;
    Float GirisCikisMiktar;
    String GirisCikisDurum; // G:Giriþ Ç:Çýkýþ
    Date Tarih; // G.Ç tarih
    String Aciklama;

    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "STOK_HAREKET_SEQ", name = "STOK_HAREKET_SEQ")
    @GeneratedValue(generator = "STOK_HAREKET_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "STOK_KOD")
    public Long getStokKod() {
        return StokKod;
    }

    public void setStokKod(Long stokKod) {
        StokKod = stokKod;
    }

    @Column(name = "FIS_NO")
    public Long getFisNo() {
        return FisNo;
    }

    public void setFisNo(Long fisNo) {
        FisNo = fisNo;
    }

    @Column(name = "GIRIS_CIKIS_MIKTAR")
    public Float getGirisCikisMiktar() {
        return GirisCikisMiktar;
    }

    public void setGirisCikisMiktar(Float girisCikisMiktar) {
        GirisCikisMiktar = girisCikisMiktar;
    }

    @Column(name = "GIRIS_CIKIS_DURUM")
    public String getGirisCikisDurum() {
        return GirisCikisDurum;
    }

    public void setGirisCikisDurum(String girisCikisDurum) {
        GirisCikisDurum = girisCikisDurum;
    }

    @Column(name = "TARIH")
    public Date getTarih() {
        return Tarih;
    }

    public void setTarih(Date tarih) {
        Tarih = tarih;
    }

    @Column(name = "ACIKLAMA", length = 250)
    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }
}