package hust.soict.dsai.aims.screen;
import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;

public class PlayMedia extends JDialog {
    public PlayMedia (Playable disc) throws PlayerException{
        super();
        try {
            disc.play();
        } catch (PlayerException e) {
            throw e;
        }
    }
}