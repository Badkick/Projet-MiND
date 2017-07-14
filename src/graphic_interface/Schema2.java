package graphic_interface;

public class Schema2 {

	// VARIABLES DE CLASSE //
	
	private Structure mtn_principale;
	private Structure apr_principale;
	
	private ElementNote<Structure>[] mtn_notees = new ElementNote[4];
	private ElementNote<Structure>[] apr_notees = new ElementNote[4];
	
	// CONSTRUCTEUR //
	
	public Schema2(Structure mtn_principale, Structure apr_principale, ElementNote<Structure>[] mtn_notees, ElementNote<Structure>[] apr_notees)
	{
		this.mtn_principale = mtn_principale;
		this.apr_principale = apr_principale;
		
		for(int i=0;i<4;i++)
		{
			this.mtn_notees[i] = mtn_notees[i];
			this.apr_notees[i] = apr_notees[i];
		}
	}
	
	// GETTERS //
	
	public Structure getMtn_principale() {
		return mtn_principale;
	}

	public Structure getApr_principale() {
		return apr_principale;
	}

	public ElementNote<Structure>[] getMtn_notees() {
		return mtn_notees;
	}

	public ElementNote<Structure>[] getApr_notees() {
		return apr_notees;
	}
	
}

