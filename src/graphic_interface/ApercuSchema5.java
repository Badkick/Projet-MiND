package graphic_interface;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class ApercuSchema5 extends ConteneurAvecImage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public void drawArrow(Graphics2D g){
		int maintenant=FenetreAccueil.etude.getS5().getMax_maintenant();
		int apres=FenetreAccueil.etude.getS5().getMax_apres();
		g.setColor(new Color(255, 211, 33));
		if(maintenant==0){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 269, 1, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==2){
				int[] X = { 294, 385, 392, 393, 367, 373, 281};
				int[] Y = { 169, 211, 198, 232, 252, 239, 196};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 299, 111, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 233, 259, 273, 248, 215, 230, 204};
				int[] Y = { 214, 350, 348, 369, 360, 356, 220};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 306, 120, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==1){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 201, 3, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==2){
				int[] X = { 601, 570, 579, 548, 540, 550, 580};
				int[] Y = { 196, 222, 234, 222, 189, 200, 173};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 676, 649, 663, 630, 605, 619, 647};
				int[] Y = { 206, 312, 316, 323, 301, 304, 198};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 50, 125, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==5){
				int[] X = { 763, 815, 829, 804, 771, 786, 734};
				int[] Y = { 189, 382, 379, 402, 394, 390, 195};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==2){
			if(apres==0){
				int[] X = { 388, 301, 294, 296, 325, 318, 404};
				int[] Y = { 244, 189, 200, 167, 151, 163, 219};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				int[] X = { 529, 566, 556, 587, 598, 587, 549};
				int[] Y = { 210, 174, 163, 174, 207, 196, 232};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 568, 226, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 416, 380, 391, 358, 345, 357, 393};
				int[] Y = { 348, 391, 400, 393, 362, 371, 329};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 564, 271, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==3){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 37, 194, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==1){
				int[] X = { 643, 669, 683, 657, 625, 639, 614};
				int[] Y = { 325, 210, 214, 192, 200, 203, 318};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 380, 353, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 512, 399, 399, 381, 394, 395, 509};
				int[] Y = { 427, 438, 452, 425, 392, 408, 396};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 672, 276, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==4){
			if(apres==0){
				int[] X = { 215, 200, 186, 213, 245, 230, 245};
				int[] Y = { 373, 238, 239, 220, 232, 233, 370};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 373, 178, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==2){
				int[] X = { 343, 382, 372, 404, 415, 404, 366};
				int[] Y = { 379, 338, 328, 337, 368, 359, 400};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 383, 496, 498, 510, 491, 492, 380};
				int[] Y = { 445, 431, 445, 414, 386, 401, 414};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 321, 294, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==5){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 19, 215, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==1){
				int[] X = { 771, 720, 705, 730, 763, 749, 800};
				int[] Y = { 403, 210, 214, 191, 198, 202, 395};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 506, 130, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 683, 278, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 83, 279, image.getWidth(null), image.getHeight(null), null);
			}
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
		double a=0.3;
		int b=70;
		
		Image reglementaire=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"reglementaire.png");
		Image mobilite=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"mobilite.png");
		Image service_public=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"pro_service_public.png");
		Image professionnelle=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"professionnelle.png");
		Image communautaire=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"communautaire.png");
		Image entrepreneuriale=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"entrepreneuriale.png");
		//reglementaire :208,129
		//mobilite : 682, 135
		//service_public : 472, 280
		//professionnelle : 604, 404
		//communautaire : 260, 431
		//entrepreneuriale : 816, 462
		/*g.setColor(Color.white);
		g.fillRoundRect(59, 111, 55, 35, 15, 15);
		g.fillRoundRect(805, 117, 55, 35, 15, 15);
		g.fillRoundRect(566, 262, 55, 35, 15, 15);
		g.fillRoundRect(576, 495, 55, 35, 15, 15);
		g.fillRoundRect(87, 413, 55, 35, 15, 15);
		g.fillRoundRect(884, 371, 55, 35, 15, 15);*/
		g.setColor(Color.white);
		g.fillRoundRect(10, 10, 170, 60, 20, 20);
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			g.setColor(Color.white);
			g.fillRoundRect(59, 111, 55, 35, 15, 15);
			g.fillRoundRect(805, 117, 55, 35, 15, 15);
			g.fillRoundRect(566, 262, 55, 35, 15, 15);
			g.fillRoundRect(576, 495, 55, 35, 15, 15);
			g.fillRoundRect(87, 413, 55, 35, 15, 15);
			g.fillRoundRect(884, 371, 55, 35, 15, 15);
			this.drawCenteredString(g, "Aujourd'hui", 10, 10, 170, 60, Color.black);
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
			try{
				this.drawArrow(g);
			}catch(NullPointerException ex){}
			g.setColor(Color.white);
			g.fillRoundRect(59, 111, 55, 35, 15, 15);
			g.fillRoundRect(805, 117, 55, 35, 15, 15);
			g.fillRoundRect(566, 262, 55, 35, 15, 15);
			g.fillRoundRect(576, 495, 55, 35, 15, 15);
			g.fillRoundRect(87, 413, 55, 35, 15, 15);
			g.fillRoundRect(884, 371, 55, 35, 15, 15);
			this.drawCenteredString(g, "Cible", 10, 10, 170, 60, Color.black);
			
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
		
		alpha +=0.01f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
		
	}

}
