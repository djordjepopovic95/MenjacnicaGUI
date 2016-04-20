package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.Kurs;

public class GUIKontroler {

	public static MenjacnicaGUI glavniProzor;
	private static LinkedList<Kurs> kursevi = new LinkedList<Kurs>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void dodajKursUListu(Kurs k) {
		kursevi.add(k);
	}

	public static void prikaziDodajKursGUIProzor() {
		DodajKursGUI prozor = new DodajKursGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				glavniProzor.postaviStatus(glavniProzor.vratiStatus() + "\nUcitan fajl: " + file.getAbsolutePath());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				glavniProzor.postaviStatus(glavniProzor.vratiStatus() + "\nSacuvan fajl: " + file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz programa?", "Zatvaranje programa", JOptionPane.YES_NO_CANCEL_OPTION);
		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void unesiKurs(int sifra, String skraceni, String naziv, double prodajni, double kupovni,
			double srednji) {
		try {
			Kurs k = new Kurs();
			k.setKupovni(kupovni);
			k.setNaziv(naziv);
			k.setProdajni(prodajni);
			k.setSifra(sifra);
			k.setSkracenoIme(skraceni);
			k.setSrednji(srednji);
			dodajKursUListu(k);
			glavniProzor.osveziTabelu();
			String s = "Sifra: " + sifra + "Skraceni naziv: " + skraceni + "Naziv: " + naziv + "Prodajni kurs: " + prodajni + "Kupovni kurs: " + kupovni + "Srednji kurs" + srednji;
			glavniProzor.postaviStatus(glavniProzor.vratiStatus() + "\nDodat kurs: " + s);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Proveri formu: " + e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static LinkedList<Kurs> vratiSveKusreve() {
		return kursevi;
	}
	
	//fali GreskaBiranjeReda
	//fali izbrisiKnjigu
}
