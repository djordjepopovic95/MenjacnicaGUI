package menjacnica.gui.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;

@SuppressWarnings("serial")
public class KursTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni",
			"Naziv" };

	private LinkedList<Kurs> kursevi;

	public KursTableModel(LinkedList<Kurs> kursevi) {
		if (kursevi == null) {
			this.kursevi = new LinkedList<Kurs>();
		} else {
			this.kursevi = kursevi;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k = kursevi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return k.getSifra();
		case 1:
			return k.getSkracenoIme();
		case 2:
			return k.getProdajni();
		case 3:
			return k.getSifra();
		case 4:
			return k.getKupovni();
		case 5:
			return k.getNaziv();
		default:
			return "NN";
		}
	}
	
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void ucitajKurseve(LinkedList<Kurs> kursevi){
		this.kursevi = kursevi; 
		fireTableDataChanged();
	}

}
