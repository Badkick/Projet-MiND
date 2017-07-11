package graphic_interface;

public class Schema1 {

	// VARIABLES INSTANCE //

	private int mtn_contr_tech;
	private int apr_contr_tech;

	private int mtn_press_envir;
	private int apr_press_envir;

	private int mtn_etabl_prot;
	private int apr_etabl_prot;

	private int mtn_mena_mar;
	private int apr_mena_mar;

	// CONSTRUCTEUR //

	public Schema1(int mtn_contr_tech, int apr_contr_tech, int mtn_press_envir, int apr_press_envir, int mtn_etabl_prot, int apr_etabl_prot, int mtn_mena_mar, int apr_mena_mar) {
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

	public int getMtn_contr_tech() {
		return mtn_contr_tech;
	}
	public int getApr_contr_tech() {
		return apr_contr_tech;
	}
	public int getMtn_press_envir() {
		return mtn_press_envir;
	}
	public int getApr_press_envir() {
		return apr_press_envir;
	}
	public int getMtn_etabl_prot() {
		return mtn_etabl_prot;
	}
	public int getApr_etabl_prot() {
		return apr_etabl_prot;
	}
	public int getMtn_mena_mar() {
		return mtn_mena_mar;
	}
	public int getApr_mena_mar() {
		return apr_mena_mar;
	}


	// SETTERS //

	public void setMtn_contr_tech(int mtn_contr_tech) {
		this.mtn_contr_tech = mtn_contr_tech;
	}
	public void setApr_contr_tech(int apr_contr_tech) {
		this.apr_contr_tech = apr_contr_tech;
	}
	public void setMtn_press_envir(int mtn_press_envir) {
		this.mtn_press_envir = mtn_press_envir;
	}
	public void setApr_press_envir(int apr_press_envir) {
		this.apr_press_envir = apr_press_envir;
	}
	public void setMtn_etabl_prot(int mtn_etabl_prot) {
		this.mtn_etabl_prot = mtn_etabl_prot;
	}
	public void setApr_etabl_prot(int apr_etabl_prot) {
		this.apr_etabl_prot = apr_etabl_prot;
	}
	public void setMtn_mena_mar(int mtn_mena_mar) {
		this.mtn_mena_mar = mtn_mena_mar;
	}
	public void setApr_mena_mar(int apr_mena_mar) {
		this.apr_mena_mar = apr_mena_mar;
	}

}
