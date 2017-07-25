package graphic_interface;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class VerificationOnglets implements ComponentListener {

	private CustomTab tab;
	private TabGraphe tab_graphe;
	
	public VerificationOnglets(CustomTab tab, TabGraphe tab_graphe) {
		this.tab = tab;
		this.tab_graphe = tab_graphe;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		new UpdateEtude(tab_graphe).updateEtude(tab_graphe);
		boolean termine = true;
		for(int i=0;i<3;i++)
		{
			new VerificationPetitsOnglets((ConteneurSchema) this.tab_graphe.getComponent(i), (CustomTab) this.tab_graphe.getTabComponentAt(i)).verification();
			termine &= this.tab_graphe.getTabComponentAt(i).getForeground().equals(Color.black);
		}
		this.tab.setForeground(termine ? Color.BLACK : Color.RED);
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentResized(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

}
