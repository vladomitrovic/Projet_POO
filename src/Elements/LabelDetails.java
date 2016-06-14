package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class LabelDetails extends JLabel {

	private Border lblBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
	private Font lblFont = new Font("Arial", Font.BOLD, 22);
	private Dimension lblSize = new Dimension(280, 25);

	public LabelDetails(String text) {
		setText(text);
		setPreferredSize(lblSize);
		setFont(lblFont);
		setBorder(lblBorder);
	}

}
