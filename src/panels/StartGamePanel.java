package panels;

import sdk.User;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartGamePanel extends JPanel {
	private JLabel lblEnterSnakeDirections;
	private JTextField controlTextfield;
	private JComboBox comboBox;
	private JLabel lblEnterGamename;
	private JTextField gameNameTextField;
	private JLabel lblChooseOpponent;
	private JButton btnCreate;
	private JLabel lblPushFinishbutton;
	private JButton btnCancel;
	private JLabel lblStartGame;

	/**
	 * Create the panel.
	 */
	public StartGamePanel() {
		setLayout(null);
		
		lblEnterSnakeDirections = new JLabel("2. Enter snake directions");
		lblEnterSnakeDirections.setBounds(38, 122, 167, 16);
		add(lblEnterSnakeDirections);
		
		controlTextfield = new JTextField();
		controlTextfield.setBounds(34, 147, 134, 28);
		add(controlTextfield);
		controlTextfield.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(273, 60, 140, 27);
		add(comboBox);
		
		lblEnterGamename = new JLabel("1. Enter game-name");
		lblEnterGamename.setBounds(34, 40, 146, 16);
		add(lblEnterGamename);

		gameNameTextField = new JTextField();
		gameNameTextField.setBounds(31, 58, 134, 28);
		add(gameNameTextField);
		gameNameTextField.setColumns(10);
		
		lblChooseOpponent = new JLabel("3. Choose opponent");
		lblChooseOpponent.setBounds(273, 40, 126, 16);
		add(lblChooseOpponent);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(271, 148, 117, 29);
		add(btnCreate);
		
		lblPushFinishbutton = new JLabel("4. Push start-button");
		lblPushFinishbutton.setBounds(273, 122, 227, 16);
		add(lblPushFinishbutton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(314, 254, 117, 29);
		add(btnCancel);
		
		lblStartGame = new JLabel("Start game");
		lblStartGame.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblStartGame.setBounds(183, 6, 134, 16);
		add(lblStartGame);

	}
	
	public void addActionListener(ActionListener e) {
		btnCreate.addActionListener(e);
		btnCancel.addActionListener(e);
	}

	public void setUserInCombobox (ArrayList<User> users){
		for (User u: users) {
			comboBox.addItem(u.getId()+" "+u.getUsername());
		}
	}

	public String getSelectedUSer(){
		return (String) comboBox.getSelectedItem();
	}

	public String getGameName() {
		return gameNameTextField.getText();
	}

	public String getControlsToSnake(){
		return controlTextfield.getText();
	}
}
