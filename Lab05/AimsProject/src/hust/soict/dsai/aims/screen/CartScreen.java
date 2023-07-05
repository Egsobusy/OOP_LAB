package hust.soict.dsai.aims.screen;

import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

import javafx.fxml.FXMLLoader;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;

    public CartScreen(Store store, Cart cart) {
        super();

        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(CartScreen.class.getResource("cart.fxml"));
                    loader.setController(new CartScreenController(cart, store));
                    Parent root = (Parent) loader.load();
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setSize(1024, 768);
    }

}