package housing2018;

public class RoomRating {
	
	private double sizeRating;
	private double locationRating;
	private double qualityRating;
	private double floorplanRating;
	
	public RoomRating(double size, double loc, double qual, double floorplan) {
		sizeRating = size;
		locationRating = loc;
		qualityRating = qual;
		floorplanRating = floorplan;
	}
	
	public double sizeRating() { return sizeRating; }
	public double locationRating() { return locationRating; }
	public double qualityRating() { return qualityRating; }
	public double floorplanRating() { return floorplanRating; }

	
}
