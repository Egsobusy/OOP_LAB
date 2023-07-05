package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;

public class Cart {
	private FXCollections FXCollection;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollection.observableArrayList();
	private int qtyOrdered = 0;
	
	public void addMedia(Media item) throws LimitExceededException {
		if(itemsOrdered.contains(item) || itemsOrdered.size() < MAX_NUMBERS_ORDERED) throw new LimitExceededException();
		itemsOrdered.add(item);
		qtyOrdered++;
	}
	
	public void removeMedia(Media item)
	{
		for(int i = 0; i < qtyOrdered; i++)
		{
			if(itemsOrdered.get(i).equals(item))
			{
				itemsOrdered.remove(i);
				qtyOrdered--;
				return;	
			}
		}
	}
	
	
	public float totalCost()
	{
		int total = 0;
		for(Media media: itemsOrdered) total += media.getCost();
		return total;
	}
	
	public Media search(String title) {
		Book bk = new Book(-1, "-1", "-1", 0f);
		for(Media media: itemsOrdered) {
			if(media.getTitle().equals(title)) return media;
		}
		return bk;
	}
	
	
	public void sortByTitle() {
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
	}
	
	
	public void showDetails(Media media) {
		System.out.print(media.getClass().getSimpleName() + " - ");
		System.out.print(media.getId() + " - ");
		System.out.print(media.getTitle() + " - ");
		System.out.print(media.getCategory() + " - ");
		System.out.println(media.getCost() + "$");
	}
	
	public void displayCart()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for(Media media: itemsOrdered) showDetails(media);
		System.out.println("***************************************************");
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}


