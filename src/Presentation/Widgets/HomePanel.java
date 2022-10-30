package Presentation.Widgets;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;

import Data.Models.Member;

import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.Box;

public class HomePanel extends JPanel {
	private Member currentMember = Member.getActiveUser();
	private final String pattern = "dd MMMM, yyyy";
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setLayout(null);
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(0, 0, 701, 543);
		add(detailsPanel);
		GridBagLayout gbl_detailsPanel = new GridBagLayout();
		gbl_detailsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_detailsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_detailsPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_detailsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		detailsPanel.setLayout(gbl_detailsPanel);
		
		JLabel memberDetailHeaderLabel = new JLabel("Detail Information of Gerald Bahati");
		memberDetailHeaderLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_memberDetailHeaderLabel = new GridBagConstraints();
		gbc_memberDetailHeaderLabel.gridwidth = 8;
		gbc_memberDetailHeaderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberDetailHeaderLabel.gridx = 1;
		gbc_memberDetailHeaderLabel.gridy = 2;
		detailsPanel.add(memberDetailHeaderLabel, gbc_memberDetailHeaderLabel);
		
		JButton editProfileButton = new JButton("Edit Details");
		editProfileButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GridBagConstraints gbc_editProfileButton = new GridBagConstraints();
		gbc_editProfileButton.insets = new Insets(0, 0, 5, 0);
		gbc_editProfileButton.gridx = 9;
		gbc_editProfileButton.gridy = 2;
		detailsPanel.add(editProfileButton, gbc_editProfileButton);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 8;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 3;
		detailsPanel.add(separator_1, gbc_separator_1);
		
		JLabel memberIDLabel = new JLabel("Member ID");
		memberIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberIDLabel = new GridBagConstraints();
		gbc_memberIDLabel.anchor = GridBagConstraints.WEST;
		gbc_memberIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberIDLabel.gridx = 1;
		gbc_memberIDLabel.gridy = 4;
		detailsPanel.add(memberIDLabel, gbc_memberIDLabel);
		
		JLabel memberIDHolder = new JLabel(currentMember.getMemberID());
		memberIDHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberIDHolder = new GridBagConstraints();
		gbc_memberIDHolder.anchor = GridBagConstraints.WEST;
		gbc_memberIDHolder.gridwidth = 5;
		gbc_memberIDHolder.insets = new Insets(0, 0, 5, 0);
		gbc_memberIDHolder.gridx = 5;
		gbc_memberIDHolder.gridy = 4;
		detailsPanel.add(memberIDHolder, gbc_memberIDHolder);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 8;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 5;
		detailsPanel.add(separator, gbc_separator);
		
		JLabel memberNameLabel = new JLabel("Member Name");
		memberNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberNameLabel = new GridBagConstraints();
		gbc_memberNameLabel.anchor = GridBagConstraints.WEST;
		gbc_memberNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberNameLabel.gridx = 1;
		gbc_memberNameLabel.gridy = 6;
		detailsPanel.add(memberNameLabel, gbc_memberNameLabel);
		
		JLabel memberNameHolder = new JLabel(currentMember.getFirstName()+" "+currentMember.getLastName());
		memberNameHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberNameHolder = new GridBagConstraints();
		gbc_memberNameHolder.anchor = GridBagConstraints.WEST;
		gbc_memberNameHolder.gridwidth = 5;
		gbc_memberNameHolder.insets = new Insets(0, 0, 5, 0);
		gbc_memberNameHolder.gridx = 5;
		gbc_memberNameHolder.gridy = 6;
		detailsPanel.add(memberNameHolder, gbc_memberNameHolder);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_2.gridwidth = 8;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 7;
		detailsPanel.add(separator_2, gbc_separator_2);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_genderLabel = new GridBagConstraints();
		gbc_genderLabel.anchor = GridBagConstraints.WEST;
		gbc_genderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genderLabel.gridx = 1;
		gbc_genderLabel.gridy = 8;
		detailsPanel.add(genderLabel, gbc_genderLabel);
		
		JLabel genderHolder = new JLabel(currentMember.getGender());
		genderHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_genderHolder = new GridBagConstraints();
		gbc_genderHolder.anchor = GridBagConstraints.WEST;
		gbc_genderHolder.gridwidth = 5;
		gbc_genderHolder.insets = new Insets(0, 0, 5, 0);
		gbc_genderHolder.gridx = 5;
		gbc_genderHolder.gridy = 8;
		detailsPanel.add(genderHolder, gbc_genderHolder);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_3.gridwidth = 8;
		gbc_separator_3.insets = new Insets(0, 0, 5, 5);
		gbc_separator_3.gridx = 1;
		gbc_separator_3.gridy = 9;
		detailsPanel.add(separator_3, gbc_separator_3);
		
		JLabel DOBTitleLabel = new JLabel("Date of Birth");
		DOBTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_DOBTitleLabel = new GridBagConstraints();
		gbc_DOBTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_DOBTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DOBTitleLabel.gridx = 1;
		gbc_DOBTitleLabel.gridy = 10;
		detailsPanel.add(DOBTitleLabel, gbc_DOBTitleLabel);
		
