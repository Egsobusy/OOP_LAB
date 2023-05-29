package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[5];
	private int qtyStore = 0;
	
	void addDVD(DigitalVideoDisc dvd)
	{
		itemsInStore[++qtyStore] = dvd;
	}
	
	void removeDVD(DigitalVideoDisc dvd)
	{
		for(int i = 0; i < qtyStore; i++)
		{
			if(itemsInStore[i].equals(dvd))
			{
				itemsInStore[i] = null;
				qtyStore--;
				break;
			}
		}
	}
}
