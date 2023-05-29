package hust.soict.dsai.aims;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

import java.util.Scanner;


public class Aims {

	public static void main(String[] args) {
		
		// Store
		
		Store store = new Store();
		
		Book book1 = new Book(1, "First Book", "Fiction", 22.5f);
		book1.addAuthor("Justin");
		store.addMedia(book1);
		Book book2 = new Book(2, "Second Book", "Sport", 5.23f);
		book2.addAuthor("Dawn");
		store.addMedia(book2);
		
		
		DigitalVideoDisc DVD1 = new DigitalVideoDisc(3, "First Disc", "Horror", 111f, "Bob", 120);
		store.addMedia(DVD1);
		DigitalVideoDisc DVD2 = new DigitalVideoDisc(4, "Second Disc", "Funny", 20f, "Jack", 10);
		store.addMedia(DVD2);
		
		Track track1 = new Track("First track", 10);
		Track track2 = new Track("Second track", 20);
		Track track3 = new Track("Third track", 30);
		CompactDisc CD1 = new CompactDisc(5, "First CD", "Love", 100f, "Brad", 300, "Pitt");
		CD1.addTrack(track1);
		CD1.addTrack(track2);
		CD1.addTrack(track3);
		store.addMedia(CD1);
		
		// User 
		
		Cart cart = new Cart();
		
		try (Scanner keyboard = new Scanner(System.in)) {
			int option;
			String title;
			
			while(true) {
				showMenu();
				option = keyboard.nextInt();
				if(option == 0) break;
				else if(option == 1) {
					store.displayStore();
					while(true)
					{
						storeMenu();
						option = keyboard.nextInt();
						if(option == 0) break;
						else if(option == 1) {
							System.out.println("Please enter the title of the media:");
							title = keyboard.nextLine();
							title = keyboard.nextLine();

							Media media = store.search(title);
							if((media.getId()) == -1) System.out.println("Can't find the media");
							else {
								store.showDetails(media);
								if (media.getClass().getSimpleName().equals("Book")) 
								{
									mediaDetailsMenuBook();
									option = keyboard.nextInt();
									if(option == 1) cart.addMedia(media);
								}
								else 
								{
									while(true) {
										mediaDetailsMenu();
										option = keyboard.nextInt();
										if(option == 2) store.play(media); 
										else if(option == 1) cart.addMedia(media);
										break;
									}
								}
							}
						}
						else if(option == 2) {
							System.out.println("Please enter the title of the media:");
							title = keyboard.nextLine();
							title = keyboard.nextLine();
							
							Media media = store.search(title);
							if((media.getId()) == -1) System.out.println("Can't find the media");
							else cart.addMedia(media);
						}
						else if (option == 3){
							System.out.println("Please enter the title of the media:");
							title = keyboard.nextLine();
							title = keyboard.nextLine();
							
							Media media = store.search(title);
							if((media.getId()) == -1) System.out.println("Can't find the media");
							else store.play(media);
						}
						else{
							cart.displayCart();
						}
					}
				}
				else if(option == 2) {
					System.out.println("Please enter the title of the media:");
					title = keyboard.nextLine();
					title = keyboard.nextLine();
					
					Media media = store.search(title);
					if((media.getId()) == -1) System.out.println("Can't find the media");
					else 
					{
						while(true)
						{
							updateMenu();
							option = keyboard.nextInt();
							if(option == 1) 
								// Need to make new media
								store.addMedia(media);
							else if(option == 2)
								store.removeMedia(media);
							break;
						}
					}
				}
				else if(option == 3) {
					cart.displayCart();
					while(true)
					{
						cartMenu();
						option = keyboard.nextInt();
						// Need option filter 
						if(option == 0) break;
						else if(option == 2) {
							sortMenu();
							option = keyboard.nextInt();
							if(option == 0) break;
							else if(option == 1) {
								cart.sortByCost();
								cart.displayCart();
							}
							else {
								cart.sortByTitle();
								cart.displayCart();
							}
							
						}
						else if(option == 3) {
							System.out.println("Please enter the title of the media:");
							title = keyboard.nextLine();
							title = keyboard.nextLine();
							
							Media media = cart.search(title);
							if((media.getId()) == -1) System.out.println("Can't find the media");
							else cart.removeMedia(media);
						}
						else if(option == 4) {
							System.out.println("Please enter the title of the media:");
							title = keyboard.nextLine();
							title = keyboard.nextLine();
							
							Media media_cart = store.search(title);
							if((media_cart.getId()) == -1) System.out.println("Can't find the media");
							else store.play(media_cart);
						}
						else {
							System.out.println("An order is created");
							cart = new Cart();
							break;
						}	
					}
				}
			}
		}

	}


	public static void updateMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Cost");
		System.out.println("2. Title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenuBook() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}


}
