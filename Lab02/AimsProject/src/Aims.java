
public class Aims {

	public static void main(String[] args) {
		
		//Create a new cart
		Cart an0rder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		an0rder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Stars war",
				"Science fiction", "George Lucas", 87, 24.95f);
		an0rder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 19.95f);
		an0rder.addDigitalVideoDisc(dvd3);
		
		
		System.out.print("Total cost is ");
		System.out.println(an0rder.totalCost());
		
		an0rder.removeDigitalVideoDisc(dvd3);
		System.out.print("Total cost is ");
		System.out.println(an0rder.totalCost());
		
	}

}
