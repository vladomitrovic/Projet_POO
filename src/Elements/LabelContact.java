package Elements;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

public class LabelContact extends JTextField{
	
	private Font cLblFont = new Font("Arial", Font.PLAIN, 20);
	private Dimension clblSize = new Dimension(280, 25);
	
	public LabelContact(){
		setPreferredSize(clblSize);
		setFont(cLblFont);
		setEditable(false);
		setBorder(null);
	}

}
