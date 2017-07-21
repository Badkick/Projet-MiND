package graphic_interface;

public class Pourcentage {

	private float valeur;
	
	public Pourcentage(float val)
	{
		this.setVal(val);
	}
	
	public void setVal(float val)
	{
		this.valeur = (val<0 ? 0 : (val>100 ? 100 : val));
	}
	
	public float get()
	{
		return this.valeur;
	}
	
	public String toString()
	{
		return String.valueOf(this.get())+" %";
	}
}
