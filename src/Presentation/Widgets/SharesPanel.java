package Presentation.Widgets;

import Presentation.Views.ContributeFrame;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SharesPanel extends JPanel {

	ImageIcon incomeIconImage = new ImageIcon(new ImageIcon("/Users/geraldbahati/Desktop/programming/MwanzoBarakaManagementSystem/src/Data/Utilities/income.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	ImageIcon expenseIconImage = new ImageIcon(new ImageIcon("/Users/geraldbahati/Desktop/programming/MwanzoBarakaManagementSystem/src/Data/Utilities/expense.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	
	ImageIcon loanIconImage = new ImageIcon(new ImageIcon("/Users/geraldbahati/Desktop/programming/MwanzoBarakaManagementSystem/src/Data/Utilities/loan.png")
			.getImage()
			.getScaledInstance(25, 25, Image.SCALE_DEFAULT));
	/**
	 * Create the panel.
	 */
	public SharesPanel() {
		setLayout(null);

		JPanel balanceDetailsPanel = new JPanel();
		AbstractBorder detailPanelBorder = new TextBubbleBorder(Color.WHITE,2,30,0);
		balanceDetailsPanel.setBackground(Color.WHITE);
		balanceDetailsPanel.setBounds(30, 30, 342, 250);
		balanceDetailsPanel.setBorder(detailPanelBorder);
		add(balanceDetailsPanel);
		GridBagLayout gbl_balanceDetailsPanel = new GridBagLayout();
		gbl_balanceDetailsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_balanceDetailsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_balanceDetailsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_balanceDetailsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		balanceDetailsPanel.setLayout(gbl_balanceDetailsPanel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		balanceDetailsPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		balanceDetailsPanel.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 0;
		balanceDetailsPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel balanceTitleLabel = new JLabel("Balance");
		balanceTitleLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 16));
		GridBagConstraints gbc_balanceTitleLabel = new GridBagConstraints();
		gbc_balanceTitleLabel.gridwidth = 3;
		gbc_balanceTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_balanceTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_balanceTitleLabel.gridx = 0;
		gbc_balanceTitleLabel.gridy = 1;
		balanceDetailsPanel.add(balanceTitleLabel, gbc_balanceTitleLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 2;
		balanceDetailsPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel shareBalanceLabel = new JLabel("Ksh. 12,3435.55");
		shareBalanceLabel.setForeground(new Color(53, 84, 212));
		shareBalanceLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 24));
		GridBagConstraints gbc_shareBalanceLabel = new GridBagConstraints();
		gbc_shareBalanceLabel.anchor = GridBagConstraints.WEST;
		gbc_shareBalanceLabel.gridwidth = 6;
		gbc_shareBalanceLabel.insets = new Insets(0, 0, 5, 0);
		gbc_shareBalanceLabel.gridx = 1;
		gbc_shareBalanceLabel.gridy = 3;
		balanceDetailsPanel.add(shareBalanceLabel, gbc_shareBalanceLabel);
		
		JLabel incomeTitleLabel = new JLabel("Income");
		incomeTitleLabel.setForeground(SystemColor.windowBorder);
		incomeTitleLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_incomeTitleLabel = new GridBagConstraints();
		gbc_incomeTitleLabel.gridwidth = 2;
		gbc_incomeTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_incomeTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_incomeTitleLabel.gridx = 1;
		gbc_incomeTitleLabel.gridy = 5;
		balanceDetailsPanel.add(incomeTitleLabel, gbc_incomeTitleLabel);
		
		JLabel expenseTitleLabel = new JLabel("Expense");
		expenseTitleLabel.setForeground(SystemColor.windowBorder);
		expenseTitleLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_expenseTitleLabel = new GridBagConstraints();
		gbc_expenseTitleLabel.gridwidth = 2;
		gbc_expenseTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_expenseTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_expenseTitleLabel.gridx = 5;
		gbc_expenseTitleLabel.gridy = 5;
		balanceDetailsPanel.add(expenseTitleLabel, gbc_expenseTitleLabel);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 3;
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 6;
		balanceDetailsPanel.add(separator, gbc_separator);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 3;
		gbc_verticalStrut_3.gridy = 6;
		balanceDetailsPanel.add(verticalStrut_3, gbc_verticalStrut_3);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 4;
		gbc_separator_1.gridy = 6;
		balanceDetailsPanel.add(separator_1, gbc_separator_1);
		
		JLabel incomeIcon = new JLabel();
		incomeIcon.setIcon(incomeIconImage);
		GridBagConstraints gbc_incomeIcon = new GridBagConstraints();
		gbc_incomeIcon.insets = new Insets(0, 0, 5, 5);
		gbc_incomeIcon.gridx = 0;
		gbc_incomeIcon.gridy = 7;
		balanceDetailsPanel.add(incomeIcon, gbc_incomeIcon);
		
		JLabel incomeDisplayLabel = new JLabel("+ Ksh. 6 320.15");
		GridBagConstraints gbc_incomeDisplayLabel = new GridBagConstraints();
		gbc_incomeDisplayLabel.gridwidth = 2;
		gbc_incomeDisplayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_incomeDisplayLabel.anchor = GridBagConstraints.WEST;
		gbc_incomeDisplayLabel.gridx = 1;
		gbc_incomeDisplayLabel.gridy = 7;
		balanceDetailsPanel.add(incomeDisplayLabel, gbc_incomeDisplayLabel);
		
		JLabel expenseIcon = new JLabel();
		expenseIcon.setIcon(expenseIconImage);
		GridBagConstraints gbc_expenseIcon = new GridBagConstraints();
		gbc_expenseIcon.insets = new Insets(0, 0, 5, 5);
		gbc_expenseIcon.gridx = 4;
		gbc_expenseIcon.gridy = 7;
		balanceDetailsPanel.add(expenseIcon, gbc_expenseIcon);
		
		JLabel expenseDisplayLabel = new JLabel("- Ksh. 919.60");
		GridBagConstraints gbc_expenseDisplayLabel = new GridBagConstraints();
		gbc_expenseDisplayLabel.gridwidth = 2;
		gbc_expenseDisplayLabel.insets = new Insets(0, 0, 5, 0);
		gbc_expenseDisplayLabel.anchor = GridBagConstraints.WEST;
		gbc_expenseDisplayLabel.gridx = 5;
		gbc_expenseDisplayLabel.gridy = 7;
		balanceDetailsPanel.add(expenseDisplayLabel, gbc_expenseDisplayLabel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 2;
		gbc_verticalStrut_2.gridy = 8;
		balanceDetailsPanel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 295, 431, 250);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 0;
		panel.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 0;
		panel.add(verticalStrut_4, gbc_verticalStrut_4);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 2;
		gbc_horizontalStrut_5.gridy = 0;
		panel.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 4;
		gbc_horizontalStrut_2.gridy = 0;
		panel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 5;
		gbc_horizontalStrut_3.gridy = 0;
		panel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_6.gridx = 7;
		gbc_horizontalStrut_6.gridy = 0;
		panel.add(horizontalStrut_6, gbc_horizontalStrut_6);
		
		JLabel latestTransactionLabel = new JLabel("Latest Transaction");
		latestTransactionLabel.setFont(new Font("Noto Sans Oriya", Font.BOLD, 16));
		GridBagConstraints gbc_latestTransactionLabel = new GridBagConstraints();
		gbc_latestTransactionLabel.anchor = GridBagConstraints.WEST;
		gbc_latestTransactionLabel.gridwidth = 3;
		gbc_latestTransactionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_latestTransactionLabel.gridx = 1;
		gbc_latestTransactionLabel.gridy = 1;
		panel.add(latestTransactionLabel, gbc_latestTransactionLabel);
		
		JButton viewButton = new JButton("View all");
		GridBagConstraints gbc_viewButton = new GridBagConstraints();
		gbc_viewButton.insets = new Insets(0, 0, 5, 5);
		gbc_viewButton.gridx = 6;
		gbc_viewButton.gridy = 1;
		panel.add(viewButton, gbc_viewButton);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 2;
		panel.add(verticalStrut_5, gbc_verticalStrut_5);
		
		JLabel transactionNumberLabel = new JLabel("");
		AbstractBorder iconBorder = new TextBubbleBorder(new Color(219,219,221),2,16,0);
		transactionNumberLabel.setBorder(iconBorder);
		transactionNumberLabel.setIcon(loanIconImage);
		GridBagConstraints gbc_transactionNumberLabel = new GridBagConstraints();
		gbc_transactionNumberLabel.gridheight = 2;
		gbc_transactionNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_transactionNumberLabel.gridx = 1;
		gbc_transactionNumberLabel.gridy = 3;
		panel.add(transactionNumberLabel, gbc_transactionNumberLabel);
		
		JLabel lblNewLabel = new JLabel("Loan Repayment");
		lblNewLabel.setFont(new Font("Noto Nastaliq Urdu", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel amountContributedLabel = new JLabel("Ksh. 2,000.45");
		amountContributedLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 16));
		GridBagConstraints gbc_amountContributedLabel = new GridBagConstraints();
		gbc_amountContributedLabel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_amountContributedLabel.gridwidth = 2;
		gbc_amountContributedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountContributedLabel.gridx = 5;
		gbc_amountContributedLabel.gridy = 3;
		panel.add(amountContributedLabel, gbc_amountContributedLabel);
		
		JLabel contributionDateLabel = new JLabel("2 September, 2020");
		contributionDateLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_contributionDateLabel = new GridBagConstraints();
		gbc_contributionDateLabel.gridwidth = 2;
		gbc_contributionDateLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_contributionDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contributionDateLabel.gridx = 5;
		gbc_contributionDateLabel.gridy = 4;
		panel.add(contributionDateLabel, gbc_contributionDateLabel);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 6;
		gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 5;
		panel.add(separator_2, gbc_separator_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(384, 30, 207, 67);
		add(panel_1);
		
		JButton contributeButton = new JButton("Contribute");
		contributeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ContributeFrame frame = new ContributeFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panel_1.add(contributeButton);

	}
}
