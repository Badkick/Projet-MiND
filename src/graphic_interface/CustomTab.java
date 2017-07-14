package graphic_interface;

import java.awt.Dimension;

import javax.swing.JLabel;

public class CustomTab extends JLabel {

	public static Dimension TAILLE = new Dimension(140,20);
	private final float TAILLE_POLICE = 12;
	
	private Theme theme;
	
	public CustomTab(String text, Theme theme) {
		super(text);
		this.theme = theme;
		this.setFont(theme.getPolice().deriveFont(TAILLE_POLICE));
	}

	public CustomTab(String text, int horizontalAlignment, Theme theme) {
		super(text, horizontalAlignment);
		this.theme = theme;
		this.setFont(theme.getPolice().deriveFont(TAILLE_POLICE));
	}
	
	public Theme getTheme()
	{
		return this.theme;
	}
	
	public void setTaille(Dimension taille)
	{
		this.setPreferredSize(taille);
		this.setMaximumSize(taille);
		this.setMinimumSize(taille);
	}
	
	

}
