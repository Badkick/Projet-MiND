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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
				}
			}catch(NullPointerException ex){}
		}else if(this.getPeriode()>=1){
			this.setPeriode(1);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
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
						this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 385, 382, 70, 36,Color.black);
					}
				}
			}catch(NullPointerException ex){}
			try{
				String texte="Risque principal :\n\n "+FenetreAccueil.etude.getS2().getRis_principale().getNom().replaceAll("\n", " ")+"\n\nRisques notés :\n\n";
				g.setColor(Color.red);
				g.fillRoundRect(205, 10, 260, 210, 20, 20);
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
				this.drawCenteredString(g, texte, 205, 10, 260, 210, Color.white);
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
