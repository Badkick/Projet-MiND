package graphic_interface;

public class Schema6 {

	// VARIABLES INSTANCE //
	
	private Entreprise mtn;
	private Entreprise apr;
	
	// CONSTRUCTEUR //
	public Schema6(Entreprise mtn, Entreprise apr) {
		super();
		this.mtn = mtn;
		this.apr = apr;
	}

	// GETTERS //
	
	public Entreprise getMtn() {
		return mtn;
	}

	public Entreprise getApr() {
		return apr;
	}
	
	// SETTERS //

	public void setMtn(Entreprise mtn) {
		this.mtn = mtn;
	}

	public void setApr(Entreprise apr) {
		this.apr = apr;
	}
	
}
