package panels;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

public class HighscorePanel extends JPanel {
	private JButton btnCancel;
	private JLabel lblHighscore;

	/**
	 * Create the panel.
	 */
	public HighscorePanel() {
		setLayout(null);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(310, 245, 117, 29);
		add(btnCancel);

		lblHighscore = new JLabel("Highscore");
		lblHighscore.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHighscore.setBounds(190, 6, 101, 16);
		add(lblHighscore);

	}

	public void addActionListener(ActionListener e){
		btnCancel.addActionListener(e);

	}
}
