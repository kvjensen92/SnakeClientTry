package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblLoginMenu = new JLabel("Login menu");
		lblLoginMenu.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblLoginMenu.setBounds(179, 6, 93, 16);
		add(lblLoginMenu);
		
		JLabel lblEnterUsername = new JLabel("Enter username:");
		lblEnterUsername.setBounds(25, 65, 115, 16);
		add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setBounds(25, 83, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter password:");
		lblEnterPassword.setBounds(25, 152, 115, 16);
		add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(25, 178, 134, 28);
		add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(35, 218, 93, 29);
		add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/image/Snake.png")));
		lblNewLabel.setBounds(179, 65, 265, 152);
		add(lblNewLabel);

	}
	
	public void addActionListener(ActionListener e){
		btnLogin.addActionListener(e);
	}

	public String getusername() {
		return textField.getText();
	}

	public String getpassword(){ return new String(passwordField.getPassword());}
}
