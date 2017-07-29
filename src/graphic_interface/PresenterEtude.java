package graphic_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PresenterEtude implements ActionListener {
	
	public PresenterEtude(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			BufferedImage image=new ImagesApercu(1920,1080,i).getImage();
			File output=new File("image"+String.valueOf(i)+".png");
			try {
				ImageIO.write(image, "PNG", output);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
