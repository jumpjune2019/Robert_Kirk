import java.awt.BorderLayout;

enum LabelsEnum {
	CENTER("Center", BorderLayout.CENTER), 
	EAST("East", BorderLayout.EAST), 
	NORTH("North", BorderLayout.NORTH), 
	SOUTH("South", BorderLayout.SOUTH), 
	WEST("West", BorderLayout.WEST);
	
	private String label;
	private String position;
	
	// Constructor
	LabelsEnum(String l, String p) { 
		label = l;
		position = p;
	}

	String getLabel() {
		return label;
	}
	
	String getPosition() {
		return position;
	}
}