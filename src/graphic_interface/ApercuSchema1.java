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

public class ApercuSchema1 extends ConteneurAvecImage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int periode;
	float alpha = 0.0f;
	
	public ApercuSchema1(int width, int height,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_fond.png"));
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema1(Dimension dim)
	{
		this((int)dim.getWidth(),(int)dim.getHeight(),0);
	}
	
	
	public int getPeriode(){
		return this.periode;
	}
	
	
	public void setPeriode(int periode){
		this.periode=periode;
	}
	
	public void drawCenteredString(Graphics g, String text, int abscisse, int ordonnee, int width, int height){
		FontMetrics metrics = g.getFontMetrics(FenetreAccueil.theme.getPolice());
		int y = ordonnee + (height - (metrics.getAscent()+metrics.getDescent())*text.split("\n").length)/2;
		g.setFont(FenetreAccueil.theme.getPolice());
		g.setColor(Color.black);
		for (String line : text.split("\n")){
			g.drawString(line, abscisse +(width - metrics.stringWidth(line))/2, y +=g.getFontMetrics().getAscent());
		}
	}
	
	public void drawArrow(Graphics2D g,int instant_precedent){
		int avant=0;
		int maintenant=0;
		if(instant_precedent==0){
			avant = FenetreAccueil.etude.getS1().getMax_maintenant();
			maintenant=FenetreAccueil.etude.getS1().getMax_apres();
		}else if(instant_precedent==1){
			avant = FenetreAccueil.etude.getS1().getMax_apres();
			maintenant=FenetreAccueil.etude.getS1().getMax_encore_apres();
		}
		g.setColor(new Color(255, 211, 33));
		if(avant ==0){
			if(maintenant==1){
				int[] X = { 411, 516, 516, 541, 516, 516, 411};
				int[] Y = { 105, 105, 85, 120, 155, 135, 135};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==2){
				int[] X = { 266, 266, 286, 251, 216, 236, 236};
				int[] Y = { 170, 220, 220, 240, 220, 220, 170};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant ==3){
				int[] X = { 385, 547, 564, 564, 500, 527, 365};
				int[] Y = { 144, 248, 221, 285, 290, 273, 169};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(avant ==1){
			if(maintenant==0){
				int[] X = { 541, 436, 436, 411, 436, 436, 541};
				int[] Y = { 105, 105, 85, 120, 155, 135, 135};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==2){
				int[] X = { 587, 425, 452, 388, 388, 405, 567};
				int[] Y = { 169, 273, 290, 285, 221, 248, 144};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant ==3){
				int[] X = { 717, 717, 737, 702, 667, 687, 687};
				int[] Y = { 170, 220, 220, 240, 220, 220, 170};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(avant==2){
			if(maintenant==0){
				int[] X = { 266, 266, 286, 251, 216, 236, 236};
				int[] Y = { 240, 190, 190, 170, 190, 190, 240};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==1){
				int[] X = { 385, 547, 564, 564, 500, 527, 365};
				int[] Y = { 316, 212, 239, 175, 170, 187, 291};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);	
			}else if(maintenant==3){
				int[] X = { 411, 516, 516, 541, 516, 516, 411};
				int[] Y = { 317, 317, 297, 332, 367, 347,347};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(avant==3){
			if(maintenant==0){
				int[] X = { 587, 425, 452, 388, 388, 405, 567};
				int[] Y = { 291, 187, 170, 175, 239, 212, 316};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);	
			}else if(maintenant==1){
				int[] X = { 717, 717, 737, 702, 667, 687, 687};
				int[] Y = { 240, 190, 190, 170, 190, 190, 240};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==2){
				int[] X = { 541, 436, 436, 411, 436, 436, 541};
				int[] Y = { 317, 317, 297, 332, 367, 347,347};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
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
		//pas fini, je dois calculer les coordonnées des centres des ellipses
		//En haut à gauche : 253 , 125
		//En haut à droite : 702 , 125
		//En bas à gauche : 253 , 332
		//En bas à droite : 702 , 332
		//On prend la coordonnée moins la taille correspondante divisée par 2
		Graphics2D g=(Graphics2D) g_base;
		this.setFocusable(true);
		this.requestFocusInWindow();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Image technique=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton3.png");
		Image pression=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton2.png");
		Image protege=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton4.png");
		Image menace=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton1.png");
		g.setColor(Color.white);
		g.fillRoundRect(376, 10, 200, 60, 15, 15);
		/*g.fillRoundRect(401, 178, 55, 35, 15, 15);
		g.fillRoundRect(498, 178, 55, 35, 15, 15);
		g.fillRoundRect(401, 245, 55, 35, 15, 15);
		g.fillRoundRect(498, 245, 55, 35, 15, 15);*/
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			g.setColor(Color.white);
			g.fillRoundRect(401, 178, 55, 35, 15, 15);
			g.fillRoundRect(498, 178, 55, 35, 15, 15);
			g.fillRoundRect(401, 245, 55, 35, 15, 15);
			g.fillRoundRect(498, 245, 55, 35, 15, 15);
			this.drawCenteredString(g, "Années 2000", 376, 10, 200, 60);
			try{
				int x=(int) (253-technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/200);
				int y=(int) (125-technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/200);
				int width=(int) (technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/100);
				int height=(int) (technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getMtn_contr_tech().get()!=0){
					g.drawImage(technique, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_contr_tech().toString(), 401, 178, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/200);
				int y=(int) (125-pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/200);
				int width=(int) (pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/100);
				int height=(int) (pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getMtn_press_envir().get()!=0){
					g.drawImage(pression, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_press_envir().toString(), 498, 178, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
			}
			try{
				int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/200);
				int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/200);
				int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/100);
				int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()!=0){
					g.drawImage(protege, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_etabl_prot().toString(), 401, 245, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/200);
				int y=(int) (332-menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/200);
				int width=(int) (menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/100);
				int height=(int) (menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getMtn_mena_mar().get()!=0){
					g.drawImage(menace, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_mena_mar().toString(), 498, 245, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
			}
		}else if(this.getPeriode()==1){
			this.drawCenteredString(g, "Années 2010", 376, 10, 200, 60);
			try{
				this.drawArrow(g, 0);
			}catch(NullPointerException ex){}
			g.setColor(Color.white);
			g.fillRoundRect(401, 178, 55, 35, 15, 15);
			g.fillRoundRect(498, 178, 55, 35, 15, 15);
			g.fillRoundRect(401, 245, 55, 35, 15, 15);
			g.fillRoundRect(498, 245, 55, 35, 15, 15);
			try{
				int x=(int) (253-technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/200);
				int y=(int) (125-technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/200);
				int width=(int) (technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/100);
				int height=(int) (technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getApr_contr_tech().get()!=0){
					g.drawImage(technique, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_contr_tech().toString(), 401, 178, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/200);
				int y=(int) (125-pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/200);
				int width=(int) (pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/100);
				int height=(int) (pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getApr_press_envir().get()!=0){
					g.drawImage(pression, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_press_envir().toString(), 498, 178, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
			}
			try{
				int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/200);
				int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/200);
				int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/100);
				int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getApr_etabl_prot().get()!=0){
					g.drawImage(protege, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_etabl_prot().toString(), 401, 245, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/200);
				int y=(int) (332-menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/200);
				int width=(int) (menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/100);
				int height=(int) (menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getApr_mena_mar().get()!=0){
					g.drawImage(menace, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_mena_mar().toString(), 498, 245, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
			}
		}else if(this.getPeriode()>=2){
			this.setPeriode(2);
			try{
				this.drawArrow(g, 1);
			}catch(NullPointerException ex){}
			g.setColor(Color.white);
			g.fillRoundRect(401, 178, 55, 35, 15, 15);
			g.fillRoundRect(498, 178, 55, 35, 15, 15);
			g.fillRoundRect(401, 245, 55, 35, 15, 15);
			g.fillRoundRect(498, 245, 55, 35, 15, 15);
			this.drawCenteredString(g, "Années 2020", 376, 10, 200, 60);
			try{
				if(!FenetreAccueil.etude.getS1().getCommentaire_risque().equals("")){
					g.setColor(Color.white);
					g.fillOval(376, 380, 200, 60);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getCommentaire_risque(), 376, 380, 200, 60);
			}catch(NullPointerException ex){}
			try{
				int x=(int) (253-technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/200);
				int y=(int) (125-technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/200);
				int width=(int) (technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/100);
				int height=(int) (technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getRis_contr_tech().get()!=0){
					g.drawImage(technique, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_contr_tech().toString(), 401, 178, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/200);
				int y=(int) (125-pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/200);
				int width=(int) (pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/100);
				int height=(int) (pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getRis_press_envir().get()!=0){
					g.drawImage(pression, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_press_envir().toString(), 498, 178, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
			}
			try{
				int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/200);
				int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/200);
				int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/100);
				int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/100);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_etabl_prot().toString(), 401, 245, 55, 35);
				if(FenetreAccueil.etude.getS1().getRis_etabl_prot().get()!=0){
					g.drawImage(protege, x, y, width,height , null, null);
				}
			}catch(NullPointerException ex){
				//g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/200);
				int y=(int) (332-menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/200);
				int width=(int) (menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/100);
				int height=(int) (menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/100);
				if(FenetreAccueil.etude.getS1().getRis_mena_mar().get()!=0){
					g.drawImage(menace, x, y, width,height , null, null);
				}
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_mena_mar().toString(), 498, 245, 55, 35);
			}catch(NullPointerException ex){
				//g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
			}
		}
		alpha +=0.015f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
	}

}
