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
	
	public void drawArrow_schema2(Graphics2D g){
		g.setColor(Color.red);
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
		g.setColor(Color.red);
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
				this.drawArrow_schema1(g, 0);
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
				this.drawArrow_schema1(g, 1);
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
			}else if(this.getPeriode()==4){
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
				try{
					String texte1="Risque principal :\n\n "+FenetreAccueil.etude.getS2().getRis_principale().getNom().replaceAll("\n", " ");
					g.setColor(Color.red);
					g.fillRoundRect(2*205, 2*10, 2*260, 2*60, 2*20, 2*20);
					this.drawCenteredString(g, texte1, 2*205, 2*10, 2*260, 2*60, Color.white);
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
						g.fillRoundRect(2*205, 2*72, 2*260, 2*150, 2*20, 2*20);
						this.drawCenteredString(g, texte, 2*205, 2*72, 2*260, 2*150, Color.white);
					}
				}catch(NullPointerException ex){}
			}
			this.drawCenteredString(g, Structure.SIMPLE_MARCHE.getNom(), 2*705, 2*35, width, height,Color.white);
			this.drawCenteredString(g, Structure.PROFESSIONNELLE.getNom(), 2*475, 2*85, width, height,Color.white);
			this.drawCenteredString(g, Structure.MECANISTE.getNom(), 2*205, 2*245, width, height,Color.white);
			this.drawCenteredString(g, Structure.SIMPLE_CENTRALISEE.getNom(), 2*205, 2*355, width, height,Color.white);
			this.drawCenteredString(g, Structure.ENTREPRENEURIALE.getNom(), 2*615, 2*275, width, height,Color.white);
			
		}else if(this.getPeriode()==5||this.getPeriode()==6){
			
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
			if(this.getPeriode()==5){
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
			}else if(this.getPeriode()==6){
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
				try{
					String texte1="Risque principal :\n\n "+FenetreAccueil.etude.getS3().getRis_principale().getNom().replaceAll("\n", " ");
					g.setColor(Color.red);
					g.fillRoundRect(2*325, 2*250, 2*300, 2*60, 2*20, 2*20);
					this.drawCenteredString(g, texte1, 2*325, 2*250, 2*300, 2*60, Color.white);
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
						g.fillRoundRect(2*490, 2*440, 2*450, 2*90, 2*20, 2*20);
						this.drawCenteredString(g, texte, 2*490, 2*445, 2*450, 2*90, Color.white);
					}
				}catch(NullPointerException ex){}
			}
			this.drawCenteredString(g, Organisation.RATIONNELLE.getNom(), 2*195, 2*70, width, height,Color.white);
			this.drawCenteredString(g, Organisation.ARTISANALE.getNom(), 2*390, 2*95, width, height,Color.white);
			this.drawCenteredString(g, Organisation.PERSONNALISEE.getNom(), 2*587, 2*70, width, height,Color.white);
			this.drawCenteredString(g, Organisation.PROFESSIONNELLE_PROCESS.getNom(), 2*195, 2*345, width, height,Color.white);
			this.drawCenteredString(g, Organisation.FLEXIBLE.getNom(), 2*587, 2*345, width, height,Color.white);
			
		}else if(this.getPeriode()==7 || this.getPeriode()==8){
			
		}else if(this.getPeriode()==9 || this.getPeriode()==10){
			
		}else if(this.getPeriode()==11 || this.getPeriode()==12){
			
		}
	}

}
