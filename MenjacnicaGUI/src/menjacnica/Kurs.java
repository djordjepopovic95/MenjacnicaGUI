package menjacnica;

import java.util.LinkedList;

public class Kurs {

	private int Sifra;
	private double Prodajni;
	private double Srednji;
	private double Kupovni;
	private String SkracenoIme;
	private String Naziv;
	
	public int getSifra() {
		return Sifra;
	}

	public void setSifra(int sifra) {
		if (sifra > 0) {
			Sifra = sifra;
		} else
			throw new RuntimeException("Sifra mora da bude pozitivan broj.");
	}

	public double getProdajni() {
		return Prodajni;
	}

	public void setProdajni(double prodajni) {
		if (prodajni > 0) {
			Prodajni = prodajni;
		} else
			throw new RuntimeException("Kurs mora da bude pozitivan broj.");
	}

	public double getSrednji() {
		return Srednji;
	}

	public void setSrednji(double srednji) {
		if (srednji > 0) {
			Srednji = srednji;
		} else
			throw new RuntimeException("Sifra mora da bude pozitivan broj.");
	}

	public double getKupovni() {
		return Kupovni;
	}

	public void setKupovni(double kupovni) {
		if (kupovni > 0) {
			Kupovni = kupovni;
		} else
			throw new RuntimeException("Sifra mora da bude pozitivan broj.");
	}

	public String getSkracenoIme() {
		return SkracenoIme;
	}

	public void setSkracenoIme(String skracenoIme) {
		if (skracenoIme != null && skracenoIme != "") {
			SkracenoIme = skracenoIme;
		} else
			throw new RuntimeException("Skraceno ime ne moze da bude prazan string niti null.");
	}

	public String getNaziv() {
		return Naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv != null && naziv != "") {
			Naziv = naziv;
		} else
			throw new RuntimeException("Naziv ne moze da bude prazan.");
	}

	@Override
	public String toString() {
		return "Kurs [Sifra=" + Sifra + ", Prodajni=" + Prodajni + ", Srednji=" + Srednji + ", Kupovni=" + Kupovni
				+ ", SkracenoIme=" + SkracenoIme + ", Naziv=" + Naziv + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Kupovni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((Naziv == null) ? 0 : Naziv.hashCode());
		temp = Double.doubleToLongBits(Prodajni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Sifra;
		result = prime * result + ((SkracenoIme == null) ? 0 : SkracenoIme.hashCode());
		temp = Double.doubleToLongBits(Srednji);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (Double.doubleToLongBits(Kupovni) != Double.doubleToLongBits(other.Kupovni))
			return false;
		if (Naziv == null) {
			if (other.Naziv != null)
				return false;
		} else if (!Naziv.equals(other.Naziv))
			return false;
		if (Double.doubleToLongBits(Prodajni) != Double.doubleToLongBits(other.Prodajni))
			return false;
		if (Sifra != other.Sifra)
			return false;
		if (SkracenoIme == null) {
			if (other.SkracenoIme != null)
				return false;
		} else if (!SkracenoIme.equals(other.SkracenoIme))
			return false;
		if (Double.doubleToLongBits(Srednji) != Double.doubleToLongBits(other.Srednji))
			return false;
		return true;
	}

}
