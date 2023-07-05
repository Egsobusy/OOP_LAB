package hust.soict.dsai.aims.screen;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hust.soict.dsai.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.awt.*;

public class AddItemToStore extends JFrame {
    protected Store store;
    public AddItemToStore (Store store) {
        super();
        this.store = store;
    }

}
