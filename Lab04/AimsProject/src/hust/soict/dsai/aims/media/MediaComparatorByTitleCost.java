package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media obj1, Media obj2) {
		if(obj1.getTitle() != obj2.getTitle())
		{
			return Integer.valueOf(obj1.getTitle()) - Integer.valueOf(obj2.getTitle());
		}
		float difference = obj1.getCost() - obj2.getCost();
		if(difference > 0) return 1;
		else {
			if(difference == 0) return 0;
			return -1;
		}
	}
}
