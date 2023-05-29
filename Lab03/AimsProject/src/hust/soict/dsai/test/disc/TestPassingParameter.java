package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

class Wrapper
{
	DigitalVideoDisc w;
	
	public Wrapper(DigitalVideoDisc w)
	{
		this.w = w;
	}
}

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		Wrapper jungle = new Wrapper(jungleDVD);
		Wrapper cinderella = new Wrapper(cinderellaDVD);
		
		swap(jungle, cinderella);
		
		System.out.println("jungle dvd title: " + jungle.w.getTitle());
		System.out.println("cinderella dvd title: " + cinderella.w.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Wrapper o1, Wrapper o2)
	{
		DigitalVideoDisc tmp = o1.w;
		o1.w = o2.w;
		o2.w = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title)
	{
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
