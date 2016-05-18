package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopBarPanel2 extends JPanel {

	private JLabel vladoAleks = new JLabel("Vlado et Aleks");
	private JLabel calendar = new JLabel();
	private JLabel time = new JLabel();
	private JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	public TopBarPanel2() {
		// set the leftPanel
		vladoAleks.setForeground(Color.WHITE);
		leftPanel.add(vladoAleks);
		leftPanel.setBackground(Color.BLACK);

		// set the center Panel (calendarDate)
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		Date date = new Date();
		String display = (dateFormat.format(date));
		display = display.substring(0, 10);
		calendar.setText(display);
		calendar.setForeground(Color.WHITE);
		centerPanel.add(calendar);
		centerPanel.setBackground(Color.BLACK);

		// set the right panel
		time.setText("Afficher l'heure");
		time.setForeground(Color.WHITE);
		rightPanel.add(time);
		rightPanel.setBackground(Color.BLACK);

		// add the 3 panels to TopBarPanel
		setPreferredSize(new Dimension(25, 25));
		setLayout(new GridLayout(1, 3));
		add(leftPanel);
		add(centerPanel);
		add(rightPanel);
	}

}
