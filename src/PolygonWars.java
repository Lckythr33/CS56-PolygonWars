import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolygonWars extends JFrame 
{
    private BattleField battleField;
    private String[] level = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9"};
    private JComboBox cbLevel = new JComboBox<>(level);
    private JRadioButton rdoMouseClick;
    private JRadioButton rdoMouseMove;
    private JButton btnStartGame;
    
    public PolygonWars()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));
        
        //  sidePanel is input and output panel that contains: settings panel, missile panel and star panel
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1));
        
        //  1. Start settings panel
        JPanel settings = new JPanel();
        settings.setLayout(new GridLayout(2, 1));
        
        //  1a. Start current settings panel
        JPanel currentSettingsPanel = new JPanel();
        currentSettingsPanel.setLayout(new GridLayout(2, 1));
        
        //  Start user input panel
        JPanel userInputPanel = new JPanel();
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
        JPanel mousePanel = new JPanel();
        mousePanel.setLayout(new GridLayout(2, 1));
        mousePanel.add(rdoMouseClick);
        mousePanel.add(rdoMouseMove);

        ButtonGroup grpMouse = new ButtonGroup();
        grpMouse.add(rdoMouseClick);
        grpMouse.add(rdoMouseMove);
        
        userInputPanel.add(cbLevel);
        userInputPanel.add(mousePanel);
        userInputPanel.add(btnStartGame);
        //  End user input panel

        JTextField speedScoreTextField = new JTextField();
        speedScoreTextField.setEditable(false);
        speedScoreTextField.setBackground(Color.MAGENTA);
        
        currentSettingsPanel.add(userInputPanel);
        
        currentSettingsPanel.add(speedScoreTextField);
        //  End current settings panel
        
        //  1b. User History text area
        JTextField userHistoryTextField = new JTextField();
        userHistoryTextField.setEditable(false);
        userHistoryTextField.setBackground(Color.GRAY);
        
        settings.add(currentSettingsPanel);
        settings.add(userHistoryTextField);
        //  End settings panel
        
        //  2. Missile panel
        JPanel missileInventory = new JPanel();
        missileInventory.setBackground(Color.YELLOW);
        
        //  3. Star panel
        JPanel starInventory = new JPanel();
        starInventory.setBackground(Color.CYAN);
        
        sidePanel.add(settings);
        sidePanel.add(missileInventory);
        sidePanel.add(starInventory);
        
        //  Game panel
/*
        if (rdoMouseClick.isSelected())
            battleField = new BattleField(true);
        else
            battleField = new BattleField(false);
*/

        contentPane.add(sidePanel);
        contentPane.add(new BattleField());
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
                    battleField.setMouseClick(true);
                }
                else if (e.getSource() == rdoMouseMove) 
                {
                    battleField.setMouseClick(false);
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
        win.setResizable(false);
		win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	} 
}


