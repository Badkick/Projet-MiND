package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class ConteneurSchema extends ConteneurAvecImage {

	public static final Dimension DIMENSION_TEXT_FIELD = new Dimension(45,30);

	// VARIABLES INSTANCE //

	// variables générales
	private Theme theme;
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

	private Bouton b_simple_marche;
	private Bouton b_professionnelle;
	private Bouton b_mecaniste;
	private Bouton b_simple_centralisee;
	private Bouton b_entrepreneuriale;

	// cas 3

	// cas 4

	// cas 5

	// cas 6


	// CONSTRUCTEURS //

	public ConteneurSchema(int type, int width, int height, Theme theme) {
		super(width,height,theme.getSchemas()[type-1]);
		this.typeSchema = type;
		this.theme = theme;
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
							.addComponent(mena_mar)
							)
					.addGap(110)
					.addGroup(this.layout.createParallelGroup()
							.addComponent(etabl_prot)
							.addGap(100)
							.addComponent(press_envir)
							)
					);
			break;
		case 2:
			Dimension dim_boutons = new Dimension(170,90);
			this.b_simple_marche = new Bouton("Structure\nSIMPLE DE MARCHE",dim_boutons,theme);
			this.b_professionnelle = new Bouton("Structure\nPROFESSIONNELLE",dim_boutons,theme);
			this.b_mecaniste = new Bouton("Structure\nMECANISTE",dim_boutons,theme);
			this.b_simple_centralisee = new Bouton("Structure\nSIMPLE CENTRALISEE",dim_boutons,theme);
			this.b_entrepreneuriale = new Bouton("Structure\nENTREPRENEURIALE",dim_boutons,theme);

			this.b_entrepreneuriale.setImgRepos(theme.getbSchema2Repos());
			this.b_entrepreneuriale.setImgSurvol(theme.getbSchema2Survol());
			this.b_entrepreneuriale.setImgClic(theme.getbSchema2Survol());
			this.b_entrepreneuriale.setCouleurTexte(Color.white);
			this.b_entrepreneuriale.updateCouleur();
			this.b_entrepreneuriale.repaint();

			this.b_simple_marche.setImgRepos(theme.getbSchema2Repos());
			this.b_simple_marche.setImgSurvol(theme.getbSchema2Survol());
			this.b_simple_marche.setImgClic(theme.getbSchema2Survol());
			this.b_simple_marche.setCouleurTexte(Color.white);
			this.b_simple_marche.updateCouleur();
			this.b_simple_marche.repaint();

			this.b_professionnelle.setImgRepos(theme.getbSchema2Repos());
			this.b_professionnelle.setImgSurvol(theme.getbSchema2Survol());
			this.b_professionnelle.setImgClic(theme.getbSchema2Survol());
			this.b_professionnelle.setCouleurTexte(Color.white);
			this.b_professionnelle.updateCouleur();
			this.b_professionnelle.repaint();

			this.b_mecaniste.setImgRepos(theme.getbSchema2Repos());
			this.b_mecaniste.setImgSurvol(theme.getbSchema2Survol());
			this.b_mecaniste.setImgClic(theme.getbSchema2Survol());
			this.b_mecaniste.setCouleurTexte(Color.white);
			this.b_mecaniste.updateCouleur();
			this.b_mecaniste.repaint();

			this.b_simple_centralisee.setImgRepos(theme.getbSchema2Repos());
			this.b_simple_centralisee.setImgSurvol(theme.getbSchema2Survol());
			this.b_simple_centralisee.setImgClic(theme.getbSchema2Survol());
			this.b_simple_centralisee.setCouleurTexte(Color.white);
			this.b_simple_centralisee.updateCouleur();
			this.b_simple_centralisee.repaint();

			this.layout.setHorizontalGroup(
					this.layout.createSequentialGroup()
					.addGap(220)
					.addGroup(this.layout.createParallelGroup()
							.addComponent(b_mecaniste)
							.addComponent(b_simple_centralisee)
							)
					.addGap(85)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addGap(230)
									.addComponent(b_simple_marche)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addComponent(b_professionnelle)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addGap(140)
									.addComponent(b_entrepreneuriale)
									)
							)
					);
			
			this.layout.setVerticalGroup(
					this.layout.createSequentialGroup()
					.addGap(35)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addGap(50)
									.addComponent(b_professionnelle)
									)
							.addComponent(b_simple_marche)
							)
					.addGap(70)
					.addGroup(this.layout.createParallelGroup()
							.addGroup(this.layout.createSequentialGroup()
									.addComponent(b_mecaniste)
									.addGap(20)
									.addComponent(b_simple_centralisee)
									)
							.addGroup(this.layout.createSequentialGroup()
									.addGap(30)
									.addComponent(b_entrepreneuriale)
									)
							)
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

	public ConteneurSchema(int type, Dimension dim, Theme theme) {
		this(type,(int)dim.getWidth(),(int)dim.getHeight(),theme);		
	}

	// GETTERS //

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
		} catch (StringIndexOutOfBoundsException e) {
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

	// METHODES //



}
