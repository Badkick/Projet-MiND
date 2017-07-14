package graphic_interface;

public enum Structure implements ElementPouvantEtreNote{ // pour schéma 2
	
	SIMPLE_MARCHE("simple_marche",1),
	PROFESSIONNELLE("professionnelle",2),
	MECANISTE("mecaniste",3),
	SIMPLE_CENTRALISEE("simple_centralisee",4),
	ENTREPRENEURIALE("entrepreneuriale",5);

	private String nom;
	private int numero;
	
	private Structure(String nom, int numero)
	{
		this.nom = nom;
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}
	
	public int getNumero()
	{
		return this.numero;
	}
}