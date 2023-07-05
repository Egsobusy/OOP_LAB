package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store st = new Store();
		
		DigitalVideoDisc DVD1 = new DigitalVideoDisc(3, "First Disc", "Horror", 111f, "Bob", 120);
		st.addMedia(DVD1);
	}

}
