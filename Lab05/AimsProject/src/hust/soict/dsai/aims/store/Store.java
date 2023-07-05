package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.media.CompactDisc;

public class Store {
	private ArrayList <Media> itemsInStore = new ArrayList <Media>();
	private int qtyStore = 0;

	public Store() {
		super();
	}
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
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

}
