import java.awt.*;
import java.awt.geom.Point2D;

public class Star extends Polygon
    {
        // TODO make speed depend on level
        public final double MIN_SPEED = .5, MAX_SPEED = 3;

        // number of sides is twice the number of points
        private int points;
        private Color color;
        private double speed;

        // direction of motion
        private double heading;

        // direction of rotation
        private boolean cw;

        // distance moved per timeslice; function of speed and heading
        private double dx, dy;

        private Point2D position = new Point2D.Double(0, 0);

        public static final double INNER_RADIUS = 10;
        public static final double OUTER_RADIUS = INNER_RADIUS * 2;

        // angle between adjacent vertices; equal to 2*pi / (number of points * 2)
        private double dTheta;
        double angle;

        public static Color outlineColor = Color.WHITE;

        static Color colors[] = new Color[] {
            Color.RED, // 3 points
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.PINK,
            Color.MAGENTA,
            Color.BLUE,
            Color.LIGHT_GRAY,
            Color.DARK_GRAY,
            Color.BLACK
        };

        public void reverseDx() {
            dx = -dx;
        }
        public void reverseDy() {
        dy = -dy;
    }

        public int getPoints() {
            return points;
        }

        public void setHeading(double heading) {
            this.heading = heading;
            dx = speed * Math.cos(heading);
            dy = -speed * Math.sin(heading);
        }

        public double getHeading() {
            return heading;
        }

        public Color getColor() {
            return color;
        }

        public double getX() {
            return position.getX();
        }

        public double getY() {
            return position.getY();
        }

        public void move() {
            super.translate((int)dx, (int)dy);
            spin();
            position.setLocation(position.getX() + dx, position.getY() + dy);
        }

        private void spin() {
            // angular speed is proportional to linear speed
            angle += (cw ? 1 : -1) * 2*Math.PI * speed / 400;
            reset();

            for (int n = 0; n < points*2; n++) {
                // alternate between inner and outer radius
                double radius = (n%2 == 0) ? INNER_RADIUS : OUTER_RADIUS;
                double theta = angle + n * dTheta;

                addPoint(
                        (int)(position.getX() + radius * Math.cos(theta)),
                        (int)(position.getY() + radius * Math.sin(theta)));
            }
        }



        public Star(int points, double x, double y) {
            // create dummy polygon
            super();

            // set the absolute angle
            angle = Math.random() * 2 * Math.PI;
            dTheta = 2*Math.PI / (points*2);

            position.setLocation(x, y);

            cw = Math.random() > .5;

            // set the geometry
            this.points = points;
            for (int n = 0; n < points*2; n++) {
                // alternate between inner and outer radius
                double radius = (n%2 == 0) ? INNER_RADIUS : OUTER_RADIUS;
                double theta = angle + n * dTheta;

                addPoint(
                        (int)(radius * Math.cos(theta)),
                        (int)(radius * Math.sin(theta)));
            }

            spin();

            // set the innerColor
            if (this.points - 3 > colors.length)
                color = Color.BLACK;
            else
                color = colors[this.points - 3];
            
            // set the speed
            speed = Math.random() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED;
            
            // set the initial direction to a random number in the arc from 7/6*pi to 11/6*pi
            setHeading(Math.random() * 4/6 * Math.PI + (7/6 * Math.PI));
        }

}

