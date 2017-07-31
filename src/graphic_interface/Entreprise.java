package graphic_interface;

public enum Entreprise {

	COMMUNAUTE("Entreprise\ncommunauté",1),
	DUALE("Entreprise\nduale",2),
	MODERNISEE("Entreprise\nmodernisée",3),
	CRISE("Entreprise\nen crise",4),
	BUREAUCRATIQUE("Entreprise\nbureaucratique",5);
	
	private String nom;
	private int numero;
	
	private Entreprise(String nom, int numero) {
		this.nom = nom;
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public int getNumero() {
		return numero;
	}
	
	public static Entreprise getByName(String nom){
		for(Entreprise e:Entreprise.values()){
			if(nom.equals(e.getNom())){
				return e;
			}
		}return null;
	}
	
}
