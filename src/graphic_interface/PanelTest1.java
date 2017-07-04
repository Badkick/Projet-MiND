package graphic_interface;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelTest1 extends JPanel {

	public PanelTest1(Dimension size) {
		
		this.setPreferredSize(size);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawString("Panel 1", (int) this.getPreferredSize().getHeight()/2, (int) this.getPreferredSize().getWidth()/2);
	}

}
