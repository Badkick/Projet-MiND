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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public void drawArrow_schema1(Graphics2D g,int instant_precedent){
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
	
	public void drawArrow_schema2(Graphics2D g){
		g.setColor(new Color(255, 211, 33));
		if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==1){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 2*700, 2*665, 2*669, 2*646, 2*653, 2*657, 2*692};
				int[] Y = { 2*114, 2*124, 2*138, 2*114, 2*81, 2*95, 2*85};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 2*776, 2*787, 2*443, 2*449, 2*382, 2*427, 2*433};
				int[] Y = { 2*125, 2*153, 2*287, 2*300, 2*294, 2*245, 2*258};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 2*775, 2*791, 2*440, 2*448, 2*381, 2*416, 2*424};
				int[] Y = { 2*123, 2*148, 2*372, 2*385, 2*392, 2*334, 2*346};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 2*769, 2*797, 2*769, 2*783, 2*734, 2*727, 2*741};
				int[] Y = { 2*127, 2*138, 2*209, 2*215, 2*259, 2*193, 2*198};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==2){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 2*657, 2*686, 2*691, 2*697, 2*674, 2*678, 2*649};
				int[] Y = { 2*127, 2*118, 2*133, 2*99, 2*75, 2*89, 2*98};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 2*451, 2*472, 2*434, 2*444, 2*380, 2*402, 2*413};
				int[] Y = { 2*149, 2*171, 2*208, 2*219, 2*239, 2*176, 2*187};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 2*529, 2*553, 2*434, 2*446, 2*385, 2*399, 2*410};
				int[] Y = { 2*181, 2*200, 2*350, 2*359, 2*388, 2*322, 2*331};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 2*627, 2*635, 2*649, 2*635, 2*591, 2*605, 2*598};
				int[] Y = { 2*175, 2*206, 2*203, 2*268, 2*217, 2*213, 2*182};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==3){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 2*377, 2*729, 2*723, 2*790, 2*749, 2*743, 2*390};
				int[] Y = { 2*304, 2*139, 2*125, 2*127, 2*179, 2*166, 2*332};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 2*374, 2*488, 2*480, 2*547, 2*512, 2*504, 2*390};
				int[] Y = { 2*269, 2*198, 2*185, 2*179, 2*236, 2*223, 2*295};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 2*275, 2*275, 2*261, 2*290, 2*319, 2*305, 2*305};
				int[] Y = { 2*333, 2*339, 2*339, 2*355, 2*339, 2*339, 2*333};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 2*384, 2*553, 2*554, 2*611, 2*547, 2*549, 2*380};
				int[] Y = { 2*275, 2*296, 2*281, 2*318, 2*341, 2*326, 2*305};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==4){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 2*374, 2*709, 2*701, 2*767, 2*734, 2*726, 2*391};
				int[] Y = { 2*373, 2*149, 2*137, 2*128, 2*187, 2*174, 2*397};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 2*374, 2*486, 2*474, 2*533, 2*523, 2*511, 2*399};
				int[] Y = { 2*379, 2*216, 2*207, 2*174, 2*241, 2*233, 2*396};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 2*274, 2*274, 2*258, 2*289, 2*320, 2*304, 2*304};
				int[] Y = { 2*353, 2*348, 2*348, 2*333, 2*348, 2*348, 2*353};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==5){
				int[] X = { 2*380, 2*550, 2*545, 2*612, 2*563, 2*559, 2*388};
				int[] Y = { 2*373, 2*321, 2*307, 2*318, 2*364, 2*350, 2*402};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS2().getMtn_principale().getNumero()==5){
			if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==1){
				int[] X = { 2*699, 2*733,2*720, 2*773, 2*774, 2*761, 2*726};
				int[] Y = { 2*251, 2*181, 2*174, 2*134, 2*201, 2*194, 2*265};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==2){
				int[] X = { 2*641, 2*624, 2*610, 2*610, 2*664, 2*651, 2*668};
				int[] Y = { 2*273, 2*239, 2*246, 2*179, 2*219, 2*225, 2*259};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){
				int[] X = { 2*602, 2*444, 2*443, 2*384, 2*446, 2*445, 2*603};
				int[] Y = { 2*315, 2*308, 2*323, 2*290, 2*263, 2*277, 2*285};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==4){
				int[] X = { 2*602, 2*450, 2*455, 2*389, 2*437, 2*442, 2*593};
				int[] Y = { 2*341, 2*388,2*403,2*391, 2*345, 2*359, 2*312};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}
	}
	
	public void drawArrow_schema3(Graphics2D g){
		g.setColor(new Color(255, 211, 33));
		if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==1){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 2*364, 2*377, 2*377, 2*392, 2*375, 2*375, 2*364};
				int[] Y = { 2*111, 2*111, 2*96, 2*127, 2*156, 2*141, 2*141};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 2*381, 2*567, 2*567, 2*583, 2*567, 2*567, 2*381};
				int[] Y = { 2*61, 2*61, 2*48, 2*77, 2*107, 2*93, 2*93};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 2*290, 2*290, 2*303, 2*274, 2*245, 2*258, 2*258};
				int[] Y = { 2*180, 2*324, 2*324, 2*340, 2*324, 2*324, 2*180};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 2*302, 2*573, 2*581, 2*579, 2*552, 2*559, 2*287};
				int[] Y = { 2*172, 2*323, 2*311, 2*343, 2*362, 2*350, 2*198};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==2){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 2*389, 2*383, 2*383, 2*367, 2*383, 2*383, 2*389};
				int[] Y = { 2*108, 2*108, 2*94, 2*123, 2*153, 2*139, 2*139};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 2*562, 2*570, 2*570, 2*585, 2*570, 2*570, 2*562};
				int[] Y = { 2*108, 2*109, 2*95, 2*124, 2*153, 2*139, 2*139};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 2*412, 2*355, 2*369, 2*335, 2*314, 2*327, 2*385};
				int[] Y = { 2*200, 2*332, 2*339, 2*340, 2*315, 2*320, 2*188};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 2*541, 2*568, 2*635, 2*649, 2*628, 2*595, 2*608};
				int[] Y = { 2*201, 2*187, 2*318, 2*310, 2*338, 2*338, 2*332};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==3){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 2*583, 2*383, 2*383, 2*368, 2*383, 2*383, 2*583};
				int[] Y = { 2*61, 2*61, 2*48, 2*77, 2*105, 2*87, 2*87};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 2*585, 2*577, 2*576, 2*562, 2*577, 2*577, 2*585};
				int[] Y = { 2*116, 2*116, 2*102, 2*131, 2*160, 2*146, 2*146};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 2*597, 2*380, 2*371, 2*376, 2*407, 2*398, 2*615};
				int[] Y = { 2*169, 2*329, 2*318, 2*351, 2*366, 2*354, 2*192};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 2*714, 2*713, 2*698, 2*727, 2*758, 2*744, 2*745};
				int[] Y = { 2*177, 2*325, 2*325, 2*341, 2*326, 2*326, 2*177};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==4){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 2*258, 2*258, 2*244, 2*274, 2*304, 2*288, 2*288};
				int[] Y = { 2*334, 2*177, 2*176, 2*161, 2*177, 2*176, 2*334};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 2*304, 2*430, 2*422, 2*452, 2*463, 2*452, 2*325};
				int[] Y = { 2*322, 2*196, 2*187, 2*196, 2*227, 2*219, 2*343};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 2*373, 2*614, 2*607, 2*636, 2*640, 2*632, 2*390};
				int[] Y = { 2*337, 2*172, 2*160, 2*175, 2*208, 2*197, 2*362};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
				int[] X = { 2*374, 2*566, 2*566, 2*582, 2*566, 2*566, 2*374};
				int[] Y = { 2*380, 2*379, 2*365, 2*395, 2*423, 2*410, 2*409};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==5){
			if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
				int[] X = { 2*569, 2*324, 2*317, 2*320, 2*350, 2*342, 2*586};
				int[] Y = { 2*365, 2*200, 2*210, 2*178, 2*163, 2*174, 2*340};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
				int[] X = { 2*597, 2*498, 2*485, 2*499, 2*533, 2*522, 2*621};
				int[] Y = { 2*343, 2*215, 2*223, 2*194, 2*186, 2*195, 2*324};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
				int[] X = { 2*657, 2*654, 2*641, 2*670, 2*699, 2*686, 2*687};
				int[] Y = { 2*339, 2*180, 2*180, 2*164, 2*180, 2*180, 2*339};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
				int[] X = { 2*570, 2*389, 2*388, 2*372, 2*387, 2*387, 2*570};
				int[] Y = { 2*379, 2*375, 2*361, 2*389, 2*420, 2*406, 2*410};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}
	}
	
	public void drawArrow_schema4(Graphics2D g){
		int maintenant=FenetreAccueil.etude.getS4().getMax_maintenant();
		int apres=FenetreAccueil.etude.getS4().getMax_apres();
		g.setColor(new Color(255, 211, 33));
		if(maintenant==0){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*352, 2*155, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==2){
				int[] X = { 2*372, 2*500, 2*500, 2*513, 2*500, 2*500, 2*372};
				int[] Y = { 2*151, 2*151, 2*137, 2*167, 2*197, 2*181, 2*181};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*361, 2*1, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*352, 2*168, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==5){
				int[] X = { 2*364, 2*557, 2*563, 2*562, 2*535, 2*542, 2*349};
				int[] Y = { 2*177, 2*292, 2*281, 2*312, 2*330, 2*318, 2*203};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				int[] X = { 2*366, 2*554, 2*564, 2*553, 2*521, 2*532, 2*344};
				int[] Y = { 2*187, 2*393, 2*384, 2*414, 2*423, 2*413, 2*207};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==1){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*357, 2*154, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==2){
				int[] X = { 2*360, 2*498, 2*494, 2*516, 2*512, 2*506, 2*369};
				int[] Y = { 2*225, 2*181, 2*168, 2*191, 2*222, 2*211, 2*253};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*368, 2*235, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==4){
				int[] X = { 2*314, 2*344, 2*356, 2*338, 2*306, 2*318, 2*288};
				int[] Y = { 2*287, 2*338, 2*331, 2*359, 2*360, 2*353, 2*302};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==5){
				int[] X = { 2*365, 2*543, 2*548, 2*552, 2*528, 2*533, 2*355};
				int[] Y = { 2*240, 2*305, 2*292, 2*325, 2*347, 2*333, 2*268};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				int[] X = { 2*359, 2*552, 2*560, 2*558, 2*529, 2*536, 2*342};
				int[] Y = { 2*264, 2*389, 2*378, 2*409, 2*427, 2*415, 2*289};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==2){
			if(apres==0){
				int[] X = { 2*509, 2*372, 2*372, 2*357, 2*371, 2*371, 2*509};
				int[] Y = { 2*152, 2*149, 2*134, 2*164, 2*193, 2*179, 2*181};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==1){
				int[] X = { 2*511, 2*366, 2*362, 2*355, 2*377, 2*374, 2*519};
				int[] Y = { 2*181, 2*220, 2*206, 2*239, 2*263, 2*249, 2*210};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*633, 2*14, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==4){
				int[] X = { 2*530, 2*449, 2*438, 2*453, 2*485, 2*474, 2*555};
				int[] Y = { 2*223, 2*338, 2*331, 2*359, 2*364, 2*355, 2*240};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==5){
				int[] X = { 2*599, 2*604, 2*589, 2*620, 2*647, 2*633, 2*628};
				int[] Y = { 2*256, 2*300, 2*300, 2*312, 2*294, 2*295, 2*253};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*491, 2*227, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==3){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*175, 2*13, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*197, 2*233, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*624, 2*242, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 2*709, 2*473, 2*466, 2*466, 2*492, 2*487, 2*723};
				int[] Y = { 2*228, 2*344, 2*331, 2*365, 2*385, 2*371, 2*255};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				int[] X = { 2*749, 2*727, 2*714, 2*735, 2*768, 2*754, 2*777};
				int[] Y = { 2*248, 2*301, 2*296, 2*321, 2*319, 2*313, 2*259};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*832, 2*213, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==4){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*354, 2*104, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==1){
				int[] X = { 2*335, 2*314, 2*300, 2*323, 2*356, 2*342, 2*363};
				int[] Y = { 2*363, 2*302, 2*307, 2*283, 2*287, 2*292, 2*353};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				int[] X = { 2*425, 2*520, 2*509, 2*541, 2*555, 2*544, 2*449};
				int[] Y = { 2*346, 2*230, 2*220, 2*227, 2*258, 2*248, 2*365};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 2*471, 2*697, 2*689, 2*717, 2*720, 2*712, 2*487};
				int[] Y = { 2*353, 2*216, 2*203, 2*221, 2*254, 2*242, 2*378};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*448, 2*264, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*448, 2*447, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==5){
			if(apres==0){
				int[] X = { 2*550, 2*362, 2*352, 2*358, 2*389, 2*379, 2*568};
				int[] Y = { 2*340, 2*199, 2*209, 2*177, 2*162, 2*175, 2*315};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				int[] X = { 2*534, 2*364, 2*357, 2*355, 2*381, 2*375, 2*546};
				int[] Y = { 2*357, 2*285, 2*298, 2*266, 2*244, 2*258, 2*329};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				int[] X = { 2*587, 2*586, 2*572, 2*601, 2*631, 2*617, 2*617};
				int[] Y = { 2*315, 2*269, 2*269, 2*253, 2*268, 2*268, 2*314};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 2*703, 2*730, 2*717, 2*750, 2*770, 2*757, 2*729};
				int[] Y = { 2*309, 2*255, 2*248, 2*247, 2*274, 2*268, 2*323};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*357, 2*287, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==6){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*822, 2*351, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==6){
			if(apres==0){
				int[] X = { 2*546, 2*360, 2*349, 2*361, 2*393, 2*383, 2*569};
				int[] Y = { 2*422, 2*204, 2*212, 2*181, 2*174, 2*184, 2*402};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				int[] X = { 2*558, 2*357, 2*350, 2*353, 2*382, 2*375, 2*575};
				int[] Y = { 2*426, 2*289, 2*301, 2*267, 2*252, 2*264, 2*401};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*446, 2*180, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*792, 2*159, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*361, 2*433, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*822, 2*351, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}
	}
	
	public void drawArrow_schema5(Graphics2D g){
		int maintenant=FenetreAccueil.etude.getS5().getMax_maintenant();
		int apres=FenetreAccueil.etude.getS5().getMax_apres();
		g.setColor(new Color(255, 211, 33));
		if(maintenant==0){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*269, 2*1, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==2){
				int[] X = { 2*294, 2*385, 2*392, 2*393, 2*367, 2*373, 2*281};
				int[] Y = { 2*169, 2*211, 2*198, 2*232, 2*252, 2*239, 2*196};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*299, 2*111, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 2*233, 2*259, 2*273, 2*248, 2*215, 2*230, 2*204};
				int[] Y = { 2*214, 2*350, 2*348, 2*369, 2*360, 2*356, 2*220};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*306, 2*120, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==1){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*201, 2*3, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==2){
				int[] X = { 2*601, 2*570, 2*579, 2*548, 2*540, 2*550, 2*580};
				int[] Y = { 2*196, 2*222, 2*234, 2*222, 2*189, 2*200, 2*173};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 2*676, 2*649, 2*663, 2*630, 2*605, 2*619, 2*647};
				int[] Y = { 2*206, 2*312, 2*316, 2*323, 2*301, 2*304, 2*198};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*50, 2*125, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==5){
				int[] X = { 2*763, 2*815, 2*829, 2*804, 2*771, 2*786, 2*734};
				int[] Y = { 2*189, 2*382, 2*379, 2*402, 2*394, 2*390, 2*195};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==2){
			if(apres==0){
				int[] X = { 2*388, 2*301, 2*294, 2*296, 2*325, 2*318, 2*404};
				int[] Y = { 2*244, 2*189, 2*200, 2*167, 2*151, 2*163, 2*219};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				int[] X = { 2*529, 2*566, 2*556, 2*587, 2*598, 2*587, 2*549};
				int[] Y = { 2*210, 2*174, 2*163, 2*174, 2*207, 2*196, 2*232};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*568, 2*226, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 2*416, 2*380, 2*391, 2*358, 2*345, 2*357, 2*393};
				int[] Y = { 2*348, 2*391, 2*400, 2*393, 2*362, 2*371, 2*329};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*564, 2*271, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==3){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*37, 2*194, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==1){
				int[] X = { 2*643, 2*669, 2*683, 2*657, 2*625, 2*639, 2*614};
				int[] Y = { 2*325, 2*210, 2*214, 2*192, 2*200, 2*203, 2*318};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*380, 2*353, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==4){
				int[] X = { 2*512, 2*399, 2*399, 2*381, 2*394, 2*395, 2*509};
				int[] Y = { 2*427, 2*438, 2*452, 2*425, 2*392, 2*408, 2*396};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*672, 2*276, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==4){
			if(apres==0){
				int[] X = { 2*215, 2*200, 2*186, 2*213, 2*245, 2*230, 2*245};
				int[] Y = { 2*373, 2*238, 2*239, 2*220, 2*232, 2*233, 2*370};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*373, 2*178, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==2){
				int[] X = { 2*343, 2*382, 2*372, 2*404, 2*415, 2*404, 2*366};
				int[] Y = { 2*379, 2*338, 2*328, 2*337, 2*368, 2*359, 2*400};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 2*383, 2*496, 2*498, 2*510, 2*491, 2*492, 2*380};
				int[] Y = { 2*445, 2*431, 2*445, 2*414, 2*386, 2*401, 2*414};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*321, 2*294, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==5){
			if(apres==0){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*19, 2*215, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==1){
				int[] X = { 2*771, 2*720, 2*705, 2*730, 2*763, 2*749, 2*800};
				int[] Y = { 2*403, 2*210, 2*214, 2*191, 2*198, 2*202, 2*395};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*506, 2*130, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==3){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*683, 2*278, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==4){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"fleche"+String.valueOf(maintenant+1)+String.valueOf(apres+1)+".png");
				g.drawImage(image, 2*83, 2*279, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}
	}
	
	public void drawArrow_schema6(Graphics2D g,int instant_precedent){
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
				g.drawImage(image, 2*217, 2*149, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==3){
				int[] X = { 2*496, 2*590, 2*592, 2*603, 2*585, 2*586, 2*492};
				int[] Y = { 2*140, 2*151, 2*137, 2*168, 2*196, 2*182, 2*170};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 2*488, 2*568, 2*580, 2*567, 2*534, 2*544, 2*465};
				int[] Y = { 2*188, 2*287, 2*279, 2*310, 2*316, 2*307, 2*207};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 2*143, 2*155, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==2){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 2*248, 2*141, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==3){
				int[] X = { 2*475, 2*587, 2*582, 2*607, 2*606, 2*599, 2*487};
				int[] Y = { 2*250, 2*201, 2*188, 2*209, 2*242, 2*230, 2*277};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 2*489, 2*537, 2*542, 2*546, 2*522, 2*526, 2*478};
				int[] Y = { 2*294, 2*312, 2*300, 2*333, 2*355, 2*341, 2*322};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 2*198, 2*250, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}
		}else if(maintenant==3){
			if(apres==1){
				int[] X = { 2*606, 2*513, 2*515, 2*495, 2*504, 2*508, 2*601};
				int[] Y = { 2*166, 2*149, 2*135, 2*160, 2*193, 2*178, 2*196};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==2){
				int[] X = { 2*614, 2*500, 2*505, 2*481, 2*486, 2*492, 2*605};
				int[] Y = { 2*234, 2*271, 2*285, 2*262, 2*229, 2*242, 2*205};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 2*694, 2*685, 2*699, 2*666, 2*642, 2*656, 2*664};
				int[] Y = { 2*262, 2*291, 2*295, 2*302, 2*278, 2*282, 2*253};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				int[] X = { 2*625, 2*433, 2*441, 2*411, 2*405, 2*415, 2*607};
				int[] Y = { 2*244, 2*389, 2*401, 2*386, 2*352, 2*364, 2*219};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==4){
			if(apres==1){
				int[] X = { 2*566, 2*474, 2*464, 2*476, 2*508, 2*497, 2*589};
				int[] Y = { 2*315, 2*209, 2*219, 2*188, 2*180, 2*190, 2*295};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if (apres==2){
				int[] X = { 2*558, 2*492, 2*487, 2*483, 2*508, 2*503, 2*569};
				int[] Y = { 2*336, 2*310, 2*323, 2*290, 2*268, 2*282, 2*308};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==3){
				int[] X = { 2*649, 2*657, 2*644, 2*677, 2*700, 2*687, 2*677};
				int[] Y = { 2*294, 2*265, 2*260, 2*254, 2*277, 2*273, 2*303};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==5){
				int[] X = { 2*544, 2*431, 2*432, 2*413, 2*423, 2*426, 2*538};
				int[] Y = { 2*384, 2*403, 2*417, 2*390, 2*358, 2*373, 2*355};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}else if(maintenant==5){
			if(apres==1){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 2*203, 2*75, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if (apres==2){
				Image image=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"fleche"+String.valueOf(maintenant)+String.valueOf(apres)+".png");
				g.drawImage(image, 2*216, 2*224, 2*image.getWidth(null), 2*image.getHeight(null), null);
			}else if(apres==3){
				int[] X = { 2*409, 2*598, 2*590, 2*619, 2*624, 2*616, 2*427};
				int[] Y = { 2*367, 2*228, 2*216, 2*231, 2*264, 2*252, 2*391};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}else if(apres==4){
				int[] X = { 2*416, 2*527, 2*525, 2*545, 2*536, 2*533, 2*422};
				int[] Y = { 2*386, 2*365, 2*351, 2*377, 2*409, 2*395, 2*416};
				Shape shape=new Polygon(X,Y,X.length);
				g.fill(shape);
			}
		}
	}
	
	
	public void drawCenteredString(Graphics g, String text, int abscisse, int ordonnee, int width, int height,Color color){
		FontMetrics metrics = g.getFontMetrics(new Font(FenetreAccueil.theme.getPolice().getFontName(),Font.BOLD,2*FenetreAccueil.theme.getPolice().getSize()));
		int y = ordonnee + (height - (metrics.getAscent()+metrics.getDescent())*text.split("\n").length)/2;
		g.setFont(new Font(FenetreAccueil.theme.getPolice().getFontName(),Font.BOLD,2*FenetreAccueil.theme.getPolice().getSize()));
		g.setColor(color);
		for (String line : text.split("\n")){
			g.drawString(line, abscisse +(width - metrics.stringWidth(line))/2, y +=g.getFontMetrics().getAscent());
		}
	}
	
	public void drawMainTitle(Graphics g, String text, int abscisse, int ordonnee, int width, int height,Color color){
		FontMetrics metrics = g.getFontMetrics(new Font(FenetreAccueil.theme.getPolice().getFontName(),FenetreAccueil.theme.getPolice().getStyle(),8*FenetreAccueil.theme.getPolice().getSize()));
		int y = ordonnee + (height - (metrics.getAscent()+metrics.getDescent())*text.split("\n").length)/2;
		g.setFont(new Font(FenetreAccueil.theme.getPolice().getFontName(),FenetreAccueil.theme.getPolice().getStyle(),8*FenetreAccueil.theme.getPolice().getSize()));
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
				this.drawCenteredString(g, "Années 2000", 2*376, 2*10, 2*200, 2*60,Color.black);
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
					//g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
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
					//g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
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
					//g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
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
					//g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
				}
			}else if(this.getPeriode()==1){
				this.drawCenteredString(g, "Années 2010", 2*376, 2*10, 2*200, 2*60,Color.black);
				try{
					this.drawArrow_schema1(g, 0);
				}catch(NullPointerException ex){}
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
					//g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
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
					//g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
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
					//g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
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
					//g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
				}
			}else if(this.getPeriode()==2){
				this.drawCenteredString(g, "Années 2020", 2*376, 2*10, 2*200, 2*60,Color.black);
				try{
					this.drawArrow_schema1(g, 1);
				}catch(NullPointerException ex){}
				g.setColor(Color.white);
				g.fillRoundRect(2*401, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*178, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*401, 2*245, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*498, 2*245, 2*55, 2*35, 2*15, 2*15);
				try{
					if(!FenetreAccueil.etude.getS1().getCommentaire_risque().equals("")){
						g.setColor(Color.white);
						g.fillOval(2*376, 2*380, 2*200, 2*60);
					}
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
					//g.drawImage(technique,(int)(253-technique.getWidth(null)/2),(int)(125-technique.getHeight(null)/2),technique.getWidth(null),technique.getHeight(null),null,null);
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
					//g.drawImage(pression,(int)(702-pression.getWidth(null)/2),(int)(125-pression.getHeight(null)/2),pression.getWidth(null),pression.getHeight(null),null,null);
				}
				try{
					int x=(int) (253-protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/200);
					int y=(int) (332-protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/200);
					int width=(int) (protege.getWidth(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/100);
					int height=(int) (protege.getHeight(null)*(0.7*FenetreAccueil.etude.getS1().getRis_etabl_prot().get()+30)/100);
					if(FenetreAccueil.etude.getS1().getRis_etabl_prot().get()!=0){
						g.drawImage(protege, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS1().getRis_etabl_prot().toString(), 2*401, 2*245, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){
					//g.drawImage(protege,(int)(253-protege.getWidth(null)/2),(int)(332-technique.getHeight(null)/2),protege.getWidth(null),protege.getHeight(null),null,null);
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
					//g.drawImage(menace,(int)(702-menace.getWidth(null)/2),(int)(332-menace.getHeight(null)/2),menace.getWidth(null),menace.getHeight(null),null,null);
				}
			}
		}else if(this.getPeriode()==3 ||this.getPeriode()==4 ||this.getPeriode()==5){
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
			g.fillRoundRect(2*10, 2*10, 2*170, 2*60, 2*20, 2*20);
			if(this.getPeriode()==3){
				this.drawCenteredString(g, "Aujourd'hui", 2*10, 2*10, 2*170, 2*60, Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getMtn_notees()[3].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
					}
				}catch(NullPointerException ex){}
			}else if(this.getPeriode()>=4){
				this.drawCenteredString(g, "Cible", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					this.drawArrow_schema2(g);
				}catch(NullPointerException ex){}
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS2().getApr_principale().getNumero()==3){//mecaniste
						g.drawImage(actif,2*205,2*245,width,height,null,null);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 2*665, 2*372, 2*70, 2*36,Color.black);
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
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS2().getApr_notees()[3].getNote())+" / 10", 2*385, 2*382, 2*70, 2*36,Color.black);
						}
					}
				}catch(NullPointerException ex){}
				if(this.getPeriode()==5){
					try{
						String texte="Risques notés :\n\n";
						if(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS2().getRis_notees()[0].getElement().getNom().replaceAll("\n", " ")+"\n ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[0].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS2().getRis_notees()[1].getElement().getNom().replaceAll("\n", " ")+"\n ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[1].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS2().getRis_notees()[2].getElement().getNom().replaceAll("\n", " ")+"\n ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[2].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS2().getRis_notees()[3].getElement().getNom().replaceAll("\n", " ")+"\n ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[3].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS2().getRis_notees()[4].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS2().getRis_notees()[4].getElement().getNom().replaceAll("\n", " ")+"\n ("+String.valueOf(FenetreAccueil.etude.getS2().getRis_notees()[4].getNote())+" / 10)\n";
						}
						String comparaison="Risques notés :\n\n";
						if(!comparaison.equals(texte)){
							g.setColor(Color.red);
							g.fillRoundRect(2*205, 2*10, 2*260, 2*200, 2*20, 2*20);
							this.drawCenteredString(g, texte, 2*205, 2*10, 2*260, 2*200, Color.white);
						}
					}catch(NullPointerException ex){}
				}
			}
			this.drawCenteredString(g, Structure.SIMPLE_MARCHE.getNom(), 2*705, 2*35, width, height,Color.white);
			this.drawCenteredString(g, Structure.PROFESSIONNELLE.getNom(), 2*475, 2*85, width, height,Color.white);
			this.drawCenteredString(g, Structure.MECANISTE.getNom(), 2*205, 2*245, width, height,Color.white);
			this.drawCenteredString(g, Structure.SIMPLE_CENTRALISEE.getNom(), 2*205, 2*355, width, height,Color.white);
			this.drawCenteredString(g, Structure.ENTREPRENEURIALE.getNom(), 2*615, 2*275, width, height,Color.white);
			
		}else if(this.getPeriode()==6||this.getPeriode()==7 ||this.getPeriode()==8){
			
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema3"+File.separator+"Etude_3_fond.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			Image repos=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema3"+File.separator+"Etude_3_repos.png");
			Image actif=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema3"+File.separator+"Etude_3_actif.png");
			int width=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getWidth();
			int height=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMAS23.getHeight();
			width=2*width;
			height=2*height;
			g.drawImage(repos,2*195,2*70,width,height,null,null);
			g.drawImage(repos,2*390,2*95,width,height,null,null);
			g.drawImage(repos,2*587,2*70,width,height,null,null);
			g.drawImage(repos,2*195,2*345,width,height,null,null);
			g.drawImage(repos,2*587,2*345,width,height,null,null);
			g.setColor(Color.white);
			g.fillRoundRect(2*10, 2*10, 2*170, 2*60, 2*20, 2*20);
			if(this.getPeriode()==6){
				this.drawCenteredString(g, "Aujourd'hui", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==1){
						g.drawImage(actif,2*195,2*70,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==2){
						g.drawImage(actif,2*390,2*95,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==3){
						g.drawImage(actif,2*587,2*70,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==4){
						g.drawImage(actif,2*195,2*345,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getMtn_principale().getNumero()==5){
						g.drawImage(actif,2*587, 2*345,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[1].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[2].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getMtn_notees()[3].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
					}
				}catch(NullPointerException ex){}
			}else if(this.getPeriode()>=7){
				this.drawCenteredString(g, "Cible", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					this.drawArrow_schema3(g);
				}catch(NullPointerException ex){}
				try{
					if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==1){
						g.drawImage(actif,2*195,2*70,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==2){
						g.drawImage(actif,2*390,2*95,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==3){
						g.drawImage(actif,2*587,2*70,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==4){
						g.drawImage(actif,2*195,2*345,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*767, 2*372, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 2*767, 2*372, 2*70, 2*36,Color.black);
						}
					}else if(FenetreAccueil.etude.getS3().getApr_principale().getNumero()==5){
						g.drawImage(actif,2*587, 2*345,width,height,null,null);
						if(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[0].getNote())+" / 10", 2*245, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*440, 2*193, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[1].getNote())+" / 10", 2*440, 2*193, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*637, 2*168, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[2].getNote())+" / 10", 2*637, 2*168, 2*70, 2*36,Color.black);
						}
						if(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote()!=Integer.MAX_VALUE){
							g.setColor(Color.white);
							g.fillRoundRect(2*245, 2*443, 2*70, 2*36, 2*15, 2*15);
							this.drawCenteredString(g, String.valueOf(FenetreAccueil.etude.getS3().getApr_notees()[3].getNote())+" / 10", 2*245, 2*443, 2*70, 2*36,Color.black);
						}
					}
				}catch(NullPointerException ex){}
				if(this.getPeriode()==8){
					try{
						/*String texte1="Risque principal :\n\n "+FenetreAccueil.etude.getS3().getRis_principale().getNom().replaceAll("\n", " ");
						g.setColor(Color.red);
						g.fillRoundRect(325, 250, 300, 60, 20, 20);
						this.drawCenteredString(g, texte1, 325, 250, 300, 60, Color.white);*/
						String texte="Risques notés :\n";
						if(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS3().getRis_notees()[0].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[0].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS3().getRis_notees()[1].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[1].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS3().getRis_notees()[2].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[2].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS3().getRis_notees()[3].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[3].getNote())+" / 10)\n";
						}
						if(FenetreAccueil.etude.getS3().getRis_notees()[4].getNote()!=Integer.MAX_VALUE){
							texte=texte+FenetreAccueil.etude.getS3().getRis_notees()[4].getElement().getNom().replaceAll("\n", " ")+" ("+String.valueOf(FenetreAccueil.etude.getS3().getRis_notees()[4].getNote())+" / 10)";
						}
						String comparaison="Risques notés :\n";
						if(!comparaison.equals(texte)){
							g.setColor(Color.red);
							g.fillRoundRect(2*490, 2*440, 2*450, 2*90, 2*20, 2*20);
							this.drawCenteredString(g, texte, 2*490, 2*445, 2*450, 2*90, Color.white);
						}
					}catch(NullPointerException ex){}
				}
			}
			this.drawCenteredString(g, Organisation.RATIONNELLE.getNom(), 2*195, 2*70, width, height,Color.white);
			this.drawCenteredString(g, Organisation.ARTISANALE.getNom(), 2*390, 2*95, width, height,Color.white);
			this.drawCenteredString(g, Organisation.PERSONNALISEE.getNom(), 2*587, 2*70, width, height,Color.white);
			this.drawCenteredString(g, Organisation.PROFESSIONNELLE_PROCESS.getNom(), 2*195, 2*345, width, height,Color.white);
			this.drawCenteredString(g, Organisation.FLEXIBLE.getNom(), 2*587, 2*345, width, height,Color.white);
			
		}else if(this.getPeriode()==9 || this.getPeriode()==10 ||this.getPeriode()==11){
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema4"+File.separator+"Etude_4_fond.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			double a=0.3;
			int b=70;
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
			
			g.setColor(Color.white);
			g.fillRoundRect(2*10, 2*10, 2*170, 2*60, 2*20, 2*20);
			
			if(this.getPeriode()==9){
				this.drawCenteredString(g, "Aujourd'hui", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					int width=(int) (rouge.getWidth(null)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100);
					int height=(int) (rouge.getHeight(null)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100);
					int x=279-width/2;
					int y=210-height/2;
					if(FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()!=0){
						g.drawImage(rouge, 2*x, 2*y, 2*width, 2*height , null, null);
						try{
							int width_cons=(int) (consensus.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().get()+b)/100);
							int height_cons=(int) (consensus.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().get()+b)/100);
							int x_cons=279-width_cons/2;
							int y_cons=(int) ((166-210)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)+210-height_cons/2);
							if(FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().get()!=0){
								g.drawImage(consensus, 2*x_cons, 2*y_cons, 2*width_cons, 2*height_cons , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*140,2*148, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getConsensus().toString(), 2*140,2*148, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_pac=(int) (pacte.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().get()+b)/100);
							int height_pac=(int) (pacte.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().get()+b)/100);
							int x_pac=279-width_pac/2;
							int y_pac=(int) ((250-210)*((a*FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().get()+b)/100)+210-height_pac/2);
							if(FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().get()!=0){
								g.drawImage(pacte, 2*x_pac, 2*y_pac, 2*width_pac,2*height_pac , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*140,2*234, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getPacte().toString(), 2*140,2*234, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
					}
					g.setColor(new Color(122,0,38));
					g.fillRoundRect(2*60, 2*119, 2*55, 2*35, 2*15, 2*15);
					this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_consensus().getImportance().toString(), 2*60, 2*119, 2*55, 2*35, Color.white);
				}catch(NullPointerException ex){}
				try{
					int width=(int) (bleu.getWidth(null)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100);
					int height=(int) (bleu.getHeight(null)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100);
					int x=694-width/2;
					int y=171-height/2;
					if(FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()!=0){
						g.drawImage(bleu, 2*x, 2*y, 2*width,2*height , null, null);
						try{
							int width_aju=(int) (ajustement.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().get()+b)/100);
							int height_aju=(int) (ajustement.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().get()+b)/100);
							int x_aju=(int) ((606-694)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)+694-width_aju/2);
							int y_aju=171-height_aju/2;
							if(FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().get()!=0){
								g.drawImage(ajustement, 2*x_aju, 2*y_aju, 2*width_aju,2*height_aju , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*578,2*55, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getAjustement().toString(), 2*578, 2*55, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_transfo=(int) (transformation.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().get()+b)/100);
							int height_transfo=(int) (transformation.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().get()+b)/100);
							int x_transfo=(int) ((786-694)*((a*FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().get()+b)/100)+694-width_transfo/2);
							int y_transfo=171-height_transfo/2;
							if(FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().get()!=0){
								g.drawImage(transformation, 2*x_transfo, 2*y_transfo, 2*width_transfo,2*height_transfo , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*884, 2*143, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getTransformation().toString(), 2*884, 2*143, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
					}
					g.setColor(new Color(27,20,100));
					g.fillRoundRect(2*885, 2*63, 2*55, 2*35, 2*15, 2*15);
					this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_negociation().getImportance().toString(), 2*885,2*63, 2*55, 2*35, Color.white);
				}catch(NullPointerException ex){}
				try{
					int width=(int) (vert.getWidth(null)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100);
					int height=(int) (vert.getHeight(null)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100);
					int x=568-width/2;
					int y=395-height/2;
					if(FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()!=0){
						g.drawImage(vert, 2*x, 2*y, 2*width,2*height , null, null);
						try{
							int width_domi=(int) (domination.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().get()+b)/100);
							int height_domi=(int) (domination.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().get()+b)/100);
							int x_domi=(int) ((389-568)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+568-width_domi/2);
							int y_domi=395-height_domi/2;
							if(FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().get()!=0){
								g.drawImage(domination, 2*x_domi, 2*y_domi, 2*width_domi,2*height_domi , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*243, 2*380, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getDomination().toString(), 2*243, 2*380, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_cp=(int) (contrePouvoir.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().get()+b)/100);
							int height_cp=(int) (contrePouvoir.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().get()+b)/100);
							int x_cp=(int) ((656-568)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+568-width_cp/2);
							int y_cp=(int) ((352-395)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+395-height_cp/2);
							if(FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().get()!=0){
								g.drawImage(contrePouvoir, 2*x_cp, 2*y_cp, 2*width_cp,2*height_cp , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*777,2*337, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getContrePouvoir().toString(), 2*777, 2*337, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_ant=(int) (antagonisme.getWidth(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().get()+b)/100);
							int height_ant=(int) (antagonisme.getHeight(null)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().get()+b)/100);
							int x_ant=(int) ((655-568)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+568-width_ant/2);
							int y_ant=(int) ((439-395)*((a*FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().get()+b)/100)+395-height_ant/2);
							if(FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().get()!=0){
								g.drawImage(antagonisme, 2*x_ant, 2*y_ant, 2*width_ant,2*height_ant , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*777,2*424, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getAntagonisme().toString(), 2*777, 2*424, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
					}
					g.setColor(new Color(0,88,38));
					g.fillRoundRect(2*903,2*460, 2*55, 2*35, 2*15, 2*15);
					this.drawCenteredString(g, FenetreAccueil.etude.getS4().getMtn_opposition().getImportance().toString(), 2*903, 2*460, 2*55, 2*35, Color.white);
				}catch(NullPointerException ex){}
				
			}else if(this.getPeriode()>=10){
				this.drawCenteredString(g, "Cible", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					int width=(int) (rouge.getWidth(null)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100);
					int height=(int) (rouge.getHeight(null)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100);
					int x=279-width/2;
					int y=210-height/2;
					if(FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()!=0){
						g.drawImage(rouge, 2*x, 2*y, 2*width, 2*height , null, null);
						try{
							int width_cons=(int) (consensus.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().get()+b)/100);
							int height_cons=(int) (consensus.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().get()+b)/100);
							int x_cons=279-width_cons/2;
							int y_cons=(int) ((166-210)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)+210-height_cons/2);
							if(FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().get()!=0){
								g.drawImage(consensus, 2*x_cons, 2*y_cons, 2*width_cons, 2*height_cons , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*140,2*148, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_consensus().getConsensus().toString(), 2*140,2*148, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_pac=(int) (pacte.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getPacte().get()+b)/100);
							int height_pac=(int) (pacte.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_consensus().getPacte().get()+b)/100);
							int x_pac=279-width_pac/2;
							int y_pac=(int) ((250-210)*((a*FenetreAccueil.etude.getS4().getApr_consensus().getImportance().get()+b)/100)+210-height_pac/2);
							if(FenetreAccueil.etude.getS4().getApr_consensus().getPacte().get()!=0){
								g.drawImage(pacte, 2*x_pac, 2*y_pac, 2*width_pac,2*height_pac , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*140,2*234, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_consensus().getPacte().toString(), 2*140,2*234, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
					}
					g.setColor(new Color(122,0,38));
					g.fillRoundRect(2*60, 2*119, 2*55, 2*35, 2*15, 2*15);
					this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_consensus().getImportance().toString(), 2*60, 2*119, 2*55, 2*35, Color.white);
				}catch(NullPointerException ex){}
				try{
					int width=(int) (bleu.getWidth(null)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100);
					int height=(int) (bleu.getHeight(null)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100);
					int x=694-width/2;
					int y=171-height/2;
					if(FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()!=0){
						g.drawImage(bleu, 2*x, 2*y, 2*width,2*height , null, null);
						try{
							int width_aju=(int) (ajustement.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().get()+b)/100);
							int height_aju=(int) (ajustement.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().get()+b)/100);
							int x_aju=(int) ((606-694)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)+694-width_aju/2);
							int y_aju=171-height_aju/2;
							if(FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().get()!=0){
								g.drawImage(ajustement, 2*x_aju, 2*y_aju, 2*width_aju,2*height_aju , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*578,2*55, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_negociation().getAjustement().toString(), 2*578, 2*55, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_transfo=(int) (transformation.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().get()+b)/100);
							int height_transfo=(int) (transformation.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().get()+b)/100);
							int x_transfo=(int) ((786-694)*((a*FenetreAccueil.etude.getS4().getApr_negociation().getImportance().get()+b)/100)+694-width_transfo/2);
							int y_transfo=171-height_transfo/2;
							if(FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().get()!=0){
								g.drawImage(transformation, 2*x_transfo, 2*y_transfo, 2*width_transfo,2*height_transfo , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*884, 2*143, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_negociation().getTransformation().toString(), 2*884, 2*143, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
					}
					g.setColor(new Color(27,20,100));
					g.fillRoundRect(2*885, 2*63, 2*55, 2*35, 2*15, 2*15);
					this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_negociation().getImportance().toString(), 2*885,2*63, 2*55, 2*35, Color.white);
				}catch(NullPointerException ex){}
				try{
					int width=(int) (vert.getWidth(null)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100);
					int height=(int) (vert.getHeight(null)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100);
					int x=568-width/2;
					int y=395-height/2;
					if(FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()!=0){
						g.drawImage(vert, 2*x, 2*y, 2*width,2*height , null, null);
						try{
							int width_domi=(int) (domination.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getDomination().get()+b)/100);
							int height_domi=(int) (domination.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getDomination().get()+b)/100);
							int x_domi=(int) ((389-568)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+568-width_domi/2);
							int y_domi=395-height_domi/2;
							if(FenetreAccueil.etude.getS4().getApr_opposition().getDomination().get()!=0){
								g.drawImage(domination, 2*x_domi, 2*y_domi, 2*width_domi,2*height_domi , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*243, 2*380, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getDomination().toString(), 2*243, 2*380, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_cp=(int) (contrePouvoir.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().get()+b)/100);
							int height_cp=(int) (contrePouvoir.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().get()+b)/100);
							int x_cp=(int) ((656-568)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+568-width_cp/2);
							int y_cp=(int) ((352-395)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+395-height_cp/2);
							if(FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().get()!=0){
								g.drawImage(contrePouvoir, 2*x_cp, 2*y_cp, 2*width_cp,2*height_cp , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*777,2*337, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getContrePouvoir().toString(), 2*777, 2*337, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
						try{
							int width_ant=(int) (antagonisme.getWidth(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().get()+b)/100);
							int height_ant=(int) (antagonisme.getHeight(null)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)*(a*FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().get()+b)/100);
							int x_ant=(int) ((655-568)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+568-width_ant/2);
							int y_ant=(int) ((439-395)*((a*FenetreAccueil.etude.getS4().getApr_opposition().getImportance().get()+b)/100)+395-height_ant/2);
							if(FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().get()!=0){
								g.drawImage(antagonisme, 2*x_ant, 2*y_ant, 2*width_ant,2*height_ant , null, null);
								g.setColor(Color.white);
								g.fillRoundRect(2*777,2*424, 2*55, 2*35, 2*15, 2*15);
								this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getAntagonisme().toString(), 2*777, 2*424, 2*55, 2*35, Color.black);
							}
							
						}catch(NullPointerException ex){}
					}
					g.setColor(new Color(0,88,38));
					g.fillRoundRect(2*903,2*460, 2*55, 2*35, 2*15, 2*15);
					this.drawCenteredString(g, FenetreAccueil.etude.getS4().getApr_opposition().getImportance().toString(), 2*903, 2*460, 2*55, 2*35, Color.white);
				}catch(NullPointerException ex){}
				try{
					this.drawArrow_schema4(g);
				}catch(NullPointerException ex){}
				
				if(this.getPeriode()==11){
					String texte1="";
					String texte2="";
					String texte3="";
					try{
						texte1=texte1+"Risque Consensus ("+FenetreAccueil.etude.getS4().getRis_consensus().getImportance().toString()+")\n\n";
						try{
							texte1=texte1+"Consensus ("+FenetreAccueil.etude.getS4().getRis_consensus().getConsensus().toString()+")\n";
						}catch(NullPointerException ex){}
						try{
							texte1=texte1+"Pacte ("+FenetreAccueil.etude.getS4().getRis_consensus().getPacte().toString()+")";
						}catch(NullPointerException ex){}
						g.setColor(Color.red);
						g.fillRoundRect(2*0, 2*306, 2*243, 2*75, 2*20, 2*20);
						this.drawCenteredString(g, texte1, 2*0, 2*306, 2*243, 2*75, Color.white);
					}catch(NullPointerException ex){}
					try{
						texte2=texte2+"Risque Negociation ("+FenetreAccueil.etude.getS4().getRis_negociation().getImportance().toString()+")\n\n";
						try{
							texte2=texte2+"Ajustement hiérarchique ("+FenetreAccueil.etude.getS4().getRis_negociation().getAjustement().toString()+")\n";
						}catch(NullPointerException ex){}
						try{
							texte2=texte2+"Transformation négociée ("+FenetreAccueil.etude.getS4().getRis_negociation().getTransformation().toString()+")";
						}catch(NullPointerException ex){}
						g.setColor(Color.red);
						g.fillRoundRect(2*0, 2*383, 2*243, 2*75, 2*20, 2*20);
						this.drawCenteredString(g, texte2, 2*0, 2*383, 2*243, 2*75, Color.white);
					}catch(NullPointerException ex){}
					try{
						texte3=texte3+"Risque Opposition ("+FenetreAccueil.etude.getS4().getRis_opposition().getImportance().toString()+")\n\n";
						try{
							texte3=texte3+"Domination ("+FenetreAccueil.etude.getS4().getRis_opposition().getDomination().toString()+")\n";
						}catch(NullPointerException ex){}
						try{
							texte3=texte3+"Contre Pouvoir ("+FenetreAccueil.etude.getS4().getRis_opposition().getContrePouvoir().toString()+")\n";
						}catch(NullPointerException ex){}
						try{
							texte3=texte3+"Antagonisme ("+FenetreAccueil.etude.getS4().getRis_opposition().getAntagonisme().toString()+")";
						}catch(NullPointerException ex){}
						g.setColor(Color.red);
						g.fillRoundRect(2*0, 2*460, 2*243, 2*75, 2*20, 2*20);
						this.drawCenteredString(g, texte3, 2*0, 2*464, 2*243, 2*75, Color.white);
					}catch(NullPointerException ex){}
				}
			}
			
		}else if(this.getPeriode()==12 || this.getPeriode()==13||this.getPeriode()==14){
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"Etude_5_fond.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			
			double a=0.3;
			int b=70;
			
			Image reglementaire=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"reglementaire.png");
			Image mobilite=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"mobilite.png");
			Image service_public=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"pro_service_public.png");
			Image professionnelle=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"professionnelle.png");
			Image communautaire=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"communautaire.png");
			Image entrepreneuriale=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema5"+File.separator+"entrepreneuriale.png");
			
			g.setColor(Color.white);
			g.fillRoundRect(2*10, 2*10, 2*170, 2*60, 2*20, 2*20);
			
			if(this.getPeriode()==12){
				g.setColor(Color.white);
				g.fillRoundRect(2*59, 2*111, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*805, 2*117, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*566, 2*262, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*576, 2*495, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*87, 2*413, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*884, 2*371, 2*55, 2*35, 2*15, 2*15);
				this.drawCenteredString(g, "Aujourd'hui", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					int x=(int) (208-reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/200);
					int y=(int) (129-reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/200);
					int width=(int) (reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/100);
					int height=(int) (reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_reglementaire().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getMtn_reglementaire().get()!=0){
						g.drawImage(reglementaire, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_reglementaire().toString(), 2*59, 2*111, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (682-mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/200);
					int y=(int) (135-mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/200);
					int width=(int) (mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/100);
					int height=(int) (mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_mobilite().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getMtn_mobilite().get()!=0){
						g.drawImage(mobilite, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_mobilite().toString(), 2*805, 2*117, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (472-service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/200);
					int y=(int) (280-service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/200);
					int width=(int) (service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/100);
					int height=(int) (service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getMtn_pro_service_public().get()!=0){
						g.drawImage(service_public, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_pro_service_public().toString(), 2*566, 2*262, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (604-professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/200);
					int y=(int) (404-professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/200);
					int width=(int) (professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/100);
					int height=(int) (professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_professionnelle().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getMtn_professionnelle().get()!=0){
						g.drawImage(professionnelle, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_professionnelle().toString(), 2*576, 2*495, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (260-communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/200);
					int y=(int) (431-communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/200);
					int width=(int) (communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/100);
					int height=(int) (communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_communautaire().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getMtn_communautaire().get()!=0){
						g.drawImage(communautaire, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_communautaire().toString(), 2*87, 2*413, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (816-entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/200);
					int y=(int) (462-entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/200);
					int width=(int) (entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/100);
					int height=(int) (entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().get()!=0){
						g.drawImage(entrepreneuriale, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getMtn_entrepreneuriale().toString(), 2*884, 2*371, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
			}else if(this.getPeriode()>=13){
				try{
					this.drawArrow_schema5(g);
				}catch(NullPointerException ex){}
				g.setColor(Color.white);
				g.fillRoundRect(2*59, 2*111, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*805, 2*117, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*566, 2*262, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*576, 2*495, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*87, 2*413, 2*55, 2*35, 2*15, 2*15);
				g.fillRoundRect(2*884, 2*371, 2*55, 2*35, 2*15, 2*15);
				this.drawCenteredString(g, "Cible", 2*10, 2*10, 2*170, 2*60, Color.black);
				
				try{
					int x=(int) (208-reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/200);
					int y=(int) (129-reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/200);
					int width=(int) (reglementaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/100);
					int height=(int) (reglementaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_reglementaire().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getApr_reglementaire().get()!=0){
						g.drawImage(reglementaire, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_reglementaire().toString(), 2*59, 2*111, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (682-mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/200);
					int y=(int) (135-mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/200);
					int width=(int) (mobilite.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/100);
					int height=(int) (mobilite.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_mobilite().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getApr_mobilite().get()!=0){
						g.drawImage(mobilite, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_mobilite().toString(), 2*805, 2*117, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (472-service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/200);
					int y=(int) (280-service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/200);
					int width=(int) (service_public.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/100);
					int height=(int) (service_public.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_pro_service_public().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getApr_pro_service_public().get()!=0){
						g.drawImage(service_public, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_pro_service_public().toString(), 2*566, 2*262, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (604-professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/200);
					int y=(int) (404-professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/200);
					int width=(int) (professionnelle.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/100);
					int height=(int) (professionnelle.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_professionnelle().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getApr_professionnelle().get()!=0){
						g.drawImage(professionnelle, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_professionnelle().toString(), 2*576, 2*495, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (260-communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/200);
					int y=(int) (431-communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/200);
					int width=(int) (communautaire.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/100);
					int height=(int) (communautaire.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_communautaire().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getApr_communautaire().get()!=0){
						g.drawImage(communautaire, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_communautaire().toString(), 2*87, 2*413, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				
				try{
					int x=(int) (816-entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/200);
					int y=(int) (462-entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/200);
					int width=(int) (entrepreneuriale.getWidth(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/100);
					int height=(int) (entrepreneuriale.getHeight(null)*(a*FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()+b)/100);
					if(FenetreAccueil.etude.getS5().getApr_entrepreneuriale().get()!=0){
						g.drawImage(entrepreneuriale, 2*x, 2*y, 2*width,2*height , null, null);
					}
					this.drawCenteredString(g, FenetreAccueil.etude.getS5().getApr_entrepreneuriale().toString(), 2*884, 2*371, 2*55, 2*35,Color.black);
				}catch(NullPointerException ex){}
				if(this.getPeriode()==14){
					String texte="Risque\n\n";
					try{
						texte=texte+"Identité réglementaire ("+FenetreAccueil.etude.getS5().getRis_reglementaire().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte=texte+"Identité de mobilité ("+FenetreAccueil.etude.getS5().getRis_mobilite().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte=texte+"Identité professionnelle de service \npublic ("+FenetreAccueil.etude.getS5().getRis_pro_service_public().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte=texte+"Identité professionnelle ("+FenetreAccueil.etude.getS5().getRis_professionnelle().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte=texte+"Identité communautaire ("+FenetreAccueil.etude.getS5().getRis_communautaire().toString()+")\n";
					}catch(NullPointerException ex){}
					try{
						texte=texte+"Identité entrepreneuriale ("+FenetreAccueil.etude.getS5().getRis_entrepreneuriale().toString()+")";
					}catch(NullPointerException ex){}
					String comparaison="Risque\n\n";
					if(!texte.equals(comparaison)){
						g.setColor(Color.red);
						g.fillRoundRect(2*316, 2*60, 2*240, 2*134, 2*15, 2*15);
						this.drawCenteredString(g, texte, 2*308, 2*70, 2*256, 2*134, Color.white);
					}
				}
				
			}
			
		}else if(this.getPeriode()==15 ||this.getPeriode()==16 ||this.getPeriode()==17){
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_fond.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			Image repos=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_repos.png");
			Image actif=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"Apercu"+File.separator+"Schema6"+File.separator+"Etude_6_actif.png");
			int width=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMA6.getWidth();
			int height=(int) ConteneurSchema.DIMENSION_BOUTON_SCHEMA6.getHeight();
			
			width=2*width;
			height=2*height;//meilleure qualité
			
			g.drawImage(repos,2*315,2*90,width,height,null,null);
			g.drawImage(repos,2*305,2*220,width,height,null,null);
			g.drawImage(repos,2*610,2*130,width,height,null,null);
			g.drawImage(repos,2*550,2*300,width,height,null,null);
			g.drawImage(repos,2*235,2*340,width,height,null,null);
			g.setColor(Color.white);
			g.fillRoundRect(2*10, 2*10, 2*170,2*60, 2*20, 2*20);
			
			if(this.getPeriode()==15){
				this.drawCenteredString(g, "Passé", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					if(FenetreAccueil.etude.getS6().getMtn().getNumero()==1){
						g.drawImage(actif,2*315,2*90,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==2){
						g.drawImage(actif,2*305,2*220,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==3){
						g.drawImage(actif,2*610,2*130,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==4){
						g.drawImage(actif,2*550,2*300,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getMtn().getNumero()==5){
						g.drawImage(actif,2*235,2*340,width,height,null,null);
					}
				
				}catch(NullPointerException ex){}
			}else if(this.getPeriode()==16){
				this.drawCenteredString(g, "Aujourd'hui", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					this.drawArrow_schema6(g,0);
				}catch(NullPointerException ex){}
				try{
					if(FenetreAccueil.etude.getS6().getApr().getNumero()==1){
						g.drawImage(actif,2*315,2*90,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==2){
						g.drawImage(actif,2*305,2*220,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==3){
						g.drawImage(actif,2*610,2*130,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==4){
						g.drawImage(actif,2*550,2*300,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getApr().getNumero()==5){
						g.drawImage(actif,2*235,2*340,width,height,null,null);
					}
				}catch(NullPointerException ex){}
				
				/*try{
					String texte="Risque principal:\n\n"+FenetreAccueil.etude.getS6().getRis().getNom();
					g.setColor(Color.red);
					g.fillRoundRect(2*750, 2*420, 2*200, 2*100, 2*20, 2*20);
					this.drawCenteredString(g, texte, 2*750, 2*420, 2*200, 2*100, Color.white);
				}catch(NullPointerException ex){}*/
			}else if(this.getPeriode()==17){
				this.drawCenteredString(g, "Cible", 2*10, 2*10, 2*170, 2*60, Color.black);
				try{
					this.drawArrow_schema6(g,1);
				}catch(NullPointerException ex){}
				try{
					if(FenetreAccueil.etude.getS6().getRis().getNumero()==1){
						g.drawImage(actif,2*315,2*90,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==2){
						g.drawImage(actif,2*305,2*220,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==3){
						g.drawImage(actif,2*610,2*130,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==4){
						g.drawImage(actif,2*550,2*300,width,height,null,null);
					}else if(FenetreAccueil.etude.getS6().getRis().getNumero()==5){
						g.drawImage(actif,2*235,2*340,width,height,null,null);
					}
				}catch(NullPointerException ex){}
			}
			
			this.drawCenteredString(g, Entreprise.COMMUNAUTE.getNom(), 2*315, 2*90, width, height, Color.WHITE);
			this.drawCenteredString(g, Entreprise.DUALE.getNom(), 2*305, 2*220, width, height, Color.WHITE);
			this.drawCenteredString(g, Entreprise.MODERNISEE.getNom(), 2*610, 2*130, width, height, Color.WHITE);
			this.drawCenteredString(g, Entreprise.CRISE.getNom(), 2*550, 2*300, width, height, Color.WHITE);
			this.drawCenteredString(g, Entreprise.BUREAUCRATIQUE.getNom(), 2*235, 2*340, width, height, Color.WHITE);
			
		}else if(this.getPeriode()==18){
			Image fond=Images.importerImage("themes"+File.separator+FenetreAccueil.theme.getNom()+File.separator+"fondppt.png");
			g.drawImage(Images.scaleImage(fond,1920, 1080),0,0,null);
			this.drawMainTitle(g, ConteneurNouvelleEtude.nom, 0, 0, 1920, 1080, Color.white);
			
		}
	}

}
