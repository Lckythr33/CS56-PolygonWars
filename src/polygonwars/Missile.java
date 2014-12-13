package polygonwars;

import java.awt.*;
import java.awt.geom.Point2D;

public class Missile extends Polygon {
    public final double SPEED = 3;
    private static final int HEIGHT = 20, WIDTH = 10;

    static Color innerColor = Color.MAGENTA;
    static Color outlineColor = Color.WHITE;
    private Point2D position = new Point2D.Double(0, 0);

    public void move() {
        int dx = 0, dy = -(int)SPEED;
        super.translate(dx, dy);
        position.setLocation(position.getX() + dx, position.getY() + dy);
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

    public Missile(Point2D initialPosition) {
        // create dummy polygon
        super();

        this.position = initialPosition;

        addPoint((int)position.getX() - WIDTH/2, (int)position.getY());
        addPoint((int)position.getX(), (int)position.getY() - HEIGHT);
        addPoint((int)position.getX() + WIDTH/2, (int)position.getY());
    }
}
