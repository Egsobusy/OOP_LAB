package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	

	
	public Media(int id, String title, String category, float cost) {
		setId(id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	

	public boolean equals(Media obj) {
		return (this.title == obj.title);
	}
	
	public static final Comparator <Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator <Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();


}
