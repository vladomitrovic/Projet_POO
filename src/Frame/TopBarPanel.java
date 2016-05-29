package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TopBarPanel extends JPanel {

	private JLabel vladoAleks = new JLabel("Vlado et Aleks");
	private JLabel calendar = new JLabel();
	private JLabel time = new JLabel();
	private GridLayout gridL = new GridLayout(1, 3);

	public TopBarPanel() {
		//set mainPanel
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(25, 25));
		gridL.setHgap(90);
		setLayout(gridL);

		// set the leftLabel
		vladoAleks.setForeground(Color.WHITE);
		vladoAleks.setAlignmentX(SwingConstants.LEFT);

		// set the centerLabel (calendarDate)
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		Date date = new Date();
		String display = (dateFormat.format(date));
		display = display.substring(0, 10);
		calendar.setText(display);
		calendar.setForeground(Color.WHITE);

		// set the rightLabel
		time.setText("Afficher l'heure");
		time.setForeground(Color.WHITE);

		// add the 3 labels to TopBarPanel
		add(vladoAleks);
		add(calendar);
		add(time);
	}

}
