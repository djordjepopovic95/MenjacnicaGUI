package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import menjacnica.Kurs;
import menjacnica.gui.models.KursTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelEast;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPaneSouth;
	private JTextArea textAreaStatus;
	private JScrollPane scrollPaneCenter;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MenjacnicaGUI.class.getResource("/icons/nicki-minaj-the-pinkprint-album-cover.jpg")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 294);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getScrollPaneSouth(), BorderLayout.SOUTH);
		contentPane.add(getScrollPaneCenter(), BorderLayout.CENTER);
	}

	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			GridBagLayout gbl_panelEast = new GridBagLayout();
			gbl_panelEast.columnWidths = new int[] { 83, 0 };
			gbl_panelEast.rowHeights = new int[] { 23, 0, 0, 0 };
			gbl_panelEast.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
			gbl_panelEast.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panelEast.setLayout(gbl_panelEast);
			GridBagConstraints gbc_btnDodajKurs = new GridBagConstraints();
			gbc_btnDodajKurs.insets = new Insets(0, 0, 5, 0);
			gbc_btnDodajKurs.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnDodajKurs.gridx = 0;
			gbc_btnDodajKurs.gridy = 0;
			panelEast.add(getBtnDodajKurs(), gbc_btnDodajKurs);
			GridBagConstraints gbc_btnIzbrisiKurs = new GridBagConstraints();
			gbc_btnIzbrisiKurs.insets = new Insets(0, 0, 5, 0);
			gbc_btnIzbrisiKurs.gridx = 0;
			gbc_btnIzbrisiKurs.gridy = 1;
			panelEast.add(getBtnIzbrisiKurs(), gbc_btnIzbrisiKurs);
			GridBagConstraints gbc_btnIzvrsiZamenu = new GridBagConstraints();
			gbc_btnIzvrsiZamenu.gridx = 0;
			gbc_btnIzvrsiZamenu.gridy = 2;
			panelEast.add(getBtnIzvrsiZamenu(), gbc_btnIzvrsiZamenu);
		}
		return panelEast;
	}

	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajKursGUIProzor();
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(98, 23));
		}
		return btnDodajKurs;
	}

	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi kurs");
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int ind = table.getSelectedRow();
					if (ind == -1) {
						GUIKontroler.greskaPriIzboruReda();
					} else {
						int opcija = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da izbrisete kurs?", "Poruka",
								JOptionPane.YES_NO_OPTION);
						if (opcija == JOptionPane.YES_OPTION) {
							KursTableModel model = (KursTableModel) table.getModel();
							Kurs k = model.getKursByIndex(ind);
							GUIKontroler.izbrisiKursIzListe(k);
							
							JOptionPane.showInternalMessageDialog(getContentPane(), "Kurs uspesno izbrisan.");
							postaviStatus(vratiStatus() + "Izbrisan je red sa indeksom: " + ind + "\n");
						}
					}
				}
			});
			btnIzbrisiKurs.setPreferredSize(new Dimension(98, 23));
		}
		return btnIzbrisiKurs;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziIzvrsiZamenuProzor();
				}
			});
			btnIzvrsiZamenu.setPreferredSize(new Dimension(98, 23));
		}
		return btnIzvrsiZamenu;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ucitajIzFajla();
				}
			});
			mntmOpen.setIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvajUFajl();
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(getContentPane(), "Djordje Popovic \nFON, 2016.", "About",
							JOptionPane.PLAIN_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}

	private JScrollPane getScrollPaneSouth() {
		if (scrollPaneSouth == null) {
			scrollPaneSouth = new JScrollPane();
			scrollPaneSouth.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPaneSouth.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPaneSouth
					.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPaneSouth.setPreferredSize(new Dimension(450, 100));
			scrollPaneSouth.setViewportView(getTextAreaStatus());
		}
		return scrollPaneSouth;
	}

	private JTextArea getTextAreaStatus() {
		if (textAreaStatus == null) {
			textAreaStatus = new JTextArea();
			textAreaStatus.setPreferredSize(new Dimension(300, 20));
		}
		return textAreaStatus;
	}

	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			addPopup(scrollPaneCenter, getPopupMenu());
			scrollPaneCenter.setViewportView(getTable());
		}
		return scrollPaneCenter;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			KursTableModel model = new KursTableModel(null);
			table.setModel(model);
		}
		return table;
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodajKursGUIProzor();
				}
			});
		}
		return mntmDodajKurs;
	}

	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
			mntmIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int ind = table.getSelectedRow();
					if (ind == -1) {
						GUIKontroler.greskaPriIzboruReda();
					} else {
						int opcija = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da izbrisete kurs?", "Poruka",
								JOptionPane.YES_NO_OPTION);
						if (opcija == JOptionPane.YES_OPTION) {
							KursTableModel model = (KursTableModel) table.getModel();
							Kurs k = model.getKursByIndex(ind);
							GUIKontroler.izbrisiKursIzListe(k);
							
							JOptionPane.showInternalMessageDialog(getContentPane(), "Kurs uspesno izbrisan.");
							postaviStatus(vratiStatus() + "Izbrisan je red sa indeksom: " + ind + "\n");
						}
					}
				}
			});
		}
		return mntmIzbrisiKurs;
	}

	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziIzvrsiZamenuProzor();
				}
			});
		}
		return mntmIzvrsiZamenu;
	}

	public String vratiStatus() {
		return textAreaStatus.getText();
	}

	public void postaviStatus(String s) {
		textAreaStatus.setText(s);
	}
	
	public void osveziTabelu() {
		KursTableModel model = (KursTableModel) table.getModel();
		model.ucitajKurseve(GUIKontroler.vratiSveKusreve());
		
	}
	
	
}
