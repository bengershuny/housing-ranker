package housing2018;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRanker {

	int maxSqft;
	double maxFloorplanScore;
	double maxQualityScore;
	
	List<Room> roomList;
	Map<Room, RoomRating> ratingMap;
	
	public RoomRanker(List<Room> rooms) {
		this.roomList = rooms;
		maxSqft = findMaxSqft();
		maxFloorplanScore = findMaxFPScore();
		maxQualityScore = findMaxQualScore();
	}
	
	public void setRatings() {
		for (Room r : roomList) {
			ratingMap.put(r, new RoomRating(rateSize(r), rateLocation(r), 
					rateQuality(r), rateFloorplan(r)));
		}
	}
	
	/*
	 * Ranks rooms given weights for each of four features of a room. Does so by
	 * simply using the given weight as a multiplier with the corresponding-feature's 
	 * rating in the ratingMap for the given room. Then sums the weighted ratings of
	 * the four features for each rooms, and sorts --DESCENDING-- from highest weighted score
	 * to lowest.
	 */
	public List<Room> rankRooms(double sizeWeight, double locationWeight, 
			double qualityWeight, double floorplanWeight) {
		
		Map<Room, Double> weightedRatingsMap = new HashMap<>();
		for (Room r : roomList) {
			RoomRating ratings = ratingMap.get(r);
			double weightedRating = 0.0;
			
			weightedRating += sizeWeight * ratings.sizeRating();
			weightedRating += locationWeight * ratings.locationRating();
			weightedRating += qualityWeight * ratings.qualityRating();
			weightedRating += floorplanWeight * ratings.floorplanRating();
			
			weightedRatingsMap.put(r, weightedRating);
		}
		
		// copy underlying room list.
		List<Room> rooms = new ArrayList<>(roomList);
		
		// sort in descending order based on weighted rating of room
		Collections.sort(rooms, (r1, r2) 
				-> Double.compare(weightedRatingsMap.get(r2), 
						weightedRatingsMap.get(r1)));
		return new ArrayList<>(rooms);
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
		return locRating;
	}
	
	/**
	 * Divides room's quality score by the max quality score of all rooms.
	 */
	private double rateQuality(Room r) {
		return r.getQualityScore() / maxQualityScore;
	}
	
	/**
	 * Divides room's floorplan score by the max floorplan score of all rooms.
	 */
	private double rateFloorplan(Room r) {
		return r.getFloorplanScore() / maxFloorplanScore;
	}
	
	/*
	 * Uses lambda to find square footage of room with biggest square footage.
	 */
	private int findMaxSqft() {
		Room maxSqftRoom = Collections.max(roomList, 
				(r1, r2) -> Integer.compare(r1.getSqft(), r2.getSqft()));
		return maxSqftRoom.getSqft();
	}
	
	private double findMaxFPScore() {
		Room maxFPSRoom = Collections.max(roomList,  (r1, r2) 
				-> Double.compare(r1.getFloorplanScore(), r2.getFloorplanScore()));
		return maxFPSRoom.getFloorplanScore();
	}
	
	private double findMaxQualScore() {
		Room maxQualRoom = Collections.max(roomList, (r1, r2) 
				-> Double.compare(r1.getQualityScore(), r2.getQualityScore()));
		return maxQualRoom.getQualityScore();
	}
}
