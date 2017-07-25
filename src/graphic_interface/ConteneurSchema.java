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

	// variables gÈnÈrales
	private int typeSchema; // le type du schÈma : de 1 ‡ 6
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

	private Bouton b_simple_marche;
	private Bouton b_professionnelle;
	private Bouton b_mecaniste;
	private Bouton b_simple_centralisee;
	private Bouton b_entrepreneuriale;
	private Bouton b_annuler;

	private JLabel note_simple_marche;
	private JLabel note_professionnelle;
	private JLabel note_mecaniste;
	private JLabel note_simple_centralisee;
	private JLabel note_entrepreneuriale;

	private ActionBoutonSchema2 action;

	// cas 3

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
			Dimension dim_boutons = new Dimension(170,90);
			Dimension dim_label = new Dimension(60,60);
			action = new ActionBoutonSchema2(this);

			this.b_simple_marche = new Bouton("Structure\nSIMPLE DE MARCHE",dim_boutons);
			this.b_professionnelle = new Bouton("Structure\nPROFESSIONNELLE",dim_boutons);
			this.b_mecaniste = new Bouton("Structure\nMECANISTE",dim_boutons);
			this.b_simple_centralisee = new Bouton("Structure\nSIMPLE CENTRALISEE",dim_boutons);
			this.b_entrepreneuriale = new Bouton("Structure\nENTREPRENEURIALE",dim_boutons);
			this.b_annuler = new Bouton("R‡Z", new Dimension(120, 40));

			this.initialiserBoutonSchema2(this.b_entrepreneuriale);
			this.initialiserBoutonSchema2(this.b_simple_marche);
			this.initialiserBoutonSchema2(this.b_professionnelle);
			this.initialiserBoutonSchema2(this.b_mecaniste);
			this.initialiserBoutonSchema2(this.b_simple_centralisee);

			this.b_annuler.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					action.activerBouton(b_entrepreneuriale);
					action.activerBouton(b_simple_marche);
					action.activerBouton(b_professionnelle);
					action.activerBouton(b_mecaniste);
					action.activerBouton(b_simple_centralisee);
					action.setBoutonSelected(null);
					action.setSelected(false);
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
			
			this.initialiserLabelSchema2(note_entrepreneuriale, dim_label);
			this.initialiserLabelSchema2(note_mecaniste, dim_label);
			this.initialiserLabelSchema2(note_professionnelle, dim_label);
			this.initialiserLabelSchema2(note_simple_centralisee, dim_label);
			this.initialiserLabelSchema2(note_simple_marche, dim_label);

			this.layout.setHorizontalGroup(
					this.layout.createSequentialGroup()
					.addGap(5)
					.addComponent(b_annuler)
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
					.addComponent(b_annuler)
					);
			break;
		case 3:

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

	public int getTypeSchema()
	{
		return this.typeSchema;
	}

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

	public ActionBoutonSchema2 getAction()
	{
		return this.action;
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

	// METHODES //
	
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
	
	public void initialiserBoutonSchema2(Bouton b)
	{
		b.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
		b.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
		b.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
		b.updateCouleur();
		b.repaint();
		b.addActionListener(this.getAction());
	}
	
	public void initialiserLabelSchema2(JLabel label, Dimension dim_label)
	{
		label.setForeground(Color.WHITE);
		label.setPreferredSize(dim_label);
		label.setMaximumSize(dim_label);
		label.setMinimumSize(dim_label);
	}

}
