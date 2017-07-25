package graphic_interface;

public enum Structure implements ElementPouvantEtreNote{ // pour schéma 2
	
	SIMPLE_MARCHE("Structure\nSIMPLE DE MARCHE",1),
	PROFESSIONNELLE("Structure\nPROFESSIONNELLE",2),
	MECANISTE("Structure\nMECANISTE",3),
	SIMPLE_CENTRALISEE("Structure\nSIMPLE CENTRALISEE",4),
	ENTREPRENEURIALE("Structure\nENTREPRENEURIALE",5);

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
	
	public static Structure getByName(String nom){
		for(Structure e:Structure.values()){
			if(nom.equals(e.getNom())){
				return e;
			}
		}return null;
	}
}