package graphic_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JLabel;

public class BoutonEtude extends ConteneurAvecImage {

	public static final int LARGEUR = 697;
	public static final int HAUTEUR = 80;
	
	// VARIABLES INSTANCE //
	
	private Theme theme;
	private int id;
	private JLabel conteneur_nom;
	private String nom = "";
	private Bouton editer;
	private Bouton presenter;
	private Fenetre fenetre;
	
	// CONTRUCTEURS //

	public BoutonEtude(Theme theme, String nom,Fenetre fenetre) {
		super(LARGEUR, HAUTEUR, theme.getSelectionEtude());
		this.theme = theme;
		this.nom = nom/*+" Bonjour je suis Hugo et j'habite à Villeneuve les Béziers, une ville bien pourrie askip."*/;	
		this.conteneur_nom = new JLabel();
		this.conteneur_nom.setOpaque(false);
		this.conteneur_nom.setText(this.nom);
		this.conteneur_nom.setPreferredSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setMinimumSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setMaximumSize(new Dimension((int)(LARGEUR / 2), HAUTEUR-20));
		this.conteneur_nom.setFont(this.getTheme().getPolice());
		this.conteneur_nom.setForeground(this.getTheme().getCouleurTexte());
		this.conteneur_nom.setToolTipText(this.getNom());
		this.editer = new Bouton("Modifier", new Dimension(100, 50), theme);
		this.presenter = new Bouton("Présentation", new Dimension(100, 50), theme);
		this.fenetre=fenetre;
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addComponent(this.conteneur_nom)
				.addGap(50)
				.addComponent(this.editer)
				.addGap(30)
				.addComponent(this.presenter)
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup()
				.addComponent(this.conteneur_nom)
				.addComponent(this.editer)
				.addComponent(this.presenter)
				);		
		this.initialiserBoutons();
	}


	// GETTERS //
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Bouton getEditer() {
		return editer;
	}

	public Bouton getPresenter() {
		return presenter;
	}
	
	public Theme getTheme()
	{
		return this.theme;
	}
	
	public JLabel getConteneurNom()
	{
		return this.conteneur_nom;
	}
	
	public Fenetre getFenetre(){
		return this.fenetre;
	}

	// SETTERS //
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEditer(Bouton editer) {
		this.editer = editer;
	}

	public void setPresenter(Bouton presenter) {
		this.presenter = presenter;
	}
	
	// METHODES //

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(this.getTheme().getCouleurTexte());
		g2d.drawImage(this.getImg(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public void initialiserBoutons(){
		this.getEditer().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String contraintes="saves"+File.separator+getNom()+File.separator+"Contraintes.txt";
				Schema1 schema1=null;
				try {
					BufferedReader aLire_1 = new BufferedReader(new FileReader(contraintes));
					Pourcentage p_1=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_2=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_3=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_4=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_5=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_6=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_7=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					Pourcentage p_8=new Pourcentage(Integer.valueOf(aLire_1.readLine()));
					aLire_1.close();
					schema1=new Schema1(p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8);
				}
				catch (IOException e1){
					System.out.println("Une operation sur le fichier Contraintes a leve l'exception "+e1);
				}
				
				String structures="saves"+File.separator+getNom()+File.separator+"Structures.txt";
				Schema2 schema2=null;
				try {
					BufferedReader aLire_2 = new BufferedReader(new FileReader(structures));
					Structure st_1=Structure.getByName(aLire_2.readLine());
					Structure st_2=Structure.getByName(aLire_2.readLine());
					ElementNote<Structure>[] mtn_notees = new ElementNote[4];
					ElementNote<Structure>[] apr_notees = new ElementNote[4];
					for(int i=0;i<4;i++){
						mtn_notees[i]=new ElementNote(Structure.getByName(aLire_2.readLine()),Integer.valueOf(aLire_2.readLine()));
						apr_notees[i]=new ElementNote(Structure.getByName(aLire_2.readLine()),Integer.valueOf(aLire_2.readLine()));
					}
					aLire_2.close();
					schema2=new Schema2(st_1,st_2,mtn_notees,apr_notees);
					
				}
				catch (IOException e2){
					System.out.println("Une operation sur le fichier Structures a leve l'exception "+e2);
				}
				
				String organisations="saves"+File.separator+getNom()+File.separator+"Organisations.txt";
				Schema3 schema3=null;
				try {
					BufferedReader aLire_3 = new BufferedReader(new FileReader(organisations));
					Organisation org_1=Organisation.getByName(aLire_3.readLine());
					Organisation org_2=Organisation.getByName(aLire_3.readLine());
					ElementNote<Organisation>[] mtn_notees = new ElementNote[4];
					ElementNote<Organisation>[] apr_notees = new ElementNote[4];
					for(int i=0;i<4;i++){
						mtn_notees[i]=new ElementNote(Organisation.getByName(aLire_3.readLine()),Integer.valueOf(aLire_3.readLine()));
						apr_notees[i]=new ElementNote(Organisation.getByName(aLire_3.readLine()),Integer.valueOf(aLire_3.readLine()));
					}
					aLire_3.close();
					schema3=new Schema3(org_1,org_2,mtn_notees,apr_notees);
				}
				catch (IOException e3){
					System.out.println("Une operation sur le fichier Organisations a leve l'exception "+e3);
				}
				
				String relations="saves"+File.separator+getNom()+File.separator+"Relations.txt";
				Schema4 schema4=null;
				try {
					BufferedReader aLire_4 = new BufferedReader(new FileReader(relations));
					Consensus cons_1=new Consensus(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
					Consensus cons_2=new Consensus(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
					Negociation nego_1=new Negociation(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
					Negociation nego_2=new Negociation(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
					Opposition opp_1=new Opposition(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
					Opposition opp_2=new Opposition(new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())),new Pourcentage(Integer.valueOf(aLire_4.readLine())));
					
					aLire_4.close();
					schema4=new Schema4(cons_1,cons_2,nego_1,nego_2,opp_1,opp_2);
					
				}
				catch (IOException e4){
					System.out.println("Une operation sur le fichier Relations a leve l'exception "+e4);
				}
				
				String identites="saves"+File.separator+getNom()+File.separator+"Identites.txt";
				Schema5 schema5=null;
				try {
					BufferedReader aLire_5 = new BufferedReader(new FileReader(identites));
					Pourcentage p_1=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_2=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_3=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_4=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_5=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_6=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_7=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_8=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_9=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_10=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_11=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					Pourcentage p_12=new Pourcentage(Integer.valueOf(aLire_5.readLine()));
					schema5=new Schema5(p_1,p_2,p_3,p_4,p_5,p_6,p_7,p_8,p_9,p_10,p_11,p_12);
					aLire_5.close();
					
				}
				catch (IOException e5){
					System.out.println("Une operation sur le fichier Identites a leve l'exception "+e5);
				}
				
				String mondes="saves"+File.separator+getNom()+File.separator+"Mondes.txt";
				Schema6 schema6=null;
				try {
					BufferedReader aLire_6 = new BufferedReader(new FileReader(mondes));
					Entreprise e_1=Entreprise.getByName(aLire_6.readLine());
					Entreprise e_2=Entreprise.getByName(aLire_6.readLine());
					
					aLire_6.close();
					schema6=new Schema6(e_1,e_2);
					
				}
				catch (IOException e6){
					System.out.println("Une operation sur le fichier Mondes a leve l'exception "+e6);
				}
				
				Etude etude=new Etude(schema1,schema2,schema3,schema4,schema5,schema6);
				ConteneurAvecImage conteneur_principal = new ConteneurAvecImage(0,0,getTheme().getBackground());
				ConteneurListeEtudes liste = new ConteneurListeEtudes(getFenetre().getSize(), getTheme(), conteneur_principal, getFenetre());
				conteneur_principal.setTaille(getFenetre().getSize());
				ConteneurNouvelleEtude nouvelle_etude = new ConteneurNouvelleEtude(getFenetre().getSize(), getTheme(), liste, getFenetre(),getNom(),etude);
				getFenetre().setConteneur(nouvelle_etude,"Projet MiND - "+getNom());
			}
			
		});
		

		this.getPresenter().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//méthode à ajouter pour le powerpoint
			}
			
		});
	}

}
