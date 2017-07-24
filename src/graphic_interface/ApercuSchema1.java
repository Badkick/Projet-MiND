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
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"fond.png"));
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
		//En haut à gauche : 252 , 115
		//En haut à droite : 702 , 115
		//En bas à gauche : 252 , 332
		//En bas à droite : 702 , 332
		//On prend la coordonnée moins la taille correspondante divisée par 2
		Graphics2D g=(Graphics2D) g_base;
		this.setFocusable(true);
		this.requestFocusInWindow();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRoundRect(370, 10, 200, 60, 15, 15);
		g.fillOval(370, 190, 200, 60);
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			this.drawCenteredString(g, "Aujourd'hui", 370, 10, 200, 60);
			try{
				this.drawCenteredString(g, this.getSchema1().getCommentaire_risque(), 370, 190, 200, 60);
			}catch(NullPointerException ex){}
			g.setColor(Color.red);
			g.fillRect(242, 105, 20, 20);
			g.setColor(Color.blue);
			g.fillRect(692, 105, 20, 20);
			g.setColor(Color.yellow);
			g.fillRect(242, 322, 20, 20);
			g.setColor(Color.GREEN);
			g.fillRect(692, 322, 20, 20);
		}else if(this.getPeriode()==1){
			this.drawCenteredString(g, "Demain", 370, 10, 200, 60);
			try{
				this.drawCenteredString(g, this.getSchema1().getCommentaire_risque(), 370, 190, 200, 60);
			}catch(NullPointerException ex){}
			g.setColor(Color.blue);
			g.fillRect(242, 105, 20, 20);
			g.setColor(Color.yellow);
			g.fillRect(692, 105, 20, 20);
			g.setColor(Color.green);
			g.fillRect(242, 322, 20, 20);
			g.setColor(Color.red);
			g.fillRect(692, 322, 20, 20);
		}else if(this.getPeriode()>=2){
			this.setPeriode(2);
			this.drawCenteredString(g, "Après-demain", 370, 10, 200, 60);
			try{
				this.drawCenteredString(g, this.getSchema1().getCommentaire_risque(), 370, 190, 200, 60);
			}catch(NullPointerException ex){}
			g.setColor(Color.yellow);
			g.fillRect(242, 105, 20, 20);
			g.setColor(Color.green);
			g.fillRect(692, 105, 20, 20);
			g.setColor(Color.red);
			g.fillRect(242, 322, 20, 20);
			g.setColor(Color.blue);
			g.fillRect(692, 322, 20, 20);
		}
		alpha +=0.02f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
	}

}
