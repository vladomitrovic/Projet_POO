package Frame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class BasiqueFrame extends JFrame {

	public BasiqueFrame() {
		setPreferredSize(new Dimension(480, 800));
		setSize(480,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
	}

}
