import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Viewer extends JPanel {
    List<Track> tracks = new ArrayList<>();
    private final int speed = 10;

    public void add(Track track){
        tracks.add(track);
        Collections.sort(tracks);
    }

    public void update(){
        for (Track track:tracks){
            track.shift(10);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Track track:tracks){
            track.draw(g2);
        }
    }
}
