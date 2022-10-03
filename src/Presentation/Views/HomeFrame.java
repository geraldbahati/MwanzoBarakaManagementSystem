package Presentation.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Presentation.Widgets.RoundedBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSeparator;
import java.awt.Insets;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel titlePanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		titlePanel.setBounds(11, 11, 938, 35);
		contentPane.add(titlePanel);
		
		JLabel titleLabel = new JLabel("Mwanzo Baraka Management System");
		titleLabel.setFont(new Font("Hiragino Sans", Font.BOLD, 20));
		titlePanel.add(titleLabel);
		
		JPanel navigatorPanel = new JPanel();
		navigatorPanel.setBounds(11, 46, 938, 41);
		navigatorPanel.setBorder(new RoundedBorder(10));
		navigatorPanel.setBorder(UIManager.getBorder("Button.border"));
		navigatorPanel.setBackground(new Color(49, 62, 79));
		navigatorPanel.setForeground(new Color(49, 62, 80));
		contentPane.add(navigatorPanel);
		SpringLayout sl_navigatorPanel = new SpringLayout();
		navigatorPanel.setLayout(sl_navigatorPanel);
		
		JLabel iBankingLabel = new JLabel("iBanking");
		sl_navigatorPanel.putConstraint(SpringLayout.NORTH, iBankingLabel, 9, SpringLayout.NORTH, navigatorPanel);
		iBankingLabel.setForeground(new Color(254, 255, 255));
		sl_navigatorPanel.putConstraint(SpringLayout.WEST, iBankingLabel, 10, SpringLayout.WEST, navigatorPanel);
		iBankingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		navigatorPanel.add(iBankingLabel);
		
		JComboBox comboBox = new JComboBox();
		sl_navigatorPanel.putConstraint(SpringLayout.NORTH, comboBox, 1, SpringLayout.NORTH, iBankingLabel);
		sl_navigatorPanel.putConstraint(SpringLayout.EAST, comboBox, -215, SpringLayout.EAST, navigatorPanel);
		comboBox.setBackground(new Color(254, 255, 255));
		comboBox.setForeground(new Color(0, 0, 0));
		navigatorPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Customer");
		sl_navigatorPanel.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblNewLabel);
		sl_navigatorPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 2, SpringLayout.NORTH, iBankingLabel);
		sl_navigatorPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 55, SpringLayout.EAST, iBankingLabel);
		lblNewLabel.setForeground(new Color(254, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		navigatorPanel.add(lblNewLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(11, 86, 938, 574);
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(24, 35, 180, 47);
		btnNewButton.setForeground(new Color(56, 72, 92));
		btnNewButton.setBackground(new Color(56, 72, 92));
		btnNewButton.setFocusable(false);
		bodyPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(24, 94, 180, 47);
		btnNewButton_1.setBackground(new Color(56, 72, 92));
		btnNewButton_1.setForeground(new Color(56, 72, 92));
		btnNewButton_1.setFocusable(false);
		bodyPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(24, 152, 180, 47);
		btnNewButton_2.setBackground(new Color(56, 72, 92));
		btnNewButton_2.setForeground(new Color(56, 72, 92));
		btnNewButton_2.setFocusable(false);
		bodyPanel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(216, 6, 716, 562);
		bodyPanel.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel memberDetailHeaderLabel = new JLabel("Detail Information of Gerald Bahati");
		memberDetailHeaderLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_memberDetailHeaderLabel = new GridBagConstraints();
		gbc_memberDetailHeaderLabel.gridwidth = 8;
		gbc_memberDetailHeaderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberDetailHeaderLabel.gridx = 1;
		gbc_memberDetailHeaderLabel.gridy = 2;
		panel.add(memberDetailHeaderLabel, gbc_memberDetailHeaderLabel);
		
		JButton editProfileButton = new JButton("Edit Details");
		editProfileButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		editProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_editProfileButton = new GridBagConstraints();
		gbc_editProfileButton.insets = new Insets(0, 0, 5, 5);
		gbc_editProfileButton.gridx = 9;
		gbc_editProfileButton.gridy = 2;
		panel.add(editProfileButton, gbc_editProfileButton);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 8;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 3;
		panel.add(separator_1, gbc_separator_1);
		
		JLabel memberIDLabel = new JLabel("Member ID");
		memberIDLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberIDLabel = new GridBagConstraints();
		gbc_memberIDLabel.anchor = GridBagConstraints.WEST;
		gbc_memberIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberIDLabel.gridx = 1;
		gbc_memberIDLabel.gridy = 4;
		panel.add(memberIDLabel, gbc_memberIDLabel);
		
		JLabel memberIDHolder = new JLabel("MM-001");
		memberIDHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberIDHolder = new GridBagConstraints();
		gbc_memberIDHolder.anchor = GridBagConstraints.WEST;
		gbc_memberIDHolder.gridwidth = 5;
		gbc_memberIDHolder.insets = new Insets(0, 0, 5, 5);
		gbc_memberIDHolder.gridx = 5;
		gbc_memberIDHolder.gridy = 4;
		panel.add(memberIDHolder, gbc_memberIDHolder);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 8;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 5;
		panel.add(separator, gbc_separator);
		
		JLabel memberNameLabel = new JLabel("Member Name");
		memberNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberNameLabel = new GridBagConstraints();
		gbc_memberNameLabel.anchor = GridBagConstraints.WEST;
		gbc_memberNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_memberNameLabel.gridx = 1;
		gbc_memberNameLabel.gridy = 6;
		panel.add(memberNameLabel, gbc_memberNameLabel);
		
		JLabel memberNameHolder = new JLabel("Gerald Bahati");
		memberNameHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_memberNameHolder = new GridBagConstraints();
		gbc_memberNameHolder.anchor = GridBagConstraints.WEST;
		gbc_memberNameHolder.gridwidth = 5;
		gbc_memberNameHolder.insets = new Insets(0, 0, 5, 5);
		gbc_memberNameHolder.gridx = 5;
		gbc_memberNameHolder.gridy = 6;
		panel.add(memberNameHolder, gbc_memberNameHolder);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 8;
		gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 7;
		panel.add(separator_2, gbc_separator_2);
		
		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_genderLabel = new GridBagConstraints();
		gbc_genderLabel.anchor = GridBagConstraints.WEST;
		gbc_genderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_genderLabel.gridx = 1;
		gbc_genderLabel.gridy = 8;
		panel.add(genderLabel, gbc_genderLabel);
		
		JLabel genderHolder = new JLabel("Male");
		genderHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_genderHolder = new GridBagConstraints();
		gbc_genderHolder.anchor = GridBagConstraints.WEST;
		gbc_genderHolder.gridwidth = 5;
		gbc_genderHolder.insets = new Insets(0, 0, 5, 5);
		gbc_genderHolder.gridx = 5;
		gbc_genderHolder.gridy = 8;
		panel.add(genderHolder, gbc_genderHolder);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.gridwidth = 8;
		gbc_separator_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_3.insets = new Insets(0, 0, 5, 5);
		gbc_separator_3.gridx = 1;
		gbc_separator_3.gridy = 9;
		panel.add(separator_3, gbc_separator_3);
		
		JLabel DOBTitleLabel = new JLabel("Date of Birth");
		DOBTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_DOBTitleLabel = new GridBagConstraints();
		gbc_DOBTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_DOBTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DOBTitleLabel.gridx = 1;
		gbc_DOBTitleLabel.gridy = 10;
		panel.add(DOBTitleLabel, gbc_DOBTitleLabel);
		
		JLabel DOBHolder = new JLabel("13 Thur 2021");
		DOBHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_DOBHolder = new GridBagConstraints();
		gbc_DOBHolder.anchor = GridBagConstraints.WEST;
		gbc_DOBHolder.gridwidth = 5;
		gbc_DOBHolder.insets = new Insets(0, 0, 5, 5);
		gbc_DOBHolder.gridx = 5;
		gbc_DOBHolder.gridy = 10;
		panel.add(DOBHolder, gbc_DOBHolder);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.gridwidth = 8;
		gbc_separator_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_4.insets = new Insets(0, 0, 5, 5);
		gbc_separator_4.gridx = 1;
		gbc_separator_4.gridy = 11;
		panel.add(separator_4, gbc_separator_4);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_ageLabel = new GridBagConstraints();
		gbc_ageLabel.anchor = GridBagConstraints.WEST;
		gbc_ageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ageLabel.gridx = 1;
		gbc_ageLabel.gridy = 12;
		panel.add(ageLabel, gbc_ageLabel);
		
		JLabel ageHolder = new JLabel("23");
		ageHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_ageHolder = new GridBagConstraints();
		gbc_ageHolder.anchor = GridBagConstraints.WEST;
		gbc_ageHolder.gridwidth = 5;
		gbc_ageHolder.insets = new Insets(0, 0, 5, 5);
		gbc_ageHolder.gridx = 5;
		gbc_ageHolder.gridy = 12;
		panel.add(ageHolder, gbc_ageHolder);
		
		JSeparator separator_5 = new JSeparator();
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.gridwidth = 8;
		gbc_separator_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_5.insets = new Insets(0, 0, 5, 5);
		gbc_separator_5.gridx = 1;
		gbc_separator_5.gridy = 13;
		panel.add(separator_5, gbc_separator_5);
		
		JLabel dateOfJoinLabel = new JLabel("Date of Join");
		dateOfJoinLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_dateOfJoinLabel = new GridBagConstraints();
		gbc_dateOfJoinLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_dateOfJoinLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateOfJoinLabel.gridx = 1;
		gbc_dateOfJoinLabel.gridy = 14;
		panel.add(dateOfJoinLabel, gbc_dateOfJoinLabel);
		
		JLabel dateOfJoinHolder = new JLabel("23 Mar 2922");
		dateOfJoinHolder.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_dateOfJoinHolder = new GridBagConstraints();
		gbc_dateOfJoinHolder.anchor = GridBagConstraints.WEST;
		gbc_dateOfJoinHolder.gridwidth = 5;
		gbc_dateOfJoinHolder.insets = new Insets(0, 0, 5, 5);
		gbc_dateOfJoinHolder.gridx = 5;
		gbc_dateOfJoinHolder.gridy = 14;
		panel.add(dateOfJoinHolder, gbc_dateOfJoinHolder);
		
		JLabel sharesContributionTitleLabel = new JLabel("Shares Contribution by the Member");
		sharesContributionTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_sharesContributionTitleLabel = new GridBagConstraints();
		gbc_sharesContributionTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sharesContributionTitleLabel.gridwidth = 9;
		gbc_sharesContributionTitleLabel.gridx = 1;
		gbc_sharesContributionTitleLabel.gridy = 16;
		panel.add(sharesContributionTitleLabel, gbc_sharesContributionTitleLabel);
		
		JLabel latestDateOfContTitleLabel = new JLabel("Last Transaction Date");
		latestDateOfContTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_latestDateOfContTitleLabel = new GridBagConstraints();
		gbc_latestDateOfContTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_latestDateOfContTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_latestDateOfContTitleLabel.gridx = 1;
		gbc_latestDateOfContTitleLabel.gridy = 18;
		panel.add(latestDateOfContTitleLabel, gbc_latestDateOfContTitleLabel);
		
		JLabel counterTitleLabel = new JLabel("Counter");
		counterTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_counterTitleLabel = new GridBagConstraints();
		gbc_counterTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_counterTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_counterTitleLabel.gridx = 3;
		gbc_counterTitleLabel.gridy = 18;
		panel.add(counterTitleLabel, gbc_counterTitleLabel);
		
		JLabel amountTitleLabel = new JLabel("Monthly Contributed");
		amountTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_amountTitleLabel = new GridBagConstraints();
		gbc_amountTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_amountTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountTitleLabel.gridx = 5;
		gbc_amountTitleLabel.gridy = 18;
		panel.add(amountTitleLabel, gbc_amountTitleLabel);
		
		JLabel totalSharesLabel = new JLabel("Total Shares");
		totalSharesLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_totalSharesLabel = new GridBagConstraints();
		gbc_totalSharesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalSharesLabel.gridx = 7;
		gbc_totalSharesLabel.gridy = 18;
		panel.add(totalSharesLabel, gbc_totalSharesLabel);
		
		JSeparator separator_6 = new JSeparator();
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.gridwidth = 8;
		gbc_separator_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_6.insets = new Insets(0, 0, 5, 5);
		gbc_separator_6.gridx = 1;
		gbc_separator_6.gridy = 19;
		panel.add(separator_6, gbc_separator_6);
		
		JButton moreDetailsButton = new JButton("View Details");
		GridBagConstraints gbc_moreDetailsButton = new GridBagConstraints();
		gbc_moreDetailsButton.insets = new Insets(0, 0, 0, 5);
		gbc_moreDetailsButton.gridx = 9;
		gbc_moreDetailsButton.gridy = 20;
		panel.add(moreDetailsButton, gbc_moreDetailsButton);
	}
}
