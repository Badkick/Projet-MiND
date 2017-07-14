package graphic_interface;

public enum Entreprise {

	COMMUNAUTE("communaute",1),
	DUALE("duale",2),
	MODERNISEE("modernisee",3),
	CRISE("crise",4),
	BUREAUCRATIQUE("bureaucratique",5);
	
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
	
	
}
