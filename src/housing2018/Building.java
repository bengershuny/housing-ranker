package housing2018;

import java.util.HashMap;
import java.util.Map;

public enum Building {
	Perkins(1.0, 
			"Farthest from everything (south campus)",
			"PERKINS HALL"),
	Barbour(2.0, 
			"Second farthest (south campus)",
			"BARBOUR HALL"), 
	NewPem(3.0, 
			"North campus, right on Thayer",
			"NEW PEMBROKE 3"), 
	Minden(4.0, 
			"Past SciLi, decent location, socially isolated",
			"MINDEN HALL"), 
	Gregorian(5.0, 
			"Far, right outside Jo's",
			"GREGORIAN QUAD A"), 
	GradCenterB(6.0, 
			"Far, south campus below Ratty",
			"GRAD CENTER B"),
	GradCenterD(6.0, 
			"Far, south campus below Ratty",
			"GRAD CENTER D"),
	Olney(7.0, 
			"Solid location on Wriston, houses Sigma Chi",
			"OLNEY HOUSE"),
	Sears(8.0, 
			"Good location, but on Wriston and houses frat",
			"SEARS HOUSE"), 
	SouthCaswell(9.0, 
			"On Simmons Quad by Thayer",
			"SOUTH CASWELL HALL"),
	MiddleCaswell(9.0, 
			"On Simmons Quad by Thayer",
			"MIDDLE CASWELL HALL"),
	NorthCaswell(9.0, 
			"On Simmons Quad by Thayer",
			"NORTH CASWELL HALL"), 
	Chapin(10.0, 
			"On Thayer Street right below Ratty",
			"CHAPIN HOUSE"), 
	Littlefield(11.0, 
			"Insulated, central location",
			"LITTLEFIELD HALL"), 
	Marcy(12.0, 
			"Between Wriston and Patriot's, potentially noisey",
			"MARCY HOUSE"), 
	Goddard(13.0, 
			"Right on Patriot's Court below Diman",
			"GODDARD HOUSE"), 
	Diman(14.0, 
			"Right by Ratty, insulated from noise",
			"DIMAN HOUSE"),
	Hope(15.0,
			"Right on Main Green by Faunce",
			"HOPE COLLEGE");
	
	
	private double locationRating;
	private String locationDescription;
	private String name;
	
	// code attribute useful for quick, typable room-removing.
	
	//private String code;
	
	private Building(double locRating, String locDescription, String name //, String code
			) { 
		locationRating = locRating; 
		locationDescription = locDescription;
		this.name = name;
		//this.code = code;
	}
	
	public String getName() { return name; }
	public String getLocDescription() { return locationDescription; }
	public double getLocRating() { return locationRating; }
	
	private static Map<String, Building> nameMap;
	static {
		nameMap = new HashMap<String, Building>();
		for (Building b : Building.values()) {
			nameMap.put(b.name(), b);
		}
	}
	
	public static Building withName(String name) {
		return nameMap.get(name);
	}
	
}





