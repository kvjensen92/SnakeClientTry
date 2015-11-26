package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panels.DeleteGamePanel;
import panels.FindGamePanel;
import panels.HighscorePanel;
import panels.LoginPanel;
import panels.MenuPanel;
import panels.StartGamePanel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Screen extends JFrame {

	private JPanel contentPane;
	private JPanel cardLayoutPanel;
	private CardLayout cl;
	private LoginPanel login;
	private MenuPanel menu;
	private StartGamePanel startGamePanel;
	private FindGamePanel findGamePanel;
	private DeleteGamePanel deleteGamePanel;
	private HighscorePanel highscorePanel;


	/**
	 * Create the frame.
	 */
	public Screen() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 675, 450);
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(cardLayoutPanel);
		cl = new CardLayout();
		cardLayoutPanel.setLayout(cl);
		login = new LoginPanel();
		login.setBackground(SystemColor.window);
		menu = new MenuPanel();
		menu.setBackground(SystemColor.window);
		startGamePanel = new StartGamePanel();
		findGamePanel = new FindGamePanel();
		deleteGamePanel = new DeleteGamePanel();
		highscorePanel = new HighscorePanel();

		cardLayoutPanel.add(login, "login");
		cardLayoutPanel.add(menu, "menu");
		cardLayoutPanel.add(startGamePanel, "start game");
		cardLayoutPanel.add(findGamePanel, "find game");
		cardLayoutPanel.add(deleteGamePanel, "delete game");
		cardLayoutPanel.add(highscorePanel, "highscore");

		cl.show(cardLayoutPanel, "login");

		//		login.addActionListener(new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//
		//				cl.show(cardLayoutPanel, "menu");
		//			}
		//		});
		//
		//		startGamePanel.addActionListener(new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				switch (e.getActionCommand()){
		//				case "Cancel":
		//					cl.show(cardLayoutPanel, "menu");
		//					break;
		//				}
		//
		//			}
		//		});
		//
		//		findGamePanel.addActionListener(new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				switch (e.getActionCommand()){
		//				case "Cancel":
		//					cl.show(cardLayoutPanel, "menu");
		//					break;
		//				}
		//			}
		//		});
		//
		//		deleteGamePanel.addActionListener(new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				switch (e.getActionCommand()){
		//				case "Cancel":
		//					cl.show(cardLayoutPanel, "menu");
		//					break;
		//				}
		//			}
		//		});
		//
		//		highscorePanel.addActionListener(new ActionListener() {
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				switch (e.getActionCommand()){
		//				case "Cancel":
		//					cl.show(cardLayoutPanel, "menu");
		//					break;
		//				}
		//			}
		//		});



		//		menu.addActionListener(new ActionListener() {
		//			
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				switch (e.getActionCommand()) {
		//				case "Start game":
		//					cl.show(cardLayoutPanel, "start game");
		//					break;
		//					
		//				case "Find game":
		//					cl.show(cardLayoutPanel,  "find game");
		//					
		//					break;
		//					
		//				case "Delete game":
		//					cl.show(cardLayoutPanel,  "delete game");
		//					
		//					break;
		//					
		//				case "Highscore":
		//					cl.show(cardLayoutPanel, "highscore");
		//					
		//					break;
		//					
		//				case "Log out":
		//					cl.show(cardLayoutPanel, "login");
		//		
		//					break;
		//					
		//				}
		//			}
		//		});
		setVisible(true);
	}

	public void show(String card){
		cl.show(cardLayoutPanel, card);
	}

	public LoginPanel getLogin() {
		return login;
	}


	public MenuPanel getMenu() {
		return menu;
	}


	public StartGamePanel getStartGamePanel() {
		return startGamePanel;
	}


	public FindGamePanel getFindGamePanel() {
		return findGamePanel;
	}


	public DeleteGamePanel getDeleteGamePanel() {
		return deleteGamePanel;
	}


	public HighscorePanel getHighscorePanel() {
		return highscorePanel;
	}


}
