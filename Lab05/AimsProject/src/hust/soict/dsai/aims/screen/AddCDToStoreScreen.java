package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.media.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AddCDToStoreScreen extends AddItemToStore {
    public AddCDToStoreScreen(Store store) {
        super(store);

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(AddCDToStoreScreen.class.getResource("addCD.fxml"));
                    AddCompactDiscToScreenController controller = new AddCompactDiscToScreenController(store);
                    loader.setController(controller);
                    Parent root = (Parent) loader.load();
                    fxPanel.setScene (new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(640, 480);
    }

    private class AddCompactDiscToScreenController {

        @FXML private TextField titleCD;
        @FXML private TextField authorCD;
        @FXML private TextField categoryCD;
        @FXML private TextField costCD;
        @FXML private TextField tracksCD;
        @FXML private Button btnAddCD;
        @FXML private TextField directorCD;


        public AddCompactDiscToScreenController(Store newStore) {
            super();
            store = newStore;
        }

        @FXML
        private void btnAddCDPressed() {
            String title = titleCD.getText();
            String author = authorCD.getText();
            String category = categoryCD.getText();
            String director = directorCD.getText();

            try {

                ArrayList<Track> trackList = new ArrayList<Track>();

                Float cost = Float.parseFloat(costCD.getText());
                String[] tracks = tracksCD.getText().split(", ");
                Integer length = 0;
                for (int i = 0; i < tracks.length; i += 2) {
                    String track_title = tracks[i];
                    Integer track_length = Integer.parseInt(tracks[i+1].replace(" ", ""));
                    if (track_length <= 0) throw new IllegalArgumentException();
                    
                    length += track_length;
                    trackList.add(new Track(track_title, track_length));
                }

                Integer cur_id = store.getItemsInStore().size() + 1;
                CompactDisc cd = new CompactDisc(cur_id, title, category, cost, director, length , author);
                for (Track track: trackList) cd.addTrack(track);
                store.addMedia(cd);

                setVisible(false);
                JOptionPane.showMessageDialog(null,"Add to store successfully!");
                new StoreScreen(store);

            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }
}