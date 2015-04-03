package mypack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumInfoAction {

	private String title;
	private Artist artist;
	private static List<Song> songs = new ArrayList<Song>();
	private List<String> sampleList = new ArrayList<String>();
	private String[] sampleArray;
	private Map<Integer, String> myMap = new HashMap<Integer, String>();
	// initializer block
	{
		sampleArray = new String[] { "item1", "item2", "item3" };
		myMap.put(1, "One");
		myMap.put(2, "Two");
		myMap.put(3, "Three");
		sampleList.add("Thriller Disco");
		sampleList.add("Beat It Rock");
		sampleList.add("Billie Jean Pop");
		sampleList.add("Thriller Disco");
		sampleList.add("Beat It Rock");
		sampleList.add("Billie Jean Pop");
	}

	public  List<String> getSampleList() {
		return sampleList;
	}

	public void setSampleList(List<String> sampleList) {
		this.sampleList = sampleList;
	}

	public Map<Integer, String> getMyMap() {
		return myMap;
	}

	public void setMyMap(Map<Integer, String> myMap) {
		this.myMap = myMap;
	}

	public String[] getSampleArray() {
		return sampleArray;
	}

	public void setSampleArray(String[] sampleArray) {
		this.sampleArray = sampleArray;
	}

	static {
		songs.add(new Song("Thriller", "Disco"));
		songs.add(new Song("Beat It", "Rock"));
		songs.add(new Song("Billie Jean", "Pop"));
		songs.add(new Song("Thriller", "Disco"));
		songs.add(new Song("Beat It", "Rock"));
		songs.add(new Song("Billie Jean", "Pop"));
	}

	public List<Song> getSongs() {
		return songs;
	}

	public String populate() {
		title = "Thriller";
		artist = new Artist("Michael Jackson", "King of pop");
		return "populate";
	}

	public String execute() {
		return "success";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public String welcome()
	{
		return "Hello Welcome method called...";
	}

}