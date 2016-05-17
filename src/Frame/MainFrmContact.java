package Frame;

import java.awt.*;

import javax.swing.*;

public class MainFrmContact extends BasiqueFrame{
	
	JLabel nom=new JLabel("Nom :");
	JLabel prenom=new JLabel("Prénom :");
	JLabel noTel=new JLabel("Tél : ");
	
	JLabel nomC=new JLabel("");
	JLabel prenomC=new JLabel("");
	JLabel noTelC=new JLabel("");
	
	
	JPanel panel=new JPanel();
	
	public MainFrmContact(){
		add(panel);
		
		panel.setLayout(new GridLayout(3,2));
		
		panel.add(nom);
		panel.add(nomC);
		
		panel.add(prenom);
		panel.add(prenomC);
		
		panel.add(noTel);
		panel.add(noTelC);
		
		
	}
	
	
	

}
