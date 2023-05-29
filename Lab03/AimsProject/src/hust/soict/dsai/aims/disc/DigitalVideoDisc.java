package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private	String category;
	private String directory;
	private int length;
	private float cost;
	
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getID()
	{
		return id;
	}
	public DigitalVideoDisc(String title) {
		super();
		nbDigitalVideoDiscs++;
		setID(nbDigitalVideoDiscs);
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category) {
		super();
		nbDigitalVideoDiscs++;
		setID(nbDigitalVideoDiscs);
		this.title = title;
		this.category = category;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		nbDigitalVideoDiscs++;
		setID(nbDigitalVideoDiscs);
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		nbDigitalVideoDiscs++;
		setID(nbDigitalVideoDiscs);
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		nbDigitalVideoDiscs++;
		setID(nbDigitalVideoDiscs);
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
	}
	
	
	
}
