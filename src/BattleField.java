import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

class BattleField extends JPanel implements MouseMotionListener, MouseListener
{
    private static final int WIDTH = 500, HEIGHT = 600;

    private Ship xWing = new Ship();
    private ArrayList<Star> stars = new ArrayList<>();
    private int xNew;
    private int yNew;
    private boolean blnMouseClick = false;

    public void spawnStar() {
        // create a star with a random number of points between 3 and the length of the colors array
        Star newStar = new Star((int)(Math.random()*(Star.colors.length) + 3));

        // set the initial position of the star
        newStar.translate((int)(Math.random() * WIDTH * .80 + WIDTH * .10), 0);

        stars.add(newStar);

    }

    public BattleField()
    {
//        this.blnMouseClick = blnMouseClick;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        spawnStar();
        spawnStar();
        spawnStar();
        spawnStar();
        spawnStar();
//        xWing.translate(225, 330);
    }

    public void setMouseClick(boolean theClick)
    {
//        blnMouseClick = theClick;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        //x = e.getX();
        //y = e.getY();

        //if (xWing.contains(x, y))


        //setLocation(x, y);
        //xWing.translate(e.getX() - x, e.getY() - y);

        //repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
//        if (!blnMouseClick)
//        {
            xNew = e.getX();
            yNew = e.getY();

            // move ship
//            xWing.translate(xNew-xWing.position.x, yNew-xWing.position.y);
//            xWing.translate(xWing.position.x - xNew, xWing.position.y - yNew);
//            xWing.position = new Point(xNew, yNew);
            xWing.moveTo(e.getPoint());
            repaint();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
/*
        if (blnMouseClick)      //  Mouse Click
        {
            xNew = e.getX();
            yNew = e.getY();

            if (xWing.contains(xNew, yNew))
            {
                // fire missile
            }
            else
            {
                // move ship
                xWing.translate(xNew-xWing.position.x, yNew-xWing.position.y);
                repaint();
            }

        }
        else                    //  Using Mouse Move so fire missile
        {
        }
*/

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Star star : stars) {
            g.setColor(star.color);
            g.fillPolygon(star);
        }

        g.setColor(xWing.color);
        g.fillPolygon(xWing);

        System.out.println(xWing.position);
    }

}
