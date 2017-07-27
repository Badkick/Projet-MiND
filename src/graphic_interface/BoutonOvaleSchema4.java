package graphic_interface;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

class BoutonOvaleSchema4 extends JButton implements MouseListener {

	private Shape shape;
	private Image img;
	
	public BoutonOvaleSchema4(Image img) {
		this.img = img;
		Icon icon = new ImageIcon(img);
		this.addMouseListener(this);
		this.setModel(new DefaultButtonModel());
		this.init("",icon);

		this.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);

		this.initShape();
	}
	
	protected void initShape() {
		this.shape = new Ellipse2D.Float(0, 0, this.getPreferredSize().width-1, this.getPreferredSize().height-1);
	}
	
	@Override 
	public Dimension getPreferredSize() {
		return new Dimension(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}
	
	@Override 
	protected void paintBorder(Graphics g) {
		this.initShape();
		Graphics2D g2 = (Graphics2D)g;	
		g2.setStroke(new BasicStroke(1.0f));
		g2.draw(this.shape);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.initShape();
		Graphics2D g2 = (Graphics2D)g;
		g2.setClip(this.shape);
		g2.drawImage(this.getImage(), 0, 0, null);
	}
	
	@Override 
	public boolean contains(int x, int y) {
		this.initShape();
		return shape.contains(x, y);
	}
	
	public Image getImage()
	{
		return this.img;
	}
	
	public void setImage(Image img)
	{
		this.img = img;
		this.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("hello");

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}