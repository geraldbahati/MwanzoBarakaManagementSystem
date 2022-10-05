package Presentation.Widgets;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class CreateGroupPanel extends JPanel {
	private JTextField groupNameTextField;

	/**
	 * Create the panel.
	 */
	public CreateGroupPanel() {
		setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(6, 6, 639, 45);
		add(headerPanel);
		
		JLabel headerLabel = new JLabel("Create Group");
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		headerPanel.add(headerLabel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(6, 63, 389, 188);
		add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_formPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		JLabel groupIDLabel = new JLabel("Group ID");
		groupIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_groupIDLabel = new GridBagConstraints();
		gbc_groupIDLabel.anchor = GridBagConstraints.WEST;
		gbc_groupIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_groupIDLabel.gridx = 2;
		gbc_groupIDLabel.gridy = 1;
		formPanel.add(groupIDLabel, gbc_groupIDLabel);
		
		JLabel GroupIDGeneratedLabel = new JLabel("New label");
		GroupIDGeneratedLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_GroupIDGeneratedLabel = new GridBagConstraints();
		gbc_GroupIDGeneratedLabel.anchor = GridBagConstraints.WEST;
		gbc_GroupIDGeneratedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_GroupIDGeneratedLabel.gridx = 5;
		gbc_GroupIDGeneratedLabel.gridy = 1;
		formPanel.add(GroupIDGeneratedLabel, gbc_GroupIDGeneratedLabel);
		
		JLabel groupNameLabel = new JLabel("Group Name");
		groupNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_groupNameLabel = new GridBagConstraints();
		gbc_groupNameLabel.anchor = GridBagConstraints.WEST;
		gbc_groupNameLabel.insets = new Insets(0, 0, 0, 5);
		gbc_groupNameLabel.gridx = 2;
		gbc_groupNameLabel.gridy = 3;
		formPanel.add(groupNameLabel, gbc_groupNameLabel);
		
		groupNameTextField = new JTextField();
		GridBagConstraints gbc_groupNameTextField = new GridBagConstraints();
		gbc_groupNameTextField.gridwidth = 2;
		gbc_groupNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_groupNameTextField.gridx = 5;
		gbc_groupNameTextField.gridy = 3;
		formPanel.add(groupNameTextField, gbc_groupNameTextField);
		groupNameTextField.setColumns(10);
		
		JPanel addMemberPanel = new JPanel();
		addMemberPanel.setBounds(407, 63, 238, 239);
		add(addMemberPanel);
		addMemberPanel.setLayout(null);
		
		JList memberListDetail = new JList();
		memberListDetail.setBounds(6, 63, 226, 159);
		addMemberPanel.add(memberListDetail);
		
		JLabel addMemberLabel = new JLabel("Add Members");
		addMemberLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		addMemberLabel.setBounds(18, 24, 141, 16);
		addMemberPanel.add(addMemberLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(6, 250, 389, 45);
		add(buttonPanel);
		
		JButton submitButton = new JButton("Submit Group");
		buttonPanel.add(submitButton);
		
		JButton clearButton = new JButton("Clear");
		buttonPanel.add(clearButton);

	}
}
