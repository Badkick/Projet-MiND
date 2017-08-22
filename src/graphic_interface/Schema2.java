package graphic_interface;

public class Schema2 {

	// VARIABLES DE CLASSE //
	
	private Structure mtn_principale;
	private Structure apr_principale;
	private Structure ris_principale;
	
	@SuppressWarnings("unchecked")
	private ElementNote<Structure>[] mtn_notees = new ElementNote[4];
	@SuppressWarnings("unchecked")
	private ElementNote<Structure>[] apr_notees = new ElementNote[4];
	@SuppressWarnings("unchecked")
	private ElementNote<Structure>[] ris_notees = new ElementNote[4];
	
	// CONSTRUCTEUR //
	
	public Schema2(Structure mtn_principale, Structure apr_principale, Structure ris_principale, ElementNote<Structure>[] mtn_notees, ElementNote<Structure>[] apr_notees, ElementNote<Structure>[] ris_notees)
	{
		this.mtn_principale = mtn_principale;
		this.apr_principale = apr_principale;
		this.ris_principale = ris_principale;
		
		for(int i=0;i<4;i++)
		{
			this.mtn_notees[i] = mtn_notees[i];
			this.apr_notees[i] = apr_notees[i];
			this.ris_notees[i] = ris_notees[i];
		}
	}
	
	// GETTERS //
	
	public Structure getMtn_principale() {
		return mtn_principale;
	}
	public Structure getApr_principale() {
		return apr_principale;
	}
	public Structure getRis_principale() {
		return ris_principale;
	}
	public ElementNote<Structure>[] getMtn_notees() {
		return mtn_notees;
	}
	public ElementNote<Structure>[] getApr_notees() {
		return apr_notees;
	}	
	public ElementNote<Structure>[] getRis_notees() {
		return ris_notees;
	}

	// SETTERS //
	
	public void setMtn_principale(Structure mtn_principale) {
		this.mtn_principale = mtn_principale;
	}
	public void setApr_principale(Structure apr_principale) {
		this.apr_principale = apr_principale;
	}
	public void setRis_principale(Structure ris_principale) {
		this.ris_principale = ris_principale;
	}
	public void setMtn_notees(ElementNote<Structure>[] mtn_notees) {
		for(int i=0;i<mtn_notees.length;i++) this.mtn_notees[i] = mtn_notees[i];
	}
	public void setApr_notees(ElementNote<Structure>[] apr_notees) {
		for(int i=0;i<apr_notees.length;i++) this.apr_notees[i] = apr_notees[i];
	}
	public void setRis_notees(ElementNote<Structure>[] ris_notees) {
		for(int i=0;i<ris_notees.length;i++) this.ris_notees[i] = ris_notees[i];
	}
	
}

