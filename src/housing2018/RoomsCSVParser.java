package housing2018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomsCSVParser {
	
	private File csv;
	private List<Room> rooms;
	
	public RoomsCSVParser(String filePath) {
		csv = new File(filePath);
		parseRooms();
	}
	
	private void parseRooms() {
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(
	        new FileInputStream(csv), "UTF8"))) {
	      String nextLine;
	      List<String> row;
	      while ((nextLine = br.readLine()) != null) { // while next line exists
	        row = parseLine(nextLine);
	        rooms.add(roomFromRow(row));
	      }
	    } catch (Exception fnfex) {
	      System.err.println("ERROR: file " + csv + " not found.");
	    }
	  }
	
	public Room roomFromRow(List<String> row) {
		String buildingName = parseBuildingName(row.get(0));
		String roomNum = parseRoomNumber(row.get(0));
		int sqft = Integer.parseInt(row.get(1));
		int occ = Integer.parseInt(row.get(2));
		return new Room(roomNum, buildingName, sqft, occ);
	}
	
	public static List<String> parseLine(String line) {
		return Arrays.asList(line.split(","));
	}
	
	/**
	 * Removes numerals and trims spaces from name in csv.
	 */
	public static String parseBuildingName(String fullName) {
		String withoutNumerals = fullName.toUpperCase().replaceAll("[^A-Z]", "");
		return withoutNumerals.trim();
	}
	
	/*
	 * split the name, the last item of the split on spaces should be the room #.
	 */
	public static String parseRoomNumber(String fullName) {
		List<String> splitName = Arrays.asList(fullName.trim().split(","));
		return splitName.get(splitName.size() - 1);
	}
	
	
}
