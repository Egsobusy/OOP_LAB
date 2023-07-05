package hust.soict.dsai.aims.screen;
import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;



public class AddToCart extends JDialog {
    private Media media;
    private Cart cart;

    public AddToCart (Media media, Cart cart) throws LimitExceededException {
        super();
        try {
            this.media = media;
            this.cart = cart;
            this.cart.addMedia(this.media);

            Container cp = getContentPane();
            cp.setLayout(new FlowLayout(FlowLayout.CENTER));
            cp.add(new JLabel("Add to cart successfully"));

            setTitle("Added to cart");
            setSize(300, 100);
            setVisible(true);
        }
        catch (LimitExceededException e) {
            JOptionPane.showMessageDialog(null,"Cart limit reached!");
        }

    }

    public Cart getUpdatedCart() {
        return this.cart;
    }
}

