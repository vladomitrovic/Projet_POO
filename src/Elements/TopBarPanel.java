package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TopBarPanel extends JPanel {

	private JLabel vladoAleks = new JLabel("Vlado et Aleks");
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
		vladoAleks.setHorizontalAlignment(SwingConstants.CENTER);
		time.setHorizontalAlignment(SwingConstants.CENTER);

		// add the 3 labels to TopBarPanel
		add(vladoAleks);
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



