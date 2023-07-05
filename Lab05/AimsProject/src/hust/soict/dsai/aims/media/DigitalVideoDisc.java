package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}

	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			String messageDialog = "Playing: " + this.getTitle() + "\nLength: " + this.getLength();
			JOptionPane.showMessageDialog(null,messageDialog);
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
}