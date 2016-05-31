package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class ContactButton extends JButton{
	
	
	
	public ContactButton(String text){
		

		setText(text);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		setHorizontalAlignment(SwingConstants.LEFT);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setPreferredSize(new Dimension(407, 50));
		
	}

}
