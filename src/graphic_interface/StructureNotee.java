package graphic_interface;

public class StructureNotee {

	// VARIABLES DE CLASSE //
	
	private Structure structure;
	private int note;
	
	// CONSTRUCTEUR //
	
	public StructureNotee(Structure structure, int note)
	{
		this.structure = structure;
		this.setNote(note);
	}
	
	// GETTERS //
	
	public Structure getStructure()
	{
		return this.structure;
	}
	
	public int getNote()
	{
		return this.note;
	}

	// SETTERS //
	
	public void setNote(int note)
	{
		this.note = (note<1 ? 1 : (note>10 ? 10 : note));
	}
	
	
}
