import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolygonWars extends JFrame 
{
    private static final int WIDTH = 1200, HEIGHT = 900;
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

        UserInputListener listener = new UserInputListener();      //  for Level combobox and StartGame button

        for (int i = 1; i <= MAX_LEVEL; i++)
            cbLevel.addItem("Level " + i);

        cbLevel.setSelectedItem(0);
        cbLevel.addActionListener(listener);

        //  hud is input and output panel that contains: settings panel, missile panel and star panel
        JPanel hud = new JPanel();
        hud.setLayout(new GridLayout(1, 4));
        
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

        contentPane.add(hud, BorderLayout.SOUTH);
        contentPane.add(new BattleField(WIDTH, HEIGHT), BorderLayout.CENTER);
    }
    
    
    public class UserInputListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent e) 
        {
/*            try {
                if (e.getSource() == btnStartGame) 
                {
                }
                else if (e.getSource() == cbLevel) 
                {
                }
                else if (e.getSource() == rdoMouseClick) 
                {
                    battleField.setMouseClick(true);
                }
                else if (e.getSource() == rdoMouseMove) 
                {
                    battleField.setMouseClick(false);
                }
            
            }    
            catch (Exception ex) {
            }
        */}
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


