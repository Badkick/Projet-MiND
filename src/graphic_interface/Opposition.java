package graphic_interface;

public class Opposition {
	
	// VARIABLES INSTANCE //
	
	private Pourcentage importance;
	private Pourcentage domination;
	private Pourcentage contrePouvoir;
	private Pourcentage antagonisme;
	
	// CONSTRUCTEUR //
	
	public Opposition(Pourcentage importance, Pourcentage domination, Pourcentage contrePouvoir, Pourcentage antagonisme) {
		this.importance = importance;
		this.domination = domination;
		this.contrePouvoir = contrePouvoir;
		this.antagonisme = antagonisme;
	}
	
	// GETTERS //
	
	public Pourcentage getImportance() {
		return importance;
	}
	public Pourcentage getDomination() {
		return domination;
	}
	public Pourcentage getContrePouvoir() {
		return contrePouvoir;
	}
	public Pourcentage getAntagonisme() {
		return antagonisme;
	}

}
