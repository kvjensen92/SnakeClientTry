package panels;

import sdk.Game;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class DeleteGamePanel extends JPanel {
	private JLabel lblDeleteGame;
	private JButton btnCancel;
	private JComboBox comboBox;
	private JButton btnDeleteGame;

	/**
	 * Create the panel.
	 */
	public DeleteGamePanel() {
		setLayout(null);

		lblDeleteGame = new JLabel("Delete game");
		lblDeleteGame.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDeleteGame.setBounds(189, 6, 128, 16);
		add(lblDeleteGame);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(310, 249, 117, 29);
		add(btnCancel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(40, 105, 150, 27);
		add(comboBox);
		
		JLabel lblChoseAGame = new JLabel("Chose a game to delete");
		lblChoseAGame.setBounds(40, 77, 168, 16);
		add(lblChoseAGame);
		
		btnDeleteGame = new JButton("Delete game");
		btnDeleteGame.setBounds(35, 144, 117, 29);
		add(btnDeleteGame);
	}
	public void addActionListener(ActionListener e){
		btnCancel.addActionListener(e);
		btnDeleteGame.addActionListener(e);
	}

	public void setGamesInCombobox (ArrayList<Game> games){
		comboBox.removeAllItems();
		for (Game g: games) {
			comboBox.addItem(g.getName());

		}
	}

	public void removeGame (){
		comboBox.removeItemAt(comboBox.getSelectedIndex());
	}

	public String getSelectedGame(){
		return (String) comboBox.getSelectedItem();
	}
}
