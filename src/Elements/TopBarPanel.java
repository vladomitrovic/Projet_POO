package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TopBarPanel extends JPanel {

	private JLabel vladoAleks = new JLabel("Vlado et Aleks");
	private JLabel calendar = new JLabel();
	private HorlogeLabel time = new HorlogeLabel();
	private GridLayout gridL = new GridLayout(1, 3);

	public TopBarPanel() {
		
		// set mainPanel
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(25, 25));
		gridL.setHgap(90);
		setLayout(gridL);

		// set the leftLabel
		vladoAleks.setForeground(Color.WHITE);
		vladoAleks.setAlignmentX(SwingConstants.LEFT);

//		// set the centerLabel (calendarDate)
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
//		Date date = new Date();
//		String display = (dateFormat.format(date));
//		display = display.substring(0, 10);
//		Timer time = new Timer(60000, ) ;
//		calendar.setText(display);
//		calendar.setForeground(Color.WHITE);

		// add the 3 labels to TopBarPanel
		add(vladoAleks);
		add(calendar);
		add(time);
	}

	class HorlogeLabel extends JLabel implements ActionListener {
		public HorlogeLabel() {
			super("" + Calendar.getInstance());
			Timer t = new Timer(500, this);
			t.start();
		}

		public void actionPerformed(ActionEvent ae) {
			setForeground(Color.WHITE);
			setText(String.format("%tT", Calendar.getInstance()));
		}
	}

}
