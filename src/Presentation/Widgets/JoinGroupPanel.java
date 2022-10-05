package Presentation.Widgets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JoinGroupPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public JoinGroupPanel() {
		setLayout(null);
		
		JScrollPane detailsScrollPane = new JScrollPane();
		detailsScrollPane.setBounds(347, 6, 347, 370);
		add(detailsScrollPane);
		
		JPanel memberInGroupPanel = new JPanel();
		detailsScrollPane.setViewportView(memberInGroupPanel);
		GridBagLayout gbl_memberInGroupPanel = new GridBagLayout();
		gbl_memberInGroupPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_memberInGroupPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_memberInGroupPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_memberInGroupPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		memberInGroupPanel.setLayout(gbl_memberInGroupPanel);
		
		JLabel memberTitleLabel = new JLabel("Members in The Group");
		memberTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_memberTitleLabel = new GridBagConstraints();
		gbc_memberTitleLabel.gridwidth = 4;
		gbc_memberTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberTitleLabel.gridx = 1;
		gbc_memberTitleLabel.gridy = 1;
		memberInGroupPanel.add(memberTitleLabel, gbc_memberTitleLabel);
		
		JLabel memberIDLabel = new JLabel("Member ID");
		memberIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberIDLabel = new GridBagConstraints();
		gbc_memberIDLabel.anchor = GridBagConstraints.WEST;
		gbc_memberIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberIDLabel.gridx = 1;
		gbc_memberIDLabel.gridy = 3;
		memberInGroupPanel.add(memberIDLabel, gbc_memberIDLabel);
		
		JLabel fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_fullNameLabel = new GridBagConstraints();
		gbc_fullNameLabel.anchor = GridBagConstraints.WEST;
		gbc_fullNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullNameLabel.gridx = 4;
		gbc_fullNameLabel.gridy = 3;
		memberInGroupPanel.add(fullNameLabel, gbc_fullNameLabel);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 4;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 4;
		memberInGroupPanel.add(separator, gbc_separator);
		
		JPanel groupDetailsPanel = new JPanel();
		groupDetailsPanel.setBounds(6, 129, 340, 188);
		add(groupDetailsPanel);
		GridBagLayout gbl_groupDetailsPanel = new GridBagLayout();
		gbl_groupDetailsPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_groupDetailsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_groupDetailsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_groupDetailsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		groupDetailsPanel.setLayout(gbl_groupDetailsPanel);
		
		JLabel titleGroupDetailsLabel = new JLabel("Group Details of Group 1");
		titleGroupDetailsLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_titleGroupDetailsLabel = new GridBagConstraints();
		gbc_titleGroupDetailsLabel.gridwidth = 3;
		gbc_titleGroupDetailsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleGroupDetailsLabel.gridx = 1;
		gbc_titleGroupDetailsLabel.gridy = 0;
		groupDetailsPanel.add(titleGroupDetailsLabel, gbc_titleGroupDetailsLabel);
		
		JLabel groupIDDetailLabel = new JLabel("Group ID");
		groupIDDetailLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupIDDetailLabel = new GridBagConstraints();
		gbc_groupIDDetailLabel.anchor = GridBagConstraints.WEST;
		gbc_groupIDDetailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_groupIDDetailLabel.gridx = 1;
		gbc_groupIDDetailLabel.gridy = 2;
		groupDetailsPanel.add(groupIDDetailLabel, gbc_groupIDDetailLabel);
		
		JLabel groupIdHolder = new JLabel("G-001");
		groupIdHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupIdHolder = new GridBagConstraints();
		gbc_groupIdHolder.anchor = GridBagConstraints.WEST;
		gbc_groupIdHolder.insets = new Insets(0, 0, 5, 0);
		gbc_groupIdHolder.gridx = 3;
		gbc_groupIdHolder.gridy = 2;
		groupDetailsPanel.add(groupIdHolder, gbc_groupIdHolder);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 3;
		groupDetailsPanel.add(separator_1, gbc_separator_1);
		
		JLabel groupNameLabel = new JLabel("Group Name");
		groupNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupNameLabel = new GridBagConstraints();
		gbc_groupNameLabel.anchor = GridBagConstraints.WEST;
		gbc_groupNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_groupNameLabel.gridx = 1;
		gbc_groupNameLabel.gridy = 4;
		groupDetailsPanel.add(groupNameLabel, gbc_groupNameLabel);
		
		JLabel groupNameHolder = new JLabel("Group 1");
		groupNameHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupNameHolder = new GridBagConstraints();
		gbc_groupNameHolder.anchor = GridBagConstraints.WEST;
		gbc_groupNameHolder.insets = new Insets(0, 0, 5, 0);
		gbc_groupNameHolder.gridx = 3;
		gbc_groupNameHolder.gridy = 4;
		groupDetailsPanel.add(groupNameHolder, gbc_groupNameHolder);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 3;
		gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 5;
		groupDetailsPanel.add(separator_2, gbc_separator_2);
		
		JLabel groupCreatedTLabel = new JLabel("Group Created");
		groupCreatedTLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupCreatedTLabel = new GridBagConstraints();
		gbc_groupCreatedTLabel.anchor = GridBagConstraints.WEST;
		gbc_groupCreatedTLabel.insets = new Insets(0, 0, 0, 5);
		gbc_groupCreatedTLabel.gridx = 1;
		gbc_groupCreatedTLabel.gridy = 6;
		groupDetailsPanel.add(groupCreatedTLabel, gbc_groupCreatedTLabel);
		
		JLabel groupCreatedHolder = new JLabel("12 Nov 2002");
		groupCreatedHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupCreatedHolder = new GridBagConstraints();
		gbc_groupCreatedHolder.anchor = GridBagConstraints.WEST;
		gbc_groupCreatedHolder.gridx = 3;
		gbc_groupCreatedHolder.gridy = 6;
		groupDetailsPanel.add(groupCreatedHolder, gbc_groupCreatedHolder);
		
		JPanel submitPanel = new JPanel();
		submitPanel.setBounds(6, 329, 340, 47);
		add(submitPanel);
		submitPanel.setLayout(null);
		
		JButton joinGroupButton = new JButton("Join Group");
		joinGroupButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		joinGroupButton.setBounds(217, 12, 117, 29);
		submitPanel.add(joinGroupButton);
		
		JPanel showGroupPanel = new JPanel();
		showGroupPanel.setBounds(6, 6, 331, 112);
		add(showGroupPanel);
		showGroupPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Groups");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(17, 6, 139, 26);
		showGroupPanel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(54, 44, 225, 27);
		showGroupPanel.add(comboBox);
		
		JButton showDetailsButton = new JButton("Show Details");
		showDetailsButton.setBounds(208, 77, 117, 29);
		showGroupPanel.add(showDetailsButton);

	}
}
