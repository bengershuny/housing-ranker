package housing2018;

public enum RoomType {
	Single(1), SuiteSingle(1), Double(2), SplitDouble(2);
	
	private int occupancy;
	private RoomType(int occupancy) { this.occupancy = occupancy; }
	
	public int getOccupancy() {
		return occupancy;
	}
}
