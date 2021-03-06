package graphic_interface;

public class Schema4 {

	// VARIABLES INSTANCE //
	
	private Consensus mtn_consensus;
	private Consensus apr_consensus;
	private Consensus ris_consensus;
	
	private Negociation mtn_negociation;
	private Negociation apr_negociation;
	private Negociation ris_negociation;
	
	private Opposition mtn_opposition;
	private Opposition apr_opposition;
	private Opposition ris_opposition;

	// CONSTRUCTEUR //
	
	public Schema4(Consensus mtn_consensus, Consensus apr_consensus, Consensus ris_consensus,
			Negociation mtn_negociation, Negociation apr_negociation, Negociation ris_negociation,
			Opposition mtn_opposition, Opposition apr_opposition, Opposition ris_opposition) {
		this.mtn_consensus = mtn_consensus;
		this.apr_consensus = apr_consensus;
		this.ris_consensus = ris_consensus;
		this.mtn_negociation = mtn_negociation;
		this.apr_negociation = apr_negociation;
		this.ris_negociation = ris_negociation;
		this.mtn_opposition = mtn_opposition;
		this.apr_opposition = apr_opposition;
		this.ris_opposition = ris_opposition;
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
	public Consensus getRis_consensus() {
		return ris_consensus;
	}
	public Negociation getRis_negociation() {
		return ris_negociation;
	}
	public Opposition getRis_opposition() {
		return ris_opposition;
	}

	// SETTERS //
	
	public void setRis_consensus(Consensus ris_consensus) {
		this.ris_consensus = ris_consensus;
	}
	public void setRis_negociation(Negociation ris_negociation) {
		this.ris_negociation = ris_negociation;
	}
	public void setRis_opposition(Opposition ris_opposition) {
		this.ris_opposition = ris_opposition;
	}
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
	
	//METHODES
	
	public int getMax_maintenant(){
		try{
			float[] liste={this.getMtn_consensus().getConsensus().get()*this.getMtn_consensus().getImportance().get(),this.getMtn_consensus().getPacte().get()*this.getMtn_consensus().getImportance().get(),this.getMtn_negociation().getAjustement().get()*this.getMtn_negociation().getImportance().get(),this.getMtn_negociation().getTransformation().get()*this.getMtn_negociation().getImportance().get(),this.getMtn_opposition().getDomination().get()*this.getMtn_opposition().getImportance().get(),this.getMtn_opposition().getContrePouvoir().get()*this.getMtn_opposition().getImportance().get(),this.getMtn_opposition().getAntagonisme().get()*this.getMtn_opposition().getImportance().get()};
			float max=0;
			int j=0;
			for(int i=0;i<7;i++){
				if(liste[i]>max){
					max=liste[i];
					j=i;
				}
			}
			return j;
		}catch(NullPointerException ex){return Integer.MAX_VALUE;}
	}
	
	public int getMax_apres(){
		try{
			float[] liste={this.getApr_consensus().getConsensus().get()*this.getApr_consensus().getImportance().get(),this.getApr_consensus().getPacte().get()*this.getApr_consensus().getImportance().get(),this.getApr_negociation().getAjustement().get()*this.getApr_negociation().getImportance().get(),this.getApr_negociation().getTransformation().get()*this.getApr_negociation().getImportance().get(),this.getApr_opposition().getDomination().get()*this.getApr_opposition().getImportance().get(),this.getApr_opposition().getContrePouvoir().get()*this.getApr_opposition().getImportance().get(),this.getApr_opposition().getAntagonisme().get()*this.getApr_opposition().getImportance().get()};
			float max=0;
			int j=0;
			for(int i=0;i<7;i++){
				if(liste[i]>max){
					max=liste[i];
					j=i;
				}
			}
			return j;
		}catch(NullPointerException ex){return Integer.MAX_VALUE;}
	}
}
