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

			this.b_entrepreneuriale.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
			this.b_entrepreneuriale.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
			this.b_entrepreneuriale.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
			this.b_entrepreneuriale.setCouleurTexte(Color.white);
			this.b_entrepreneuriale.updateCouleur();
			this.b_entrepreneuriale.repaint();
			this.b_entrepreneuriale.addActionListener(action);

			this.b_simple_marche.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
			this.b_simple_marche.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
			this.b_simple_marche.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
			this.b_simple_marche.setCouleurTexte(Color.white);
			this.b_simple_marche.updateCouleur();
			this.b_simple_marche.repaint();
			this.b_simple_marche.addActionListener(action);

			this.b_professionnelle.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
			this.b_professionnelle.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
			this.b_professionnelle.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
			this.b_professionnelle.setCouleurTexte(Color.white);
			this.b_professionnelle.updateCouleur();
			this.b_professionnelle.repaint();
			this.b_professionnelle.addActionListener(action);

			this.b_mecaniste.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
			this.b_mecaniste.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
			this.b_mecaniste.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
			this.b_mecaniste.setCouleurTexte(Color.white);
			this.b_mecaniste.updateCouleur();
			this.b_mecaniste.repaint();
			this.b_mecaniste.addActionListener(action);

			this.b_simple_centralisee.setImgRepos(FenetreAccueil.theme.getbSchema2Repos());
			this.b_simple_centralisee.setImgSurvol(FenetreAccueil.theme.getbSchema2Survol());
			this.b_simple_centralisee.setImgClic(FenetreAccueil.theme.getbSchema2Survol());
			this.b_simple_centralisee.setCouleurTexte(Color.white);
			this.b_simple_centralisee.updateCouleur();
			this.b_simple_centralisee.repaint();
			this.b_simple_centralisee.addActionListener(action);

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
				}
			});

			this.note_entrepreneuriale = new JLabel("10 / 10");
			this.note_entrepreneuriale.setForeground(Color.WHITE);
			this.note_entrepreneuriale.setPreferredSize(dim_label);
			this.note_entrepreneuriale.setMaximumSize(dim_label);
			this.note_entrepreneuriale.setMinimumSize(dim_label);

			this.note_mecaniste = new JLabel("10 / 10");
			this.note_mecaniste.setForeground(Color.WHITE);
			this.note_mecaniste.setPreferredSize(dim_label);
			this.note_mecaniste.setMaximumSize(dim_label);
			this.note_mecaniste.setMinimumSize(dim_label);

			this.note_professionnelle = new JLabel("10 / 10");
			this.note_professionnelle.setForeground(Color.WHITE);
			this.note_professionnelle.setPreferredSize(dim_label);
			this.note_professionnelle.setMaximumSize(dim_label);
			this.note_professionnelle.setMinimumSize(dim_label);

			this.note_simple_centralisee = new JLabel("10 / 10");
			this.note_simple_centralisee.setForeground(Color.WHITE);
			this.note_simple_centralisee.setPreferredSize(dim_label);
			this.note_simple_centralisee.setMaximumSize(dim_label);
			this.note_simple_centralisee.setMinimumSize(dim_label);

			this.note_simple_marche = new JLabel("10 / 10");
			this.note_simple_marche.setForeground(Color.WHITE);
			this.note_simple_marche.setPreferredSize(dim_label);
			this.note_simple_marche.setMaximumSize(dim_label);
			this.note_simple_marche.setMinimumSize(dim_label);

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

	public JLabel getNote_simple_marche() {
		return note_simple_marche;
	}

	public JLabel getNote_professionnelle() {
		return note_professionnelle;
	}

	public JLabel getNote_mecaniste() {
		return note_mecaniste;
	}

	public JLabel getNote_simple_centralisee() {
		return note_simple_centralisee;
	}

	public JLabel getNote_entrepreneuriale() {
		return note_entrepreneuriale;
	}

	// METHODES //

	public void setNote_simple_marche(int note)
	{
		this.getNote_simple_marche().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_professionnelle(int note)
	{
		this.getNote_professionnelle().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_mecaniste(int note)
	{
		this.getNote_mecaniste().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_simple_centralisee(int note)
	{
		this.getNote_simple_centralisee().setText(String.valueOf(note)+" / 10");
	}
	
	public void setNote_entrepreneuriale(int note)
	{
		this.getNote_entrepreneuriale().setText(String.valueOf(note)+" / 10");
	}

}
