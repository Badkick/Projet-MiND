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

public class ApercuSchema2 extends ConteneurAvecImage{
	
	private Schema2 schema2;
	private int periode;
	float alpha = 0.0f;
	
	public ApercuSchema2(int width, int height, Schema2 schema2,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema2"+File.separator+"Etude_2_fond.png"));
		this.schema2=schema2;
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema2(Dimension dim, Schema2 schema2)
	{
		this((int)dim.getWidth(),(int)dim.getHeight(),schema2,0);
	}
	
	public Schema2 getSchema(){
		return this.schema2;
	}
	
	public int getPeriode(){
		return this.periode;
	}
	
	public void setSchema(Schema2 schema2){
		this.schema2=schema2;
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
		if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==1){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 700, 665, 669, 646, 653, 657, 692};
				int[] Y = { 114, 124, 138, 114, 81, 95, 85};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 776, 787, 443, 449, 382, 427, 433};
				int[] Y = { 125, 153, 287, 300, 294, 245, 258};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 775, 791, 440, 448, 381, 416, 424};
				int[] Y = { 123, 148, 372, 385, 392, 334, 346};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 769, 797, 769, 783, 734, 727, 741};
				int[] Y = { 127, 138, 209, 215, 259, 193, 198};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==2){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 657, 686, 691, 697, 674, 678, 649};
				int[] Y = { 127, 118, 133, 99, 75, 89, 98};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 451, 472, 434, 444, 380, 402, 413};
				int[] Y = { 149, 171, 208, 219, 239, 176, 187};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 529, 553, 434, 446, 385, 399, 410};
				int[] Y = { 181, 200, 350, 359, 388, 322, 331};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 627, 635, 649, 635, 591, 605, 598};
				int[] Y = { 175, 206, 203, 268, 217, 213, 182};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==3){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 377, 729, 723, 790, 749, 743, 390};
				int[] Y = { 304, 139, 125, 127, 179, 166, 332};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 374, 488, 480, 547, 512, 504, 390};
				int[] Y = { 269, 198, 185, 179, 236, 223, 295};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 275, 275, 261, 290, 319, 305, 305};
				int[] Y = { 333, 339, 339, 355, 339, 339, 333};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 384, 553, 554, 611, 547, 549, 380};
				int[] Y = { 275, 296, 281, 318, 341, 326, 305};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==4){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 374, 709, 701, 767, 734, 726, 391};
				int[] Y = { 373, 149, 137, 128, 187, 174, 397};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 374, 486, 474, 533, 523, 511, 399};
				int[] Y = { 379, 216, 207, 174, 241, 233, 396};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 274, 274, 258, 289, 320, 304, 304};
				int[] Y = { 353, 348, 348, 333, 348, 348, 353};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 380, 550, 545, 612, 563, 559, 388};
				int[] Y = { 373, 321, 307, 318, 364, 350, 402};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==5){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 699, 733, 720, 773, 774, 761, 726};
				int[] Y = { 251, 181, 174, 134, 201, 194, 265};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 641, 624, 610, 610, 664, 651, 668};
				int[] Y = { 273, 239, 246, 179, 219, 225, 259};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 602, 444, 443, 384, 446, 445, 603};
				int[] Y = { 315, 308, 323, 290, 263, 277, 285};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 602, 450, 455, 389, 437, 442, 593};
				int[] Y = { 341, 388, 403, 391, 345, 359, 312};
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
		Image repos=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema2"+File.separator+"Etude_2_repos.png");
		Image actif=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema2"+File.separator+"Etude_2_actif.png");
		int width=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getWidth();
		int height=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getHeight();
		g.drawImage(repos,205,245,width,height,null,null);
		g.drawImage(repos,205,355,width,height,null,null);
		g.drawImage(repos,475,85,width,height,null,null);
		g.drawImage(repos,615,275,width,height,null,null);
		g.drawImage(repos,705,35,width,height,null,null);
		g.setColor(Color.white);
		/*g.fillRoundRect(755, 132, 70, 36, 15, 15);//simple marche
		g.fillRoundRect(525, 182, 70, 36, 15, 15);//professionnelle
		g.fillRoundRect(385, 272, 70, 36, 15, 15);//mecaniste
		g.fillRoundRect(385, 382, 70, 36, 15, 15);//simple centralisee
		g.fillRoundRect(665, 372, 70, 36, 15, 15); //entrepreneuriale*/
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			try{
				if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==1){//simple marche
					g.drawImage(actif,705,35,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==2){//professionnelle
					g.drawImage(actif,475,85,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==3){//mecaniste
					g.drawImage(actif,205,245,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==4){//simple centralisee
					g.drawImage(actif,205,355,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==5){//entrepreneuriale
					g.drawImage(actif,615,275,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
				}
			}catch(NullPointerException ex){}
		}else if(this.getPeriode()>=1){
			this.setPeriode(1);
			try{
				this.drawArrow(g);
			}catch(NullPointerException ex){}
			try{
				if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){//simple marche
					g.drawImage(actif,705,35,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){//professionnelle
					g.drawImage(actif,475,85,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){//mecaniste
					g.setColor(Color.white);g.drawImage(actif,205,245,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){//simple centralisee
					g.drawImage(actif,205,355,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(665, 372, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 665, 372, 70, 36,Color.black);
					}
				}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){//entrepreneuriale
					g.drawImage(actif,615,275,width,height,null,null);
					if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(755, 132, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 755, 132, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(525, 182, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 525, 182, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 272, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 385, 272, 70, 36,Color.black);
					}
					if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
						g.setColor(Color.white);
						g.fillRoundRect(385, 382, 70, 36, 15, 15);
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
				}
			}catch(NullPointerException ex){}
			try{
				String texte1="Risque principal :\n\n "+FenetreAccueil.etude.getS2().getRis_principale().getNom().replaceAll("\n", " ");
				g.setColor(Color.red);
				//g.fillRoundRect(205, 10, 260, 210, 20, 20);
				g.fillRoundRect(205, 10, 260, 60, 20, 20);
				this.drawCenteredString(g, texte1, 205, 10, 260, 60, Color.white);
				String texte="Risques notés :\n\n";
				if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS2().getRis_notees()[0].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote())+" / 10)\n";
				}
				if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS2().getRis_notees()[1].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote())+" / 10)\n";
				}
				if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS2().getRis_notees()[2].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote())+" / 10)\n";
				}
				if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
					texte=texte+"- "+FenetreAccueil.etude.getS2().getRis_notees()[3].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote())+" / 10)\n";
				}
				String comparaison="Risques notés :\n\n";
				if(!comparaison.equals(texte)){
					g.setColor(Color.red);
					g.fillRoundRect(205, 72, 260, 150, 20, 20);
					this.drawCenteredString(g, texte, 205, 72, 260, 150, Color.white);
				}
			}catch(NullPointerException ex){}
			
		}
		this.drawCenteredString(g, Structure.SIMPLE_MARCHE.getNom(), 705, 35, width, height,Color.white);
		this.drawCenteredString(g, Structure.PROFESSIONNELLE.getNom(), 475, 85, width, height,Color.white);
		this.drawCenteredString(g, Structure.MECANISTE.getNom(), 205, 245, width, height,Color.white);
		this.drawCenteredString(g, Structure.SIMPLE_CENTRALISEE.getNom(), 205, 355, width, height,Color.white);
		this.drawCenteredString(g, Structure.ENTREPRENEURIALE.getNom(), 615, 275, width, height,Color.white);
		
		
		alpha +=0.02f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
	}
	
	

}
