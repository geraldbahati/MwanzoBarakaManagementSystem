package Presentation.Views;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;

public class DefaultFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DefaultFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension( 580, 352));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(6, 6, 568, 41);
		contentPane.add(titlePanel);
		
		JLabel titleLabel = new JLabel("Mwanzo Baraka Management System");
		titleLabel.setForeground(new Color(52, 61, 78));
		titleLabel.setFont(new Font("Hiragino Sans GB", Font.BOLD, 20));
		titlePanel.add(titleLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 59, 568, 259);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel headingLabel = new JLabel("About us...");
		headingLabel.setForeground(new Color(52, 61, 78));
		headingLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		headingLabel.setBounds(36, 27, 103, 16);
		panel.add(headingLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 50, 500, 12);
		panel.add(separator);
		
		JTextArea descriptionTextArea = new JTextArea();
		descriptionTextArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setText("Mwanzo Baraka organisation is a self-help group intended to improve the economic status of its members through pooling of financial resources. ");
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setOpaque(false);
		descriptionTextArea.setEditable(false);
		descriptionTextArea.setBounds(46, 66, 490, 82);
		panel.add(descriptionTextArea);
		
		JButton registerButton = new JButton("Register Now");
		registerButton.setBackground(new Color(52, 61, 78));
		registerButton.setBounds(46, 201, 117, 29);
		registerButton.addActionListener(e -> {
			new RegisterFrame();
			dispose();
		});
		panel.add(registerButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(UIManager.getColor("CheckBox.select"));
		exitButton.setBounds(419, 201, 117, 29);
		exitButton.addActionListener(e -> dispose());
		panel.add(exitButton);
	}
}
