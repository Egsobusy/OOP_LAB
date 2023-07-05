package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;

public class Track implements Playable{

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public void play () throws PlayerException{
		if (this.getLength() > 0) {
			String messageDialog = "Playing: " + this.getTitle() + "\nLength: " + this.getLength();
			JOptionPane.showMessageDialog(null,messageDialog);
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
	
	public boolean equals(Track obj) {
		return (this.title == obj.title && this.length == obj.length);
	}
}
