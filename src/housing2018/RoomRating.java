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
		assert (validRating(sizeRating) && validRating(locationRating) 
				&& validRating(qualityRating) && validRating(floorplanRating));
	}
	
	public double sizeRating() { return sizeRating; }
	public double locationRating() { return locationRating; }
	public double qualityRating() { return qualityRating; }
	public double floorplanRating() { return floorplanRating; }

	/*
	 * asserts that rating is between 0 and 1 (valid)
	 */
	public static boolean validRating(double rating) {
		return (0.0 <= rating && rating <= 1.0);
	}
	
}
