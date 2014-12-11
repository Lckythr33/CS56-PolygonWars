import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class BattleField extends JPanel implements MouseMotionListener, MouseListener
{


    private int width, height;
    private Ship xWing = new Ship();
    private ArrayList<Star> stars = new ArrayList<>();
    private int xNew;
    private int yNew;
    private boolean blnMouseClick = false;
    private static final int TIME_SLICE = 10;

    private final Timer timer = new Timer(TIME_SLICE, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            for (Star star : stars) {
                star.move();
                if(star.getPos().getX() < 0 || star.getPos().getX() > width)
                    star.reverseDx();

                if(star.getPos().getY() < 0 || star.getPos().getY() > height)
                    star.reverseDy();
            }
            repaint();
//            System.out.println("Star: " + stars.get(0).getPos());
        }
    });

    public void spawnStar() {
        // create a star with a random number of points between 3 and the length of the colors array
        Star newStar = new Star(
                (int)(Math.random()*(Star.colors.length) + 3),
        // set the initial position of the star
                (int)(Math.random() * width * .80 + width * .10), 0
        );

        stars.add(newStar);

    }

    public BattleField(int width, int height)
    {
        this.width = width;
        this.height = height;
//        this.blnMouseClick = blnMouseClick;
        this.setBackground(new Color(0x00, 0x00, 0x88));
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        for (int i = 0; i < 12; i++)
            spawnStar();

     // xWing.translate(225, 330);
        timer.start();
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
        // TODO: check https://github.com/ncoop/intro-java/blob/master/9e_18_36/chapter18/DisplayAngles.java
        // for a way to keep the object responsive when the cursor moves out of frame
        xNew = e.getX();
        yNew = e.getY();

        // move ship
        xWing.moveTo(e.getPoint());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    // TODO: shoot missiles!
        System.out.println("mouseClicked");
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
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /*public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }*/
/*
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
    }
*/

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Star star : stars) {
            g.setColor(star.getColor());
            g.fillPolygon(star);
        }

        g.setColor(xWing.color);
        g.fillPolygon(xWing);

//        System.out.println("xWing: " + xWing.position);
    }

}
