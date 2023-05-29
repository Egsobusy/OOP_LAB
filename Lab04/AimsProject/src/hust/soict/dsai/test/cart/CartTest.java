package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		DigitalVideoDisc DVD1 = new DigitalVideoDisc(3, "First Disc", "Horror", 111f, "Bob", 120);
		cart.addMedia(DVD1);
	}
}
