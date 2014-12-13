package polygonwars;

import java.awt.*;
import java.awt.geom.Point2D;

class Ship extends Polygon
{
    //  Polygon WIDTH and HEIGHT
    private static final int WIDTH = 26, HEIGHT = 50;

    private boolean alive;

    private boolean invincible;
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

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible() {
        this.invincible = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        alive = false;
    }

    public void spawn() {
        alive = true;
    }
}