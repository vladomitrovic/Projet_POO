package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Elements.AddButton;
import Elements.TopTitleBar;

public class Notes_Accueil extends JPanel {

	// for Panel Notes_Accueil
	private CardLayout c1 = new CardLayout();

	private JPanel panelBlocNotes = new JPanel(new BorderLayout());
	private TopTitleBar titleBar = new TopTitleBar("Notes", 255, 218, 1, new AddButton(), new Add_Click());
	private JPanel panelNotes = new JPanel();
	private JScrollPane scroll = new JScrollPane(panelNotes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public Notes_Accueil() {
		// set Notes_Accueil
		setLayout(c1);

		// set panelBlocNotes
		panelBlocNotes.add(titleBar, BorderLayout.NORTH);
		panelBlocNotes.add(scroll);

		// add to Notes_Accueil
		add(panelBlocNotes);
	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}

	}

}
