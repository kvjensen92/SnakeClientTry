package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FindGamePanel extends JPanel {
	private JLabel lblFindGame;
	private JButton btnCancel;

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
		
		JLabel lblChooseOpponent = new JLabel("Choose opponent");
		lblChooseOpponent.setBounds(40, 70, 126, 16);
		add(lblChooseOpponent);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(40, 98, 52, 27);
		add(comboBox);
		
		JButton btnStartGame = new JButton("Start game");
		btnStartGame.setBounds(40, 142, 117, 29);
		add(btnStartGame);
	}
	
	public void addActionListener(ActionListener e){
		btnCancel.addActionListener(e);
		
	}
}
