package Frame.Contact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Elements.BackButton;
import Elements.PhotoButton;
import Elements.TopTitleBar;
import Elements.WrapLayout;
import Frame.Galerie.Galerie_Accueil;
import Galerie.Galerie;
import Galerie.Photo;

public class Contact_Image extends JPanel {
	
	private JPanel imagesPanel=new JPanel();
	private JScrollPane scrollPane=new JScrollPane(imagesPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private TopTitleBar topPanel=new TopTitleBar(new BackButton(), new Return_Click(), "", Color.GRAY);
	private Galerie galerie=new Galerie();
	private Contact_Details top;
	private int id;
	
	public Contact_Image(int id, Contact_Details top){
		this.id=id;
		this.top=top;
		setLayout(new BorderLayout());
		
		add(topPanel, BorderLayout.NORTH);
		add(scrollPane);
		
		imagesPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 5, 5));
		
		
		galerie.createPhotoContact(Contact_Image.this, new Galerie_Accueil());
		
		
	}
	
	
	public void addButtonsToPanel(ArrayList<PhotoButton> photoButtons, int index){
		
		imagesPanel.add(photoButtons.get(index));
		photoButtons.get(index).addActionListener(new Choose_Click());
		
	}
	
	class Choose_Click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Photo photo= (Photo) button.getIcon();
			top.getCarnet().getCarnet().get(id).setPhoto(photo.getPath());
			System.out.println("Choose pic");
			top.getCarnet().serialize();
			top.remove(Contact_Image.this);
			top.setPicture(photo.getPath());

		}
		
	}
	
	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.remove(Contact_Image.this);
		}

	}
	

}
