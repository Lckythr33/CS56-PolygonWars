package polygonwars;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PolygonWars extends JFrame implements KeyListener, ActionListener {
    private static final int WIDTH = 800, HEIGHT = 600;
    private static final int MAX_LEVEL = 9;
    private static final int LEVEL_SCORE_PT_REQ = 1000;
    private static final Color LABEL_TEXT_COLOR = Color.RED;
    private static final Color LABEL_BACKGROUND_COLOR = Color.GRAY;
    private static final Font LABEL_FONT = new Font("Sans Serif", Font.BOLD, 16);

    private static AudioClip bgm;
    private static int currentLevel = 1;
    private static int maxStars = 0;

    private BattleField battleField;
    private static JComboBox cbLevel = new JComboBox<>();
    private static JLabel scoreLbl = new JLabel(), starsLbl = new JLabel(), missilesLbl = new JLabel();
    private static int score = 0;

    public PolygonWars() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        for (int i = 1; i <= MAX_LEVEL; i++)
            cbLevel.addItem("Level " + i);

        cbLevel.setSelectedItem(0);
        cbLevel.addActionListener(this);
        cbLevel.setFont(LABEL_FONT);
        cbLevel.setForeground(LABEL_TEXT_COLOR);

        //  hud is input and output panel that contains: settings panel, missile panel and star panel
        JPanel hud = new JPanel();
        hud.setLayout(new GridLayout(1, 4));
        hud.setCursor(Cursor.getDefaultCursor());
        //  1. select level before game start; show level after game start
        JLabel levelLbl = new JLabel();
        JPanel levelPnl = new JPanel();
        levelPnl.setBackground(LABEL_BACKGROUND_COLOR);
        levelPnl.add(cbLevel);
//        levelPnl.add(levelLbl);
        levelPnl.setBorder(BorderFactory.createLineBorder(Color.black));

        //  2. show missile supply

        // TODO: use a missile icon with text
        missilesLbl.setFont(LABEL_FONT);
        missilesLbl.setForeground(LABEL_TEXT_COLOR);
        updateMissiles(true);
        JPanel missilesPnl = new JPanel();
        missilesPnl.setBackground(LABEL_BACKGROUND_COLOR);
        missilesPnl.add(missilesLbl);
        missilesPnl.setBorder(BorderFactory.createLineBorder(Color.black));

        //  3. show stars remaining
        // TODO: use a star icon with text
        JPanel starsPnl = new JPanel();
        starsPnl.setBackground(LABEL_BACKGROUND_COLOR);
        starsLbl.setFont(LABEL_FONT);
        starsLbl.setForeground(LABEL_TEXT_COLOR);
        starsPnl.add(starsLbl);
        starsPnl.setBorder(BorderFactory.createLineBorder(Color.black));

        //  4. show score
        JPanel scorePnl = new JPanel();
        scorePnl.setBackground(LABEL_BACKGROUND_COLOR);
        scoreLbl.setFont(LABEL_FONT);
        scoreLbl.setForeground(LABEL_TEXT_COLOR);
        scorePnl.add(scoreLbl);
        scorePnl.setBorder(BorderFactory.createLineBorder(Color.black));

        hud.add(levelPnl);
        hud.add(missilesPnl);
        hud.add(starsPnl);
        hud.add(scorePnl);

/*
        if (rdoMouseClick.isSelected())
            battleField = new BattleField(true);
        else
            battleField = new BattleField(false);
*/
        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");

// Set the blank cursor to the JFrame.
        contentPane.setCursor(blankCursor);

        contentPane.add(hud, BorderLayout.SOUTH);

        JLabel statusLbl = new JLabel("", SwingConstants.CENTER);
        statusLbl.setOpaque(false);
        statusLbl.setFont(new Font("Sans Serif", Font.BOLD, 92));
        statusLbl.repaint();

        battleField = new BattleField(this, WIDTH, HEIGHT, statusLbl);
        contentPane.add(battleField, BorderLayout.CENTER);

        battleField.setLayout(new BorderLayout());
        battleField.add(statusLbl, BorderLayout.CENTER);

        updateStars();
        updateScore(0);

        this.addKeyListener(this);
    }

   public void actionPerformed(ActionEvent e) {
       cbLevel = (JComboBox)e.getSource();
       currentLevel = cbLevel.getSelectedIndex() + 1;
       maxStars = currentLevel + 4;
   }

    public static int getMaxStars() {
        return maxStars;
    }

    // TODO: respond to key events to restart after game over
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("key released");
    }

    public void updateScore(int change) {
        score += change;
        scoreLbl.setText(String.format("Score: %05d", score));
        if (score >= currentLevel * LEVEL_SCORE_PT_REQ) {
            currentLevel = score / LEVEL_SCORE_PT_REQ;
//            System.out.println("Level changed to " + currentLevel);
            try {
                cbLevel.setSelectedIndex(currentLevel - 1);
            } catch (IllegalArgumentException e) {
                battleField.gameWin();
            }
        }
    }

    public static void updateStars() {
        starsLbl.setText(String.format("Stars: %d/%d", BattleField.getStar(), currentLevel + 4));
    }

    public static void updateMissiles(boolean state) {
        missilesLbl.setText("Missiles: " + (state ? "Ready" : "Reloading"));
    }

    public static void main(String [] args) throws Exception {
        PolygonWars win = new PolygonWars();

        win.setSize(WIDTH, HEIGHT);
        win.setTitle("Polygon Wars");
        win.setVisible(true);
        win.setLocationRelativeTo(null);
        win.setResizable(false);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}


