package Presentation.Widgets;

import Data.Models.Group;
import Data.Models.GroupMember;
import Logic.GroupEvent;
import Presentation.Views.GroupFrame;
import Presentation.Views.RegisterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JoinGroupPanel extends JPanel implements ActionListener {

	private final String pattern = "dd MMMM, yyyy";
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


	private final GroupEvent groupEvent = new GroupEvent();

	private final JComboBox<Object> comboBox;
	private final JLabel groupIdHolder;
	private final JLabel groupNameHolder;
	private final JLabel groupCreatedHolder;
	private final JPanel memberInGroupPanel;

	private ArrayList<GroupMember> groupMembers;
	/**
	 * Create the panel.
	 */
	public JoinGroupPanel() {
		setLayout(null);
		
		JScrollPane detailsScrollPane = new JScrollPane();
		detailsScrollPane.setBounds(347, 6, 347, 370);
		add(detailsScrollPane);
		
		memberInGroupPanel = new JPanel();
		detailsScrollPane.setViewportView(memberInGroupPanel);
		GridBagLayout gbl_memberInGroupPanel = new GridBagLayout();
		gbl_memberInGroupPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_memberInGroupPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_memberInGroupPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_memberInGroupPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		memberInGroupPanel.setLayout(gbl_memberInGroupPanel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		memberInGroupPanel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JLabel memberTitleLabel = new JLabel("Members in The Group");
		memberTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_memberTitleLabel = new GridBagConstraints();
		gbc_memberTitleLabel.gridwidth = 4;
		gbc_memberTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberTitleLabel.gridx = 1;
		gbc_memberTitleLabel.gridy = 1;
		memberInGroupPanel.add(memberTitleLabel, gbc_memberTitleLabel);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 2;
		memberInGroupPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		memberInGroupPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 2;
		memberInGroupPanel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 3;
		gbc_horizontalStrut_4.gridy = 2;
		memberInGroupPanel.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
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
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 4;
		memberInGroupPanel.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JPanel groupDetailsPanel = new JPanel();
		groupDetailsPanel.setBounds(6, 129, 340, 188);
		add(groupDetailsPanel);
		GridBagLayout gbl_groupDetailsPanel = new GridBagLayout();
		gbl_groupDetailsPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_groupDetailsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_groupDetailsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_groupDetailsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		groupDetailsPanel.setLayout(gbl_groupDetailsPanel);
		
		JLabel titleGroupDetailsLabel = new JLabel("Group Details of the Group");
		titleGroupDetailsLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_titleGroupDetailsLabel = new GridBagConstraints();
		gbc_titleGroupDetailsLabel.gridwidth = 3;
		gbc_titleGroupDetailsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleGroupDetailsLabel.gridx = 1;
		gbc_titleGroupDetailsLabel.gridy = 0;
		groupDetailsPanel.add(titleGroupDetailsLabel, gbc_titleGroupDetailsLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		groupDetailsPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		groupDetailsPanel.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 1;
		groupDetailsPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel groupIDDetailLabel = new JLabel("Group ID");
		groupIDDetailLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_groupIDDetailLabel = new GridBagConstraints();
		gbc_groupIDDetailLabel.anchor = GridBagConstraints.WEST;
		gbc_groupIDDetailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_groupIDDetailLabel.gridx = 1;
		gbc_groupIDDetailLabel.gridy = 2;
		groupDetailsPanel.add(groupIDDetailLabel, gbc_groupIDDetailLabel);
		
		groupIdHolder = new JLabel();
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
		
		groupNameHolder = new JLabel();
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
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
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
		
		groupCreatedHolder = new JLabel();
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

		JPanel showGroupPanel = new JPanel();
		showGroupPanel.setBounds(6, 6, 331, 112);
		add(showGroupPanel);
		showGroupPanel.setLayout(null);

		comboBox = new JComboBox<>(Group.getAvailableGroups());
		comboBox.setBounds(54, 44, 225, 27);
		comboBox.addActionListener(this);
		showGroupPanel.add(comboBox);
		
		JButton joinGroupButton = new JButton("Join Group");
		joinGroupButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		joinGroupButton.setBounds(217, 12, 117, 29);
		joinGroupButton.addActionListener(e -> {
			if (comboBox.getSelectedItem() == null) return;
			RegisterFrame.updateGroupStatus((Group) comboBox.getSelectedItem());
			GroupFrame.disposeWindow();
		});
		submitPanel.add(joinGroupButton);
		

		
		JLabel lblNewLabel = new JLabel("Available Groups");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(17, 6, 139, 26);
		showGroupPanel.add(lblNewLabel);

		JButton showDetailsButton = new JButton("Show Details");
		showDetailsButton.setBounds(208, 77, 117, 29);
		showGroupPanel.add(showDetailsButton);


	}

	private void updateGroupInfoLabels(){
		if (comboBox.getSelectedItem() == null) return;

		var groupSelected = (Group)comboBox.getSelectedItem();
		groupIdHolder.setText(groupSelected.getGroupId());
		groupNameHolder.setText(groupSelected.getGroupName());
		groupCreatedHolder.setText(simpleDateFormat.format(groupSelected.getCreated()));

		groupEvent.loadGroupMembers(groupSelected);
		System.out.println(GroupMember.getGroupMembersList());
		groupMembers = GroupMember.getGroupMembersList();
		displayGroupMemberList();
	}

	private void refreshAccess(){
		
	}

	private void displayGroupMemberList() {
		ArrayList<JLabel> memberIdLabels = new ArrayList<>();
		ArrayList<JLabel> memberNameLabels = new ArrayList<>();
		ArrayList<JSeparator> separators = new ArrayList<>();
		ArrayList<GridBagConstraints> gridBagConstraints = new ArrayList<>();
		ArrayList<GridBagConstraints> gridBagConstraints2 = new ArrayList<>();
		ArrayList<GridBagConstraints> gridBagConstraints3 = new ArrayList<>();

		byte idGridXCCoordinate = 1;
		byte nameGridXCCoordinate = 4;

		byte gridYCCoordinate = 5;

		for (GroupMember member : groupMembers){
			memberIdLabels.add(new JLabel(member.getMemberID()));
			gridBagConstraints.add(new GridBagConstraints());
			memberNameLabels.add(new JLabel(member.getMemberName()));
			gridBagConstraints2.add(new GridBagConstraints());
			separators.add(new JSeparator());
			gridBagConstraints3.add(new GridBagConstraints());
		}

		for(int i = 0; i<groupMembers.size();i++) {

			gridBagConstraints.get(i).insets = new Insets(0, 0, 5, 5);
			gridBagConstraints.get(i).anchor = GridBagConstraints.WEST;
			gridBagConstraints.get(i).gridx = idGridXCCoordinate;
			gridBagConstraints.get(i).gridy = gridYCCoordinate;
			memberInGroupPanel.add(memberIdLabels.get(i), gridBagConstraints.get(i));

			gridBagConstraints2.get(i).insets = new Insets(0, 0, 5, 5);
			gridBagConstraints2.get(i).anchor = GridBagConstraints.WEST;
			gridBagConstraints2.get(i).gridx = nameGridXCCoordinate;
			gridBagConstraints2.get(i).gridy = gridYCCoordinate;
			memberInGroupPanel.add(memberNameLabels.get(i), gridBagConstraints2.get(i));

			gridYCCoordinate++;

			gridBagConstraints3.get(i).gridwidth = 4;
			gridBagConstraints3.get(i).fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.get(i).insets = new Insets(0, 0, 5, 5);
			gridBagConstraints3.get(i).gridx = idGridXCCoordinate;
			gridBagConstraints3.get(i).gridy = gridYCCoordinate;
			memberInGroupPanel.add(separators.get(i), gridBagConstraints3.get(i));

			gridYCCoordinate++;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == comboBox){
			updateGroupInfoLabels();
		}
	}
}
