package application;

import java.time.LocalDate;

import javafx.beans.property.SimpleIntegerProperty;


public class Hastalar{

	String HastaAdi;
	String HastaCinsiyeti;
	String HastaMeslek;
	String Il;
	String hastaAtes;
	String HastaTeshis;
	LocalDate Tarih;
	private final SimpleIntegerProperty colSayi;
	
	
	public Hastalar(String ad,String sehir,String cinsiyet,String meslek,String olcum,String teshisHasta,LocalDate localdate,Integer id) {
		this.HastaAdi=ad;
		this.HastaCinsiyeti=cinsiyet;
		this.HastaMeslek=meslek;
		this.Il=sehir;
		this.hastaAtes=olcum;
		this.HastaTeshis=teshisHasta;
		this.Tarih=localdate;
		this.colSayi=new SimpleIntegerProperty(id) ;
	
		
		
	}

	public String getHastaAdi() {
		return HastaAdi;
	}

	public void setHastaAdi(String hastaAdi) {
		HastaAdi = hastaAdi;
	}

	public String getHastaCinsiyeti() {
		return HastaCinsiyeti;
	}

	public void setHastaCinsiyeti(String hastaCinsiyeti) {
		HastaCinsiyeti = hastaCinsiyeti;
	}

	public String getIl() {
		return Il;
	}

	public void setIl(String il) {
		Il = il;
	}
	
	public String getHastaMeslek() {
		return HastaMeslek;
	}

	public void setHastaMeslek(String hastaMeslek) {
		HastaMeslek = hastaMeslek;
	}

	public String getHastaAtesi() {
		return hastaAtes;
	}

	public void setHastaAtesi(String olcum) {
		hastaAtes = olcum;
	}

	public String getHastaTeshis() {
		return HastaTeshis;
	}

	public void setHastaTeshis(String hastaTeshis) {
		HastaTeshis = hastaTeshis;
	}

	public LocalDate getTarih() {
		return Tarih;
	}

	public void setTarih(LocalDate tarih) {
		Tarih = tarih;
	}

	public int getColSayi() {
		return colSayi.get();
	}
	
	public void setColSayi(int id) {
		this.colSayi.set(id);
	}
	

	
}
