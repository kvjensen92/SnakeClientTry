package panels;

import sdk.Score;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HighscorePanel extends JPanel {
	private JButton btnCancel;
	private JLabel lblHighscore;
	private JTable tableshowHighscore;

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


		tableshowHighscore = new JTable();
		JScrollPane scrollPane = new JScrollPane(tableshowHighscore);
		scrollPane.setBounds(80, 25, 300, 200);
		add(scrollPane);

	}

	public void addActionListener(ActionListener e){
		btnCancel.addActionListener(e);

	}
	public void setTableshowHighscore(ArrayList<Score> scores){
		HighscoreTableModel highscoreTableModel = new HighscoreTableModel(scores);
		tableshowHighscore.setModel(highscoreTableModel);
	}

// Opsætning af JTable til visning af highscores
	private class HighscoreTableModel extends AbstractTableModel
	{
		private static final long serialVersionUID = 1L;
		public static final int USERNAME = 0;
		public static final int SCORE = 1;
		public static final int GAME_ID = 2;

		private ArrayList<Score> highscores;
		private String[] columns = {"Username", "Score", "Game ID"};
		private int numberOfRows;

		public HighscoreTableModel(ArrayList<Score> highscores)
		{
			this.highscores = highscores;
			fireTableStructureChanged();
		}

		@Override
		public int getColumnCount() {
			return columns.length;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return super.getColumnClass(columnIndex);
		}

		@Override
		public int getRowCount() {
			numberOfRows = highscores.size();
			return numberOfRows;
		}

		public String getColumnName(int columnIndex) {

			return columns[columnIndex];

		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {

				case USERNAME:
					return highscores.get(rowIndex).getGame().getWinner().getUsername();
				case SCORE:
					return highscores.get(rowIndex).getScore();
				case GAME_ID:
					return highscores.get(rowIndex).getGame().getGameId();

			}

			return null;
		}

	}
}
