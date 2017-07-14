package graphic_interface;

public class Pourcentage {

	private int valeur;
	
	public Pourcentage(int val)
	{
		this.setVal(val);
	}
	
	public Pourcentage(float val)
	{
		this.setVal((int)val);
	}
	
	public void setVal(int val)
	{
		this.valeur = (val<0 ? 0 : (val>100 ? 100 : val));
	}
	
	public int get()
	{
		return this.valeur;
	}
	
	public String toString()
	{
		return String.valueOf(this.get())+" %";
	}
}
