import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class BattleField extends JPanel implements MouseMotionListener, MouseListener {

    private int width, height;
    private Ship xWing = new Ship();
    private ArrayList<Star> stars = new ArrayList<>();
    private ArrayList<Missile> missiles = new ArrayList<>();
    private boolean blnMouseClick = false;
    private static final int STAR_SPAWN_DELAY = 100;
    private static int starSpawnTimeout = 0;
    private static JLabel statusLbl;

    private static final String DEAD_MESSAGE = "You Died!";
    private static final Color BACKGROUND_COLOR = new Color(0x00, 0x00, 0x88);
    private static final Color BACKGROUND_COLOR_DEAD = new Color(0xcc, 0x44, 0x44);
    private static final int TIME_SLICE = 10;
    private static final int MISSILE_LIMIT = 3;
    private static final int STAR_LIMIT = 8;

    private final Timer timer = new Timer(TIME_SLICE, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            starSpawnTimeout ++;
            if (starSpawnTimeout >= STAR_SPAWN_DELAY && stars.size() <= STAR_LIMIT) {
                spawnStar();
                starSpawnTimeout = 0;
            }

            // move stars
            for (Star star : stars) {
                star.move();
                if(star.getX() < 0 || star.getX() > width)
                    star.reverseDx();

                if(star.getY() < 0 || star.getY()+ Star.OUTER_RADIUS * 4 > height)
                    star.reverseDy();
            }

            // list of missiles and stars to be removed
            ArrayList<Missile> deadMissiles = new ArrayList<>();
            ArrayList<Star> deadStars = new ArrayList<>();
            ArrayList<Star> damagedStars = new ArrayList<>();

            // check for missile-star collisions
            for (Star star : stars) {
                for (Missile missile : missiles) {
                    if (missile.intersects(star.getBounds2D())) {
                        deadMissiles.add(missile);
                        if (star.getPoints() <= 3)
                            deadStars.add(star);
                        else
                            damagedStars.add(star);
                    }
                }
                if (xWing.intersects(star.getBounds2D())) {
                    gameOver();
                }
            }

            // check for escaped missiles
            for (Missile missile : missiles) {
                missile.move();
                if (missile.getY() < 0)
                    deadMissiles.add(missile);
            }

            // damage the stars
            for (Star star : damagedStars) {
                Star newStar = new Star(star.getPoints() - 1, star.getX(), star.getY());
                stars.remove(star);
                stars.add(newStar);
            }

            // remove the dead missiles and stars
            for (Missile missile : deadMissiles)
                missiles.remove(missile);
            for (Star star : deadStars)
                stars.remove(star);

            repaint();
//            System.out.println("Star: " + stars.get(0).getPos());
        }
    });

    private void gameStart() {
        stars.clear();
        missiles.clear();
        xWing.spawn();

        statusLbl.setText("");
        this.setBackground(BACKGROUND_COLOR);
    }

    private void gameOver() {
        xWing.die();
        statusLbl.setText(DEAD_MESSAGE);
        this.setBackground(BACKGROUND_COLOR_DEAD);
    }

    public void spawnStar() {
        // create a star with a random number of points between 3 and the length of the colors array
        Star newStar = new Star(
                (int)(Math.random()*(Star.colors.length) + 3),
        // set the initial position of the star
                (int)(Math.random() * width * .80 + width * .10), 0
        );

        stars.add(newStar);
    }

    public void spawnMissile(Point spawnPoint) {
        Missile newMissile = new Missile(spawnPoint);
        missiles.add(newMissile);
    }

    public BattleField(int width, int height, JLabel statusLbl) {
        this.width = width;
        this.height = height;
        BattleField.statusLbl = statusLbl;
//        this.blnMouseClick = blnMouseClick;
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
/*
        for (int i = 0; i < 12; i++)
            spawnStar();
*/
        gameStart();

        timer.start();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //x = e.getX();
        //y = e.getY();

        //setLocation(x, y);
        //xWing.translate(e.getX() - x, e.getY() - y);

        //repaint();
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO: check https://github.com/ncoop/intro-java/blob/master/9e_18_36/chapter18/DisplayAngles.java
        // for a way to keep the object responsive when the cursor moves out of frame
        int xNew = e.getX();
        int yNew = e.getY();

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
//        System.out.println("missile #: " + missiles.size());
        if (missiles.size() <= MISSILE_LIMIT && xWing.isAlive())
            spawnMissile(e.getPoint());

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Star star : stars) {
            g.setColor(star.getColor());
            g.fillPolygon(star);
            g.setColor(Star.outlineColor);
            g.drawPolygon(star);
        }

        for (Missile missile : missiles) {
            g.setColor(Missile.innerColor);
            g.fillPolygon(missile);
            g.setColor(Missile.outlineColor);
            g.drawPolygon(missile);
        }

        if (xWing.isAlive()) {
            g.setColor(xWing.color);
            g.fillPolygon(xWing);
        }

//        System.out.println("xWing: " + xWing.position);
    }

}
