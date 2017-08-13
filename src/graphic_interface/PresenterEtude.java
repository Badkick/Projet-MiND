package graphic_interface;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.PictureData.PictureType;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class PresenterEtude implements ActionListener {

	ConteneurNouvelleEtude conteneur;

	public PresenterEtude(ConteneurNouvelleEtude conteneur){
		this.conteneur = conteneur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ConteneurNouvelleEtude.getBoutonSave().doClick();

		boolean ok = true;

		for(int i=0;i<ConteneurNouvelleEtude.NB_ONGLETS;i++) ok &= ((CustomTab)this.conteneur.getTabs().getTabComponentAt(i)).getForeground().equals(Color.black);

		if(!ok) if(Communication.messageAttentionChoix("L'étude n'est pas complète, voulez vous quand même la présenter ?")==JOptionPane.YES_OPTION) presenter();
		else presenter();
	}

	public void creerPowerPoint() throws IOException{
		XMLSlideShow ppt = new XMLSlideShow();
		XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
		XSLFSlideLayout titleLayout = slideMaster.getLayout(SlideLayout.TITLE_ONLY);
		XSLFSlideLayout contentLayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

		XSLFSlide slidetitle = ppt.createSlide(contentLayout);
		/*XSLFTextShape title1 = slidetitle.getPlaceholder(0);
		title1.setText(ConteneurNouvelleEtude.nom);
		//XSLFTextShape subtitle1 = slidetitle.getPlaceholder(1);
		//subtitle1.setText("");*/
		Rectangle2D anchor_main=slidetitle.getBackground().getAnchor();
		byte[] pictureData_main = IOUtils.toByteArray(
				new FileInputStream("saves"+File.separator+ConteneurNouvelleEtude.nom+File.separator+"main.png"));
		XSLFPictureData idx_main = ppt.addPicture(pictureData_main,
				PictureData.PictureType.PNG);
		XSLFPictureShape picture_main = slidetitle.createPicture(idx_main);
		picture_main.setAnchor(anchor_main);
		ArrayList<String> titres=new ArrayList<String>();
		for(int i=0;i<3;i++){
			titres.add(ConteneurNouvelleEtude.nom+" - Environnement");
		}
		for(int i=0;i<2;i++){
			titres.add(ConteneurNouvelleEtude.nom+" - Orga/travail");
		}
		for(int i=0;i<2;i++){
			titres.add(ConteneurNouvelleEtude.nom+" - Orga/structure");
		}
		for(int i=0;i<2;i++){
			titres.add(ConteneurNouvelleEtude.nom+" - Relations");
		}
		for(int i=0;i<2;i++){
			titres.add(ConteneurNouvelleEtude.nom+" - Identités");
		}
		for(int i=0;i<3;i++){
			titres.add(ConteneurNouvelleEtude.nom);
		}
		for(int i=0;i<14;i++){
			XSLFSlide slide=ppt.createSlide(contentLayout);
			XSLFTextShape title=slide.getPlaceholder(0);
			title.setText(titres.get(i));
			XSLFShape pic=slide.getShapes().get(1);
			Rectangle2D anchor=pic.getAnchor();
			byte[] pictureData = IOUtils.toByteArray(
					new FileInputStream("saves"+File.separator+ConteneurNouvelleEtude.nom+File.separator+"image"+String.valueOf(i)+".png"));
			XSLFPictureData idx = ppt.addPicture(pictureData,
					PictureData.PictureType.PNG);
			XSLFPictureShape picture = slide.createPicture(idx);
			slide.removeShape(pic);

			picture.setAnchor(anchor);
		}




		File file=new File("Présentations"+File.separator+ConteneurNouvelleEtude.nom+".pptx");
		FileOutputStream out = new FileOutputStream(file);
		ppt.write(out);
		out.close();
	}

	private void presenter()
	{
		for(int i=0;i<14;i++){
			BufferedImage image=new ImagesApercu(1920,1080,i).getImage();
			File output=new File("saves"+File.separator+ConteneurNouvelleEtude.nom+File.separator+"image"+String.valueOf(i)+".png");
			try {
				ImageIO.write(image, "PNG", output);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		BufferedImage image=new ImagesApercu(1920,1080,14).getImage();
		File output=new File("saves"+File.separator+ConteneurNouvelleEtude.nom+File.separator+"main.png");
		try {
			ImageIO.write(image, "PNG", output);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			creerPowerPoint();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
