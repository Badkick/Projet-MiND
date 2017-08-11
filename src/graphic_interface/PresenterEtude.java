package graphic_interface;

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
	
	public PresenterEtude(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<13;i++){
			BufferedImage image=new ImagesApercu(1920,1080,i).getImage();
			File output=new File("image"+String.valueOf(i)+".png");
			try {
				ImageIO.write(image, "PNG", output);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			creerPowerPoint();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void creerPowerPoint() throws IOException{
		XMLSlideShow ppt = new XMLSlideShow();
		XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
		XSLFSlideLayout titleLayout = slideMaster.getLayout(SlideLayout.TITLE);
		XSLFSlideLayout contentLayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
		
		XSLFSlide slidetitle = ppt.createSlide(titleLayout);
		XSLFTextShape title1 = slidetitle.getPlaceholder(0);
		title1.setText(ConteneurNouvelleEtude.nom);
		XSLFTextShape subtitle1 = slidetitle.getPlaceholder(1);
		subtitle1.setText("");
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
		for(int i=0;i<2;i++){
			titres.add(ConteneurNouvelleEtude.nom);
		}
		for(int i=0;i<13;i++){
			XSLFSlide slide=ppt.createSlide(contentLayout);
			XSLFTextShape title=slide.getPlaceholder(0);
			title.setText(titres.get(i));
			XSLFShape pic=slide.getShapes().get(1);
			Rectangle2D anchor=pic.getAnchor();
			byte[] pictureData = IOUtils.toByteArray(
					new FileInputStream("image"+String.valueOf(i)+".png"));
				XSLFPictureData idx = ppt.addPicture(pictureData,
						PictureData.PictureType.PNG);
				XSLFPictureShape picture = slide.createPicture(idx);
				slide.removeShape(pic);

				picture.setAnchor(anchor);
		}
        
		
        
		
		File file=new File(ConteneurNouvelleEtude.nom+".pptx");
	    FileOutputStream out = new FileOutputStream(file);
	    ppt.write(out);
	    out.close();
	}


}
