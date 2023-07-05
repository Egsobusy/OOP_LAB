package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AddDVDToStoreScreen extends AddItemToStore {
    public AddDVDToStoreScreen(Store store) {
        super(store);

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(AddDVDToStoreScreen.class.getResource("addDVD.fxml"));
                    AddDigitalVideoDiscToScreenController controller = new AddDigitalVideoDiscToScreenController(store);
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

    private class AddDigitalVideoDiscToScreenController {

        @FXML private TextField titleDVD;
        @FXML private TextField authorDVD;
        @FXML private TextField categoryDVD;
        @FXML private TextField costDVD;
        @FXML private TextField lengthDVD;
        @FXML private Button btnAddDVD;


        public AddDigitalVideoDiscToScreenController(Store newStore) {
            super();
            store = newStore;
        }

        @FXML
        private void btnAddDVDPressed() {
            String title = titleDVD.getText();
            String author = authorDVD.getText();
            String category = categoryDVD.getText();
            try {
                Float cost = Float.parseFloat(costDVD.getText());
                Integer length = Integer.parseInt(lengthDVD.getText());
                if (cost <= 0.0) throw new IllegalArgumentException();
                if (length <= 0) throw new IllegalArgumentException();
                Integer cur_id = store.getItemsInStore().size() + 1;
                store.addMedia(new DigitalVideoDisc(cur_id, title, category, cost, author , length));

                setVisible(false);
                JOptionPane.showMessageDialog(null,"Add to store successfully!");
                new StoreScreen(store);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, "Invalid input!");;
            }
        }
    }
}