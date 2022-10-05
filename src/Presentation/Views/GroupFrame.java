package Presentation.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;

public class GroupFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupFrame frame = new GroupFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GroupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(6, 6, 722, 41);
		contentPane.add(titlePanel);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel titlleHeaderLabel = new JLabel("Mwanzo Baraka Management System");
		titlleHeaderLabel.setFont(new Font("Hiragino Sans GB", Font.BOLD, 20));
		titlePanel.add(titlleHeaderLabel);
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(new Color(51, 62, 77));
		navigationPanel.setBounds(6, 50, 722, 41);
		contentPane.add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JButton createGroupButtton = new JButton("Create Group");
		createGroupButtton.setBounds(500, 6, 117, 29);
		navigationPanel.add(createGroupButtton);
		
		JButton joinExistingGroupButton = new JButton("Join Existing Group");
		joinExistingGroupButton.setBounds(78, 6, 146, 29);
		navigationPanel.add(joinExistingGroupButton);
	}
}
