package graphic_interface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

class BoutonOvaleSchema6 extends JButton implements MouseListener {
	
	// VARIABLES INSTANCE //

	private String name = "Bouton";
	private Dimension taille;
	private Shape shape;
	private Image img;
	
	private Image img_repos = FenetreAccueil.theme.getBRepos();
	private Image img_survol = FenetreAccueil.theme.getBSurvol();
	private Image img_clic = FenetreAccueil.theme.getBClic();
	
	// CONSTRUCTEUR //
	
	public BoutonOvaleSchema6(String name, Dimension dim) {
		this.name = name;
		this.taille = dim;
		this.img = FenetreAccueil.theme.getBRepos();
		Icon icon = new ImageIcon(img);
		this.addMouseListener(this);
		this.setModel(new DefaultButtonModel());
		this.init("",icon);
		this.setForeground(Color.WHITE);
		
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setMinimumSize(dim);

		this.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);

		this.initShape();
	}
	
	// GETTERS //
	
	public Image getImage()
	{
		return this.img;
	}
	
	public Image getImgRepos()
	{
		return this.img_repos;
	}
	
	public Image getImgSurvol()
	{
		return this.img_survol;
	}
	
	public Image getImgClic()
	{
		return this.img_clic;
	}
	
	// SETTERS //
	
	public void setImage(Image img)
	{
		this.img = img;
		this.setIcon(new ImageIcon(img));
		this.repaint();
	}
	
	public void setImgRepos(Image imgRepos)
	{
		this.img_repos = imgRepos;
	}
	
	public void setImgSurvol(Image imgSurvol)
	{
		this.img_survol = imgSurvol;
	}
	
	public void setImgClic(Image imgClic)
	{
		this.img_clic = imgClic;
	}
	
	// METHODES //
	
	protected void initShape() {
		//this.shape = new Ellipse2D.Float(0, 0, this.getPreferredSize().width-1, this.getPreferredSize().height-1);
		this.shape = new Ellipse2D.Float(0, 0, this.taille.width, this.taille.height);
		//this.shape = new RoundRectangle2D.Float(0f, 0f, (float)this.getPreferredSize().width-1, (float)this.getPreferredSize().height-1,230f,130f);
	}
	
	@Override 
	public Dimension getPreferredSize() {
		return this.taille;
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
		g2.drawImage(this.getImage(), -(this.getIcon().getIconWidth()-this.taille.width)/2, -(this.getIcon().getIconHeight()-this.taille.height)/2, null);
		g2.setFont(FenetreAccueil.theme.getPolice());
		int y = (this.getHeight()-(g2.getFontMetrics().getAscent()+g2.getFontMetrics().getDescent())*this.name.split("\n").length)/2;
		for (String line : this.name.split("\n")) g2.drawString(line, (this.getWidth()-g2.getFontMetrics().stringWidth(line))/2, y += g2.getFontMetrics().getAscent());
	}
	
	@Override 
	public boolean contains(int x, int y) {
		this.initShape();
		return shape.contains(x, y);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setImage(this.getImgSurvol());

	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setImage(this.getImgRepos());

	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.setImage(this.getImgClic());

	}
	@Override
	public void mouseReleased(MouseEvent event) {
		int y = event.getY();
		int x = event.getX();
		this.img=(y>0 && y<this.getHeight() && x>0 && x<this.getWidth()) ? this.getImgSurvol() : this.getImgRepos();
	}
}