package graphic_interface;

public class Etude {

	// VARIABLES INSTANCE //
	
	private Schema1 s1;
	private Schema2 s2;
	private Schema3 s3;
	private Schema4 s4;
	private Schema5 s5;
	private Schema6 s6;
	
	// CONSTRUCTEUR //
	
	public Etude(Schema1 s1, Schema2 s2, Schema3 s3, Schema4 s4, Schema5 s5, Schema6 s6) {

		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.s6 = s6;
	}
	
	public Etude()
	{
		@SuppressWarnings("unchecked")
		ElementNote<Structure>[] structure = new ElementNote[4];
		@SuppressWarnings("unchecked")
		ElementNote<Structure>[] risque_structure = new ElementNote[5];
		@SuppressWarnings("unchecked")
		ElementNote<Organisation>[] organisation = new ElementNote[4];
		@SuppressWarnings("unchecked")
		ElementNote<Organisation>[] risque_organisation = new ElementNote[5];
		@SuppressWarnings("unchecked")
		ElementNote<Entreprise>[] entreprise = new ElementNote[4];
		for (int i=0;i<4;i++){
			structure[i]=null;
			organisation[i]=null;
			entreprise[i] = null;
			risque_structure[i]=null;
			risque_organisation[i]=null;
		}
		risque_structure[4]=null;
		risque_organisation[4]=null;
		this.s1=new Schema1(null,null,null,null,null,null,null,null,null,null,null,null,null);
		this.s2=new Schema2(null,null,structure,structure,risque_structure);
		this.s3=new Schema3(null,null,organisation,organisation,risque_organisation);
		this.s4=new Schema4(null,null,null,null,null,null,null,null,null);
		this.s5=new Schema5(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
		this.s6=new Schema6(null,null,null,entreprise,entreprise,entreprise);
		
	}
	
	// GETTERS //

	public Schema1 getS1() {
		return s1;
	}

	public Schema2 getS2() {
		return s2;
	}

	public Schema3 getS3() {
		return s3;
	}

	public Schema4 getS4() {
		return s4;
	}

	public Schema5 getS5() {
		return s5;
	}

	public Schema6 getS6() {
		return s6;
	}

	// SETTERS //
	
	public void setS1(Schema1 s1) {
		this.s1 = s1;
	}

	public void setS2(Schema2 s2) {
		this.s2 = s2;
	}

	public void setS3(Schema3 s3) {
		this.s3 = s3;
	}

	public void setS4(Schema4 s4) {
		this.s4 = s4;
	}

	public void setS5(Schema5 s5) {
		this.s5 = s5;
	}

	public void setS6(Schema6 s6) {
		this.s6 = s6;
	}
	
	
}
