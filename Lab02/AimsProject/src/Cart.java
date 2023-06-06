
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc items0rdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		if(this.qtyOrdered == MAX_NUMBERS_ORDERED)
		{
			System.out.println("The cart is full!");
		}
		else
		{
			this.items0rdered[this.qtyOrdered] = disc;
			this.qtyOrdered++;
			System.out.println("The disc has been added.");
		}
	}
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		for(int i = 0; i < this.qtyOrdered; i++)
		{
			if(this.items0rdered[i].equals(disc))
			{
				this.items0rdered[i] = null;
				this.qtyOrdered--;
				break;
				
			}
		}
	}
	
	float totalCost()
	{
		float total = 0;
		for(int i = 0; i < this.qtyOrdered; i++)
		{
			total += this.items0rdered[i].getCost();
		}
		return total;
	}
}
