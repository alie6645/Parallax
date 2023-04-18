import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Track implements Comparable{
    private double depth;
    private double length;
    private double pos;

    private Color color = Color.BLACK;
    List<Shape> shapes = new ArrayList<Shape>();
    AffineTransform transform = new AffineTransform();

    public Track(double depth, double length){
        this.depth = depth;
        this.length = length;
        transform.setToTranslation(-length,0);
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }
    public void shift(double x){
        pos += x*(1/depth);
        if (pos>length){
            pos = pos - length;
        }
        transform.setToTranslation(pos-length,0);
    }

    public void draw(Graphics2D g2){
        g2.setColor(color);
        for (Shape shape:shapes){
            g2.draw(transform.createTransformedShape(shape));
        }
    }

    public void setColor(Color color){
        this.color = color;
    }

    public double getDepth(){
        return depth;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Track){
            Track other = (Track) o;
            return Double.compare(depth,other.getDepth());
        }
        return 0;
    }
}
