import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Viewer viewer = new Viewer();

        Track mountains = new Track(10,1000);
        Track trees = new Track(3,400);

        mountains.addShape(new Rectangle(400,100));
        mountains.addShape(new Rectangle(400,0,1000,200));

        for (int i=0 ; i<4; i++){
            trees.addShape(new Rectangle());
        }

        viewer.add(mountains);
        viewer.add(trees);



        frame.add(viewer);
        frame.setVisible(true);
        Timer timer = new Timer(0, e->viewer.update());
        timer.start();
    }
}
