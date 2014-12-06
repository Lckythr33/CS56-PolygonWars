import java.awt.*;

class Ship extends Polygon
{
    private static int nPoints = 5;
    private int[] xPoints = new int[nPoints];
    private int[] yPoints = new int[nPoints];
    //  Polygon width and height
    private static int width = 26;
    private static int height = 50;

    public Ship()
    {

        xPoints[0] = (int) width / 2;
        yPoints[0] = 0;
        //addPoint(xPoints[0], yPoints[0]);

        xPoints[1] = width;
        yPoints[1] = height;
        //addPoint(xPoints[1], yPoints[1]);

        xPoints[2] = 0;
        yPoints[2] = (int) height / 2;
        //addPoint(xPoints[2], yPoints[2]);

        xPoints[3] = width;
        yPoints[3] = (int) height / 2;
        //addPoint(xPoints[3], yPoints[3]);

        xPoints[4] = 0;
        yPoints[4] = height;
        //addPoint(xPoints[4], yPoints[4]);  

        super.xpoints = xPoints;
        super.ypoints = yPoints;
        super.npoints = nPoints;

    }

    public int[] getXPoints()
    {
        return xPoints;
    }

    public int[] getYPoints()
    {
        return yPoints;
    }

    public int getNPoints()
    {
        return nPoints;
    }

}