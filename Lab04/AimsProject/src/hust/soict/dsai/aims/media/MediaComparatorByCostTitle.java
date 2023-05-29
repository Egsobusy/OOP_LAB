package hust.soict.dsai.aims.media;
import java.util.Comparator;


public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media obj1, Media obj2) {
		if(obj1.getCost() != obj2.getCost())
		{
			float difference = obj1.getCost() - obj2.getCost();
			if(difference > 0) return 1;
			else {
				if(difference == 0) return 0;
				return -1;
			}
		}
		return obj1.getTitle().compareTo(obj2.getTitle());
	}
}
