package hust.soict.dsai.aims.screen;
import javafx.fxml.FXML;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.media.*;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AddBookToStoreScreen extends AddItemToStore {
    public AddBookToStoreScreen(Store store) {
        super(store);

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Book");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(AddBookToStoreScreen.class.getResource("addBook.fxml"));
                    AddBookToScreenController controller = new AddBookToScreenController(store);
                    loader.setController(controller);
                    Parent root = (Parent) loader.load();
                    fxPanel.setScene (new Scene(root));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        this.setSize(640, 480);
    }

    private class AddBookToScreenController {

        @FXML private TextField titleBook;
        @FXML private TextField authorsBook;
        @FXML private TextField categoryBook;
        @FXML private TextField costBook;
        @FXML private Button btnAddBook;


        public AddBookToScreenController(Store newStore) {
            super();
            store = newStore;
        }

        @FXML
        private void btnAddBookPressed() {
            String title = titleBook.getText();
            String[] authors = authorsBook.getText().split(",");
            String category = categoryBook.getText();
            try {
                Float cost = Float.parseFloat(costBook.getText());
                if (cost >= 0.0) {
                    Integer cur_id = store.getItemsInStore().size() + 1;
                    Book book = new Book(cur_id, title, category, cost);
                    for (String author: authors) book.addAuthor(author);
                    store.addMedia(book);
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"Add to store successfully!");
                    new StoreScreen(store);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null,"Invalid input!");
            }


        }
    }
}