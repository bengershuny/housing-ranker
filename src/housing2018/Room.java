package housing2018;

public class Room {

	private String roomNumber;
	private int floorLevel;
	private int sqFeet;
	private int occupancy;
	
	private double qualityScore;
	private double floorplanScore;
	
	private Building building;
	
	public Room(String number, String buildingName, int squareFootage, int occupancy,
			double qualityScore, double floorplanScore) {
		
		roomNumber = number;
		floorLevel = parseFloor(number);
		sqFeet = squareFootage;
		this.occupancy = occupancy;
		
		this.floorplanScore = floorplanScore;
		this.qualityScore = qualityScore;
		
		building = Building.withName(buildingName);
	}
	
	public int getSqft() { return sqFeet; }
	public int getOccupancy() { return occupancy; }
	public Building getBuilding() { return building; }
	
	public double getQualityScore() { return qualityScore; }
	public double getFloorplanScore() { return floorplanScore; }
	
	public int parseFloor(String number) {
		return Integer.parseInt(Character.toString(number.charAt(0)));
	}
	
	@Override
	public String toString() {
		return building.getName() + " " + roomNumber + " (" + occupancy + ")";
	}
	
	public String descriptionString() {
		return toString() + ": " + sqFeet + " sqft. | ";
	}
}
