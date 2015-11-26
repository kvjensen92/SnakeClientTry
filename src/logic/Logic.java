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

	public Logic(){
		screen = new Screen();
		currentUser = new User();
		api = new API();
	}

	public void run(){
		screen.getDeleteGamePanel().addActionListener(new DeleteGameActionHandler());
		screen.getFindGamePanel().addActionListener(new FindGameActionHandler());
		screen.getHighscorePanel().addActionListener(new HighscoreActionHandler());
		screen.getLogin().addActionListener(new LoginPanelActionHandler());
		screen.getStartGamePanel().addActionListener(new StartGameActionHandler());
		screen.getMenu().addActionListener(new MenuPanelActionHandler());

	}

	private class DeleteGameActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()){
				case "Cancel":
					screen.show("menu");
					break;
			}
		}

	}

	private class FindGameActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()){
				case "Cancel":
					screen.show("menu");
					break;
			}

		}

	}

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

	private class LoginPanelActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			currentUser.setUsername(screen.getLogin().getusername());
			currentUser.setPassword(screen.getLogin().getpassword());
			String message = api.login(currentUser);
			if (message.equals("Login successful")){
				screen.show("menu");
				ArrayList<User> users = api.getUsers();
				screen.getStartGamePanel().setUserInCombobox(users);
			}
			else JOptionPane.showMessageDialog(screen, message);
		}


	}

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
					Gamer host = new Gamer();
					host.setId(currentUser.getId());
					host.setControls(screen.getStartGamePanel().getControlsToSnake());
					startGame.setHost(host);
					Gamer opponent = new Gamer();
					opponent.setId(screen.getStartGamePanel().getSelectedUSer().charAt(0));
					startGame.setOpponent(opponent);
					String message = api.createGame(startGame);
					JOptionPane.showMessageDialog(screen, message);
					screen.show("menu");
					break;

			}

		}

	}

	private class MenuPanelActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
				case "Start game":
					screen.show("start game");
					break;

				case "Find game":
					screen.show("find game");

					break;

				case "Delete game":
					screen.show("delete game");

					break;

				case "Highscore":
					screen.show("highscore");

					break;

				case "Log out":
					screen.show("login");

					break;

			}

		}

	}

}




