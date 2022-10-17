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
import javax.swing.border.MatteBorder;
import java.awt.Color;

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
		formPanel.setLayout(null);
		
		JLabel groupIDLabel = new JLabel("Group ID");
		groupIDLabel.setBounds(60, 30, 64, 19);
		groupIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		formPanel.add(groupIDLabel);
		
		JLabel GroupIDGeneratedLabel = new JLabel("New label");
		GroupIDGeneratedLabel.setBounds(215, 30, 69, 19);
		GroupIDGeneratedLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		formPanel.add(GroupIDGeneratedLabel);
		
		JLabel groupNameLabel = new JLabel("Group Name");
		groupNameLabel.setBounds(60, 87, 90, 19);
		groupNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		formPanel.add(groupNameLabel);
		
		groupNameTextField = new JTextField();
		groupNameTextField.setBorder(new MatteBorder(560020, 1, 0, 0, (Color) new Color(255, 255, 255)));
		groupNameTextField.setBounds(215, 84, 174, 26);
		formPanel.add(groupNameTextField);
		groupNameTextField.setColumns(10);
		
		JPanel addMemberPanel = new JPanel();
		addMemberPanel.setBounds(407, 63, 238, 239);
		add(addMemberPanel);
		addMemberPanel.setLayout(null);
		
		JList memberListDetail = new JList();
		memberListDetail.setBounds(6, 63, 226, 176);
		addMemberPanel.add(memberListDetail);
		
		JLabel addMemberLabel = new JLabel("Added Members");
		addMemberLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 18));
		addMemberLabel.setBounds(18, 24, 165, 16);
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
