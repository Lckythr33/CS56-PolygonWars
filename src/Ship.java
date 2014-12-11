import java.awt.*;
import java.awt.geom.Point2D;

class Ship extends Polygon
{
    //  Polygon WIDTH and HEIGHT
    private static final int WIDTH = 26, HEIGHT = 50;

    Point2D position = new Point2D.Double(0, 0);
    Color color = Color.WHITE;

    public Ship()
    {
        addPoint(0, 0);
        addPoint(WIDTH / 2, HEIGHT);
        addPoint(-(WIDTH / 2), HEIGHT / 2);
        addPoint(WIDTH / 2, HEIGHT / 2);
        addPoint(-(WIDTH / 2), HEIGHT);
    }

    public void moveTo(Point destination) {
        int dx = destination.x - (int)position.getX();
        int dy = destination.y - (int)position.getY();
        position = destination;
        translate(dx, dy);
    }
}