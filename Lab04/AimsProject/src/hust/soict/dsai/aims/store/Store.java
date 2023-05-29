package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;

public class Store {
	private ArrayList <Media> itemsInStore = new ArrayList <Media>();
	private int qtyStore = 0;
	
	public void addMedia(Media item) {
		if(itemsInStore.contains(item)) return;
		itemsInStore.add(item);
		qtyStore++;
	}
	
	public void removeMedia(Media item)
	{
		for(int i = 0; i < qtyStore; i++)
		{
			if((itemsInStore.get(i)).equals(item))
			{
				itemsInStore.remove(i);
				qtyStore--;
				return;	
			}
		}
	}

	
	public Media search(String title) {
		Book bk = new Book(-1, "-1", "-1", 0f);
		for(Media media: itemsInStore) {
			if(media.getTitle().equals(title)) return media;
		}
		return bk;
	}
	
	public void play(Media media) {
		String type = media.getClass().getSimpleName();
		if(type == "Book") System.out.println("Can't play this media");
		else if(type == "DigitalVideoDisc")
		{
			DigitalVideoDisc DVD = (DigitalVideoDisc) media;
			DVD.play();
		}
		else
		{
			CompactDisc CD = (CompactDisc) media;
			CD.play();
		}
	}
	
	public void showDetails(Media media) {
		System.out.print(media.getClass().getSimpleName() + " - ");
		System.out.print(media.getId() + " - ");
		System.out.print(media.getTitle() + " - ");
		System.out.print(media.getCategory() + " - ");
		System.out.println(media.getCost() + "$");
	}
	
	public void displayStore() {
		System.out.println("**********************STORE************************");
		System.out.println("Ordered Items: ");
		for(Media media: itemsInStore) showDetails(media);
		System.out.println("***************************************************");
	}

}
