package graphic_interface;

public class Schema6 {

	// VARIABLES INSTANCE //
	
	private Entreprise mtn;
	private Entreprise apr;
	private Entreprise ris;
	
	@SuppressWarnings("unchecked")
	private ElementNote<Entreprise>[] mtn_notee = new ElementNote[4];
	@SuppressWarnings("unchecked")
	private ElementNote<Entreprise>[] apr_notee = new ElementNote[4];
	@SuppressWarnings("unchecked")
	private ElementNote<Entreprise>[] ris_notee = new ElementNote[4];
	
	// CONSTRUCTEUR //
	public Schema6(Entreprise mtn, Entreprise apr, Entreprise ris,ElementNote<Entreprise>[] mtn_notee,ElementNote<Entreprise>[] apr_notee,ElementNote<Entreprise>[] ris_notee) {
		this.mtn = mtn;
		this.apr = apr;
		this.ris = ris;
		
		for(int i=0;i<4;i++)
		{
			this.mtn_notee[i] = mtn_notee[i];
			this.apr_notee[i] = apr_notee[i];
			this.ris_notee[i] = ris_notee[i];
		}
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
	public ElementNote<Entreprise>[] getMtn_notee() {
		return mtn_notee;
	}
	public ElementNote<Entreprise>[] getApr_notee() {
		return apr_notee;
	}	
	public ElementNote<Entreprise>[] getRis_notee() {
		return ris_notee;
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
	public void setMtn_notee(ElementNote<Entreprise>[] mtn_notee) {
		for(int i=0;i<mtn_notee.length;i++) this.mtn_notee[i] = mtn_notee[i];
	}
	public void setApr_notee(ElementNote<Entreprise>[] apr_notee) {
		for(int i=0;i<apr_notee.length;i++) this.apr_notee[i] = apr_notee[i];
	}
	public void setRis_notee(ElementNote<Entreprise>[] ris_notee) {
		for(int i=0;i<ris_notee.length;i++) this.ris_notee[i] = ris_notee[i];
	}
}
