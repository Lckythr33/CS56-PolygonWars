import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PolygonWars extends JFrame implements KeyListener, ActionListener {
    private static final int WIDTH = 800, HEIGHT = 600;
    private static final int MAX_LEVEL = 9;
    private BattleField battleField;
    private JComboBox<String> cbLevel = new JComboBox<>();
    private JRadioButton rdoMouseClick;
    private JRadioButton rdoMouseMove;
    private JButton btnStartGame;
    
    public PolygonWars()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        for (int i = 1; i <= MAX_LEVEL; i++)
            cbLevel.addItem("Level " + i);

        cbLevel.setSelectedItem(0);
        cbLevel.addActionListener(this);

        //  hud is input and output panel that contains: settings panel, missile panel and star panel
        JPanel hud = new JPanel();
        hud.setLayout(new GridLayout(1, 4));
        hud.setCursor(Cursor.getDefaultCursor());
        //  1. select level before game start; show level after game start
        JLabel levelLbl = new JLabel();
        // TODO: update this text when level changes
        levelLbl.setText("level goes here");
        JPanel levelPnl = new JPanel();
        levelPnl.setBackground(Color.GRAY);
        levelPnl.add(cbLevel);
//        levelPnl.add(levelLbl);
        // TODO: remove combobox and replace with label once the game starts

        //  2. show missile supply
        JLabel missilesLbl = new JLabel();
        // TODO: update this label when missiles change
        // TODO: use a missile icon with text
        missilesLbl.setText("missiles go here");
        JPanel missilesPnl = new JPanel();
        missilesPnl.setBackground(Color.YELLOW);
        missilesPnl.add(missilesLbl);
        
        //  3. show stars remaining
        JLabel starsLbl = new JLabel();
        // TODO: update this label when stars change
        // TODO: use a star icon with text
        starsLbl.setText("stars go here");
        JPanel starsPnl = new JPanel();
        starsPnl.setBackground(Color.CYAN);
        starsPnl.add(starsLbl);

        //  4. show score
        JLabel scoreLbl = new JLabel();
        // TODO: update this label when score changes
        scoreLbl.setText("score goes here");
        JPanel scorePnl = new JPanel();
        scorePnl.setBackground(Color.MAGENTA);
        scorePnl.add(scoreLbl);

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

        battleField = new BattleField(WIDTH, HEIGHT, statusLbl);
        contentPane.add(battleField, BorderLayout.CENTER);

        battleField.setLayout(new BorderLayout());
        battleField.add(statusLbl, BorderLayout.CENTER);

        this.addKeyListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action");
        battleField.requestFocusInWindow();
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


