package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;

public class CompactDisc extends Disc implements Playable{

	private String artist;
	private ArrayList <Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
	}

	public int getLength(){
		int length = 0;
		for(Track cur_track: tracks)
			length += cur_track.getLength();
		return length;
	}
	
	public void addTrack(Track new_track) {
		if(tracks.contains(new_track)) return;
		tracks.add(new_track);
	}
	
	public void removeTrack(Track old_track)
	{
		int num_track = tracks.size();
		for(int i = 0; i < num_track; i++)
		{
			if(tracks.get(i).equals(old_track))
			{
				tracks.remove(i);
				return;	
			}
		}
	}

	public void play() throws PlayerException{
		int length = 0;
		for(Track track: tracks)
			length += track.getLength();
		if (length > 0) {
			for (Track track: tracks) {
				String messageDialog = "Playing: " + track.getTitle() + "\nLength: " + track.getLength();
				JOptionPane.showMessageDialog(null, messageDialog);
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}


}
