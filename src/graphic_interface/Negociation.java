package graphic_interface;

public class Negociation {

	// VARIABLES INSTANCE //
	
	private Pourcentage importance;
	private Pourcentage ajustement;
	private Pourcentage transformation;
	
	// CONSTRUCTEUR //
	
	public Negociation(Pourcentage importance, Pourcentage ajustement, Pourcentage transformation)
	{
		this.importance = importance;
		this.ajustement = ajustement;
		this.transformation = transformation;
	}
	
	// GETTERS //
	
	public Pourcentage getImportance() {
		return importance;
	}
	public Pourcentage getAjustement() {
		return ajustement;
	}
	public Pourcentage getTransformation() {
		return transformation;
	}
	
	// SETTERS //

	public void setImportance(Pourcentage importance) {
		this.importance = importance;
	}

	public void setAjustement(Pourcentage ajustement) {
		this.ajustement = ajustement;
	}

	public void setTransformation(Pourcentage transformation) {
		this.transformation = transformation;
	}
}
