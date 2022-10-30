package Presentation.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class ContributeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ContributeFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(524, 230);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel amountDisplayPanel = new JPanel();
		amountDisplayPanel.setBounds(5, 5, 512, 49);
		contentPane.add(amountDisplayPanel);
		amountDisplayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel detailLabel = new JLabel("This Month Contribution: ");
		detailLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		amountDisplayPanel.add(detailLabel);
		
		JLabel monthContLabel = new JLabel("Ksh. 1,200");
		monthContLabel.setForeground(SystemColor.textHighlight);
		monthContLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		amountDisplayPanel.add(monthContLabel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(5, 55, 512, 91);
		contentPane.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter amount");
		lblNewLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 16));
		lblNewLabel.setBounds(115, 36, 130, 21);
		formPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(279, 22, 196, 42);
		formPanel.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 147, 512, 49);
		contentPane.add(panel);
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		JButton applyButton = new JButton("Apply");
		panel.add(applyButton);
	}
}
