package graphic_interface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class ApercuSchema5 extends ConteneurAvecImage {
	private int periode;
	float alpha = 0.0f;
	
	public ApercuSchema5(int width, int height,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"Etude_5_fond.png"));
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema5(Dimension dim)
	{
		this((int)dim.getWidth(),(int)dim.getHeight(),0);
	}
	
	
	public int getPeriode(){
		return this.periode;
	}
	
	
	public void setPeriode(int periode){
		this.periode=periode;
	}
	
	public void drawCenteredString(Graphics g, String text, int abscisse, int ordonnee, int width, int height,Color color){
		FontMetrics metrics = g.getFontMetrics(FenetreAccueil.theme.getPolice());
		int y = ordonnee + (height - (metrics.getAscent()+metrics.getDescent())*text.split("\n").length)/2;
		g.setFont(FenetreAccueil.theme.getPolice());
		g.setColor(color);
		for (String line : text.split("\n")){
			g.drawString(line, abscisse +(width - metrics.stringWidth(line))/2, y +=g.getFontMetrics().getAscent());
		}
	}
	
	public void initialiserTouche(){
		this.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_RIGHT){
					setPeriode(getPeriode()+1);
					if(getPeriode()<=2){
						alpha = 0.0f;
					}
					repaint();
				}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
					setPeriode(getPeriode()-1);
					if (getPeriode()>=0){
						alpha = 0.0f;
					}
					repaint();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
	}
	
	public void paintComponent(Graphics g_base){
		super.paintComponent(g_base);
		Graphics2D g=(Graphics2D) g_base;
		this.setFocusable(true);
		this.requestFocusInWindow();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		double a=0.7;
		int b=30;
		
		Image reglementaire=null;
		Image mobilite=null;
		Image service_public=null;
		Image professionnelle=null;
		Image communautaire=null;
		Image entrepreneuriale=null;
		//reglementaire :208,129
		//mobilite : 682, 135
		//service_public : 472, 280
		//professionnelle : 604, 404
		//communautaire : 260, 431
		//entrepreneuriale : 816, 462
		g.setColor(Color.white);
		g.fillRoundRect(59, 111, 55, 35, 15, 15);
		g.fillRoundRect(805, 117, 55, 35, 15, 15);
		g.fillRoundRect(566, 262, 55, 35, 15, 15);
		g.fillRoundRect(576, 495, 55, 35, 15, 15);
		g.fillRoundRect(87, 413, 55, 35, 15, 15);
		g.fillRoundRect(884, 371, 55, 35, 15, 15);
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			g.setColor(Color.white);
			g.fillRoundRect(59, 111, 55, 35, 15, 15);
			g.fillRoundRect(805, 117, 55, 35, 15, 15);
			g.fillRoundRect(566, 262, 55, 35, 15, 15);
			g.fillRoundRect(576, 495, 55, 35, 15, 15);
			g.fillRoundRect(87, 413, 55, 35, 15, 15);
			g.fillRoundRect(884, 371, 55, 35, 15, 15);
			try{
				int x=(int) (208-reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/200);
				int y=(int) (129-reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/200);
				int width=(int) (reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/100);
				int height=(int) (reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getMtn_reglementaire().get()!=0){
					g.drawImage(reglementaire, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_reglementaire().toString(), 59, 111, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (682-mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/200);
				int y=(int) (135-mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/200);
				int width=(int) (mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/100);
				int height=(int) (mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getMtn_mobilite().get()!=0){
					g.drawImage(mobilite, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_mobilite().toString(), 805, 117, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (472-service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/200);
				int y=(int) (280-service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/200);
				int width=(int) (service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/100);
				int height=(int) (service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()!=0){
					g.drawImage(service_public, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_pro_service_public().toString(), 566, 262, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (604-professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/200);
				int y=(int) (404-professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/200);
				int width=(int) (professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/100);
				int height=(int) (professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getMtn_professionnelle().get()!=0){
					g.drawImage(professionnelle, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_professionnelle().toString(), 576, 495, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (260-communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/200);
				int y=(int) (431-communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/200);
				int width=(int) (communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/100);
				int height=(int) (communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getMtn_communautaire().get()!=0){
					g.drawImage(communautaire, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_communautaire().toString(), 87, 413, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (816-entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/200);
				int y=(int) (462-entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/200);
				int width=(int) (entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/100);
				int height=(int) (entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()!=0){
					g.drawImage(entrepreneuriale, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().toString(), 884, 371, 55, 35,Color.black);
			}catch(NullPointerException ex){}

		}else if(this.getPeriode()>=1){
			this.setPeriode(1);
			//dessiner les fleches
			g.setColor(Color.white);
			g.fillRoundRect(59, 111, 55, 35, 15, 15);
			g.fillRoundRect(805, 117, 55, 35, 15, 15);
			g.fillRoundRect(566, 262, 55, 35, 15, 15);
			g.fillRoundRect(576, 495, 55, 35, 15, 15);
			g.fillRoundRect(87, 413, 55, 35, 15, 15);
			g.fillRoundRect(884, 371, 55, 35, 15, 15);
			
			try{
				int x=(int) (208-reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/200);
				int y=(int) (129-reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/200);
				int width=(int) (reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/100);
				int height=(int) (reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getApr_reglementaire().get()!=0){
					g.drawImage(reglementaire, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_reglementaire().toString(), 59, 111, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (682-mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/200);
				int y=(int) (135-mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/200);
				int width=(int) (mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/100);
				int height=(int) (mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getApr_mobilite().get()!=0){
					g.drawImage(mobilite, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_mobilite().toString(), 805, 117, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (472-service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/200);
				int y=(int) (280-service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/200);
				int width=(int) (service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/100);
				int height=(int) (service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getApr_pro_service_public().get()!=0){
					g.drawImage(service_public, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_pro_service_public().toString(), 566, 262, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (604-professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/200);
				int y=(int) (404-professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/200);
				int width=(int) (professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/100);
				int height=(int) (professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getApr_professionnelle().get()!=0){
					g.drawImage(professionnelle, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_professionnelle().toString(), 576, 495, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (260-communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/200);
				int y=(int) (431-communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/200);
				int width=(int) (communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/100);
				int height=(int) (communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getApr_communautaire().get()!=0){
					g.drawImage(communautaire, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_communautaire().toString(), 87, 413, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			try{
				int x=(int) (816-entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/200);
				int y=(int) (462-entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/200);
				int width=(int) (entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/100);
				int height=(int) (entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/100);
				if(FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()!=0){
					g.drawImage(entrepreneuriale, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_entrepreneuriale().toString(), 884, 371, 55, 35,Color.black);
			}catch(NullPointerException ex){}
			
			String texte="Risque\n\n";
			try{
				texte=texte+"Identité réglementaire ("+FenetreAccueil.etude.getS5().getRis_reglementaire().toString()+")\n";
			}catch(NullPointerException ex){}
			try{
				texte=texte+"Identité de mobilité ("+FenetreAccueil.etude.getS5().getRis_mobilite().toString()+")\n";
			}catch(NullPointerException ex){}
			try{
				texte=texte+"Identité professionnelle de service \npublic ("+FenetreAccueil.etude.getS5().getRis_pro_service_public().toString()+")\n";
			}catch(NullPointerException ex){}
			try{
				texte=texte+"Identité professionnelle ("+FenetreAccueil.etude.getS5().getRis_professionnelle().toString()+")\n";
			}catch(NullPointerException ex){}
			try{
				texte=texte+"Identité communautaire ("+FenetreAccueil.etude.getS5().getRis_communautaire().toString()+")\n";
			}catch(NullPointerException ex){}
			try{
				texte=texte+"Identité entrepreneuriale ("+FenetreAccueil.etude.getS5().getRis_entrepreneuriale().toString()+")";
			}catch(NullPointerException ex){}
			String comparaison="Risque\n\n";
			if(!texte.equals(comparaison)){
				g.setColor(Color.red);
				g.fillRoundRect(316, 60, 240, 134, 15, 15);
				this.drawCenteredString(g, texte, 308, 70, 256, 134, Color.white);
			}
			
		}
		
		alpha +=0.02f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
		
	}

}
