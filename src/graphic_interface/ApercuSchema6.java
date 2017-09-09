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

public class ApercuSchema6 extends ConteneurAvecImage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int periode;
	float alpha = 0.0f;
	
	public ApercuSchema6(int width, int height,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_fond.png"));
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema6(Dimension dim)
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
	
	public void drawArrow(Graphics2D g,int instant_precedent){
		g.setColor(new Color(255, 211, 33));
		int maintenant=0;
		int apres=0;
		if(instant_precedent==0){
			maintenant=FenetreAccueil.etude.getS6().getMtn().getNumero();
			apres=FenetreAccueil.etude.getS6().getApr().getNumero();
		}else if(instant_precedent==1){
			maintenant=FenetreAccueil.etude.getS6().getApr().getNumero();
			apres=FenetreAccueil.etude.getS6().getRis().getNumero();
		}
		if(maintenant==1){
			if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 217, 149, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==3){
				int[] X = { 496, 590, 592, 603, 585, 586, 492};
				int[] Y = { 140, 151, 137, 168, 196, 182, 170};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 488, 568, 580, 567, 534, 544, 465};
				int[] Y = { 188, 287, 279, 310, 316, 307, 207};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 143, 155, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==2){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 248, 141, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==3){
				int[] X = { 475, 587, 582, 607, 606, 599, 487};
				int[] Y = { 250, 201, 188, 209, 242, 230, 277};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 489, 537, 542, 546, 522, 526, 478};
				int[] Y = { 294, 312, 300, 333, 355, 341, 322};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 198, 250, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==3){
			if(apres==1){
				int[] X = { 606, 513, 515, 495, 504, 508, 601};
				int[] Y = { 166, 149, 135, 160, 193, 178, 196};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==2){
				int[] X = { 614, 500, 505, 481, 486, 492, 605};
				int[] Y = { 234, 271, 285, 262, 229, 242, 205};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 694, 685, 699, 666, 642, 656, 664};
				int[] Y = { 262, 291, 295, 302, 278, 282, 253};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				int[] X = { 625, 433, 441, 411, 405, 415, 607};
				int[] Y = { 244, 389, 401, 386, 352, 364, 219};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==4){
			if(apres==1){
				int[] X = { 566, 474, 464, 476, 508, 497, 589};
				int[] Y = { 315, 209, 219, 188, 180, 190, 295};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==2){
				int[] X = { 558, 492, 487, 483, 508, 503, 569};
				int[] Y = { 336, 310, 323, 290, 268, 282, 308};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 649, 657, 644, 677, 700, 687, 677};
				int[] Y = { 294, 265, 260, 254, 277, 273, 303};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				int[] X = { 544, 431, 432, 413, 423, 426, 538};
				int[] Y = { 384, 403, 417, 390, 358, 373, 355};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==5){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 203, 75, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 216, 224, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==3){
				int[] X = { 409, 598, 590, 619, 624, 616, 427};
				int[] Y = { 367, 228, 216, 231, 264, 252, 391};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 416, 527, 525, 545, 536, 533, 422};
				int[] Y = { 386, 365, 351, 377, 409, 395, 416};
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
		Graphics2D g=(Graphics2D) g_base;
		this.setFocusable(true);
		this.requestFocusInWindow();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Image repos=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_repos.png");
		Image secondaire =Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_secondaire.png");
		Image actif=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_actif.png");
		int width=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMA6.getWidth();
		int height=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMA6.getHeight();
		
		g.drawImage(repos,315,90,width,height,null,null);
		g.drawImage(repos,305,220,width,height,null,null);
		g.drawImage(repos,610,130,width,height,null,null);
		g.drawImage(repos,550,300,width,height,null,null);
		g.drawImage(repos,235,340,width,height,null,null);
		g.setColor(Color.white);
		g.fillRoundRect(10, 10, 170, 60, 20, 20);
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			this.drawCenteredString(g, "Passé", 10, 10, 170, 60, Color.black);
			try{
				if(FenetreAccueil.etude.getS6().getMtn().getNumero()==1){
					g.drawImage(actif,315,90,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==2){
					g.drawImage(actif,305,220,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==3){
					g.drawImage(actif,610,130,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==4){
					g.drawImage(actif,550,300,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==5){
					g.drawImage(actif,235,340,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[2].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getMtn_notee()[3].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
				}
			
			}catch(NullPointerException ex){}
			
				
		}else if(this.getPeriode()==1){
			
			this.drawCenteredString(g, "Aujourd'hui", 10, 10, 170, 60, Color.black);
			try{
				this.drawArrow(g,0);
			}catch(NullPointerException ex){}
			try{
				if(FenetreAccueil.etude.getS6().getApr().getNumero()==1){
					g.drawImage(actif,315,90,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==2){
					g.drawImage(actif,305,220,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==3){
					g.drawImage(actif,610,130,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==4){
					g.drawImage(actif,550,300,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==5){
					g.drawImage(actif,235,340,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[2].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getApr_notee()[3].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
				}
			
			}catch(NullPointerException ex){}
			
			/*try{
				String texte="Risque principal:\n\n"+FenetreAccueil.etude.getS6().getRis().getNom();
				g.setColor(Color.red);
				g.fillRoundRect(750, 420, 200, 100, 20, 20);
				this.drawCenteredString(g, texte, 750, 420, 200, 100, Color.white);
			}catch(NullPointerException ex){}*/
		}else if(this.getPeriode()>=2){
			this.setPeriode(2);
			this.drawCenteredString(g, "Cible", 10, 10, 170, 60, Color.black);
			try{
				this.drawArrow(g,1);
			}catch(NullPointerException ex){}
			try{
				if(FenetreAccueil.etude.getS6().getRis().getNumero()==1){
					g.drawImage(actif,315,90,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==2){
					g.drawImage(actif,305,220,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==3){
					g.drawImage(actif,610,130,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==4){
					g.drawImage(actif,550,300,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=0){
						g.drawImage(secondaire,235,340,width,height,null,null);
					}
				}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==5){
					g.drawImage(actif,235,340,width,height,null,null);
					if(FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[0].getNote()!=0){
						g.drawImage(secondaire,315,90,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[1].getNote()!=0){
						g.drawImage(secondaire,305,220,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[2].getNote()!=0){
						g.drawImage(secondaire,610,130,width,height,null,null);
					}
					if(FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=Integer.MAX_VALUE && FenetreAccueil.etude.getS6().getRis_notee()[3].getNote()!=0){
						g.drawImage(secondaire,550,300,width,height,null,null);
					}
				}
			
			}catch(NullPointerException ex){}
		}
		
		this.drawCenteredString(g, Entreprise.COMMUNAUTE.getNom(), 315, 90, width, height, Color.WHITE);
		this.drawCenteredString(g, Entreprise.DUALE.getNom(), 305, 220, width, height, Color.WHITE);
		this.drawCenteredString(g, Entreprise.MODERNISEE.getNom(), 610, 130, width, height, Color.WHITE);
		this.drawCenteredString(g, Entreprise.CRISE.getNom(), 550, 300, width, height, Color.WHITE);
		this.drawCenteredString(g, Entreprise.BUREAUCRATIQUE.getNom(), 235, 340, width, height, Color.WHITE);
		
		alpha +=0.015f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
		
	}

}
