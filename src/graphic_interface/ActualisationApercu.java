package graphic_interface;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ActualisationApercu implements ComponentListener{
	
	private Conteneur conteneur;
	
	public ActualisationApercu(Conteneur conteneur){
		this.conteneur=conteneur;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		this.conteneur.repaint();
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
