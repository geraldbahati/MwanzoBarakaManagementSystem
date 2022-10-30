package Presentation.Views;

import Data.Models.Member;
import Presentation.Widgets.HomePanel;
import Presentation.Widgets.SharesPanel;
import Presentation.Widgets.TextBubbleBorder;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel titlePanel = new JPanel();

	private DefaultTableCellRenderer cellRenderer;

	private HomePanel homePanel;
	private SharesPanel sharesPanel;

	private static final String[] columnNames = { "Last Transaction Date", "Counter", "Monthly Contributed", "Total Shares"};
	private static DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
	/**
	 * Create the frame.
	 */
	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(960, 700));
//		setBounds(100, 100, 960, 700);
		setLocationRelativeTo(null);
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
		AbstractBorder navigatorBorder = new TextBubbleBorder(new Color(49, 62, 79),2,16,0);
		navigatorPanel.setBorder(navigatorBorder);
		navigatorPanel.setBounds(11, 58, 938, 35);
		navigatorPanel.setBackground(new Color(49, 62, 79));
		navigatorPanel.setForeground(new Color(49, 62, 80));
		contentPane.add(navigatorPanel);
		navigatorPanel.setLayout(null);
		
		JLabel iBankingLabel = new JLabel("iBanking");
		iBankingLabel.setBounds(23, 6, 74, 22);
		iBankingLabel.setForeground(new Color(254, 255, 255));
		iBankingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		navigatorPanel.add(iBankingLabel);
		
		JComboBox<Object> comboBox = new JComboBox<>(Member.getMemberRecords());
		comboBox.setBounds(239, 7, 468, 27);
		comboBox.setBackground(new Color(254, 255, 255));
		comboBox.setForeground(new Color(0, 0, 0));
		navigatorPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setBounds(162, 8, 76, 20);
		lblNewLabel.setForeground(new Color(254, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		navigatorPanel.add(lblNewLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(11, 91, 938, 569);
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JTabbedPane contentTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentTabbedPane.setBounds(222, -29, 710, 598);
		bodyPanel.add(contentTabbedPane);
		
		AbstractBorder buttonBorder = new TextBubbleBorder(new Color(49, 62, 79),2,16,0);
		
		JButton loanApplicationButton = new JButton("Loan Application");
		loanApplicationButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		loanApplicationButton.setBorder(buttonBorder);
		loanApplicationButton.setOpaque(true);
		loanApplicationButton.setBounds(24, 153, 180, 47);
		loanApplicationButton.setBackground(new Color(49, 62, 79));
		loanApplicationButton.setForeground(Color.WHITE);
		loanApplicationButton.setFocusable(false);
		bodyPanel.add(loanApplicationButton);
		
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(e -> contentTabbedPane.setSelectedIndex(0));
		homeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		homeButton.setBorder(buttonBorder);
		homeButton.setOpaque(true);
		homeButton.setBounds(24, 35, 180, 47);
		homeButton.setBackground(new Color(49, 62, 79));
		homeButton.setForeground(Color.WHITE);
		homeButton.setFocusable(false);
		bodyPanel.add(homeButton);

		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);

		tableModel.addRow(new Object[] {12,4.345,5345,3});
		
		JButton sharesContributionButton = new JButton("Shares Contribution");
		sharesContributionButton.addActionListener(e -> contentTabbedPane.setSelectedIndex(1));
		sharesContributionButton.setBorder(buttonBorder);
		sharesContributionButton.setOpaque(true);
		sharesContributionButton.setBackground(new Color(49, 62, 79));
		sharesContributionButton.setForeground(SystemColor.text);
		sharesContributionButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sharesContributionButton.setBounds(24, 94, 180, 47);
		bodyPanel.add(sharesContributionButton);
		
		
		
		JScrollPane homeScrollPane = new JScrollPane();
		homeScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		homeScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentTabbedPane.addTab("New tab", null, homeScrollPane, null);

		homePanel = new HomePanel();
		homeScrollPane.setViewportView(homePanel);
		
	
		JScrollPane contributionScrollPane = new JScrollPane();
		contributionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contributionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentTabbedPane.addTab("New tab", null, contributionScrollPane, null);

		sharesPanel = new SharesPanel();
		contributionScrollPane.setViewportView(sharesPanel);
		
		JScrollPane loanScrollPane = new JScrollPane();
		loanScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		loanScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentTabbedPane.addTab("New tab", null, loanScrollPane, null);
	}
}
