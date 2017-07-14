package graphic_interface;

public class Schema1 {

	// VARIABLES INSTANCE //

	private Pourcentage mtn_contr_tech;
	private Pourcentage apr_contr_tech;

	private Pourcentage mtn_press_envir;
	private Pourcentage apr_press_envir;

	private Pourcentage mtn_etabl_prot;
	private Pourcentage apr_etabl_prot;

	private Pourcentage mtn_mena_mar;
	private Pourcentage apr_mena_mar;

	// CONSTRUCTEUR //

	public Schema1(Pourcentage mtn_contr_tech, Pourcentage apr_contr_tech, Pourcentage mtn_press_envir, Pourcentage apr_press_envir, Pourcentage mtn_etabl_prot, Pourcentage apr_etabl_prot, Pourcentage mtn_mena_mar, Pourcentage apr_mena_mar) {
		this.mtn_contr_tech = mtn_contr_tech;
		this.apr_contr_tech = apr_contr_tech;
		this.mtn_press_envir = mtn_press_envir;
		this.apr_press_envir = apr_press_envir;
		this.mtn_etabl_prot = mtn_etabl_prot;
		this.apr_etabl_prot = apr_etabl_prot;
		this.mtn_mena_mar = mtn_mena_mar;
		this.apr_mena_mar = apr_mena_mar;
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

	

}
