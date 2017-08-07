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

public class ApercuSchema3 extends ConteneurAvecImage{
	
	private int periode;
	float alpha = 0.0f;
	
	public ApercuSchema3(int width, int height,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema3"+File.separator+"Etude_3_fond.png"));
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema3(Dimension dim)
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
		g.setColor(Color.red);
		if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==1){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 364, 377, 377, 392, 375, 375, 364};
				int[] Y = { 111, 111, 96, 127, 156, 141, 141};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 381, 567, 567, 583, 567, 567, 381};
				int[] Y = { 61, 61, 48, 77, 107, 93, 93};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 290, 290, 303, 274, 245, 258, 258};
				int[] Y = { 180, 324, 324, 340, 324, 324, 180};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 302, 573, 581, 579, 552, 559, 287};
				int[] Y = { 172, 323, 311, 343, 362, 350, 198};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==2){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 389, 383, 383, 367, 383, 383, 389};
				int[] Y = { 108, 108, 94, 123, 153, 139, 139};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 562, 570, 570, 585, 570, 570, 562};
				int[] Y = { 108, 109, 95, 124, 153, 139, 139};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 412, 355, 369, 335, 314, 327, 385};
				int[] Y = { 200, 332, 339, 340, 315, 320, 188};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 541, 568, 635, 649, 628, 595, 608};
				int[] Y = { 201, 187, 318, 310, 338, 338, 332};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==3){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 583, 383, 383, 368, 383, 383, 583};
				int[] Y = { 61, 61, 48, 77, 105, 87, 87};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 585, 577, 576, 562, 577, 577, 585};
				int[] Y = { 116, 116, 102, 131, 160, 146, 146};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 597, 380, 371, 376, 407, 398, 615};
				int[] Y = { 169, 329, 318, 351, 366, 354, 192};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 714, 713, 698, 727, 758, 744, 745};
				int[] Y = { 177, 325, 325, 341, 326, 326, 177};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==4){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 258, 258, 244, 274, 304, 288, 288};
				int[] Y = { 334, 177, 176, 161, 177, 176, 334};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 304, 430, 422, 452, 463, 452, 325};
				int[] Y = { 322, 196, 187, 196, 227, 219, 343};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 373, 614, 607, 636, 640, 632, 390};
				int[] Y = { 337, 172, 160, 175, 208, 197, 362};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 374, 566, 566, 582, 566, 566, 374};
				int[] Y = { 380, 379, 365, 395, 423, 410, 409};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==5){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 569, 324, 317, 320, 350, 342, 586};
				int[] Y = { 365, 200, 210, 178, 163, 174, 340};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 597, 498, 485, 499, 533, 522, 621};
				int[] Y = { 343, 215, 223, 194, 186, 195, 324};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 657, 654, 641, 670, 699, 686, 687};
				int[] Y = { 339, 180, 180, 164, 180, 180, 339};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 570, 389, 388, 372, 387, 387, 570};
				int[] Y = { 379, 375, 361, 389, 420, 406, 410};
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
					if(getPeriode()<=1){
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
		Image repos=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema3"+File.separator+"Etude_3_repos.png");
		Image actif=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema3"+File.separator+"Etude_3_actif.png");
		int width=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getWidth();
		int height=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getHeight();
		g.drawImage(repos,195,70,width,height,null,null);
		g.drawImage(repos,390,95,width,height,null,null);
		g.drawImage(repos,587,70,width,height,null,null);
		g.drawImage(repos,195,345,width,height,null,null);
		g.drawImage(repos,587,345,width,height,null,null);
		/*g.setColor(Color.white);
		g.fillRoundRect(245, 168, 70, 36, 15, 15);//rationnelle
		g.fillRoundRect(440, 193, 70, 36, 15, 15);//artisanale
		g.fillRoundRect(637, 168, 70, 36, 15, 15);//personnalisee
		g.fillRoundRect(245, 443, 70, 36, 15, 15);//professionnelle de process
		g.fillRoundRect(767, 372, 70, 36, 15, 15); //flexible*/
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			try{
				if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==1){
					g.drawImage(actif,195,70,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==2){
					g.drawImage(actif,390,95,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==3){
					g.drawImage(actif,587,70,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==4){
					g.drawImage(actif,195,345,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==5){
					g.drawImage(actif,587, 345,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
				}
			}catch(NullPointerException ex){}
		}else if(this.getPeriode()>=1){
			this.setPeriode(1);
			try{
				this.drawArrow(g);
			}catch(NullPointerException ex){}
			try{
				if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
					g.drawImage(actif,195,70,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
					g.drawImage(actif,390,95,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
					g.drawImage(actif,587,70,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
					g.drawImage(actif,195,345,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 440, 193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(767, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 767, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
					g.drawImage(actif,587, 345,width,height,null,null);
					if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 245, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(440, 193, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 440,193, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(637, 168, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 637, 168, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(245, 443, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 245, 443, 70, 36,Color.black);
					}
				}
			}catch(NullPointerException ex){}
			try{
				String texte1="Risque principal :\n\n "+FenetreAccueil.etude.getS3().getRis_principale().getNom().replaceAll("\n", " ");
				g.setColor(Color.red);
				g.fillRoundRect(325, 250, 300, 60, 20, 20);
				this.drawCenteredString(g, texte1, 325, 250, 300, 60, Color.white);
				String texte="Risques notés :\n\n";
				if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS3().getRis_notees()[0].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote())+" / 10)\n";
				}
				if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS3().getRis_notees()[1].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote())+" / 10)\n";
				}
				if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS3().getRis_notees()[2].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote())+" / 10)\n";
				}
				if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS3().getRis_notees()[3].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote())+" / 10)";
				}
				String comparaison="Risques notés :\n\n";
				if(!comparaison.equals(texte)){
					g.setColor(Color.red);
					g.fillRoundRect(490, 440, 450, 90, 20, 20);
					this.drawCenteredString(g, texte, 490, 445, 450, 90, Color.white);
				}
			}catch(NullPointerException ex){}
			
		}
		this.drawCenteredString(g, Organisation.RATIONNELLE.getNom(), 195, 70, width, height,Color.white);
		this.drawCenteredString(g, Organisation.ARTISANALE.getNom(), 390, 95, width, height,Color.white);
		this.drawCenteredString(g, Organisation.PERSONNALISEE.getNom(), 587, 70, width, height,Color.white);
		this.drawCenteredString(g, Organisation.PROFESSIONNELLE_PROCESS.getNom(), 195, 345, width, height,Color.white);
		this.drawCenteredString(g, Organisation.FLEXIBLE.getNom(), 587, 345, width, height,Color.white);
		
		
		alpha +=0.02f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
	}

}
