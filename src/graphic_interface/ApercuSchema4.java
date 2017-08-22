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

public class ApercuSchema4 extends ConteneurAvecImage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int periode;
	float alpha = 0.0f;
	
	public ApercuSchema4(int width, int height,int periode){
		super(width,height,Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"Etude_4_fond.png"));
		this.periode=periode;
		this.initialiserTouche();
	}
	
	public ApercuSchema4(Dimension dim)
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
		int maintenant=FenetreAccueil.etude.getS4().getMax_maintenant();
		int apres=FenetreAccueil.etude.getS4().getMax_apres();
		g.setColor(new Color(255, 211, 33));
		if(maintenant==0){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 352, 155, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==2){
				int[] X = { 372, 500, 500, 513, 500, 500, 372};
				int[] Y = { 151, 151, 137, 167, 197, 181, 181};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 361, 1, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 352, 168, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==5){
				int[] X = { 364, 557, 563, 562, 535, 542, 349};
				int[] Y = { 177, 292, 281, 312, 330, 318, 203};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				int[] X = { 366, 554, 564, 553, 521, 532, 344};
				int[] Y = { 187, 393, 384, 414, 423, 413, 207};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==1){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 357, 154, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==2){
				int[] X = { 360, 498, 494, 516, 512, 506, 369};
				int[] Y = { 225, 181, 168, 191, 222, 211, 253};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 368, 235, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==4){
				int[] X = { 314, 344, 356, 338, 306, 318, 288};
				int[] Y = { 287, 338, 331, 359, 360, 353, 302};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==5){
				int[] X = { 365, 543, 548, 552, 528, 533, 355};
				int[] Y = { 240, 305, 292, 325, 347, 333, 268};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				int[] X = { 359, 552, 560, 558, 529, 536, 342};
				int[] Y = { 264, 389, 378, 409, 427, 415, 289};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==2){
			if(apres==0){
				int[] X = { 509, 372, 372, 357, 371, 371, 509};
				int[] Y = { 152, 149, 134, 164, 193, 179, 181};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==1){
				int[] X = { 511, 366, 362, 355, 377, 374, 519};
				int[] Y = { 181, 220, 206, 239, 263, 249, 210};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 633, 14, image.getWidth(null), image.getHeight(null), null);
			}else if (apres==4){
				int[] X = { 530, 449, 438, 453, 485, 474, 555};
				int[] Y = { 223, 338, 331, 359, 364, 355, 240};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==5){
				int[] X = { 599, 604, 589, 620, 647, 633, 628};
				int[] Y = { 256, 300, 300, 312, 294, 295, 253};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 491, 227, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==3){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 175, 13, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 197, 233, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 624, 242, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 709, 473, 466, 466, 492, 487, 723};
				int[] Y = { 228, 344, 331, 365, 385, 371, 255};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				int[] X = { 749, 727, 714, 735, 768, 754, 777};
				int[] Y = { 248, 301, 296, 321, 319, 313, 259};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 832, 213, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==4){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 354, 104, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==1){
				int[] X = { 335, 314, 300, 323, 356, 342, 363};
				int[] Y = { 363, 302, 307, 283, 287, 292, 353};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				int[] X = { 425, 520, 509, 541, 555, 544, 449};
				int[] Y = { 346, 230, 220, 227, 258, 248, 365};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 471, 697, 689, 717, 720, 712, 487};
				int[] Y = { 353, 216, 203, 221, 254, 242, 378};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 448, 264, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 448, 447, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==5){
			if(apres==0){
				int[] X = { 550, 362, 352, 358, 389, 379, 568};
				int[] Y = { 340, 199, 209, 177, 162, 175, 315};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				int[] X = { 534, 364, 357, 355, 381, 375, 546};
				int[] Y = { 357, 285, 298, 266, 244, 258, 329};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				int[] X = { 587, 586, 572, 601, 631, 617, 617};
				int[] Y = { 315, 269, 269, 253, 268, 268, 314};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 703, 730, 717, 750, 770, 757, 729};
				int[] Y = { 309, 255, 248, 247, 274, 268, 323};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 357, 287, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 822, 351, image.getWidth(null), image.getHeight(null), null);
			}
		}else if(maintenant==6){
			if(apres==0){
				int[] X = { 546, 360, 349, 361, 393, 383, 569};
				int[] Y = { 422, 204, 212, 181, 174, 184, 402};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				int[] X = { 558, 357, 350, 353, 382, 375, 575};
				int[] Y = { 426, 289, 301, 267, 252, 264, 401};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 446, 180, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 792, 159, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 361, 433, image.getWidth(null), image.getHeight(null), null);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 822, 351, image.getWidth(null), image.getHeight(null), null);
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
		int b=70;//pour la loi affine sur les pourcentages
		//centre ellipse rouge: 279, 210
		//centre consensus: 279, 166
		//centre pacte: 279, 250
		//centre ellipse bleue: 694, 171
		//centre ajustement : 606, 170
		//centre transformation : 786, 171
		//centre ellipse verte: 568, 395
		//centre domination : 389, 395
		//centre contre pouvoir: 656, 352
		//centre antagonisme: 655, 439
		
		/*g.setColor(Color.white);
		g.fillRoundRect(60, 119, 55, 35, 15, 15);//importance consensus
		g.fillRoundRect(140,148, 55, 35, 15, 15);//consensus consensus
		g.fillRoundRect(140,234, 55, 35, 15, 15);//pacte consensus
		g.fillRoundRect(885, 63, 55, 35, 15, 15);//importance negociation
		g.fillRoundRect(578,55, 55, 35, 15, 15);//ajustement negociation
		g.fillRoundRect(884,143, 55, 35, 15, 15);//transformation negociation
		g.fillRoundRect(903,460, 55, 35, 15, 15);
		g.fillRoundRect(225, 380, 55, 35, 15, 15);
		g.fillRoundRect(777,337, 55, 35, 15, 15);
		g.fillRoundRect(777,424, 55, 35, 15, 15);*/
		g.setColor(Color.white);
		g.fillRoundRect(10, 10, 170, 60, 20, 20);
		
		
		//CHARGEMENT DES IMAGES
		
		Image rouge=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"rouge.png");
		Image consensus=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"consensus.png");
		Image pacte=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"pacte.png");
		Image bleu=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"bleu.png");
		Image ajustement=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"ajustement.png");
		Image transformation=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"transformation.png");
		Image vert=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"vert.png");
		Image domination=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"domination.png");
		Image contrePouvoir=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"contrepouvoir.png");
		Image antagonisme=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"antagonisme.png");
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			this.drawCenteredString(g, "Aujourd'hui", 10, 10, 170, 60, Color.black);
			
			//ROUND RECTANGLES POUR LES NOTES A DEFINIR
			
			try{
				int width=(int) (rouge.getWidth(null)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100);
				int height=(int) (rouge.getHeight(null)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100);
				int x=279-width/2;
				int y=210-height/2;
				if(FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()!=0){
					g.drawImage(rouge, x, y, width,height , null, null);
					try{
						int width_cons=(int) (consensus.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().get()+b)/100);
						int height_cons=(int) (consensus.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().get()+b)/100);
						int x_cons=279-width_cons/2;
						int y_cons=(int) ((166-210)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)+210-height_cons/2);
						if(FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().get()!=0){
							g.drawImage(consensus, x_cons, y_cons, width_cons,height_cons , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(140,148, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().toString(), 140,148, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_pac=(int) (pacte.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().get()+b)/100);
						int height_pac=(int) (pacte.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().get()+b)/100);
						int x_pac=279-width_pac/2;
						int y_pac=(int) ((250-210)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)+210-height_pac/2);
						if(FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().get()!=0){
							g.drawImage(pacte, x_pac, y_pac, width_pac,height_pac , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(140,234, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().toString(), 140,234, 55, 35, Color.black);
					}catch(NullPointerException ex){}
				}
				g.setColor(new Color(122,0,38));
				g.fillRoundRect(60, 119, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().toString(), 60, 119, 55, 35, Color.white);
			}catch(NullPointerException ex){}
			try{
				int width=(int) (bleu.getWidth(null)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100);
				int height=(int) (bleu.getHeight(null)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100);
				int x=694-width/2;
				int y=171-height/2;
				if(FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()!=0){
					g.drawImage(bleu, x, y, width,height , null, null);
					try{
						int width_aju=(int) (ajustement.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().get()+b)/100);
						int height_aju=(int) (ajustement.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().get()+b)/100);
						int x_aju=(int) ((606-694)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)+694-width_aju/2);
						int y_aju=171-height_aju/2;
						if(FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().get()!=0){
							g.drawImage(ajustement, x_aju, y_aju, width_aju,height_aju , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(578,55, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().toString(), 578, 55, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_transfo=(int) (transformation.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().get()+b)/100);
						int height_transfo=(int) (transformation.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().get()+b)/100);
						int x_transfo=(int) ((786-694)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)+694-width_transfo/2);
						int y_transfo=171-height_transfo/2;
						if(FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().get()!=0){
							g.drawImage(transformation, x_transfo, y_transfo, width_transfo,height_transfo , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(884, 143, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().toString(), 884, 143, 55, 35, Color.black);
					}catch(NullPointerException ex){}
				}
				g.setColor(new Color(27,20,100));
				g.fillRoundRect(885, 63, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().toString(), 885,63, 55, 35, Color.white);
			}catch(NullPointerException ex){}
			try{
				int width=(int) (vert.getWidth(null)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100);
				int height=(int) (vert.getHeight(null)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100);
				int x=568-width/2;
				int y=395-height/2;
				if(FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()!=0){
					g.drawImage(vert, x, y, width,height , null, null);
					try{
						int width_domi=(int) (domination.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().get()+b)/100);
						int height_domi=(int) (domination.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().get()+b)/100);
						int x_domi=(int) ((389-568)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+568-width_domi/2);
						int y_domi=395-height_domi/2;
						if(FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().get()!=0){
							g.drawImage(domination, x_domi, y_domi, width_domi,height_domi , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(243, 380, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().toString(), 243, 380, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_cp=(int) (contrePouvoir.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().get()+b)/100);
						int height_cp=(int) (contrePouvoir.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().get()+b)/100);
						int x_cp=(int) ((656-568)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+568-width_cp/2);
						int y_cp=(int) ((352-395)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+395-height_cp/2);
						if(FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().get()!=0){
							g.drawImage(contrePouvoir, x_cp, y_cp, width_cp,height_cp , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(777,337, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().toString(), 777, 337, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_ant=(int) (antagonisme.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().get()+b)/100);
						int height_ant=(int) (antagonisme.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().get()+b)/100);
						int x_ant=(int) ((655-568)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+568-width_ant/2);
						int y_ant=(int) ((439-395)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+395-height_ant/2);
						if(FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().get()!=0){
							g.drawImage(antagonisme, x_ant, y_ant, width_ant,height_ant , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(777,424, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().toString(), 777, 424, 55, 35, Color.black);
					}catch(NullPointerException ex){}
				}
				g.setColor(new Color(0,88,38));
				g.fillRoundRect(903,460, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().toString(), 903, 460, 55, 35, Color.white);
			}catch(NullPointerException ex){}

		}else if(this.getPeriode()>=1){
			if(this.getPeriode()>=2){
				this.setPeriode(2);
			}
			this.drawCenteredString(g, "Cible", 10, 10, 170, 60, Color.black);
			//ROUND RECTANGLES POUR LES NOTES A DEFINIR
			
			try{
				int width=(int) (rouge.getWidth(null)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100);
				int height=(int) (rouge.getHeight(null)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100);
				int x=279-width/2;
				int y=210-height/2;
				if(FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()!=0){
					g.drawImage(rouge, x, y, width,height , null, null);
					try{
						int width_cons=(int) (consensus.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().get()+b)/100);
						int height_cons=(int) (consensus.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().get()+b)/100);
						int x_cons=279-width_cons/2;
						int y_cons=(int) ((166-210)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)+210-height_cons/2);
						if(FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().get()!=0){
							g.drawImage(consensus, x_cons, y_cons, width_cons,height_cons , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(140,148, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().toString(), 140,148, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_pac=(int) (pacte.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getPacte().get()+b)/100);
						int height_pac=(int) (pacte.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getPacte().get()+b)/100);
						int x_pac=279-width_pac/2;
						int y_pac=(int) ((250-210)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)+210-height_pac/2);
						if(FenetreAccueil.etude.getS4().getApr_consensus().getPacte().get()!=0){
							g.drawImage(pacte, x_pac, y_pac, width_pac,height_pac , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(140,234, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_consensus().getPacte().toString(), 140,234, 55, 35, Color.black);
					}catch(NullPointerException ex){}
				}
				g.setColor(new Color(122,0,38));
				g.fillRoundRect(60, 119, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_consensus().getImportance().toString(), 60, 119, 55, 35, Color.white);
			}catch(NullPointerException ex){}
			try{
				int width=(int) (bleu.getWidth(null)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100);
				int height=(int) (bleu.getHeight(null)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100);
				int x=694-width/2;
				int y=171-height/2;
				if(FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()!=0){
					g.drawImage(bleu, x, y, width,height , null, null);
					try{
						int width_aju=(int) (ajustement.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().get()+b)/100);
						int height_aju=(int) (ajustement.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().get()+b)/100);
						int x_aju=(int) ((606-694)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)+694-width_aju/2);
						int y_aju=171-height_aju/2;
						if(FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().get()!=0){
							g.drawImage(ajustement, x_aju, y_aju, width_aju,height_aju , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(578,55, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().toString(), 578, 55, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_transfo=(int) (transformation.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().get()+b)/100);
						int height_transfo=(int) (transformation.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().get()+b)/100);
						int x_transfo=(int) ((786-694)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)+694-width_transfo/2);
						int y_transfo=171-height_transfo/2;
						if(FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().get()!=0){
							g.drawImage(transformation, x_transfo, y_transfo, width_transfo,height_transfo , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(884, 143, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().toString(), 884, 143, 55, 35, Color.black);
					}catch(NullPointerException ex){}
				}
				g.setColor(new Color(27,20,100));
				g.fillRoundRect(885, 63, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_negociation().getImportance().toString(), 885,63, 55, 35, Color.white);
			}catch(NullPointerException ex){}
			try{
				int width=(int) (vert.getWidth(null)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100);
				int height=(int) (vert.getHeight(null)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100);
				int x=568-width/2;
				int y=395-height/2;
				if(FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()!=0){
					g.drawImage(vert, x, y, width,height , null, null);
					try{
						int width_domi=(int) (domination.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getDomination().get()+b)/100);
						int height_domi=(int) (domination.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getDomination().get()+b)/100);
						int x_domi=(int) ((389-568)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+568-width_domi/2);
						int y_domi=395-height_domi/2;
						if(FenetreAccueil.etude.getS4().getApr_opposition().getDomination().get()!=0){
							g.drawImage(domination, x_domi, y_domi, width_domi,height_domi , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(243, 380, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getDomination().toString(), 243, 380, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_cp=(int) (contrePouvoir.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().get()+b)/100);
						int height_cp=(int) (contrePouvoir.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().get()+b)/100);
						int x_cp=(int) ((656-568)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+568-width_cp/2);
						int y_cp=(int) ((352-395)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+395-height_cp/2);
						if(FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().get()!=0){
							g.drawImage(contrePouvoir, x_cp, y_cp, width_cp,height_cp , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(777,337, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().toString(), 777, 337, 55, 35, Color.black);
					}catch(NullPointerException ex){}
					try{
						int width_ant=(int) (antagonisme.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().get()+b)/100);
						int height_ant=(int) (antagonisme.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().get()+b)/100);
						int x_ant=(int) ((655-568)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+568-width_ant/2);
						int y_ant=(int) ((439-395)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+395-height_ant/2);
						if(FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().get()!=0){
							g.drawImage(antagonisme, x_ant, y_ant, width_ant,height_ant , null, null);
						}
						g.setColor(Color.white);
						g.fillRoundRect(777,424, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().toString(), 777, 424, 55, 35, Color.black);
					}catch(NullPointerException ex){}
				}
				g.setColor(new Color(0,88,38));
				g.fillRoundRect(903,460, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getImportance().toString(), 903, 460, 55, 35, Color.white);
				//this.drawArrow(g);
			}catch(NullPointerException ex){}
			try{
				this.drawArrow(g);
			}catch(NullPointerException ex){}
		//mettre les risques
			/*g.setColor(Color.red);
			g.fillRoundRect(0, 310, 243, 225, 20, 20);*/
			if(this.getPeriode()>=2){
				String texte1="";
				String texte2="";
				String texte3="";
				try{
					texte1=texte1+"Risque Consensus ("+FenetreAccueil.etude.getS4().getRis_consensus().getImportance().toString()+")\n\n";
					try{
						texte1=texte1+"   -Consensus ("+FenetreAccueil.etude.getS4().getRis_consensus().getConsensus().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte1=texte1+"   -Pacte ("+FenetreAccueil.etude.getS4().getRis_consensus().getPacte().toString()+")";
					}catch(NullPointerException ex){}
					g.setColor(Color.red);
					g.fillRoundRect(0, 306, 243, 75, 20, 20);
					this.drawCenteredString(g, texte1, 0, 306, 243, 75, Color.white);
				}catch(NullPointerException ex){}
				try{
					texte2=texte2+"Risque Negociation ("+FenetreAccueil.etude.getS4().getRis_negociation().getImportance().toString()+")\n\n";
					try{
						texte2=texte2+"   -Ajustement hiérarchique ("+FenetreAccueil.etude.getS4().getRis_negociation().getAjustement().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte2=texte2+"   -Transformation négociée ("+FenetreAccueil.etude.getS4().getRis_negociation().getTransformation().toString()+")";
					}catch(NullPointerException ex){}
					g.setColor(Color.red);
					g.fillRoundRect(0, 383, 243, 75, 20, 20);
					this.drawCenteredString(g, texte2, 0, 383, 243, 75, Color.white);
				}catch(NullPointerException ex){}
				try{
					texte3=texte3+"Risque Opposition ("+FenetreAccueil.etude.getS4().getRis_opposition().getImportance().toString()+")\n\n";
					try{
						texte3=texte3+"   -Domination ("+FenetreAccueil.etude.getS4().getRis_opposition().getDomination().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte3=texte3+"   -Contre Pouvoir ("+FenetreAccueil.etude.getS4().getRis_opposition().getContrePouvoir().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte3=texte3+"   -Antagonisme ("+FenetreAccueil.etude.getS4().getRis_opposition().getAntagonisme().toString()+")";
					}catch(NullPointerException ex){}
					g.setColor(Color.red);
					g.fillRoundRect(0, 460, 243, 75, 20, 20);
					this.drawCenteredString(g, texte3, 0, 464, 243, 75, Color.white);
				}catch(NullPointerException ex){}
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
