package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	private TopTitleBar titleBar = new TopTitleBar("Notes",252, 105, 17, new AddButton(), new Add_Click());

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

		// set titleBar
//		titleBar.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
		
		// add to Notes_Accueil
		add(panelBlocNotes);

		// set panelBlocNotes
		panelBlocNotes.add(titleBar, BorderLayout.NORTH);
		panelBlocNotes.add(scroll);

		creatNotesButtons();
		
		
//		creatNotesButtons();
//		addNotesToPanel();
//		addActionListenerToNotesButtons();
	}

	
	public void creatNotesButtons(){
		panelNotes.removeAll();
		blocNotes.refreshId();
		
		for(int i=0; i< blocNotes.getBlocNotes().size();i++){
			Note n = blocNotes.getBlocNotes().get(i);
			NotesButton temp = new NotesButton (blocNotes.displayInButton(n.getTexte()));
			temp.setName("N"+i);
			temp.addActionListener(new Notes_Click());
			panelNotes.add(temp);
		}
	}
	
	
	
	public void removePanel(JPanel panel) {
		System.out.println("Je suis rentré dans la méthode removePanel");
		Notes_Accueil.this.remove(panel);
		Notes_Accueil.this.revalidate();
		Notes_Accueil.this.repaint();
		addNotesToPanel();

	}

	public void addNotesToPanel() {
		panelNotes.removeAll();
		for (int i = 0; i < blocNotes.getNotesButtons().size(); i++) {
			System.out.println("Je suis bouton " + i);
			panelNotes.add(blocNotes.getNotesButtons().get(i));
			blocNotes.getNotesButtons().get(i).setName("N" + i);
		}
		panelNotes.repaint();
		panelNotes.revalidate();
	}

	public void addActionListenerToNotesButtons() {
		for (int i = 0; i < blocNotes.getNotesButtons().size(); i++) {
			blocNotes.getNotesButtons().get(i).addActionListener(new Notes_Click());
		}
		panelNotes.repaint();
		panelNotes.revalidate();
	}

	class Notes_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Click note details");
			
			// TODO Auto-generated method stub
			for (int i = 0; i < blocNotes.getBlocNotes().size(); i++) {
				if (((JButton) e.getSource()).getName().equals("N" + i)) {
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
//			 TODO Auto-generated method stub
//			 Notes_Details noteDetails = new Notes_Details("",
//			 Notes_Accueil.this);
//			 add(noteDetails, "noteDetails");
//			 c1.show(Notes_Accueil.this, "noteDetails");
			
		Note n = new Note("");
		blocNotes.addNote(n);
		Notes_Details noteDetails = new Notes_Details(n.getTexte(),
				Notes_Accueil.this, n);
		add(noteDetails, "noteDetails");
		c1.show(Notes_Accueil.this, "noteDetails");	
		}

	}
	
	public BlocNotes getBlocNotes() {
		return blocNotes;
	}
}
