package Elements;

import javax.swing.JButton;

public abstract class TopBarButton extends JButton{
	
	public TopBarButton(){
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
