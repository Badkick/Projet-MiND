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

public class ApercuSchema1 extends ConteneurAvecImage{
	
	private Schema1 schema1;
	private int periode;
	
	public ApercuSchema1(int width, int height, Schema1 schema1,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_fond.png"));
		this.schema1=schema1;
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema1(Dimension dim, Schema1 schema1)
	{
		this((int)dim.getWidth(),(int)dim.getHeight(),schema1,0);
	}
	
	public Schema1 getSchema1(){
		return this.schema1;
	}
	
	public int getPeriode(){
		return this.periode;
	}
	
	public void setSchema1(Schema1 schema1){
		this.schema1=schema1;
	}
	
	public void setPeriode(int periode){
		this.periode=periode;
	}
	
	public void drawCenteredString(Graphics g, String text, int abscisse, int ordonnee, int width, int height){
		FontMetrics metrics = g.getFontMetrics(FenetreAccueil.theme.getPolice());
		int x = abscisse +(width - metrics.stringWidth(text))/2;
		int y = ordonnee + (height - metrics.getHeight())/2 + metrics.getAscent();
		g.setFont(FenetreAccueil.theme.getPolice());
		g.setColor(Color.black);
		g.drawString(text, x, y);
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
	
	float alpha = 0.0f;
	
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
		g.fillRoundRect(401, 178, 55, 35, 15, 15);
		g.fillRoundRect(498, 178, 55, 35, 15, 15);
		g.fillRoundRect(401, 245, 55, 35, 15, 15);
		g.fillRoundRect(498, 245, 55, 35, 15, 15);
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			this.drawCenteredString(g, "Aujourd'hui", 376, 10, 200, 60);
			try{
				int x=(int) (253-technique.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_contr_tech().get())/200);
				int y=(int) (125-technique.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_contr_tech().get())/200);
				int width=(int) (technique.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_contr_tech().get())/100);
				int height=(int) (technique.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_contr_tech().get())/100);
				g.drawImage(technique, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_contr_tech().toString(), 401, 178, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-pression.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_press_envir().get())/200);
				int y=(int) (125-pression.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_press_envir().get())/200);
				int width=(int) (pression.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_press_envir().get())/100);
				int height=(int) (pression.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_press_envir().get())/100);
				g.drawImage(pression, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_press_envir().toString(), 498, 178, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
			}
			try{
				int x=(int) (253-protege.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_etabl_prot().get())/200);
				int y=(int) (332-protege.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_etabl_prot().get())/200);
				int width=(int) (protege.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_etabl_prot().get())/100);
				int height=(int) (protege.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_etabl_prot().get())/100);
				g.drawImage(protege, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_etabl_prot().toString(), 401, 245, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-menace.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_mena_mar().get())/200);
				int y=(int) (332-menace.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_mena_mar().get())/200);
				int width=(int) (menace.getWidth(null)*(FenetreAccueil.etude.getS1().getMtn_mena_mar().get())/100);
				int height=(int) (menace.getHeight(null)*(FenetreAccueil.etude.getS1().getMtn_mena_mar().get())/100);
				g.drawImage(menace, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_mena_mar().toString(), 498, 245, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
			}
		}else if(this.getPeriode()==1){
			this.drawCenteredString(g, "Demain", 376, 10, 200, 60);
			try{
				int x=(int) (253-technique.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_contr_tech().get())/200);
				int y=(int) (125-technique.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_contr_tech().get())/200);
				int width=(int) (technique.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_contr_tech().get())/100);
				int height=(int) (technique.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_contr_tech().get())/100);
				g.drawImage(technique, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_contr_tech().toString(), 401, 178, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-pression.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_press_envir().get())/200);
				int y=(int) (125-pression.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_press_envir().get())/200);
				int width=(int) (pression.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_press_envir().get())/100);
				int height=(int) (pression.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_press_envir().get())/100);
				g.drawImage(pression, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_press_envir().toString(), 498, 178, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
			}
			try{
				int x=(int) (253-protege.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_etabl_prot().get())/200);
				int y=(int) (332-protege.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_etabl_prot().get())/200);
				int width=(int) (protege.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_etabl_prot().get())/100);
				int height=(int) (protege.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_etabl_prot().get())/100);
				g.drawImage(protege, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_etabl_prot().toString(), 401, 245, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-menace.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_mena_mar().get())/200);
				int y=(int) (332-menace.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_mena_mar().get())/200);
				int width=(int) (menace.getWidth(null)*(FenetreAccueil.etude.getS1().getApr_mena_mar().get())/100);
				int height=(int) (menace.getHeight(null)*(FenetreAccueil.etude.getS1().getApr_mena_mar().get())/100);
				g.drawImage(menace, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_mena_mar().toString(), 498, 245, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
			}
		}else if(this.getPeriode()>=2){
			this.setPeriode(2);
			this.drawCenteredString(g, "Après-demain", 376, 10, 200, 60);
			g.setColor(Color.white);
			g.fillOval(376, 380, 200, 60);
			try{
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getCommentaire_risque(), 376, 380, 200, 60);
			}catch(NullPointerException ex){}
			try{
				int x=(int) (253-technique.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_contr_tech().get())/200);
				int y=(int) (125-technique.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_contr_tech().get())/200);
				int width=(int) (technique.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_contr_tech().get())/100);
				int height=(int) (technique.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_contr_tech().get())/100);
				g.drawImage(technique, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_contr_tech().toString(), 401, 178, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-pression.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_press_envir().get())/200);
				int y=(int) (125-pression.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_press_envir().get())/200);
				int width=(int) (pression.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_press_envir().get())/100);
				int height=(int) (pression.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_press_envir().get())/100);
				g.drawImage(pression, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_press_envir().toString(), 498, 178, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
			}
			try{
				int x=(int) (253-protege.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_etabl_prot().get())/200);
				int y=(int) (332-protege.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_etabl_prot().get())/200);
				int width=(int) (protege.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_etabl_prot().get())/100);
				int height=(int) (protege.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_etabl_prot().get())/100);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_etabl_prot().toString(), 401, 245, 55, 35);
				g.drawImage(protege, x, y, width,height , null, null);
			}catch(NullPointerException ex){
				g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
			}
			try{
				int x=(int) (702-menace.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_mena_mar().get())/200);
				int y=(int) (332-menace.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_mena_mar().get())/200);
				int width=(int) (menace.getWidth(null)*(FenetreAccueil.etude.getS1().getRis_mena_mar().get())/100);
				int height=(int) (menace.getHeight(null)*(FenetreAccueil.etude.getS1().getRis_mena_mar().get())/100);
				g.drawImage(menace, x, y, width,height , null, null);
				this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_mena_mar().toString(), 498, 245, 55, 35);
			}catch(NullPointerException ex){
				g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
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
