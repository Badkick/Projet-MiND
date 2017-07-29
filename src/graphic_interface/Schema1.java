package graphic_interface;

public class Schema1 {

	// VARIABLES INSTANCE //

	private Pourcentage mtn_contr_tech;
	private Pourcentage apr_contr_tech;
	private Pourcentage ris_contr_tech;

	private Pourcentage mtn_press_envir;
	private Pourcentage apr_press_envir;
	private Pourcentage ris_press_envir;

	private Pourcentage mtn_etabl_prot;
	private Pourcentage apr_etabl_prot;
	private Pourcentage ris_etabl_prot;

	private Pourcentage mtn_mena_mar;
	private Pourcentage apr_mena_mar;
	private Pourcentage ris_mena_mar;
	
	private String commentaire_risque;

	// CONSTRUCTEUR //

	public Schema1(Pourcentage mtn_contr_tech, Pourcentage apr_contr_tech, Pourcentage ris_contr_tech,
			Pourcentage mtn_press_envir, Pourcentage apr_press_envir, Pourcentage ris_press_envir,
			Pourcentage mtn_etabl_prot, Pourcentage apr_etabl_prot, Pourcentage ris_etabl_prot,
			Pourcentage mtn_mena_mar, Pourcentage apr_mena_mar, Pourcentage ris_mena_mar, String commentaire_risque) {
		this.mtn_contr_tech = mtn_contr_tech;
		this.apr_contr_tech = apr_contr_tech;
		this.ris_contr_tech = ris_contr_tech;
		this.mtn_press_envir = mtn_press_envir;
		this.apr_press_envir = apr_press_envir;
		this.ris_press_envir = ris_press_envir;
		this.mtn_etabl_prot = mtn_etabl_prot;
		this.apr_etabl_prot = apr_etabl_prot;
		this.ris_etabl_prot = ris_etabl_prot;
		this.mtn_mena_mar = mtn_mena_mar;
		this.apr_mena_mar = apr_mena_mar;
		this.ris_mena_mar = ris_mena_mar;
		this.commentaire_risque = commentaire_risque;
	}

	// GETTERS //

	public Pourcentage getMtn_contr_tech() {
		return mtn_contr_tech;
	}
	public Pourcentage getApr_contr_tech() {
		return apr_contr_tech;
	}
	public Pourcentage getMtn_press_envir() {
		return mtn_press_envir;
	}
	public Pourcentage getApr_press_envir() {
		return apr_press_envir;
	}
	public Pourcentage getMtn_etabl_prot() {
		return mtn_etabl_prot;
	}
	public Pourcentage getApr_etabl_prot() {
		return apr_etabl_prot;
	}
	public Pourcentage getMtn_mena_mar() {
		return mtn_mena_mar;
	}
	public Pourcentage getApr_mena_mar() {
		return apr_mena_mar;
	}
	public Pourcentage getRis_contr_tech() {
		return ris_contr_tech;
	}
	public Pourcentage getRis_press_envir() {
		return ris_press_envir;
	}
	public Pourcentage getRis_etabl_prot() {
		return ris_etabl_prot;
	}
	public Pourcentage getRis_mena_mar() {
		return ris_mena_mar;
	}
	public String getCommentaire_risque() {
		return this.commentaire_risque;
	}

	// SETTERS //

	public void setRis_contr_tech(Pourcentage ris_contr_tech) {
		this.ris_contr_tech = ris_contr_tech;
	}
	public void setRis_press_envir(Pourcentage ris_press_envir) {
		this.ris_press_envir = ris_press_envir;
	}
	public void setRis_etabl_prot(Pourcentage ris_etabl_prot) {
		this.ris_etabl_prot = ris_etabl_prot;
	}
	public void setRis_mena_mar(Pourcentage ris_mena_mar) {
		this.ris_mena_mar = ris_mena_mar;
	}
	public void setMtn_contr_tech(Pourcentage mtn_contr_tech) {
		this.mtn_contr_tech = mtn_contr_tech;
	}
	public void setApr_contr_tech(Pourcentage apr_contr_tech) {
		this.apr_contr_tech = apr_contr_tech;
	}
	public void setMtn_press_envir(Pourcentage mtn_press_envir) {
		this.mtn_press_envir = mtn_press_envir;
	}
	public void setApr_press_envir(Pourcentage apr_press_envir) {
		this.apr_press_envir = apr_press_envir;
	}
	public void setMtn_etabl_prot(Pourcentage mtn_etabl_prot) {
		this.mtn_etabl_prot = mtn_etabl_prot;
	}
	public void setApr_etabl_prot(Pourcentage apr_etabl_prot) {
		this.apr_etabl_prot = apr_etabl_prot;
	}
	public void setMtn_mena_mar(Pourcentage mtn_mena_mar) {
		this.mtn_mena_mar = mtn_mena_mar;
	}
	public void setApr_mena_mar(Pourcentage apr_mena_mar) {
		this.apr_mena_mar = apr_mena_mar;
	}
	public void setCommentaire_risque(String commentaire_risque) {
		this.commentaire_risque = commentaire_risque;
	}

	//METHODES
	
	public int getMax_maintenant(){
		try{
			float[] liste={this.getMtn_contr_tech().get(),this.getMtn_press_envir().get(),this.getMtn_etabl_prot().get(),this.getMtn_mena_mar().get()};
			float max=0;
			int j=0;
			for(int i=0;i<4;i++){
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
			float[] liste={this.getApr_contr_tech().get(),this.getApr_press_envir().get(),this.getApr_etabl_prot().get(),this.getApr_mena_mar().get()};
			float max=0;
			int j=0;
			for(int i=0;i<4;i++){
				if(liste[i]>max){
					max=liste[i];
					j=i;
				}
			}
			return j;
		}catch(NullPointerException ex){return Integer.MAX_VALUE;}
	}
	
	public int getMax_encore_apres(){
		try{
			float[] liste={this.getRis_contr_tech().get(),this.getRis_press_envir().get(),this.getRis_etabl_prot().get(),this.getRis_mena_mar().get()};
			float max=0;
			int j=0;
			for(int i=0;i<4;i++){
				if(liste[i]>max){
					max=liste[i];
					j=i;
				}
			}
			return j;
		}catch(NullPointerException ex){return Integer.MAX_VALUE;}
	}

}
