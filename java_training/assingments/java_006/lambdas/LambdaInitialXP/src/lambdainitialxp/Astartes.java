package lambdainitialxp;

public class Astartes {
	
	private String name;
	private String chapter;
	
	public Astartes(String name, String chapter){
		this.name = name;
		this.chapter = chapter;
	}
	public Astartes(){}
	
	public void getBattleBrother() {
		System.out.println(this.name + ", Battle Brother of the " + this.chapter + " reporting for duty!");
	}

}
