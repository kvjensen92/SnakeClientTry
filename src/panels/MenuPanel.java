package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class MenuPanel extends JPanel {
	
	private JButton btnStartGame;
	private JButton btnFindGame;
	private JButton btnDeleteGame;
	private JButton btnHighscore;
	private JButton btnLogOut;

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		setLayout(null);
		
		JLabel lblUserMenu = new JLabel("User menu");
		lblUserMenu.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblUserMenu.setBounds(188, 6, 94, 16);
		add(lblUserMenu);
		
		btnStartGame = new JButton("Start game");
		btnStartGame.setBounds(19, 56, 117, 29);
		add(btnStartGame);
		
		btnFindGame = new JButton("Find game");
		btnFindGame.setBounds(19, 97, 117, 29);
		add(btnFindGame);
		
		btnDeleteGame = new JButton("Delete game");
		btnDeleteGame.setBounds(19, 138, 117, 29);
		add(btnDeleteGame);
		
		btnHighscore = new JButton("Highscore");
		btnHighscore.setBounds(19, 179, 117, 29);
		add(btnHighscore);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(327, 249, 117, 29);
		add(btnLogOut);

	}
	
	public void addActionListener(ActionListener e){
		btnStartGame.addActionListener(e);
		btnFindGame.addActionListener(e);
		btnDeleteGame.addActionListener(e);
		btnHighscore.addActionListener(e);
		btnLogOut.addActionListener(e);
	}
}
