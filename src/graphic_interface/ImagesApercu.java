package graphic_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagesApercu extends Conteneur{
	
	private int periode;
	
	public ImagesApercu(int width,int height,int periode){
		super(width,height);
		this.periode=periode;
	}
	
	public ImagesApercu(Dimension dim,int periode){
		this((int)dim.getWidth(),(int)dim.getHeight(),periode);
	}
	
	public int getPeriode(){
		return this.periode;
	}
	
	public void setPeriode(int periode){
		this.periode=periode;
	}
	
	public void drawArray_schema1(Graphics2D g,int instant_precedent){
		int avant=0;
		int maintenant=0;
		if(instant_precedent==0){
			avant = FenetreAccueil.etude.getS1().getMax_maintenant();
			maintenant=FenetreAccueil.etude.getS1().getMax_apres();
		}else if(instant_precedent==1){
			avant = FenetreAccueil.etude.getS1().getMax_apres();
			maintenant=FenetreAccueil.etude.getS1().getMax_encore_apres();
		}
		g.setColor(Color.red);
		if(avant ==0){
			if(maintenant==1){
				int[] X = { 2*411, 2*516, 2*516, 2*541, 2*516, 2*516, 2*411};
				int[] Y = { 2*105, 2*105, 2*85, 2*120, 2*155, 2*135, 2*135};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==2){
				int[] X = { 2*266, 2*266, 2*286, 2*251, 2*216, 2*236, 2*236};
				int[] Y = { 2*170, 2*220, 2*220, 2*240, 2*220, 2*220, 2*170};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant ==3){
				int[] X = { 2*385, 2*547, 2*564, 2*564, 2*500, 2*527, 2*365};
				int[] Y = { 2*144, 2*248, 2*221, 2*285, 2*290, 2*273, 2*169};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(avant ==1){
			if(maintenant==0){
				int[] X = { 2*541, 2*436, 2*436, 2*411, 2*436, 2*436, 2*541};
				int[] Y = { 2*105, 2*105, 2*85, 2*120, 2*155, 2*135, 2*135};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==2){
				int[] X = { 2*587, 2*425, 2*452, 2*388, 2*388, 2*405, 2*567};
				int[] Y = { 2*169, 2*273, 2*290, 2*285, 2*221, 2*248, 2*144};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant ==3){
				int[] X = { 2*717, 2*717, 2*737, 2*702, 2*667, 2*687, 2*687};
				int[] Y = { 2*170, 2*220, 2*220, 2*240, 2*220, 2*220, 2*170};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(avant==2){
			if(maintenant==0){
				int[] X = { 2*266, 2*266, 2*286, 2*251, 2*216, 2*236, 2*236};
				int[] Y = { 2*240, 2*190, 2*190, 2*170, 2*190, 2*190, 2*240};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==1){
				int[] X = { 2*385, 2*547, 2*564, 2*564, 2*500, 2*527, 2*365};
				int[] Y = { 2*316, 2*212, 2*239, 2*175, 2*170, 2*187, 2*291};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);	
			}else if(maintenant==3){
				int[] X = { 2*411, 2*516, 2*516, 2*541, 2*516, 2*516, 2*411};
				int[] Y = { 2*317, 2*317, 2*297, 2*332, 2*367, 2*347,2*347};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(avant==3){
			if(maintenant==0){
				int[] X = { 2*587, 2*425,2*452, 2*388, 2*388, 2*405, 2*567};
				int[] Y = { 2*291, 2*187, 2*170, 2*175, 2*239, 2*212, 2*316};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);	
			}else if(maintenant==1){
				int[] X = { 2*717, 2*717, 2*737, 2*702, 2*667, 2*687, 2*687};
				int[] Y = { 2*240, 2*190, 2*190, 2*170, 2*190, 2*190, 2*240};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(maintenant==2){
				int[] X = { 2*541, 2*436, 2*436, 2*411, 2*436, 2*436, 2*541};
				int[] Y = { 2*317, 2*317, 2*297, 2*332, 2*367, 2*347,2*347};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}
	}
	
	public void drawCenteredString(Graphics g, String text, int abscisse, int ordonnee, int width, int height,Color color){
		FontMetrics metrics = g.getFontMetrics(new Font(FenetreAccueil.theme.getPolice().getFontName(),FenetreAccueil.theme.getPolice().getStyle(),2*FenetreAccueil.theme.getPolice().getSize()));
		int y = ordonnee + (height - (metrics.getAscent()+metrics.getDescent())*text.split("\n").length)/2;
		g.setFont(new Font(FenetreAccueil.theme.getPolice().getFontName(),FenetreAccueil.theme.getPolice().getStyle(),2*FenetreAccueil.theme.getPolice().getSize()));
		g.setColor(color);
		for (String line : text.split("\n")){
			g.drawString(line, abscisse +(width - metrics.stringWidth(line))/2, y +=g.getFontMetrics().getAscent());
		}
	}
	
	public BufferedImage getImage(){
		BufferedImage image=new BufferedImage(1920,1080, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		this.paintComponent(g);
		return image;
	}
	
	public void paintComponent(Graphics g_base){
		super.paintComponent(g_base);
		Graphics2D g=(Graphics2D) g_base;
		if(!(this.getPeriode()>2)){
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_fond.png");
			Image technique=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton3.png");
			Image pression=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton2.png");
			Image protege=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton4.png");
			Image menace=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema1"+File.separator+"Etude_1_bouton1.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			g.setColor(Color.white);
			g.fillRoundRect(2*376, 2*10, 2*200, 2*60, 2*15, 2*15);
			if(this.getPeriode()==0){
				this.drawCenteredString(g, "Aujourd'hui", 2*376, 2*10, 2*200, 2*60,Color.black);
				g.setColor(Color.white);
				g.fillRoundRect(2*401, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*401, 2*245, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*245, 2*55, 2*35, 2*15, 2*15);
				try{
					int x=(int) (253-technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/200);
					int y=(int) (125-technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/200);
					int width=(int) (technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/100);
					int height=(int) (technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_contr_tech().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getMtn_contr_tech().get()!=0){
						g.drawImage(technique, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_contr_tech().toString(), 2*401, 2*178, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
				}
				try{
					int x=(int) (702-pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/200);
					int y=(int) (125-pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/200);
					int width=(int) (pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/100);
					int height=(int) (pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_press_envir().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getMtn_press_envir().get()!=0){
						g.drawImage(pression, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_press_envir().toString(), 2*498, 2*178, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
				}
				try{
					int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/200);
					int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/200);
					int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/100);
					int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getMtn_etabl_prot().get()!=0){
						g.drawImage(protege, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_etabl_prot().toString(), 2*401, 2*245, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
				}
				try{
					int x=(int) (702-menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/200);
					int y=(int) (332-menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/200);
					int width=(int) (menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/100);
					int height=(int) (menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getMtn_mena_mar().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getMtn_mena_mar().get()!=0){
						g.drawImage(menace, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getMtn_mena_mar().toString(), 2*498, 2*245, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
				}
			}else if(this.getPeriode()==1){
				this.drawCenteredString(g, "Demain", 2*376, 2*10, 2*200, 2*60,Color.black);
				this.drawArray_schema1(g, 0);
				g.setColor(Color.white);
				g.fillRoundRect(2*401, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*401, 2*245, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*245, 2*55, 2*35, 2*15, 2*15);
				try{
					int x=(int) (253-technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/200);
					int y=(int) (125-technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/200);
					int width=(int) (technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/100);
					int height=(int) (technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_contr_tech().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getApr_contr_tech().get()!=0){
						g.drawImage(technique, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_contr_tech().toString(), 2*401, 2*178, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
				}
				try{
					int x=(int) (702-pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/200);
					int y=(int) (125-pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/200);
					int width=(int) (pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/100);
					int height=(int) (pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_press_envir().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getApr_press_envir().get()!=0){
						g.drawImage(pression, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_press_envir().toString(), 2*498, 2*178, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
				}
				try{
					int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/200);
					int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/200);
					int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/100);
					int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_etabl_prot().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getApr_etabl_prot().get()!=0){
						g.drawImage(protege, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_etabl_prot().toString(), 2*401, 2*245, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
				}
				try{
					int x=(int) (702-menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/200);
					int y=(int) (332-menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/200);
					int width=(int) (menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/100);
					int height=(int) (menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getApr_mena_mar().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getApr_mena_mar().get()!=0){
						g.drawImage(menace, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getApr_mena_mar().toString(), 2*498, 2*245, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
				}
			}else if(this.getPeriode()==2){
				this.drawCenteredString(g, "Après-demain", 2*376, 2*10, 2*200, 2*60,Color.black);
				this.drawArray_schema1(g, 1);
				g.setColor(Color.white);
				g.fillOval(2*376, 2*380, 2*200, 2*60);
				g.fillRoundRect(2*401, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*401, 2*245, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*245, 2*55, 2*35, 2*15, 2*15);
				try{
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getCommentaire_risque(), 2*376, 2*380, 2*200, 2*60,Color.black);
				}catch(NullPointerException ex){}
				try{
					int x=(int) (253-technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/200);
					int y=(int) (125-technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/200);
					int width=(int) (technique.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/100);
					int height=(int) (technique.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_contr_tech().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getRis_contr_tech().get()!=0){
						g.drawImage(technique, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_contr_tech().toString(), 2*401, 2*178, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
				}
				try{
					int x=(int) (702-pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/200);
					int y=(int) (125-pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/200);
					int width=(int) (pression.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/100);
					int height=(int) (pression.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_press_envir().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getRis_press_envir().get()!=0){
						g.drawImage(pression, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_press_envir().toString(), 2*498, 2*178, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
				}
				try{
					int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/200);
					int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/200);
					int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/100);
					int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/100);
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_etabl_prot().toString(), 2*401, 2*245, 2*55, 2*35,Color.black);
					if(FenetreAccueil.etude.getS1().getRis_etabl_prot().get()!=0){
						g.drawImage(protege, 2*x, 2*y, 2*width,2*height , null, null);
					}
				}catch(NullPointerException ex){
					g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
				}
				try{
					int x=(int) (702-menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/200);
					int y=(int) (332-menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/200);
					int width=(int) (menace.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/100);
					int height=(int) (menace.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_mena_mar().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getRis_mena_mar().get()!=0){
						g.drawImage(menace, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_mena_mar().toString(), 2*498, 2*245, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
				}
			}
		}else if(this.getPeriode()==3 ||this.getPeriode()==4){
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema2"+File.separator+"Etude_2_fond.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			Image repos=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema2"+File.separator+"Etude_2_repos.png");
			Image actif=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema2"+File.separator+"Etude_2_actif.png");
			int width=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getWidth();
			int height=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getHeight();
			width=2*width;
			height=2*height;//multiplication par 2 des dimensions de l'image
			g.drawImage(repos,2*205,2*245,width,height,null,null);
			g.drawImage(repos,2*205,2*355,width,height,null,null);
			g.drawImage(repos,2*475,2*85,width,height,null,null);
			g.drawImage(repos,2*615,2*275,width,height,null,null);
			g.drawImage(repos,2*705,2*35,width,height,null,null);
			g.setColor(Color.white);
			if(this.getPeriode()==3){
				try{
					if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==1){//simple marche
						g.drawImage(actif,2*705,2*35,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==2){//professionnelle
						g.drawImage(actif,2*475,2*85,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 665, 372, 70, 36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==3){//mecaniste
						g.drawImage(actif,2*205,2*245,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==4){//simple centralisee
						g.drawImage(actif,2*205,2*355,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==5){//entrepreneuriale
						g.drawImage(actif,2*615,2*275,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[1].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[2].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[0].getNote())+" / 10", 385, 382, 70, 36,Color.black);
						}
					}
				}catch(NullPointerException ex){}
			}else if(this.getPeriode()==4){
				try{
					if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){//simple marche
						g.drawImage(actif,2*705,2*35,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){//professionnelle
						g.drawImage(actif,2*475,2*85,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){//mecaniste
						g.setColor(Color.white);g.drawImage(actif,2*205,2*245,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){//simple centralisee
						g.drawImage(actif,2*205,2*355,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*665, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){//entrepreneuriale
						g.drawImage(actif,2*615,2*275,width,height,null,null);
						if(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*755, 2*132, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*755, 2*132, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*525, 2*182, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[1].getNote())+" / 10", 2*525, 2*182, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*272, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[2].getNote())+" / 10", 2*385, 2*272, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*385, 2*382, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[0].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
					}
				}catch(NullPointerException ex){}
				try{
					String texte="Risque principal :\n\n "+FenetreAccueil.etude.getS2().getRis_principale().getNom().replaceAll("\n", " ")+"\n\nRisques notés :\n\n";
					g.setColor(Color.red);
					g.fillRoundRect(2*205, 2*10, 2*260, 2*210, 2*20, 2*20);
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
					this.drawCenteredString(g, texte, 2*205, 2*10, 2*260, 2*210, Color.white);
				}catch(NullPointerException ex){}
			}
			this.drawCenteredString(g, Structure.SIMPLE_MARCHE.getNom(), 2*705, 2*35, width, height,Color.white);
			this.drawCenteredString(g, Structure.PROFESSIONNELLE.getNom(), 2*475, 2*85, width, height,Color.white);
			this.drawCenteredString(g, Structure.MECANISTE.getNom(), 2*205, 2*245, width, height,Color.white);
			this.drawCenteredString(g, Structure.SIMPLE_CENTRALISEE.getNom(), 2*205, 2*355, width, height,Color.white);
			this.drawCenteredString(g, Structure.ENTREPRENEURIALE.getNom(), 2*615, 2*275, width, height,Color.white);
		}else if(this.getPeriode()==5||this.getPeriode()==6){
			
		}
	}

}
