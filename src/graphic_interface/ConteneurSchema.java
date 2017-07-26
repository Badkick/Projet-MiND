package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class ConteneurSchema extends ConteneurAvecImage {

	public static final Dimension DIMENSION_TEXT_FIELD = new Dimension(45,30);

	// VARIABLES INSTANCE //

	// variables générales
	private int typeSchema; // le type du schéma : de 1 à 6
	private GroupLayout layout;

	// cas 1

	// create a format for displaying percentages (with %-sign)
	private NumberFormat percentDisplayFormat = NumberFormat.getPercentInstance();

	// create a format for editing percentages (without %-sign)
	private NumberFormat percentEditFormat = NumberFormat.getNumberInstance();

	// create a formatter for editing percentages - input will be transformed to percentages (eg. 50 -> 0.5)
	private NumberFormatter percentEditFormatter = new NumberFormatter(percentEditFormat) {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public String valueToString(Object o) throws ParseException {
			Number number = (Number) o;
			if (number != null) {
				double d = number.doubleValue() * 100.0;
				number = new Double(d);
			}
			return super.valueToString(number);
		}

		@Override
		public Object stringToValue(String s) throws ParseException {
			Number number = (Number) super.stringToValue(s);
			if (number != null) {
				double d = number.doubleValue() / 100.0;
				number = new Double(d);
			}
			return number;
		}
	};


	private JFormattedTextField contr_tech = new JFormattedTextField(
			new DefaultFormatterFactory(
					new NumberFormatter(percentDisplayFormat),
					new NumberFormatter(percentDisplayFormat),
					percentEditFormatter));
	private JFormattedTextField press_envir = new JFormattedTextField(
			new DefaultFormatterFactory(
					new NumberFormatter(percentDisplayFormat),
					new NumberFormatter(percentDisplayFormat),
					percentEditFormatter));
	private JFormattedTextField etabl_prot = new JFormattedTextField(
			new DefaultFormatterFactory(
					new NumberFormatter(percentDisplayFormat),
					new NumberFormatter(percentDisplayFormat),
					percentEditFormatter));
	private JFormattedTextField mena_mar = new JFormattedTextField(
			new DefaultFormatterFactory(
					new NumberFormatter(percentDisplayFormat),
					new NumberFormatter(percentDisplayFormat),
					percentEditFormatter));

	// cas 2
	
	Dimension dim_boutons_schemas23 = new Dimension(170,90);
	Dimension dim_labels_schemas23 = new Dimension(60,60);

	private Bouton b_simple_marche;
	private Bouton b_professionnelle;
	private Bouton b_mecaniste;
	private Bouton b_simple_centralisee;
	private Bouton b_entrepreneuriale;
	private Bouton b_annuler2;

	private JLabel note_simple_marche;
	private JLabel note_professionnelle;
	private JLabel note_mecaniste;
	private JLabel note_simple_centralisee;
	private JLabel note_entrepreneuriale;

	private ActionBoutonSchemas23 action2;

	// cas 3
	
	private Bouton b_rationnelle;
	private Bouton b_artisanale;
	private Bouton b_personnalisee;
	private Bouton b_process;
	private Bouton b_flexible;
	private Bouton b_annuler3;
	
	private JLabel note_rationnelle;
	private JLabel note_artisanale;
	private JLabel note_personnalisee;
	private JLabel note_process;
	private JLabel note_flexible;
	
	private ActionBoutonSchemas23 action3;

	// cas 4

	// cas 5

	// cas 6


	// CONSTRUCTEURS //

	public ConteneurSchema(int type, int width, int height) {
		super(width,height,FenetreAccueil.theme.getSchemas()[type-1]);
		this.typeSchema = type;
		this.layout = new GroupLayout(this);
		this.setLayout(layout);

		switch(type)
		{
		case 1:		
			this.percentDisplayFormat.setParseIntegerOnly(false);
			this.percentDisplayFormat.setMaximumFractionDigits(1);
			this.percentEditFormat.setParseIntegerOnly(false);
			this.percentEditFormat.setMaximumFractionDigits(1);
			this.percentEditFormatter.setMinimum(0D);
			this.percentEditFormatter.setMaximum(100D);

			this.contr_tech.setHorizontalAlignment(JTextField.CENTER);
			this.press_envir.setHorizontalAlignment(JTextField.CENTER);
			this.etabl_prot.setHorizontalAlignment(JTextField.CENTER);
			this.mena_mar.setHorizontalAlignment(JTextField.CENTER);

			this.contr_tech.setPreferredSize(DIMENSION_TEXT_FIELD);
			this.press_envir.setPreferredSize(DIMENSION_TEXT_FIELD);
			this.etabl_prot.setPreferredSize(DIMENSION_TEXT_FIELD);
			this.mena_mar.setPreferredSize(DIMENSION_TEXT_FIELD);

			this.contr_tech.setMinimumSize(DIMENSION_TEXT_FIELD);
			this.press_envir.setMinimumSize(DIMENSION_TEXT_FIELD);
			this.etabl_prot.setMinimumSize(DIMENSION_TEXT_FIELD);
			this.mena_mar.setMinimumSize(DIMENSION_TEXT_FIELD);

			this.contr_tech.setMaximumSize(DIMENSION_TEXT_FIELD);
			this.press_envir.setMaximumSize(DIMENSION_TEXT_FIELD);
			this.etabl_prot.setMaximumSize(DIMENSION_TEXT_FIELD);
			this.mena_mar.setMaximumSize(DIMENSION_TEXT_FIELD);

			this.layout.setHorizontalGroup(
					this.layout.createSequentialGroup()
					.addGap(430)
					.addGroup(this.layout.createParallelGroup()
							.addComponent(contr_tech)
							.addGap(100)
							.addComponent(etabl_prot)
							)
					.addGap(345)
					.addGroup(this.layout.createParallelGroup()
							.addComponent(mena_mar)
							.addGap(100)
							.addComponent(press_envir)
							)
					);

			this.layout.setVerticalGroup(
					this.layout.createSequentialGroup()
					.addGap(107)
					.addGroup(this.layout.createParallelGroup()
							.addComponent(contr_tech)
							.addGap(100)
							.addComponent(press_envir)
							)
					.addGap(110)
					.addGroup(this.layout.createParallelGroup()
							.addComponent(etabl_prot)
							.addGap(100)
							.addComponent(mena_mar)
							)
					);
			break;
		case 2:
			action2 = new ActionBoutonSchemas23(this);

			this.b_simple_marche = new Bouton("Structure\nSIMPLE DE MARCHE",dim_boutons_schemas23);
			this.b_professionnelle = new Bouton("Structure\nPROFESSIONNELLE",dim_boutons_schemas23);
			this.b_mecaniste = new Bouton("Structure\nMECANISTE",dim_boutons_schemas23);
			this.b_simple_centralisee = new Bouton("Structure\nSIMPLE CENTRALISEE",dim_boutons_schemas23);
			this.b_entrepreneuriale = new Bouton("Structure\nENTREPRENEURIALE",dim_boutons_schemas23);
			this.b_annuler2 = new Bouton("RàZ", new Dimension(120, 40));

			this.initialiserBoutonSchemas23(this.b_entrepreneuriale,action2);
			this.initialiserBoutonSchemas23(this.b_simple_marche,action2);
			this.initialiserBoutonSchemas23(this.b_professionnelle,action2);
			this.initialiserBoutonSchemas23(this.b_mecaniste,action2);
			this.initialiserBoutonSchemas23(this.b_simple_centralisee,action2);

			this.b_annuler2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					action2.activerBouton(b_entrepreneuriale);
					action2.activerBouton(b_simple_marche);
					action2.activerBouton(b_professionnelle);
					action2.activerBouton(b_mecaniste);
					action2.activerBouton(b_simple_centralisee);
					action2.setBoutonSelected(null);
					action2.setSelected(false);
					note_entrepreneuriale.setText("");
					note_simple_marche.setText("");
					note_professionnelle.setText("");
					note_mecaniste.setText("");
					note_simple_centralisee.setText("");
				}
			});

			this.note_entrepreneuriale = new JLabel();
			this.note_mecaniste = new JLabel();
			this.note_professionnelle = new JLabel();
			this.note_simple_centralisee = new JLabel();
			this.note_simple_marche = new JLabel();
			
			this.initialiserLabelSchemas23(note_entrepreneuriale, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_mecaniste, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_professionnelle, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_simple_centralisee, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_simple_marche, dim_labels_schemas23);

			this.layout.setHorizontalGroup(
					this.layout.createSequentialGroup()
					.addGap(5)
					.addComponent(b_annuler2)
					.addGap(80)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addComponent(b_mecaniste)
									.addGap(10)
									.addComponent(note_mecaniste)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addComponent(b_simple_centralisee)
									.addGap(10)
									.addComponent(note_simple_centralisee)
									)
							)
					.addGap(30)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addGap(230)
									.addComponent(b_simple_marche)
									.addGap(10)
									.addComponent(note_simple_marche)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addComponent(b_professionnelle)
									.addGap(10)
									.addComponent(note_professionnelle)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addGap(140)
									.addComponent(b_entrepreneuriale)
									.addGap(10)
									.addComponent(note_entrepreneuriale)
									)
							)
					);

			this.layout.setVerticalGroup(
					this.layout.createSequentialGroup()
					.addGap(35)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addGap(50)
									.addGroup(this.layout.createParallelGroup()
											.addComponent(b_professionnelle)
											.addGroup(this.layout.createSequentialGroup()
													.addGap(12)
													.addComponent(note_professionnelle)
													)
											)
									)
							.addGroup(this.layout.createParallelGroup()
									.addComponent(b_simple_marche)
									.addGroup(this.layout.createSequentialGroup()
											.addGap(12)
											.addComponent(note_simple_marche)
											)
									)
							)
					.addGap(70)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addGroup(this.layout.createParallelGroup()
											.addComponent(b_mecaniste)
											.addGroup(this.layout.createSequentialGroup()
													.addGap(12)
													.addComponent(note_mecaniste)
													)
											)
									.addGap(20)
									.addGroup(this.layout.createParallelGroup()
											.addComponent(b_simple_centralisee)
											.addGroup(this.layout.createSequentialGroup()
													.addGap(12)
													.addComponent(note_simple_centralisee)
													)
											)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addGap(30)
									.addGroup(this.layout.createParallelGroup()
											.addComponent(b_entrepreneuriale)
											.addGroup(this.layout.createSequentialGroup()
													.addGap(12)
													.addComponent(note_entrepreneuriale)
													)
											)
									)
							)
					.addGap(50)
					.addComponent(b_annuler2)
					);
			break;
		case 3:
			action3 = new ActionBoutonSchemas23(this);

			this.b_rationnelle = new Bouton("Organisation\nRATIONNELLE",dim_boutons_schemas23);
			this.b_artisanale = new Bouton("Organisation\nARTISANALE",dim_boutons_schemas23);
			this.b_personnalisee = new Bouton("Organisation\nPERSONNALISEE",dim_boutons_schemas23);
			this.b_process = new Bouton("Organisation\nPROFESSIONNELLE DE PROCESS",dim_boutons_schemas23);
			this.b_flexible = new Bouton("Organisation\nFLEXIBLE",dim_boutons_schemas23);
			this.b_annuler3 = new Bouton("RàZ", new Dimension(120, 40));

			this.initialiserBoutonSchemas23(this.b_rationnelle,action3);
			this.initialiserBoutonSchemas23(this.b_artisanale,action3);
			this.initialiserBoutonSchemas23(this.b_personnalisee,action3);
			this.initialiserBoutonSchemas23(this.b_process,action3);
			this.initialiserBoutonSchemas23(this.b_flexible,action3);

			this.b_annuler3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					action3.activerBouton(b_rationnelle);
					action3.activerBouton(b_artisanale);
					action3.activerBouton(b_personnalisee);
					action3.activerBouton(b_process);
					action3.activerBouton(b_flexible);
					action3.setBoutonSelected(null);
					action3.setSelected(false);
					note_rationnelle.setText("");
					note_artisanale.setText("");
					note_personnalisee.setText("");
					note_process.setText("");
					note_flexible.setText("");
				}
			});

			this.note_rationnelle = new JLabel();
			this.note_artisanale = new JLabel();
			this.note_personnalisee = new JLabel();
			this.note_process = new JLabel();
			this.note_flexible = new JLabel();
			
			this.initialiserLabelSchemas23(note_rationnelle, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_artisanale, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_personnalisee, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_process, dim_labels_schemas23);
			this.initialiserLabelSchemas23(note_flexible, dim_labels_schemas23);
			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		default:
			System.out.println("Mauvais cas : "+type);
			break;
		}
	}

	public ConteneurSchema(int type, Dimension dim) {
		this(type,(int)dim.getWidth(),(int)dim.getHeight());		
	}

	// GETTERS //
	
	// généraux //

	public int getTypeSchema()
	{
		return this.typeSchema;
	}
	
	// schéma 1 //

	public String getTextContr_tech()
	{
		return this.contr_tech.getText();
	}

	public String getTextEtabl_prot()
	{
		return this.etabl_prot.getText();
	}

	public String getTextMena_mar()
	{
		return this.mena_mar.getText();
	}

	public String getTextPress_envir()
	{
		return this.press_envir.getText();
	}

	public Pourcentage getContr_tech()
	{
		try {
			return new Pourcentage(Float.parseFloat(this.getTextContr_tech().substring(0, this.getTextContr_tech().length()-2).replace(',', '.')));
		} catch (Exception e) {
			return null;
		}
	}

	public Pourcentage getEtabl_prot()
	{
		try {
			return new Pourcentage(Float.parseFloat(this.getTextEtabl_prot().substring(0, this.getTextEtabl_prot().length()-2).replace(',', '.')));
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}
	}

	public Pourcentage getMena_mar()
	{
		try {
			return new Pourcentage(Float.parseFloat(this.getTextMena_mar().substring(0, this.getTextMena_mar().length()-2).replace(',', '.')));
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}
	}

	public Pourcentage getPress_envir()
	{
		try {
			return new Pourcentage(Float.parseFloat(this.getTextPress_envir().substring(0, this.getTextPress_envir().length()-2).replace(',', '.')));
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	// schéma 2 //

	public Bouton getB_simple_marche() {
		return b_simple_marche;
	}

	public Bouton getB_professionnelle() {
		return b_professionnelle;
	}

	public Bouton getB_mecaniste() {
		return b_mecaniste;
	}

	public Bouton getB_simple_centralisee() {
		return b_simple_centralisee;
	}

	public Bouton getB_entrepreneuriale() {
		return b_entrepreneuriale;
	}
	
	public ActionBoutonSchemas23 getAction2()
	{
		return this.action2;
	}
	
	public JLabel getLabel_simple_marche() {
		return note_simple_marche;
	}

	public JLabel getLabel_professionnelle() {
		return note_professionnelle;
	}

	public JLabel getLabel_mecaniste() {
		return note_mecaniste;
	}

	public JLabel getLabel_simple_centralisee() {
		return note_simple_centralisee;
	}

	public JLabel getLabel_entrepreneuriale() {
		return note_entrepreneuriale;
	}
	
	public int getNote_simple_marche()
	{
		try{return Integer.valueOf(this.getLabel_simple_marche().getText().substring(0, this.getLabel_simple_marche().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_professionnelle()
	{
		try{return Integer.valueOf(this.getLabel_professionnelle().getText().substring(0, this.getLabel_professionnelle().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_mecaniste()
	{
		try{return Integer.valueOf(this.getLabel_mecaniste().getText().substring(0, this.getLabel_mecaniste().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_simple_centralisee()
	{
		try{return Integer.valueOf(this.getLabel_simple_centralisee().getText().substring(0, this.getLabel_simple_centralisee().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_entrepreneuriale()
	{
		try{return Integer.valueOf(this.getLabel_entrepreneuriale().getText().substring(0, this.getLabel_entrepreneuriale().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	// schéma 3 //

	public Bouton getB_artisanale() {
		return b_artisanale;
	}

	public Bouton getB_personnalisee() {
		return b_personnalisee;
	}

	public Bouton getB_process() {
		return b_process;
	}

	public Bouton getB_flexible() {
		return b_flexible;
	}

	public Bouton getB_rationnelle() {
		return b_rationnelle;
	}
	
	public ActionBoutonSchemas23 getAction3()
	{
		return this.action3;
	}
	
	public JLabel getLabel_rationnelle() {
		return note_rationnelle;
	}

	public JLabel getLabel_artisanale() {
		return note_artisanale;
	}

	public JLabel getLabel_personnalisee() {
		return note_personnalisee;
	}

	public JLabel getLabel_process() {
		return note_process;
	}

	public JLabel getLabel_flexible() {
		return note_flexible;
	}
	
	public int getNote_rationnelle()
	{
		try{return Integer.valueOf(this.getLabel_rationnelle().getText().substring(0, this.getLabel_rationnelle().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_artisanale()
	{
		try{return Integer.valueOf(this.getLabel_artisanale().getText().substring(0, this.getLabel_artisanale().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_personnalisee()
	{
		try{return Integer.valueOf(this.getLabel_personnalisee().getText().substring(0, this.getLabel_personnalisee().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_process()
	{
		try{return Integer.valueOf(this.getLabel_process().getText().substring(0, this.getLabel_process().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}
	
	public int getNote_flexible()
	{
		try{return Integer.valueOf(this.getLabel_flexible().getText().substring(0, this.getLabel_flexible().getText().length()-5));} catch(StringIndexOutOfBoundsException e) {return Integer.MAX_VALUE;}
	}

	// SETTERS //
	
	// schéma 1 //
	
	public void setContr_tech(Pourcentage p){
		this.contr_tech.setValue(p.get()/100);
	}
	
	public void setEtabl_prot(Pourcentage p){
		this.etabl_prot.setValue(p.get()/100);
	}
	
	public void setMena_mar(Pourcentage p){
		this.mena_mar.setValue(p.get()/100);
	}
	
	public void setPress_envir(Pourcentage p){
		this.press_envir.setValue(p.get()/100);
	}
	
	// schéma 2 //

	public void setNote_simple_marche(int note)
	{
		this.getLabel_simple_marche().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_professionnelle(int note)
	{
		this.getLabel_professionnelle().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_mecaniste(int note)
	{
		this.getLabel_mecaniste().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_simple_centralisee(int note)
	{
		this.getLabel_simple_centralisee().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_entrepreneuriale(int note)
	{
		this.getLabel_entrepreneuriale().setText(String.valueOf(note)+" / 10");
	}
	
	// schéma 3 //
	
	public void setNote(Bouton b, int note)
	{
		String nom = b.getName();
		
		switch(nom)
		{
		case "Structure\nSIMPLE DE MARCHE":
			this.setNote_simple_marche(note);
			break;
		case "Structure\nPROFESSIONNELLE":
			this.setNote_professionnelle(note);
			break;
		case "Structure\nMECANISTE":
			this.setNote_mecaniste(note);
			break;
		case "Structure\nSIMPLE CENTRALISEE":
			this.setNote_simple_centralisee(note);
			break;
		case "Structure\nENTREPRENEURIALE":
			this.setNote_entrepreneuriale(note);
			break;
		}
	}
	
	// METHODES //
	
	public void initialiserBoutonSchemas23(Bouton b, ActionBoutonSchemas23 action)
	{
		b.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
		b.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
		b.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
		b.updateCouleur();
		b.repaint();
		b.addActionListener(action);
	}
	
	public void initialiserLabelSchemas23(JLabel label, Dimension dim_label)
	{
		label.setForeground(Color.WHITE);
		label.setPreferredSize(dim_label);
		label.setMaximumSize(dim_label);
		label.setMinimumSize(dim_label);
	}

}
