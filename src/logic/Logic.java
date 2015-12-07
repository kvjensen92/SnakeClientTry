package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import sdk.*;
import ui.Screen;

import javax.swing.*;

public class Logic {
	private Screen screen;
	private User currentUser;
	private API api;
	private ArrayList<User> users;
	private ArrayList<Game> games;
	private ArrayList<Game> deleteGames;
	private ArrayList<Score> showHighscores;

	public Logic(){
		screen = new Screen();
		currentUser = new User();
		api = new API();
	}
	// Kører programmet, når main-klassen køres
	public void run(){
		screen.getDeleteGamePanel().addActionListener(new DeleteGameActionHandler());
		screen.getFindGamePanel().addActionListener(new FindGameActionHandler());
		screen.getHighscorePanel().addActionListener(new HighscoreActionHandler());
		screen.getLogin().addActionListener(new LoginPanelActionHandler());
		screen.getStartGamePanel().addActionListener(new StartGameActionHandler());
		screen.getMenu().addActionListener(new MenuPanelActionHandler());

	}
	// ActionsListeners for DeleteGame-menuen
	private class DeleteGameActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()){
				case "Cancel":
					screen.show("menu");
					break;

				case "Delete game":
					Game deleteGame = new Game();
					deleteGame.setName(screen.getDeleteGamePanel().getSelectedGame());
					for (Game g: deleteGames)
					{
						if (g.getName().equals(screen.getDeleteGamePanel().getSelectedGame()))
						{
							deleteGame = g;
						}
					}
	// Besked om at spillet er slettet
					String message = api.deleteGame(deleteGame.getGameId());
					JOptionPane.showMessageDialog(screen, message);
					if (message.equals("Game was deleted")) {
						screen.getDeleteGamePanel().removeGame();
					}
					break;

			}
		}

	}
	// ActionsListeners for FindGame-menuen
	private class FindGameActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()){
				case "Cancel":
					screen.show("menu");
					break;

				case "Start game":
					Game startGame = null;
	// 1. if tjekker værdien af hvad der er valgt i comboBoxen og sammenligner med de spil som for-loopet kører igennem
	// 2. if gør så hosten ikke kan joine sit eget spil
					for (Game g: games)
					{
						if (g.getName().equals(screen.getFindGamePanel().getSelectedGame()))
						{
							if (g.getHost().getId() != currentUser.getId())
								startGame = g;
						}
					}
					if (startGame != null) {

						Gamer opponent = new Gamer();
						opponent.setId(currentUser.getId());
						opponent.setControls(screen.getFindGamePanel().getDirectionsTextfield());
						startGame.setOpponent(opponent);
						String joinGamemessage = api.joinGame(startGame);
						String startGamemessage = api.startGame(startGame);
						System.out.println(startGamemessage);
						String winnerName = "";

						for (User u : users) {

							try {

								if (u.getId() == Integer.parseInt(startGamemessage)) {
									winnerName = u.getUsername();
								}
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							}
						}

						JOptionPane.showMessageDialog(screen, joinGamemessage + ". The winner was:" + winnerName);
					} else {
						JOptionPane.showMessageDialog(screen, "You can't join a game where you're the host");
					}
					break;
			}

		}

	}
	// ActionListener for Highscore-menuen
	private class HighscoreActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()){
				case "Cancel":
					screen.show("menu");
					break;
			}
		}
	}
	// ActionsListeners for Login-menuen
	private class LoginPanelActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			currentUser.setUsername(screen.getLogin().getusername());
			currentUser.setPassword(screen.getLogin().getpassword());
			String message = api.login(currentUser);
			if (message.equals("Login successful")){
				screen.show("menu");

			}
			else JOptionPane.showMessageDialog(screen, message);
		}


	}
	// ActionsListeners for StartGame-menuen
	private class StartGameActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {


			switch (e.getActionCommand()){

				case "Cancel":
					screen.show("menu");
					break;

				case "Create":
					Game startGame = new Game();
					startGame.setName(screen.getStartGamePanel().getGameName());
					startGame.setMapSize(25);
					Gamer opponent = new Gamer();
	// For-loop kører brugerne igennem og viser dem i en comboBox
	// 1. if tjekker værdien af hvad der er valgt i comboBoxen og sammenligner med de brugere som for-loopet kører igennem
					for (User u: users)
					{
						if (u.getUsername().equals(screen.getStartGamePanel().getSelectedUSer()))
						{
							opponent.setId(u.getId());
						}
					}
	// If tjekker om hosten vil udfordre sig selv og giver fejlmeddelelse og ellers er spillet oprettet.
					if (opponent.getId() == currentUser.getId()) {
						JOptionPane.showMessageDialog(screen, "Error: You need to choose a different opponent than yourself");
					} else {
						Gamer host = new Gamer();
						host.setId(currentUser.getId());
						host.setControls(screen.getStartGamePanel().getControlsToSnake());
						startGame.setHost(host);

						startGame.setOpponent(opponent);
						String message = api.createGame(startGame);
						JOptionPane.showMessageDialog(screen, message);
						screen.show("menu");
					}
					break;

			}

		}

	}
	// ActionListener for Menuen
	private class MenuPanelActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "Start game":
					screen.show("start game");
					users = api.getUsers();
					screen.getStartGamePanel().setUserInCombobox(users);
					screen.getStartGamePanel().clearTextFields();
					break;

				case "Find game":
					screen.show("find game");
					games = api.getGames(currentUser.getId());
					screen.getFindGamePanel().setGamesInCombobox(games);
					screen.getFindGamePanel().clearTextFields();
					break;

				case "Delete game":
					screen.show("delete game");
					deleteGames = api.getGamesToDelete(currentUser.getId());
					screen.getDeleteGamePanel().setGamesInCombobox(deleteGames);

					break;

				case "Highscore":
					screen.show("highscore");
					screen.getHighscorePanel().setTableshowHighscore(api.getHighscores());

					break;

				case "Log out":
					screen.show("login");

					break;

			}

		}

	}

}




