package graphic_interface;

public enum Structure {
	
	SIMPLE_MARCHE("simple_marche"),
	PROFESSIONNELLE("professionnelle"),
	MECANISTE("mecaniste"),
	SIMPLE_CENTRALISEE("simple_centralisee"),
	ENTREPRENEURIALE("entrepreneuriale");

	private String nom;
	
	private Structure(String nom)
	{
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}


}
