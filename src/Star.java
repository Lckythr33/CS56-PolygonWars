import java.awt.*;

    public class Star extends Polygon
    {
        // TODO make speed depend on level
        public final double MIN_SPEED = 2, MAX_SPEED = 6;

        // number of sides is twice the number of points
        int points;
        Color color;
        double speed;

        public Point position = new Point(0, 0);
        
        // direction of motion
        public double heading;
        
        public static double innerRadius = 10, outerRadius = 20;
        double angle = 0;

        static Color colors[] = new Color[] {
            Color.RED, // 3 points
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN
        };

        public Star(int points) {
            // create dummy polygon
            super();

            // set the point angle
            angle = Math.random() * 2 * Math.PI;

            // set the geometry
            this.points = points;
            double dTheta = 2*Math.PI / (points*2);
            for (int n = 0; n < points*2; n++) {
                // alternate between inner and outer radius
                double radius = (n%2 == 0) ? innerRadius : outerRadius;
                double theta = angle + n * dTheta;

                // add a point to the polygon
                addPoint((int)(radius * Math.cos(theta)), (int)(radius * Math.sin(theta)));
            }
            
            // set the color
            if (this.points - 3 > colors.length)
                color = Color.BLACK;
            else
                color = colors[this.points - 3];
            
            // set the speed
            speed = Math.random() * (MAX_SPEED - MIN_SPEED) + MIN_SPEED;
            
            // set the initial direction to a random number in the arc from 7/6*pi to 11/6*pi
            heading = Math.random() * 4/6 * Math.PI + (7/6 * Math.PI);
        }
/*
            
            public static void main (String[] args)
            {
                String nString = JOptionPane.showInputDialog("Enter the number of points for the polygon (3-10)");
                int points = Integer.parseInt(nString);
             
                JFrame jf = new JFrame();
                jf.setVisible(true);
                jf.setSize(120,180);
                jf.setLocation(600, 400);
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                Star rpp = new Star(points);
                
                jf.add(rpp);
                rpp.setVisible(true);
                
            }
*/
}