		JLabel DOBHolder = new JLabel(simpleDateFormat.format(currentMember.getDateOfBirth()));
		DOBHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_DOBHolder = new GridBagConstraints();
		gbc_DOBHolder.anchor = GridBagConstraints.WEST;
		gbc_DOBHolder.gridwidth = 5;
		gbc_DOBHolder.insets = new Insets(0, 0, 5, 0);
		gbc_DOBHolder.gridx = 5;
		gbc_DOBHolder.gridy = 10;
		detailsPanel.add(DOBHolder, gbc_DOBHolder);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_4.gridwidth = 8;
		gbc_separator_4.insets = new Insets(0, 0, 5, 5);
		gbc_separator_4.gridx = 1;
		gbc_separator_4.gridy = 11;
		detailsPanel.add(separator_4, gbc_separator_4);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_ageLabel = new GridBagConstraints();
		gbc_ageLabel.anchor = GridBagConstraints.WEST;
		gbc_ageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ageLabel.gridx = 1;
		gbc_ageLabel.gridy = 12;
		detailsPanel.add(ageLabel, gbc_ageLabel);
		
		JLabel ageHolder = new JLabel(String.valueOf(currentMember.getAge()));
		ageHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_ageHolder = new GridBagConstraints();
		gbc_ageHolder.anchor = GridBagConstraints.WEST;
		gbc_ageHolder.gridwidth = 5;
		gbc_ageHolder.insets = new Insets(0, 0, 5, 0);
		gbc_ageHolder.gridx = 5;
		gbc_ageHolder.gridy = 12;
		detailsPanel.add(ageHolder, gbc_ageHolder);
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_5.gridwidth = 8;
		gbc_separator_5.insets = new Insets(0, 0, 5, 5);
		gbc_separator_5.gridx = 1;
		gbc_separator_5.gridy = 13;
		detailsPanel.add(separator_5, gbc_separator_5);
		
		JLabel dateOfJoinLabel = new JLabel("Date of Join");
		dateOfJoinLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_dateOfJoinLabel = new GridBagConstraints();
		gbc_dateOfJoinLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_dateOfJoinLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateOfJoinLabel.gridx = 1;
		gbc_dateOfJoinLabel.gridy = 14;
		detailsPanel.add(dateOfJoinLabel, gbc_dateOfJoinLabel);
		
		JLabel dateOfJoinHolder = new JLabel(simpleDateFormat.format(currentMember.getCreated()));
		dateOfJoinHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_dateOfJoinHolder = new GridBagConstraints();
		gbc_dateOfJoinHolder.anchor = GridBagConstraints.WEST;
		gbc_dateOfJoinHolder.gridwidth = 5;
		gbc_dateOfJoinHolder.insets = new Insets(0, 0, 5, 0);
		gbc_dateOfJoinHolder.gridx = 5;
		gbc_dateOfJoinHolder.gridy = 14;
		detailsPanel.add(dateOfJoinHolder, gbc_dateOfJoinHolder);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 15;
		detailsPanel.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 15;
		detailsPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 15;
		detailsPanel.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 4;
		gbc_horizontalStrut_1.gridy = 15;
		detailsPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel sharesContributionTitleLabel = new JLabel("Shares Contribution by the Member");
		sharesContributionTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_sharesContributionTitleLabel = new GridBagConstraints();
		gbc_sharesContributionTitleLabel.gridwidth = 9;
		gbc_sharesContributionTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_sharesContributionTitleLabel.gridx = 1;
		gbc_sharesContributionTitleLabel.gridy = 16;
		detailsPanel.add(sharesContributionTitleLabel, gbc_sharesContributionTitleLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 3;
		gbc_verticalStrut_1.gridy = 17;
		detailsPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 6;
		gbc_horizontalStrut_2.gridy = 17;
		detailsPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 8;
		gbc_horizontalStrut_3.gridy = 17;
		detailsPanel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		JLabel latestDateOfContTitleLabel = new JLabel("Last Transaction Date");
		latestDateOfContTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_latestDateOfContTitleLabel = new GridBagConstraints();
		gbc_latestDateOfContTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_latestDateOfContTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_latestDateOfContTitleLabel.gridx = 1;
		gbc_latestDateOfContTitleLabel.gridy = 18;
		detailsPanel.add(latestDateOfContTitleLabel, gbc_latestDateOfContTitleLabel);
		
		JLabel counterTitleLabel = new JLabel("Counter");
		counterTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_counterTitleLabel = new GridBagConstraints();
		gbc_counterTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_counterTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_counterTitleLabel.gridx = 3;
		gbc_counterTitleLabel.gridy = 18;
		detailsPanel.add(counterTitleLabel, gbc_counterTitleLabel);
		
		JLabel amountTitleLabel = new JLabel("Monthly Contribution");
		amountTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_amountTitleLabel = new GridBagConstraints();
		gbc_amountTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_amountTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountTitleLabel.gridx = 5;
		gbc_amountTitleLabel.gridy = 18;
		detailsPanel.add(amountTitleLabel, gbc_amountTitleLabel);
		
		JLabel totalSharesLabel = new JLabel("Total Shares");
		totalSharesLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_totalSharesLabel = new GridBagConstraints();
		gbc_totalSharesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalSharesLabel.gridx = 7;
		gbc_totalSharesLabel.gridy = 18;
		detailsPanel.add(totalSharesLabel, gbc_totalSharesLabel);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_6.gridwidth = 8;
		gbc_separator_6.insets = new Insets(0, 0, 5, 5);
		gbc_separator_6.gridx = 1;
		gbc_separator_6.gridy = 19;
		detailsPanel.add(separator_6, gbc_separator_6);
		
		JButton moreDetailsButton = new JButton("View Details");
		GridBagConstraints gbc_moreDetailsButton = new GridBagConstraints();
		gbc_moreDetailsButton.insets = new Insets(0, 0, 5, 0);
		gbc_moreDetailsButton.gridx = 9;
		gbc_moreDetailsButton.gridy = 20;
		detailsPanel.add(moreDetailsButton, gbc_moreDetailsButton);

	}
}
