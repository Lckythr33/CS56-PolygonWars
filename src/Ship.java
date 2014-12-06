import java.awt.*;
import java.awt.geom.Point2D;

class Ship extends Polygon
{
    //  Polygon width and height
    private static final int width = 26, height = 50;

    Point2D position = new Point2D.Double(0, 0);
    Color color = Color.WHITE;

    public Ship()
    {
        addPoint(width / 2, 0);
        addPoint(width, height);
        addPoint(0, height / 2);
        addPoint(width, height / 2);
        addPoint(0, height);
    }

    public void moveTo(Point destination) {
        int dx = destination.x - (int)position.getX();
        int dy = destination.y - (int)position.getY();
        position = destination;
        translate(dx, dy);
    }
}