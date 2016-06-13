package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Contact.Contact;
import Elements.AddButton;
import Elements.ContactButton;
import Elements.NotesButton;
import Elements.TopTitleBar;
import Elements.WrapLayout;
import Frame.Contact.Contact_Carnet;
import Frame.Galerie.Photo_Details;
import Notes.BlocNotes;
import Notes.Note;

public class Notes_Accueil extends JPanel {

	// for Panel Notes_Accueil
	private CardLayout c1 = new CardLayout();

	// panel BlocNotes contains titleBar and Panelnotes
	private JPanel panelBlocNotes = new JPanel(new BorderLayout());

	// for titlePanel
	private TopTitleBar titleBar = new TopTitleBar("Notes", 252, 105, 17, new AddButton(), new Add_Click());

	// for panelBlocNotes
	private JPanel panelNotes = new JPanel(new WrapLayout(WrapLayout.LEFT, 10, 10));
	private JScrollPane scroll = new JScrollPane(panelNotes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private BlocNotes blocNotes = new BlocNotes();

	public Notes_Accueil() {

		blocNotes.deserialize();

		// set Notes_Accueil
		setLayout(c1);
		add(panelBlocNotes, "panelBlocNotes");
		c1.show(Notes_Accueil.this, "panelBlocNotes");

		// add to Notes_Accueil
		add(panelBlocNotes);

		// set panelBlocNotes
		panelBlocNotes.add(titleBar, BorderLayout.NORTH);
		panelBlocNotes.add(scroll);

		creatNotesButtons();


	}

	public void creatNotesButtons() {

		panelNotes.removeAll();
		blocNotes.refreshId();

		for (int i = 0; i < blocNotes.getBlocNotes().size(); i++) {
			Note n = blocNotes.getBlocNotes().get(i);
			NotesButton temp = new NotesButton(n.getTexte());
			temp.getTextArea().setName("N" + i);
			temp.getTextArea().addMouseListener(new Notes_Click());
			panelNotes.add(temp);
			
			System.out.println(i+ " "+ n.getId());
		}
	}

	class Notes_Click extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			for (int i = 0; i < blocNotes.getBlocNotes().size(); i++) {
				if (((JTextArea) e.getSource()).getName().equals("N" + i)) {
					Note note = blocNotes.getBlocNotes().get(i);
					Notes_Details noteDetails = new Notes_Details(blocNotes.getBlocNotes().get(i).getTexte(),
							Notes_Accueil.this, note);
					add(noteDetails, "noteDetails");
					c1.show(Notes_Accueil.this, "noteDetails");
					return;
				}
			}
			
		}
	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub


			Note n = new Note(null);
			blocNotes.addNote(n);
			Notes_Details noteDetails = new Notes_Details(n.getTexte(), Notes_Accueil.this, n);
			add(noteDetails, "noteDetails");
			c1.show(Notes_Accueil.this, "noteDetails");
		}

	}

	public BlocNotes getBlocNotes() {
		return blocNotes;
	}
}
