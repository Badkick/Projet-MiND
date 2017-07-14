package graphic_interface;

public class Schema5 {

	// VARIABLES INSTANCE //
	
	private Pourcentage mtn_reglementaire;
	private Pourcentage apr_reglementaire;
	
	private Pourcentage mtn_mobilite;
	private Pourcentage apr_mobilite;
	
	private Pourcentage mtn_pro_service_public;
	private Pourcentage apr_pro_service_public;
	
	private Pourcentage mtn_professionnelle;
	private Pourcentage apr_professionnelle;
	
	private Pourcentage mtn_communautaire;
	private Pourcentage apr_communautaire;
	
	private Pourcentage mtn_entrepreneuriale;
	private Pourcentage apr_entrepreneuriale;
	
	// CONSTRUCTEUR //
	
	public Schema5(Pourcentage mtn_reglementaire, Pourcentage apr_reglementaire, Pourcentage mtn_mobilite,
			Pourcentage apr_mobilite, Pourcentage mtn_pro_service_public, Pourcentage apr_pro_service_public,
			Pourcentage mtn_professionnelle, Pourcentage apr_professionnelle, Pourcentage mtn_communautaire,
			Pourcentage apr_communautaire, Pourcentage mtn_entrepreneuriale, Pourcentage apr_entrepreneuriale) {

		this.mtn_reglementaire = mtn_reglementaire;
		this.apr_reglementaire = apr_reglementaire;
		this.mtn_mobilite = mtn_mobilite;
		this.apr_mobilite = apr_mobilite;
		this.mtn_pro_service_public = mtn_pro_service_public;
		this.apr_pro_service_public = apr_pro_service_public;
		this.mtn_professionnelle = mtn_professionnelle;
		this.apr_professionnelle = apr_professionnelle;
		this.mtn_communautaire = mtn_communautaire;
		this.apr_communautaire = apr_communautaire;
		this.mtn_entrepreneuriale = mtn_entrepreneuriale;
		this.apr_entrepreneuriale = apr_entrepreneuriale;
	}

	// GETTERS //
	
	public Pourcentage getMtn_reglementaire() {
		return mtn_reglementaire;
	}

	public Pourcentage getApr_reglementaire() {
		return apr_reglementaire;
	}

	public Pourcentage getMtn_mobilite() {
		return mtn_mobilite;
	}

	public Pourcentage getApr_mobilite() {
		return apr_mobilite;
	}

	public Pourcentage getMtn_pro_service_public() {
		return mtn_pro_service_public;
	}

	public Pourcentage getApr_pro_service_public() {
		return apr_pro_service_public;
	}

	public Pourcentage getMtn_professionnelle() {
		return mtn_professionnelle;
	}

	public Pourcentage getApr_professionnelle() {
		return apr_professionnelle;
	}

	public Pourcentage getMtn_communautaire() {
		return mtn_communautaire;
	}

	public Pourcentage getApr_communautaire() {
		return apr_communautaire;
	}

	public Pourcentage getMtn_entrepreneuriale() {
		return mtn_entrepreneuriale;
	}

	public Pourcentage getApr_entrepreneuriale() {
		return apr_entrepreneuriale;
	}
	
	
}
