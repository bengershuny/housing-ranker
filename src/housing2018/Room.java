package housing2018;

public class Room {

	private String roomNumber;
	private int floor;
	private int sqFeet;
	private int occupancy;
	private Building building;
	
	public Room(String number, String buildingName, int squareFootage, int occupancy) {
		roomNumber = number;
		floor = parseFloor(number);
		sqFeet = squareFootage;
		this.occupancy = occupancy;
		building = Building.withName(buildingName);
	}
	
	public int getSqft() { return sqFeet; }
	public int getOccupancy() { return occupancy; }
	public Building getBuilding() { return building; }
	
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
