import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class BattleField extends JPanel implements MouseMotionListener, MouseListener
{
    private int xPos = 225;
    private int yPos = 330;
    private Ship xWing = new Ship();
    private int xNew;
    private int yNew;
    private boolean blnMouseClick = false;

    public BattleField(boolean blnMouseClick)
    {
        this.blnMouseClick = blnMouseClick;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        xWing.translate(225, 330);
    }

    public void setMouseClick(boolean theClick)
    {
        blnMouseClick = theClick;
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
        if (!blnMouseClick)
        {
            xNew = e.getX();
            yNew = e.getY();

            // move ship
            xWing.translate(xNew-xPos, yNew-yPos);
            xPos = xNew;
            yPos = yNew;
            repaint();
        }
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
                xWing.translate(xNew-xPos, yNew-yPos);
                xPos = xNew;
                yPos = yNew;
                repaint();
            }

        }
        else                    //  Using Mouse Move so fire missile 
        {
        }

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
        return new Dimension(450,660);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.fillPolygon(xWing);
    }

}

