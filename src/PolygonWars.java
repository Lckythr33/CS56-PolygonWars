import java.awt.*;
import java.awt.Window.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class PolygonWars extends JFrame 
{
    private Container c;
    private JPanel p1;
    private BattleField p2;
    private JPanel settings;
    private JPanel missileInventory;
    private JPanel starInventory;
    private JPanel currentSettingsPanel;
    private JTextField userHistoryTextField;
    private JPanel userInputPanel;
    private JPanel mousePanel;
    private JTextField speedScoreTextField;
    private String[] level = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9"};
    private JComboBox cbLevel = new JComboBox<String>(level);
    private ButtonGroup grpMouse = new ButtonGroup();
    private JRadioButton rdoMouseClick;
    private JRadioButton rdoMouseMove;
    private JButton btnStartGame;
    
    public PolygonWars()
    {
        c = getContentPane();
        c.setLayout(new GridLayout(1, 2));
        
        //  p1 is input and output panel that contains: settings panel, missile panel and star panel
        p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        
        //  1. Start settings panel
        settings = new JPanel();
        settings.setLayout(new GridLayout(2, 1));
        
        //  1a. Start current settings panel
        currentSettingsPanel = new JPanel();
        currentSettingsPanel.setLayout(new GridLayout(2, 1));
        
        //  Start user input panel
        userInputPanel = new JPanel();
        userInputPanel.setLayout(new GridLayout(1, 3));
        
        UserInputListener listener = new UserInputListener();      //  for Level combobox and StartGame button
        
        cbLevel.setSelectedItem(level[0]);
        cbLevel.addActionListener(listener);
        
        btnStartGame = new JButton("Start Game");
        btnStartGame.addActionListener(listener);
        
        //  add radio buttons to button group
        rdoMouseClick  = new JRadioButton("Ship: Mouse-Click");
        rdoMouseClick.setForeground(Color.BLUE);
        rdoMouseClick.setBackground(Color.WHITE);
        rdoMouseClick.setSelected(true);
        rdoMouseClick.addActionListener(listener);
        //rdoMouseMove.setMnemonic('C');
        
        rdoMouseMove = new JRadioButton("Ship: Mouse-Move");
        rdoMouseMove.setForeground(Color.BLUE);
        rdoMouseMove.setBackground(Color.WHITE);
        rdoMouseMove.addActionListener(listener);
        //rdoMouseMove.setMnemonic('M');
        
        //  mouse panel
        mousePanel = new JPanel();
        mousePanel.setLayout(new GridLayout(2, 1));
        mousePanel.add(rdoMouseClick);
        mousePanel.add(rdoMouseMove);
        
        grpMouse.add(rdoMouseClick);
        grpMouse.add(rdoMouseMove);
        
        userInputPanel.add(cbLevel);
        userInputPanel.add(mousePanel);
        userInputPanel.add(btnStartGame);
        //  End user input panel
        
        speedScoreTextField = new JTextField();
        speedScoreTextField.setEditable(false);
        speedScoreTextField.setBackground(Color.MAGENTA);
        
        currentSettingsPanel.add(userInputPanel);
        
        currentSettingsPanel.add(speedScoreTextField);
        //  End current settings panel
        
        //  1b. User History text area
        userHistoryTextField = new JTextField();      
        userHistoryTextField.setEditable(false);
        userHistoryTextField.setBackground(Color.GRAY);
        
        settings.add(currentSettingsPanel);
        settings.add(userHistoryTextField);
        //  End settings panel
        
        //  2. Missile panel
        missileInventory = new JPanel();
        missileInventory.setBackground(Color.YELLOW);
        
        //  3. Star panel
        starInventory = new JPanel();
        starInventory.setBackground(Color.CYAN);
        
        p1.add(settings);
        p1.add(missileInventory);
        p1.add(starInventory);
        
        //  Game panel
        if (rdoMouseClick.isSelected())
            p2 = new BattleField(true);
        else
            p2 = new BattleField(false);
        
        c.add(p1);
        c.add(p2);
    }
    
    
    public class UserInputListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try {
                if (e.getSource() == btnStartGame) 
                {
                }
                else if (e.getSource() == cbLevel) 
                {
                }
                else if (e.getSource() == rdoMouseClick) 
                {
                    p2.setMouseClick(true);   
                }
                else if (e.getSource() == rdoMouseMove) 
                {
                    p2.setMouseClick(false);
                }
            
            }    
            catch (Exception ex) {
            }
        } 
    }
    
    public static void main(String [] args) throws Exception {
		PolygonWars win= new PolygonWars();
		win.setSize(900, 660);		
        win.setTitle("Polygon Wars");
		win.setVisible(true);
        win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}


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