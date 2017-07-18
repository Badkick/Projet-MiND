package graphic_interface;

public class Schema4 {

	// VARIABLES INSTANCE //
	
	private Consensus mtn_consensus;
	private Consensus apr_consensus;
	
	private Negociation mtn_negociation;
	private Negociation apr_negociation;
	
	private Opposition mtn_opposition;
	private Opposition apr_opposition;

	// CONSTRUCTEUR //
	

	public Schema4(Consensus mtn_consensus, Consensus apr_consensus, Negociation mtn_negociation, Negociation apr_negociation, Opposition mtn_opposition, Opposition apr_opposition) {
		this.mtn_consensus = mtn_consensus;
		this.apr_consensus = apr_consensus;
		this.mtn_negociation = mtn_negociation;
		this.apr_negociation = apr_negociation;
		this.mtn_opposition = mtn_opposition;
		this.apr_opposition = apr_opposition;
	}
	
	// GETTERS //

	public Consensus getMtn_consensus() {
		return mtn_consensus;
	}
	public Consensus getApr_consensus() {
		return apr_consensus;
	}
	public Negociation getMtn_negociation() {
		return mtn_negociation;
	}
	public Negociation getApr_negociation() {
		return apr_negociation;
	}
	public Opposition getMtn_opposition() {
		return mtn_opposition;
	}
	public Opposition getApr_opposition() {
		return apr_opposition;
	}

	// SETTERS //
	
	public void setMtn_consensus(Consensus mtn_consensus) {
		this.mtn_consensus = mtn_consensus;
	}

	public void setApr_consensus(Consensus apr_consensus) {
		this.apr_consensus = apr_consensus;
	}

	public void setMtn_negociation(Negociation mtn_negociation) {
		this.mtn_negociation = mtn_negociation;
	}

	public void setApr_negociation(Negociation apr_negociation) {
		this.apr_negociation = apr_negociation;
	}

	public void setMtn_opposition(Opposition mtn_opposition) {
		this.mtn_opposition = mtn_opposition;
	}

	public void setApr_opposition(Opposition apr_opposition) {
		this.apr_opposition = apr_opposition;
	}
}
