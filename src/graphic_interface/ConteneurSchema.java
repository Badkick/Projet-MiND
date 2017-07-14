package graphic_interface;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.GroupLayout;

public class ConteneurSchema extends ConteneurAvecImage {

	// VARIABLES INSTANCE //

	// vaeiables générales
	private Theme theme;
	private int typeSchema; // le type du schéma : de 1 à 6
	private GroupLayout layout;

	// cas 1

	// cas 2

	// cas 3

	// cas 4
	
	// cas 5

	// cas 6
	
	
	// CONSTRUCTEURS //

	public ConteneurSchema(int type, int width, int height, Theme theme) {
		super(width,height,theme.getSchemas()[type-1]);
		this.typeSchema = type;
		this.theme = theme;
		this.layout = new GroupLayout(this);
		this.setLayout(layout);

		switch(type)
		{
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		}
	}

	public ConteneurSchema(int type, Dimension dim, Theme theme) {
		this(type,(int)dim.getWidth(),(int)dim.getHeight(),theme);		
	}

	// GETTERS //

}
