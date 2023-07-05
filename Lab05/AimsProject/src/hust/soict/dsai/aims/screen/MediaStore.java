package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
    private Media media;
    private Cart cart;
    private Playable disc;
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addCartButton = new JButton("Add to cart");
        container.add(addCartButton);
        addCartButton.addMouseListener(new AddToCartListener());

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            container.add(playButton);
            disc = (Playable) media;
            playButton.addMouseListener(new PlayButtonListener());
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class PlayButtonListener implements MouseListener {
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

        public void mouseClicked(MouseEvent e) {
            try {
                new PlayMedia(disc);
            }
            catch (PlayerException pe) {
                pe.printStackTrace();
            }
        }
    }

    private class AddToCartListener implements MouseListener {
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

        public void mouseClicked(MouseEvent e) {
            try {
                AddToCart addToCart = new AddToCart(media, cart);
                cart = addToCart.getUpdatedCart();
            }
            catch (LimitExceededException lee) {
                lee.printStackTrace();
            }
        }
    }
}
