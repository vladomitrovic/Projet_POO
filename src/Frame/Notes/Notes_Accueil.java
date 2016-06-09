package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Elements.AddButton;
import Elements.NotesButton;
import Elements.TopTitleBar;
import Elements.WrapLayout;
import Notes.BlocNotes;

public class Notes_Accueil extends JPanel {

	// for Panel Notes_Accueil
	private CardLayout c1 = new CardLayout();

	// panel BlocNotes contains titleBar and Panelnotes
	private JPanel panelBlocNotes = new JPanel(new BorderLayout());

	// for titlePanel
	private TopTitleBar titleBar = new TopTitleBar("Notes", 120, 95, 248, new AddButton(), new Add_Click());

	// for panelBlocNotes
	private JPanel panelNotes = new JPanel(new WrapLayout(WrapLayout.LEFT, 10, 10));
	private JScrollPane scroll = new JScrollPane(panelNotes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private BlocNotes blocNotes = new BlocNotes();

	public Notes_Accueil() {
		// set Notes_Accueil
		setLayout(c1);

		// set panelBlocNotes
		panelBlocNotes.add(titleBar, BorderLayout.NORTH);
		panelBlocNotes.add(scroll);

		// add to Notes_Accueil
		add(panelBlocNotes);

		// add NotesButton to panelNotes
		panelNotes.add(new NotesButton(
				"asflksjdflkasjdflksdfjalsk"
				+ "fjadsklfjaslkfjasldkfjasklfjasldkf"
				+ "jadslfkjdslkfjdsklfjds"
				+ "lfkjdslkfjasdlfkjadslfkjdsflkadsflkadsfjlkj"));
		
		String s= "élsjsafdsfasdfasfadsfsadfasfadsfadsfasfadsfasdfasdfasdfdfs";
		panelNotes.add(new NotesButton("<html>fnord<br />foo</html>"));
		panelNotes.add(new NotesButton(blocNotes.displayInButton(s)));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));
		panelNotes.add(new NotesButton("Test"));

	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("salut");
		}

	}

}
