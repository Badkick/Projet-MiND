package graphic_interface;

public class Schema6 {

	// VARIABLES INSTANCE //
	
	private Entreprise mtn;
	private Entreprise apr;
	private Entreprise ris;
	
	// CONSTRUCTEUR //
	public Schema6(Entreprise mtn, Entreprise apr, Entreprise ris) {
		this.mtn = mtn;
		this.apr = apr;
		this.ris = ris;
	}

	// GETTERS //
	
	public Entreprise getRis() {
		return ris;
	}
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
	public void setRis(Entreprise ris) {
		this.ris = ris;
	}
}
