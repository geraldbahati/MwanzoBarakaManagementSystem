package Presentation.Views;

import Presentation.Widgets.CreateGroupPanel;
import Presentation.Widgets.JoinGroupPanel;

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
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroupFrame extends JFrame {

	private JPanel contentPane;
	private String activeMemberID = "";
	
	private int activePanelIndex = 1;

	private final CreateGroupPanel createGroupPanel;
	private final JoinGroupPanel joinGroupPanel;
	/**
	 * Create the frame.
	 */
	public GroupFrame(String activeMemberID) {
		this.activeMemberID = activeMemberID;

		createGroupPanel  = new CreateGroupPanel();

		joinGroupPanel = new JoinGroupPanel();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(6, 6, 722, 41);
		contentPane.add(titlePanel);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel titleHeaderLabel = new JLabel("Mwanzo Baraka Management System");
		titleHeaderLabel.setFont(new Font("Hiragino Sans GB", Font.BOLD, 20));
		titlePanel.add(titleHeaderLabel);
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(new Color(51, 62, 77));
		navigationPanel.setBounds(6, 50, 722, 41);
		contentPane.add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JTabbedPane contentTabbedPanel = new JTabbedPane(JTabbedPane.BOTTOM);
		contentTabbedPanel.setFocusable(false);
		contentTabbedPanel.setBounds(6, 91, 728, 436);
		contentTabbedPanel.add(createGroupPanel);
		contentTabbedPanel.add(joinGroupPanel);
		contentTabbedPanel.setSelectedIndex(activePanelIndex);
		contentPane.add(contentTabbedPanel);
		
		JButton joinExistingGroupButton = new JButton("Join Existing Group");
		joinExistingGroupButton.addActionListener(e -> {
			activePanelIndex = 1;
			contentTabbedPanel.setSelectedIndex(activePanelIndex);
		});
		joinExistingGroupButton.setBounds(78, 6, 146, 29);
		navigationPanel.add(joinExistingGroupButton);
		
		JButton createGroupButton = new JButton("Create Group");
		createGroupButton.addActionListener(e -> {
			activePanelIndex = 0;
			contentTabbedPanel.setSelectedIndex(activePanelIndex);
		});
		createGroupButton.setBounds(500, 6, 117, 29);
		navigationPanel.add(createGroupButton);
	}
}
