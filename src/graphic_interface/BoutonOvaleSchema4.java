package graphic_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BoutonOvaleSchema4 extends JButton implements MouseListener {

	private Image img;
	
	public BoutonOvaleSchema4() {
		super();
		
		this.img = Images.importerImage("pb.jpg");
		
		this.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		this.setMaximumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		this.setMinimumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		//this.setBorderPainted(false);
		this.setOpaque(false);
		
		this.addMouseListener(this);
	}

	@Override
	public void paintBorder(Graphics g) {}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
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
