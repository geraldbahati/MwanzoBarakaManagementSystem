package Presentation.Widgets;

import Data.Models.Group;
import Data.Models.Member;
import Logic.MemberEvent;
import Presentation.Views.GroupRegFee;
import Presentation.Views.RegisterFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class CreateGroupPanel extends JPanel {
	private final MemberEvent memberEvent = new MemberEvent();

	private Group createGroup = null;
	private final JTextField groupNameTextField;
	private final JLabel groupIDGeneratedLabel;

	private ArrayList<Member> groupMembers;
	private JPanel addMemberPanel;

	/**
	 * Create the panel.
	 */
	public CreateGroupPanel() {
		setBackground(new Color(237, 238, 238));
		setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(6, 6, 639, 45);
		add(headerPanel);
		
		JLabel headerLabel = new JLabel("Create Group");
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		headerPanel.add(headerLabel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(6, 63, 355, 188);
		add(formPanel);
		formPanel.setLayout(null);
		
		JLabel groupIDLabel = new JLabel("Group ID");
		groupIDLabel.setBounds(16, 31, 64, 19);
		groupIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		formPanel.add(groupIDLabel);
		
		groupIDGeneratedLabel = new JLabel(Group.generateGroupId());
		groupIDGeneratedLabel.setBounds(130, 31, 69, 19);
		groupIDGeneratedLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		formPanel.add(groupIDGeneratedLabel);
		
		JLabel groupNameLabel = new JLabel("Group Name");
		groupNameLabel.setBounds(16, 88, 90, 19);
		groupNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		formPanel.add(groupNameLabel);
		
		groupNameTextField = new JTextField();
		groupNameTextField.setBounds(130, 81, 209, 35);
		formPanel.add(groupNameTextField);
		groupNameTextField.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(6, 250, 355, 45);
		add(buttonPanel);
		
		JButton submitButton = new JButton("Submit Group");
		submitButton.setFocusable(false);
		submitButton.addActionListener(e -> {
			submitGroupFunctionality();
		});
		buttonPanel.add(submitButton);
		
		JButton addMemberButton = new JButton("Add New Member");
		addMemberButton.setFocusable(false);
		addMemberButton.addActionListener(e ->  {
			if(Objects.equals(groupNameTextField.getText(),"")) return;
			new RegisterFrame(createGroup == null ? getCreateGroup() : createGroup);
		});
		buttonPanel.add(addMemberButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(237, 238, 238));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(373, 63, 272, 232);
		add(scrollPane);
		
		addMemberPanel = new JPanel();
		scrollPane.setViewportView(addMemberPanel);
		GridBagLayout gbl_addMemberPanel = new GridBagLayout();
		gbl_addMemberPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_addMemberPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_addMemberPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_addMemberPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		addMemberPanel.setLayout(gbl_addMemberPanel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		addMemberPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		addMemberPanel.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 0;
		addMemberPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 3;
		gbc_horizontalStrut_2.gridy = 0;
		addMemberPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JLabel titleLabel = new JLabel("Added Members");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.gridwidth = 4;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 1;
		addMemberPanel.add(titleLabel, gbc_titleLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		addMemberPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel memberIDTitleLabel = new JLabel("Member ID");
		memberIDTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_memberIDTitleLabel = new GridBagConstraints();
		gbc_memberIDTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberIDTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_memberIDTitleLabel.gridx = 1;
		gbc_memberIDTitleLabel.gridy = 3;
		addMemberPanel.add(memberIDTitleLabel, gbc_memberIDTitleLabel);
		
		JLabel nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_nameTitleLabel = new GridBagConstraints();
		gbc_nameTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_nameTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nameTitleLabel.gridx = 4;
		gbc_nameTitleLabel.gridy = 3;
		addMemberPanel.add(nameTitleLabel, gbc_nameTitleLabel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 4;
		addMemberPanel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 4;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 6;
		addMemberPanel.add(separator, gbc_separator);
	}

	private void submitGroupFunctionality() {
		getCreateGroup();
		Member createdMemberRecord = Member.getCreatedMemberRecords().get(0);
		createdMemberRecord.setAssociatedGroup(createGroup);
		runGroupRegistrationFee(createGroup);
	}

	private final ArrayList<JLabel> memberIdLabels = new ArrayList<>();
	private final ArrayList<JLabel> memberNameLabels = new ArrayList<>();
	private final ArrayList<JSeparator> separators = new ArrayList<>();
	private final ArrayList<GridBagConstraints> gridBagConstraints = new ArrayList<>();
	private final ArrayList<GridBagConstraints> gridBagConstraints2 = new ArrayList<>();
	private final ArrayList<GridBagConstraints> gridBagConstraints3 = new ArrayList<>();

	private void updateGroupInfoLabels(){
//		if (comboBox.getSelectedItem() == null) return;
		groupMembers = Member.getCreatedMemberRecords();
		displayGroupMemberList();
	}

//	private void refreshLabels

	private void displayGroupMemberList() {


		byte idGridXCCoordinate = 1;
		byte nameGridXCCoordinate = 4;

		byte gridYCCoordinate = 5;

		for (Member member : groupMembers){
			memberIdLabels.add(new JLabel(member.getMemberID()));
			gridBagConstraints.add(new GridBagConstraints());
			memberNameLabels.add(new JLabel(member.getFirstName() + " " + member.getLastName()));
			gridBagConstraints2.add(new GridBagConstraints());
			separators.add(new JSeparator());
			gridBagConstraints3.add(new GridBagConstraints());
		}

		for(int i = 0; i<groupMembers.size();i++) {

			gridBagConstraints.get(i).insets = new Insets(0, 0, 5, 5);
			gridBagConstraints.get(i).anchor = GridBagConstraints.WEST;
			gridBagConstraints.get(i).gridx = idGridXCCoordinate;
			gridBagConstraints.get(i).gridy = gridYCCoordinate;
			addMemberPanel.add(memberIdLabels.get(i), gridBagConstraints.get(i));

			gridBagConstraints2.get(i).insets = new Insets(0, 0, 5, 5);
			gridBagConstraints2.get(i).anchor = GridBagConstraints.WEST;
			gridBagConstraints2.get(i).gridx = nameGridXCCoordinate;
			gridBagConstraints2.get(i).gridy = gridYCCoordinate;
			addMemberPanel.add(memberNameLabels.get(i), gridBagConstraints2.get(i));

			gridYCCoordinate++;

			gridBagConstraints3.get(i).gridwidth = 4;
			gridBagConstraints3.get(i).fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.get(i).insets = new Insets(0, 0, 5, 5);
			gridBagConstraints3.get(i).gridx = idGridXCCoordinate;
			gridBagConstraints3.get(i).gridy = gridYCCoordinate;
			addMemberPanel.add(separators.get(i), gridBagConstraints3.get(i));

			gridYCCoordinate++;
		}

	}

	private void runGroupRegistrationFee(Group group) {
		EventQueue.invokeLater(() -> {
			try {
				GroupRegFee frame = new GroupRegFee(group);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private Group getCreateGroup(){
		createGroup = new Group(groupIDGeneratedLabel.getText(), groupNameTextField.getText());
		return createGroup;
	}
}
