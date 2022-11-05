package Presentation.Views;

import Data.Models.Member;
import Data.Models.MemberLoan;
import Logic.LoanEvent;
import Logic.MemberEvent;
import Presentation.Widgets.*;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel titlePanel = new JPanel();

	private DefaultTableCellRenderer cellRenderer;

	private HomePanel homePanel;
	private SharesPanel sharesPanel;
	private LoanRepaymentPanel repaymentPanel;

	private LoanApplicationPanel loanApplicationPanel;
	private Member activeMember = null;

	private static final String[] columnNames = { "Last Transaction Date", "Counter", "Monthly Contributed", "Total Shares"};
	private static DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
	private final LoanEvent loanEvent = new LoanEvent();

	private void initState() {
		activeMember = MemberEvent.getMember();
		System.out.println(activeMember.getMemberID());
		var sqlStatement = String.format(
				"SELECT * FROM baraka_db.loan WHERE member_id = \"%s\";",
				activeMember.getMemberID()
		);

		loanEvent.loadDataForDatabase(sqlStatement);
	}
	/**
	 * Create the frame.
	 */
	public HomeFrame() {
		initState();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1105, 758));
//		setBounds(100, 100, 960, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		titlePanel.setBounds(11, 11, 1088, 35);
		contentPane.add(titlePanel);
		
		JLabel titleLabel = new JLabel("Mwanzo Baraka Management System");
		titleLabel.setFont(new Font("Hiragino Sans", Font.BOLD, 20));
		titlePanel.add(titleLabel);
		
		JPanel navigatorPanel = new JPanel();
		AbstractBorder navigatorBorder = new TextBubbleBorder(new Color(49, 62, 79),2,16,0);
		navigatorPanel.setBorder(navigatorBorder);
		navigatorPanel.setBounds(11, 58, 1088, 35);
		navigatorPanel.setBackground(new Color(49, 62, 79));
		navigatorPanel.setForeground(new Color(49, 62, 80));
		contentPane.add(navigatorPanel);
		navigatorPanel.setLayout(null);
		
		JLabel iBankingLabel = new JLabel("iBanking");
		iBankingLabel.setBounds(23, 6, 74, 22);
		iBankingLabel.setForeground(new Color(254, 255, 255));
		iBankingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		navigatorPanel.add(iBankingLabel);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(e -> openLoginFrame());
		logoutButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		logoutButton.setBounds(942, 6, 117, 29);
		navigatorPanel.add(logoutButton);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(11, 91, 1088, 633);
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JTabbedPane contentTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentTabbedPane.setBounds(222, -29, 860, 656);
		bodyPanel.add(contentTabbedPane);
		
		AbstractBorder buttonBorder = new TextBubbleBorder(new Color(49, 62, 79),2,16,0);
		
		JButton loanApplicationButton = new JButton("Loan Application");
		loanApplicationButton.addActionListener(e -> contentTabbedPane.setSelectedIndex(2));
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

		JButton loanRepaymentButton = new JButton("Loan Repayment");
		if (MemberLoan.getActiveLoan() == null) loanRepaymentButton.setEnabled(false);
		loanRepaymentButton.addActionListener(e -> contentTabbedPane.setSelectedIndex(3));
		loanRepaymentButton.setBorder(buttonBorder);
		loanRepaymentButton.setOpaque(true);
		loanRepaymentButton.setForeground(Color.WHITE);
		loanRepaymentButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		loanRepaymentButton.setFocusable(false);
		loanRepaymentButton.setBackground(new Color(49, 62, 79));
		loanRepaymentButton.setBounds(24, 212, 180, 47);
		bodyPanel.add(loanRepaymentButton);

		homePanel = new HomePanel();
		contentTabbedPane.addTab("Home", null, homePanel, null);

		sharesPanel = new SharesPanel();
		contentTabbedPane.addTab("Shares", null, sharesPanel, null);

		loanApplicationPanel = new LoanApplicationPanel();
		contentTabbedPane.addTab("Loan Application", null, loanApplicationPanel, null);

		repaymentPanel = new LoanRepaymentPanel();
		contentTabbedPane.addTab("Loan Repayment", null, repaymentPanel, null);

	}

	private void openLoginFrame() {
		EventQueue.invokeLater(() -> {
			try {
				LoginFrame frame = new LoginFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		MemberLoan.setLoanNull();
		dispose();
	}
}
