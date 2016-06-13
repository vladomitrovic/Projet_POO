package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.StyleConstants;

import Elements.BackButton;
import Elements.OkButton;
import Elements.TopTitleBar;
import Elements.TrashButton;
import Galerie.Photo;
import Notes.Note;

public class Notes_Details extends JPanel {

	private TopTitleBar titleBar = new TopTitleBar(new BackButton(), new Back_Click(), "", new TrashButton(),
			new Delete_Click(), new Color(252, 105, 17));
	private JTextArea textArea = new JTextArea("");
	private Photo photo = new Photo("PicturesElements/fondEcranNote1.png");
	private PanelNotes panelNotes = new PanelNotes(photo);

	// preferences of the JScrollPane without JScrollBar
	private JScrollPane scroll = new JScrollPane(panelNotes, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
		public boolean isVisible() {
			return true;
		}
	};

	private JLabel date = new JLabel();
	private Notes_Accueil top;
	private Note note;

	public Notes_Details(String texte, Notes_Accueil top, Note note) {
		this.top = top;
		this.note = note;
		// set layout
		setLayout(new BorderLayout());

		System.out.println(panelNotes.getWidth());

		// set textArea
		textArea.setOpaque(false);
		textArea.setSize(426, 800);
		textArea.setText(note.getTexte());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(15, 85, 20, 20));
		textArea.setFont(new Font("Arial", Font.PLAIN, 33));

		//add the textarea to the panelNotes
		panelNotes.add(textArea);

		// add to Notes_Details
		add(titleBar, BorderLayout.NORTH);
		scroll.setVerticalScrollBar(scrollBar);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		add(scroll);

		// last update label
		date.setText("Dernière modification :  " + note.getDate());
		date.setHorizontalAlignment(SwingConstants.CENTER);
		add(date, BorderLayout.SOUTH);

	}

	class Back_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// If no modif on textArea, no confirmation
			if (textArea.getText().equals(top.getBlocNotes().getBlocNotes().get(note.getId()).getTexte())
					&& textArea.getText() != null) {
				top.remove(Notes_Details.this);
				return;

			} else {
				int dialogButton = JOptionPane.showConfirmDialog(null, "Enregistrer les modifications ?",
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (dialogButton == JOptionPane.YES_OPTION) {
					top.getBlocNotes().getBlocNotes().get(note.getId()).setTexte(textArea.getText());
					// top.getBlocNotes().orderOnUpdate(note.getId());
					top.getBlocNotes().serialize();
					top.remove(Notes_Details.this);
				}
				if (dialogButton == JOptionPane.NO_OPTION) {
					if (textArea.getText().equals("")) {
						top.getBlocNotes().deleteNote(note.getId());
						top.getBlocNotes().serialize();
					}
					top.remove(Notes_Details.this);
				}
			}

			top.creatNotesButtons();
		}
	}

	class Delete_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			top.getBlocNotes().deleteNote(note.getId());
			top.getBlocNotes().serialize();
			top.creatNotesButtons();
			top.remove(Notes_Details.this);
		}

	}

}
