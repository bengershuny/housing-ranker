package housing2018;

public class Main {

	public static void main(String[] args) {
		
		RoomsCSVParser parser = new RoomsCSVParser("./HousingInfoSheet.csv");
		RoomRanker ranker = new RoomRanker(parser.getRooms());
		
		for (Room r : ranker.rankRooms(1.0, 0.0, 0.0, 0.0)) {
			System.out.println(r.toString());
		}
		
	}

}
