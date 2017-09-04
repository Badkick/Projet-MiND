package graphic_interface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;


class BoutonOvaleSchema6 extends Bouton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// VARIABLES INSTANCE //

	private Shape shape;
	
	// CONSTRUCTEUR //
	
	public BoutonOvaleSchema6(String name, Dimension dim) {
		super(name,dim);

		Icon icon = new ImageIcon(this.getImg());

		this.setModel(new DefaultButtonModel());
		this.init("",icon);
		this.setForeground(Color.WHITE);

		this.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		
		this.resetImg();

		this.initShape();
	}

	
	// SETTERS //
	
	public void setImage(Image img)
	{
		super.setImage(img);
		this.setIcon(new ImageIcon(img));
	}
	
	// METHODES //
	
	protected void initShape() {
		//this.shape = new Ellipse2D.Float(0, 0, this.getPreferredSize().width-1, this.getPreferredSize().height-1);
		this.shape = new Ellipse2D.Float(0, 0, this.getTaille().width, this.getTaille().height);
		//this.shape = new RoundRectangle2D.Float(0f, 0f, (float)this.getPreferredSize().width-1, (float)this.getPreferredSize().height-1,230f,130f);
	}
	
	@Override 
	public Dimension getPreferredSize() {
		return this.getTaille();
		//return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}
	
	@Override 
	protected void paintBorder(Graphics g) {
		this.initShape();
		Graphics2D g2 = (Graphics2D)g;	
		g2.setColor(Color.DARK_GRAY);
		g2.setStroke(new BasicStroke(1.0f));
		g2.draw(this.shape);
		g2.setColor(Color.WHITE);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.initShape();
		Graphics2D g2 = (Graphics2D)g;
		g2.setClip(this.shape);
		g2.drawImage(this.getImg(), -(this.getIcon().getIconWidth()-this.getTaille().width)/2, -(this.getIcon().getIconHeight()-this.getTaille().height)/2, null);
		g2.setFont(FenetreAccueil.theme.getPolice());
		int y = (this.getHeight()-(g2.getFontMetrics().getAscent()+g2.getFontMetrics().getDescent())*this.getName().split("\n").length)/2;
		for (String line : this.getName().split("\n")) g2.drawString(line, (this.getWidth()-g2.getFontMetrics().stringWidth(line))/2, y += g2.getFontMetrics().getAscent());
	}
	
	@Override 
	public boolean contains(int x, int y) {
		this.initShape();
		return shape.contains(x, y);
	}
	
	@Override
	public void resetImg()
	{
		this.setImgClic(FenetreAccueil.theme.getbSchema6Clic());
		this.setImgRepos(FenetreAccueil.theme.getbSchema6Repos());
		this.setImgSurvol(FenetreAccueil.theme.getbSchema6Survol());
	}
	
	public void activer()
	{
		this.setEnabled(true);
		this.resetImg();
		this.updateCouleur();
	}
	
	public void desactiver(Image img)
	{
		this.setImgFixe(this.getImgSurvol());
		this.setIcon(new ImageIcon(this.getImgSurvol()));
		this.setEnabled(false);
	}
	
}