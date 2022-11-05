package Presentation.Widgets;

import Data.Models.Shares;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonthSharesPanel extends JPanel {
	private final ArrayList<Shares> sharesList;
	private double totalMonthlyAmount = 0;
	private final DecimalFormat formatter = new DecimalFormat("#,###.00");

	/**
	 * Create the panel.
	 */
	public MonthSharesPanel(String month,ArrayList<Shares> shares) {
		this.sharesList = shares;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel monthDetailPanel = new JPanel();
		add(monthDetailPanel);
		GridBagLayout gbl_monthDetailPanel = new GridBagLayout();
		gbl_monthDetailPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_monthDetailPanel.rowHeights = new int[]{0, 0, 0};
		gbl_monthDetailPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_monthDetailPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		monthDetailPanel.setLayout(gbl_monthDetailPanel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		monthDetailPanel.add(rigidArea, gbc_rigidArea);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_7.gridx = 2;
		gbc_horizontalStrut_7.gridy = 0;
		monthDetailPanel.add(horizontalStrut_7, gbc_horizontalStrut_7);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 4;
		gbc_horizontalStrut.gridy = 0;
		monthDetailPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 0;
		monthDetailPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 6;
		gbc_horizontalStrut_2.gridy = 0;
		monthDetailPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 7;
		gbc_horizontalStrut_3.gridy = 0;
		monthDetailPanel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 8;
		gbc_horizontalStrut_4.gridy = 0;
		monthDetailPanel.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 9;
		gbc_horizontalStrut_5.gridy = 0;
		monthDetailPanel.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 10;
		gbc_horizontalStrut_6.gridy = 0;
		monthDetailPanel.add(horizontalStrut_6, gbc_horizontalStrut_6);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 12;
		gbc_horizontalStrut_8.gridy = 0;
		monthDetailPanel.add(horizontalStrut_8, gbc_horizontalStrut_8);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_9 = new GridBagConstraints();
		gbc_horizontalStrut_9.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_9.gridx = 14;
		gbc_horizontalStrut_9.gridy = 0;
		monthDetailPanel.add(horizontalStrut_9, gbc_horizontalStrut_9);
		
		JLabel monthTitleLabel = new JLabel("Month: ");
		monthTitleLabel.setForeground(Color.GRAY);
		monthTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_monthTitleLabel = new GridBagConstraints();
		gbc_monthTitleLabel.insets = new Insets(0, 0, 0, 5);
		gbc_monthTitleLabel.gridx = 1;
		gbc_monthTitleLabel.gridy = 1;
		monthDetailPanel.add(monthTitleLabel, gbc_monthTitleLabel);
		
		JLabel lblNewLabel_1 = new JLabel(month);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		monthDetailPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel totalTitleLabel = new JLabel("Total:");
		totalTitleLabel.setForeground(Color.GRAY);
		totalTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_totalTitleLabel = new GridBagConstraints();
		gbc_totalTitleLabel.insets = new Insets(0, 0, 0, 5);
		gbc_totalTitleLabel.gridx = 11;
		gbc_totalTitleLabel.gridy = 1;
		monthDetailPanel.add(totalTitleLabel, gbc_totalTitleLabel);

		addSharePanels();

		JLabel totalLabel = new JLabel("Ksh. "+formatter.format(totalMonthlyAmount));
		totalLabel.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 18));
		GridBagConstraints gbc_totalLabel = new GridBagConstraints();
		gbc_totalLabel.insets = new Insets(0, 0, 0, 5);
		gbc_totalLabel.gridx = 13;
		gbc_totalLabel.gridy = 1;
		monthDetailPanel.add(totalLabel, gbc_totalLabel);


	}

	private void addSharePanels() {
		for (Shares shares : sharesList) {
			totalMonthlyAmount+=shares.getAmountContributed();
			add(new SharesRecord(shares));
		}
	}

}
