package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc items0rdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	// ADD TO CART
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if(qtyOrdered == MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is full!");
		}
		else
		{
			items0rdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
	{
		if(qtyOrdered + 2 > MAX_NUMBERS_ORDERED)
		{
			System.out.println("Can not add all the disc!");
		}
		else
		{
			items0rdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			items0rdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("All the disc has been added.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvdList[])
	{
		int orderQty = dvdList.length;
		if(qtyOrdered + orderQty > MAX_NUMBERS_ORDERED)
		{
			System.out.println("Can not add all the disc!");
		}
		else
		{
			for(int i = 0; i < orderQty; i++)
			{
				items0rdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
			}
			System.out.println("All the disc has been added.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		for(int i = 0; i < qtyOrdered; i++)
		{
			if(items0rdered[i].equals(disc))
			{
				items0rdered[i] = null;
				qtyOrdered--;
				break;
				
			}
		}
	}
	
	public float totalCost()
	{
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++)
		{
			total += items0rdered[i].getCost();
		}
		return total;
	}
	
	public void printDVD(int i)
	{
		System.out.print("DVD - " + items0rdered[i].getTitle() + " - ");
		System.out.print(items0rdered[i].getCategory() + " - ");
		System.out.print(items0rdered[i].getDirectory() + " - ");
		System.out.print(items0rdered[i].getLength() + " : ");
		System.out.println(items0rdered[i].getCost() + "$");
	}
	
	public void print()
	{
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items: ");
		for(int i = 0; i < qtyOrdered; i++)
		{
			System.out.print((i+1) + ". ");
			printDVD(i);
		}
		System.out.println("***************************************************");
	}
	
	public void searchByID(int id)
	{
		int discID;
		for(int i = 0; i < qtyOrdered; i++)
		{
			discID = items0rdered[i].getID();
			if(discID == id)
			{
				System.out.print("1. ");
				printDVD(i);
				return;
			}
		}
		System.out.println("Can't find the DVD!");
	}
	
	public void searchByTitle(String title)
	{
		boolean check = true;
		int nb = 0;
		
		String discTitle;
		for(int i = 0; i < qtyOrdered; i++)
		{
			discTitle = items0rdered[i].getTitle();
			if(discTitle.equals(title))
			{
				System.out.print((++nb) + ". ");
				printDVD(i);
				check = false;
			}
		}
		if(check)
		{
			System.out.println("Can't find the DVD!");
		}
		
	}
}
