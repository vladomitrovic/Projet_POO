package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Galerie.Photo;

public class TopBarPanel extends JPanel {

	private JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private Photo backPhoto = new Photo("Pictures/back.png");
	private JButton backButton = new JButton(backPhoto);
	private Photo addPhoto = new Photo("Pictures/plus-button.png");
	private JButton addButton = new JButton(addPhoto);
	private JPanel centerPanel;
	private JPanel panelLauncher;

	public TopBarPanel(JPanel centerPanel, JPanel panelLauncher) {
		this.centerPanel = centerPanel;
		this.panelLauncher = panelLauncher;
		setLayout(new GridLayout(1, 2));
		leftPanel.setBackground(Color.DARK_GRAY);
		rightPanel.setBackground(Color.DARK_GRAY);

		// set backButton
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setOpaque(false);
		backButton.addActionListener(new BackDesktop_Click());
		backButton.setPreferredSize(new Dimension(24, 24));

		// set addButton
		addButton.setBorderPainted(false);
		addButton.setContentAreaFilled(false);
		addButton.setFocusPainted(false);
		addButton.setOpaque(false);
		addButton.setPreferredSize(new Dimension(24, 24));

		if (centerPanel instanceof MainPanelGalerie) {
//			addButton.addActionListener(new Add_PhotoClick());
		} else if (centerPanel instanceof MainPanelCarnet) {
			// addButton.addActionListener();
		}

		// addButons to leftPanel

		leftPanel.add(backButton, FlowLayout.LEFT);
		rightPanel.add(addButton);

		// add to TopBarPanel
		add(leftPanel);
		add(rightPanel);

	}

	class BackDesktop_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			centerPanel.setVisible(false);
			panelLauncher.setVisible(true);
		}

	}

}
