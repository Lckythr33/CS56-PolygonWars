import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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


