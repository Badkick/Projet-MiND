package graphic_interface;

public enum Organisation implements ElementPouvantEtreNote { // pour schéma 3

	RATIONNELLE("Organisation\nRATIONNELLE",1),
	ARTISANALE("Organisation\nARTISANALE",2),
	PERSONNALISEE("Organisation\nPERSONNALISEE",3),
	PROFESSIONNELLE_PROCESS("Organisation\nPROFESSIONNELLE\nDE PROCESS",4),
	FLEXIBLE("Organisation\nFLEXIBLE",5);

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
	
	public static Organisation getByName(String nom){
		for(Organisation e:Organisation.values()){
			if(nom.equals(e.getNom())){
				return e;
			}
		}return null;
	}
}