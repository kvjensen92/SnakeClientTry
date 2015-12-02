package panels;

import sdk.Game;
import sdk.User;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindGamePanel extends JPanel {
	private JLabel lblFindGame;
	private JButton btnCancel;
	private JLabel lblSetGameDirections;
	private JTextField directionsTextfield;
	private JLabel lblChooseOpponent;
	private JComboBox comboBox;
	private JButton btnStartGame;

	/**
	 * Create the panel.
	 */
	public FindGamePanel() {
		setLayout(null);
		
		lblFindGame = new JLabel("Find game");
		lblFindGame.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFindGame.setBounds(187, 6, 101, 16);
		add(lblFindGame);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(310, 240, 117, 29);
		add(btnCancel);
		
		lblChooseOpponent = new JLabel("1. Choose a game");
		lblChooseOpponent.setBounds(40, 70, 175, 16);
		add(lblChooseOpponent);
		
		comboBox = new JComboBox();
		comboBox.setBounds(40, 85, 150, 27);
		add(comboBox);

		lblSetGameDirections = new JLabel("2. Set directions (W,A,S,D)");
		lblSetGameDirections.setBounds(40, 130, 175, 16);
		add(lblSetGameDirections);

		directionsTextfield = new JTextField();
		directionsTextfield.setBounds(40, 150, 134, 28);
		add(directionsTextfield);
		
		btnStartGame = new JButton("Start game");
		btnStartGame.setBounds(40, 200, 117, 29);
		add(btnStartGame);
	}
	
	public void addActionListener(ActionListener e){
		btnCancel.addActionListener(e);
		btnStartGame.addActionListener(e);
	}

	public void setGamesInCombobox (ArrayList<Game> games){
		comboBox.removeAllItems();
		for (Game g: games) {
			comboBox.addItem(g.getName());

		}
	}

	public String getSelectedGame(){
		return (String) comboBox.getSelectedItem();
	}

	public String getDirectionsTextfield() {
		return directionsTextfield.getText();
	}
}
