package Elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Frame.Contact.Contact_Carnet;;

public class ContactButton extends JButton {

	public ContactButton(String text) {

		setText(text);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		setHorizontalAlignment(SwingConstants.LEFT);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setPreferredSize(new Dimension(400, 50));
		addMouseListener(new ColorizeButton());

	}
	
	
class ColorizeButton extends MouseAdapter{
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			setContentAreaFilled(true);
			((JButton)e.getSource()).setBackground( new Color(200, 200, 255));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseExited(e);
			setContentAreaFilled(false);

			


		}
	}

}
