package graphic_interface;

public class Consensus {

	// VARIABLES INSTANCE //
	
	private Pourcentage importance;
	private Pourcentage consensus;
	private Pourcentage pacte;
	
	// CONSTRUCTEUR //
	
	public Consensus(Pourcentage importance, Pourcentage consensus, Pourcentage pacte)
	{
		this.importance = importance;
		this.consensus = consensus;
		this.pacte = pacte;
	}

	// GETTERS //
	
	public Pourcentage getImportance() {
		return importance;
	}

	public Pourcentage getConsensus() {
		return consensus;
	}

	public Pourcentage getPacte() {
		return pacte;
	}
}
