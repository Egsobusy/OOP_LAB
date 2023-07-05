package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookBtn = new JMenuItem("Add Book");
        JMenuItem addCDBtn = new JMenuItem("Add CD");
        JMenuItem addDVDBtn = new JMenuItem("Add DVD");

        smUpdateStore.add(addBookBtn);
        smUpdateStore.add(addCDBtn);
        smUpdateStore.add(addDVDBtn);

        menu.add(smUpdateStore);
        JMenuItem viewStoreBtn = new JMenuItem("View store");
        JMenuItem viewCartBtn = new JMenuItem("View cart");
        menu.add(viewStoreBtn);
        menu.add(viewCartBtn);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddBookToStoreScreen(store);
            }
        } );

        addCDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddCDToStoreScreen(store);
            }
        } );

        addDVDBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddDVDToStoreScreen(store);
            }
        } );

        viewCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CartScreen(store, cart);
            }
        } );

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton ViewCartBtn = new JButton("View cart");
        ViewCartBtn.setPreferredSize(new Dimension(100, 50));
        ViewCartBtn.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(ViewCartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        ViewCartBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CartScreen(store, cart);
            }
        } );

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 3, 2));

    //for (int i = 1; i<=3; i++) store.addMedia(new DigitalVideoDisc(i, "DVD"+i, "A", (float)10.0, "nmd", 10));
    //for (int i = 4; i<=6; i++) store.addMedia(new CompactDisc(i, "CD"+i, "A", (float)10.0, "nmd", 100, "mmb"));
    //for (int i = 7; i<=9; i++) store.addMedia(new Book(i, "Book"+i, "A", (float)10.0));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i < 9; i++) {
            try {
                MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
                center.add(cell);
            } catch (IndexOutOfBoundsException e) {
                BlankMedia cell = new BlankMedia();
                center.add(cell);
            }
        }

        return center;
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);

    }
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);

    }
}
