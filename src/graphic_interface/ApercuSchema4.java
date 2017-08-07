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

public class ApercuSchema4 extends ConteneurAvecImage{
	
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
		g.fillRoundRect(777,424, 55, 35, 15, 15);
		*/
		
		//CHARGEMENT DES IMAGES
		
		Image rouge=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton3.png");
		Image consensus=null;
		Image pacte=null;
		Image bleu=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton2.png");
		Image ajustement=null;
		Image transformation=null;
		Image vert=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton4.png");
		Image domination=null;
		Image contrePouvoir=null;
		Image antagonisme=null;
		
		if(this.getPeriode()<=0){
			this.setPeriode(0);
			
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
				g.setColor(Color.white);
				g.fillRoundRect(60, 119, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().toString(), 60, 119, 55, 35, Color.black);
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
				g.setColor(Color.white);
				g.fillRoundRect(885, 63, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().toString(), 885,63, 55, 35, Color.black);
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
						g.fillRoundRect(225, 380, 55, 35, 15, 15);
						this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().toString(), 225, 380, 55, 35, Color.black);
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
				g.setColor(Color.white);
				g.fillRoundRect(903,460, 55, 35, 15, 15);
				this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().toString(), 903, 460, 55, 35, Color.black);
			}catch(NullPointerException ex){}

		}else if(this.getPeriode()==1){
			
		}
		
		alpha +=0.02f;
		if(alpha >= 1.0f){
			alpha=1.0f;
		}else{
			repaint();
		}
		
	}

}
