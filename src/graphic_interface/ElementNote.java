package graphic_interface;

public class ElementNote<E extends ElementPouvantEtreNote> {

	private static final int NOTE_MIN = 1;
	private static final int NOTE_MAX = 10;
	
	// VARIABLES DE CLASSE //
	
	private E element;
	private int note;
	
	// CONSTRUCTEUR //
	
	public ElementNote(E element, int note)
	{
		this.element = element;
		this.setNote(note);
	}
	
	// GETTERS //
	
	public E getElement()
	{
		return this.element;
	}
	
	public int getNote()
	{
		return this.note;
	}

	// SETTERS //
	
	public void setNote(int note)
	{
		this.note = (note<NOTE_MIN ? NOTE_MIN : (note>NOTE_MAX ? NOTE_MAX : note));
	}
	
	
}
