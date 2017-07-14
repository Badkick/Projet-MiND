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
	
	
}
