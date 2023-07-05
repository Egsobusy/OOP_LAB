package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;


public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
        Store store = new Store();
        new StoreScreen(store, cart);
	}
}
	


	