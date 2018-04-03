package housing2018;

import java.util.List;
import java.util.Map;

public class RoomRanker {

	int maxSqft;
	List<Room> roomList;
	Map<Room, RoomRating> ratingMap;
	
	public RoomRanker(List<Room> rooms) {
		this.roomList = rooms;
		maxSqft = findMaxSqft();
	}
	
	public void setRatings() {
		for (Room r : roomList) {
			ratingMap.put(r, new RoomRating(rateSize(r), rateLocation(r), 
					rateQuality(r), rateFloorplan(r)));
		}
	}
	
	/**
	 * Returns the room's square footage divided 
	 * by the max square-footage of all the rooms.
	 */
	private double rateSize(Room r) {
		double max = (double) maxSqft;
		return ((double) r.getSqft() / max);
	}
	
	/**
	 * Returns the location rating of the room's building--
	 */
	private double rateLocation(Room r) {
		double locRating = r.getBuilding().getLocRating();
		assert locRating >= 0.0 && locRating <= 1.0;
		return locRating;
	}
	
	private double rateQuality(Room r) {
		return 0.0;
	}
	
	private double rateFloorplan(Room r) {
		return 0.0;
	}
	
	private int findMaxSqft() {
		int max = 0;
		for (Room r: roomList) {
			if (r.getSqft() > max) {
				max = r.getSqft();
			}
		}
		return max;
	}
}
