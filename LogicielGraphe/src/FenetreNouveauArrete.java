import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FenetreNouveauArrete extends JFrame implements ActionListener, ListSelectionListener{
	
	private JPanel pCentre, pHaut, pBas;
	private JButton ok, annuler;
	private Graphique graphe;
	private JLabel lNom, lSommetUn, lSommetDeux;
	private JTextField tNom;
	private JList jlSommetUn, jlSommetDeux;
	private JScrollPane scSommetUn, scSommetDeux;
	private String[] tabSommetUn, tabSommetDeux;
	
	private Sommet sUn, sDeux;
	
	public FenetreNouveauArrete( Graphique graphe ){
		setSize(350,200);
		setTitle("Nouvelle Arrete");
		this.graphe = graphe;
		
		this.pHaut = new JPanel( new GridLayout(1,2) );
		this.lNom = new JLabel("Nom");
		this.tNom = new JTextField();
		this.pHaut.add( this.lNom );
		this.pHaut.add( this.tNom );
		add( this.pHaut, "North" );
		
		this.pCentre = new JPanel( new GridLayout(1,4) );
		this.lSommetUn = new JLabel( "Sommet Un" );
		this.lSommetDeux = new JLabel( "Sommet Deux" );
		this.tabSommetUn = new String[this.graphe.getAlSommet().size()];
		this.tabSommetDeux = new String[this.graphe.getAlSommet().size()];
		
		for( int i = 0; i < this.graphe.getAlSommet().size(); i++ ){
			this.tabSommetUn[i] = this.graphe.getAlSommet().get(i).getNom();
		}
		
		for( int i = 0; i < this.graphe.getAlSommet().size(); i++ ){
			this.tabSommetDeux[i] = this.graphe.getAlSommet().get(i).getNom();
		}
		
		this.jlSommetUn = new JList( this.tabSommetUn );
		this.jlSommetDeux = new JList( this.tabSommetDeux );
		this.jlSommetUn.addListSelectionListener(this);
		this.jlSommetDeux.addListSelectionListener(this);
		this.scSommetUn = new JScrollPane( this.jlSommetUn );
		this.scSommetDeux = new JScrollPane( this.jlSommetDeux );
		
		this.pCentre.add( this.lSommetUn );
		this.pCentre.add( this.scSommetUn );
		this.pCentre.add( this.lSommetDeux );
		this.pCentre.add( this.scSommetDeux );
		add( this.pCentre, "Center" );
		
		this.pBas = new JPanel( new GridLayout(1,2) );
		this.ok = new JButton("Ok");
		this.annuler = new JButton("Annuler");
		this.pBas.add( this.ok );
		this.pBas.add( this.annuler );
		this.ok.addActionListener(this);
		this.annuler.addActionListener(this);
		add( this.pBas, "South" );
		
		//pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == this.ok ){
			this.graphe.createArrete( this.sUn, this.sDeux );
			//this.graphe.addSommet( new Sommet( this.tNom.getText(), Integer.parseInt(this.tX.getText()), Integer.parseInt(this.tY.getText()), Integer.parseInt(this.tWidth.getText()), Integer.parseInt(this.tHeight.getText()) ) );
			System.out.println("Lol");
			this.dispose();
		}
		if( e.getSource() == this.annuler ){
			this.dispose();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		
		if( e.getSource() == this.jlSommetUn ){
			this.sUn = this.graphe.getAlSommet().get( this.jlSommetUn.getSelectedIndex() );
			System.out.println( this.sUn.getNom() );
		}
		
		if( e.getSource() == this.jlSommetDeux ){
			this.sDeux = this.graphe.getAlSommet().get( this.jlSommetDeux.getSelectedIndex() );
			System.out.println( this.sDeux.getNom() );
		}
		
	}
	
}