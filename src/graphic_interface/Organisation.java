package graphic_interface;

public enum Organisation implements ElementPouvantEtreNote { // pour schéma 3

	RATIONNELLE("rationnelle",1),
	ARTISANALE("artisanale",2),
	PERSONNALISEE("personnalisee",3),
	PROFESSIONNELLE("professionnelle",4),
	FLEXIBLE("flexible",5);

	private String nom;
	private int numero;

	private Organisation(String nom, int numero)
	{
		this.nom = nom;
		this.numero = numero;
	}

	public String getNom()
	{
		return this.nom;
	}

	public int getNumero()
	{
		return this.numero;
	}
}