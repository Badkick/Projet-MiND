package graphic_interface;

public class Schema4 {

	// VARIABLES INSTANCE //
	
	private Consensus consensus;
	private Negociation negociation;
	private Opposition opposition;
	
	// CONSTRUCTEUR //
	
	public Schema4(Consensus consensus, Negociation negociation, Opposition opposition) {
		this.consensus = consensus;
		this.negociation = negociation;
		this.opposition = opposition;
	}
	
	// GETTERS //
	
	public Consensus getConsensus() {
		return consensus;
	}
	public Negociation getNegociation() {
		return negociation;
	}
	public Opposition getOpposition() {
		return opposition;
	}
	
}
