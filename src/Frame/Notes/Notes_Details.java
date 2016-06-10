package Frame.Notes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.StyleConstants;

import Elements.BackButton;
import Elements.OkButton;
import Elements.TopTitleBar;
import Elements.TrashButton;
import Galerie.Photo;

public class Notes_Details extends JPanel {

	private TopTitleBar titleBar = new TopTitleBar(new BackButton(), null, "", new TrashButton(), null,
			new Color(252, 105, 17));
	private JTextArea textArea = new JTextArea();
	private OkButton okButton = new OkButton();
	private Photo photo = new Photo("PicturesElements/fondEcranNote.png");

	public Notes_Details(String texte) {
		
		//set layout 
		setLayout(new BorderLayout());
		
		//set textArea
		textArea.setOpaque(false);
		textArea.setPreferredSize(new Dimension(480, 800));
		textArea.setText(texte);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setMargin(new Insets(0, 80, 20, 20));
		textArea.setFont(new Font("Arial", Font.PLAIN, 35));
		
		//add to panel
		add(titleBar, BorderLayout.NORTH);
		add(textArea);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

	}

}
