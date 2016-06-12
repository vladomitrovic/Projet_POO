package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	private JLabel date=new JLabel();

	// Photo for paintComponent
	private Photo photo = new Photo("PicturesElements/fondEcranNote.png");

	private Notes_Accueil top;
	private Note note;

	public Notes_Details(String texte, Notes_Accueil top, Note note) {
		this.top = top;
		this.note = note;
		// set layout
		setLayout(new BorderLayout());

		// set textArea
		textArea.setOpaque(false);
		textArea.setPreferredSize(new Dimension(480, 800));
		textArea.setText(note.getTexte());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(0, 80, 20, 20));
		textArea.setFont(new Font("Arial", Font.PLAIN, 35));

		// add to panel
		add(titleBar, BorderLayout.NORTH);
		add(textArea);
		
		//last update label
		date.setText("Derni�re modification :  " + note.getDate());
		date.setHorizontalAlignment(SwingConstants.CENTER);
		add(date, BorderLayout.SOUTH);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

	}

	class Back_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		
			

			// If no modif on textArea, no confirmation
			if (textArea.getText().equals(top.getBlocNotes().getBlocNotes().get(note.getId()).getTexte()) && textArea.getText()!=null) {
				top.remove(Notes_Details.this);
				System.out.println("No modif and not ... ");
				return;
				
			} else {
				int dialogButton = JOptionPane.showConfirmDialog(null, "Enregistrer les modifications ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (dialogButton == JOptionPane.YES_OPTION) {
					top.getBlocNotes().getBlocNotes().get(note.getId()).setTexte(textArea.getText());
					top.getBlocNotes().serialize();
					System.out.println("YES " + dialogButton);
					top.remove(Notes_Details.this);
				}
				if (dialogButton == JOptionPane.NO_OPTION ) {
					if(textArea.getText().equals("")){
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
