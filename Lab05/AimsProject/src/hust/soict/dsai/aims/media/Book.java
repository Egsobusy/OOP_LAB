package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media{

	private ArrayList <String> authors = new ArrayList <String>();
	
	public Book(int id,	String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		for(Object author: authors)
			if(author.equals(authorName))return;
		authors.add(authorName);
		
	}
	
}
