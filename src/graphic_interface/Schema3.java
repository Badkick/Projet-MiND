package graphic_interface;

public class Schema3 {

	// VARIABLES DE CLASSE //

	private Organisation mtn_principale;
	private Organisation apr_principale;

	@SuppressWarnings("unchecked")
	private ElementNote<Organisation>[] mtn_notees = new ElementNote[4];
	@SuppressWarnings("unchecked")
	private ElementNote<Organisation>[] apr_notees = new ElementNote[4];
	@SuppressWarnings("unchecked")
	private ElementNote<Organisation>[] ris_notees = new ElementNote[5];

	// CONSTRUCTEUR //

	public Schema3(Organisation mtn_principale, Organisation apr_principale, ElementNote<Organisation>[] mtn_notees, ElementNote<Organisation>[] apr_notees, ElementNote<Organisation>[] ris_notees)
	{
		this.mtn_principale = mtn_principale;
		this.apr_principale = apr_principale;

		for(int i=0;i<4;i++)
		{
			this.mtn_notees[i] = mtn_notees[i];
			this.apr_notees[i] = apr_notees[i];
			this.ris_notees[i] = ris_notees[i];
		}
		
		this.ris_notees[4] = ris_notees[4];
	}

	// GETTERS //

	public Organisation getMtn_principale() {
		return mtn_principale;
	}

	public Organisation getApr_principale() {
		return apr_principale;
	}

	public ElementNote<Organisation>[] getMtn_notees() {
		return mtn_notees;
	}

	public ElementNote<Organisation>[] getApr_notees() {
		return apr_notees;
	}
	
	public ElementNote<Organisation>[] getRis_notees() {
		return ris_notees;
	}
	
	// SETTERS //

	public void setMtn_principale(Organisation mtn_principale) {
		this.mtn_principale = mtn_principale;
	}

	public void setApr_principale(Organisation apr_principale) {
		this.apr_principale = apr_principale;
	}

	public void setMtn_notees(ElementNote<Organisation>[] mtn_notees) {
		for(int i=0;i<mtn_notees.length;i++) this.mtn_notees[i] = mtn_notees[i];
	}

	public void setApr_notees(ElementNote<Organisation>[] apr_notees) {
		for(int i=0;i<apr_notees.length;i++) this.apr_notees[i] = apr_notees[i];
	}
	
	public void setRis_notees(ElementNote<Organisation>[] ris_notees) {
		for(int i=0;i<ris_notees.length;i++) this.ris_notees[i] = ris_notees[i];
	}
}
