package Presentation.Views;

import Data.Models.GroupMember;
import Data.Models.Member;
import Data.Models.MemberLoan;
import Data.Models.Shares;
import Logic.GroupEvent;
import Logic.LoanEvent;
import Logic.MemberEvent;
import Logic.SharesEvent;
import Presentation.Widgets.GroupMemberPanel;
import Presentation.Widgets.TextBubbleBorder;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class GroupLoanApplicationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField amountEntered;
	private Member activeMember = null;
	private final GroupEvent groupEvent = new GroupEvent();
	private final JPanel groupMembersPanel;
	private GeneralLoadingScreen frame;
	private final JComboBox<String> periodComboBox;
	private final JLabel amountHolder;
	private final JLabel monthlyPayLabel;
	private final JLabel dateLabel;
	private final JLabel maxLoanLabel;
	private final JLabel sharesLabel;

	private final JButton loanRepaymentButton;

	private final DecimalFormat formatter = new DecimalFormat("#,###.00");
	private final String pattern = "dd MMMM, yyyy";
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	private final SharesEvent sharesEvent = new SharesEvent();
	private final LoanEvent loanEvent = new LoanEvent();

	private void initState() {
		frame = new GeneralLoadingScreen();
		activeMember = MemberEvent.getMember();
		groupEvent.loadGroupMembers(activeMember.getAssociatedGroup());
	}

	/**
	 * Create the frame.
	 */
	public GroupLoanApplicationFrame(JButton loanRepaymentButton) {
		this.loanRepaymentButton = loanRepaymentButton;
		initState();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(6, 102, 720, 446);
		bodyPanel.setLayout(null);
		contentPane.add(bodyPanel);

		JLabel applyLoanLabel = new JLabel("Apply Group Loan");
		applyLoanLabel.setFont(new Font("Noto Sans Kannada", Font.BOLD, 24));
		applyLoanLabel.setBounds(30, 40, 225, 33);
		bodyPanel.add(applyLoanLabel);

		AbstractBorder maxPanelBorder = new TextBubbleBorder(Color.WHITE,2,30,0);

		JPanel maxLoanPanel = new JPanel();
		maxLoanPanel.setBackground(Color.WHITE);
		maxLoanPanel.setBounds(30, 85, 225, 135);
		maxLoanPanel.setBorder(maxPanelBorder);
		bodyPanel.add(maxLoanPanel);
		GridBagLayout gbl_maxLoanPanel = new GridBagLayout();
		gbl_maxLoanPanel.columnWidths = new int[]{0, 0};
		gbl_maxLoanPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_maxLoanPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_maxLoanPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		maxLoanPanel.setLayout(gbl_maxLoanPanel);

		JLabel maxTitleLabel = new JLabel("Maximum Loan");
		maxTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		GridBagConstraints gbc_maxTitleLabel = new GridBagConstraints();
		gbc_maxTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_maxTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_maxTitleLabel.gridx = 0;
		gbc_maxTitleLabel.gridy = 0;
		maxLoanPanel.add(maxTitleLabel, gbc_maxTitleLabel);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 1;
		maxLoanPanel.add(verticalStrut_1, gbc_verticalStrut_1);

		maxLoanLabel = new JLabel("Ksh. .00");
		maxLoanLabel.setForeground(SystemColor.textHighlight);
		maxLoanLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		GridBagConstraints gbc_maxLoanLabel = new GridBagConstraints();
		gbc_maxLoanLabel.anchor = GridBagConstraints.WEST;
		gbc_maxLoanLabel.gridx = 0;
		gbc_maxLoanLabel.gridy = 2;
		maxLoanPanel.add(maxLoanLabel, gbc_maxLoanLabel);

		JPanel loanFormPanel = new JPanel();
		loanFormPanel.setLayout(null);
		loanFormPanel.setBounds(303, 58, 411, 375);
		bodyPanel.add(loanFormPanel);

		JPanel formPanel = new JPanel();
		formPanel.setBounds(6, 0, 399, 126);
		loanFormPanel.add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_formPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);

		JLabel loanFormTitleLabel = new JLabel("Loan Form");
		loanFormTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_loanFormTitleLabel = new GridBagConstraints();
		gbc_loanFormTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loanFormTitleLabel.gridx = 1;
		gbc_loanFormTitleLabel.gridy = 0;
		formPanel.add(loanFormTitleLabel, gbc_loanFormTitleLabel);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 0;
		formPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		formPanel.add(separator, gbc_separator);

		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		GridBagConstraints gbc_amountLabel = new GridBagConstraints();
		gbc_amountLabel.anchor = GridBagConstraints.WEST;
		gbc_amountLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountLabel.gridx = 1;
		gbc_amountLabel.gridy = 2;
		formPanel.add(amountLabel, gbc_amountLabel);

		amountEntered = new JTextField();
		amountEntered.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		formPanel.add(amountEntered, gbc_textField);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 3;
		formPanel.add(rigidArea, gbc_rigidArea);

		JLabel periodLabel = new JLabel("Period");
		periodLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		GridBagConstraints gbc_periodLabel = new GridBagConstraints();
		gbc_periodLabel.anchor = GridBagConstraints.WEST;
		gbc_periodLabel.insets = new Insets(0, 0, 0, 5);
		gbc_periodLabel.gridx = 1;
		gbc_periodLabel.gridy = 4;
		formPanel.add(periodLabel, gbc_periodLabel);

		periodComboBox = new JComboBox<>();
		periodComboBox.setModel(new DefaultComboBoxModel(new String[] {"1 year", "2 years", "3 years", "4 years", "5 years"}));
		GridBagConstraints gbc_periodComboBox = new GridBagConstraints();
		gbc_periodComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_periodComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_periodComboBox.gridx = 3;
		gbc_periodComboBox.gridy = 4;
		formPanel.add(periodComboBox, gbc_periodComboBox);

		JPanel loanDetailPanel = new JPanel();
		loanDetailPanel.setBackground(Color.WHITE);
		loanDetailPanel.setBounds(16, 132, 355, 177);
		loanDetailPanel.setBorder(maxPanelBorder);
		loanFormPanel.add(loanDetailPanel);
		GridBagLayout gbl_loanDetailPanel = new GridBagLayout();
		gbl_loanDetailPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_loanDetailPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_loanDetailPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loanDetailPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loanDetailPanel.setLayout(gbl_loanDetailPanel);

		JLabel amountTitleLabel = new JLabel("Amount");
		amountTitleLabel.setForeground(SystemColor.windowBorder);
		amountTitleLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_amountTitleLabel = new GridBagConstraints();
		gbc_amountTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_amountTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountTitleLabel.gridx = 0;
		gbc_amountTitleLabel.gridy = 0;
		loanDetailPanel.add(amountTitleLabel, gbc_amountTitleLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 0;
		loanDetailPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);

		JLabel monthlyPaymentLabel = new JLabel("Monthly Payment");
		monthlyPaymentLabel.setForeground(SystemColor.windowBorder);
		monthlyPaymentLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_monthlyPaymentLabel = new GridBagConstraints();
		gbc_monthlyPaymentLabel.anchor = GridBagConstraints.WEST;
		gbc_monthlyPaymentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_monthlyPaymentLabel.gridx = 3;
		gbc_monthlyPaymentLabel.gridy = 0;
		loanDetailPanel.add(monthlyPaymentLabel, gbc_monthlyPaymentLabel);

		amountHolder = new JLabel("Ksh. 0.00");
		amountHolder.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_amountHolder = new GridBagConstraints();
		gbc_amountHolder.anchor = GridBagConstraints.WEST;
		gbc_amountHolder.gridwidth = 2;
		gbc_amountHolder.insets = new Insets(0, 0, 5, 5);
		gbc_amountHolder.gridx = 0;
		gbc_amountHolder.gridy = 1;
		loanDetailPanel.add(amountHolder, gbc_amountHolder);

		monthlyPayLabel = new JLabel("Ksh. 0.00");
		monthlyPayLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_monthlyPayLabel = new GridBagConstraints();
		gbc_monthlyPayLabel.anchor = GridBagConstraints.WEST;
		gbc_monthlyPayLabel.gridwidth = 2;
		gbc_monthlyPayLabel.insets = new Insets(0, 0, 5, 0);
		gbc_monthlyPayLabel.gridx = 3;
		gbc_monthlyPayLabel.gridy = 1;
		loanDetailPanel.add(monthlyPayLabel, gbc_monthlyPayLabel);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 2;
		loanDetailPanel.add(verticalStrut, gbc_verticalStrut);

		JLabel rateLabel = new JLabel("Rate");
		rateLabel.setForeground(SystemColor.windowBorder);
		rateLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_rateLabel = new GridBagConstraints();
		gbc_rateLabel.anchor = GridBagConstraints.WEST;
		gbc_rateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_rateLabel.gridx = 0;
		gbc_rateLabel.gridy = 3;
		loanDetailPanel.add(rateLabel, gbc_rateLabel);

		JLabel dueDateLabel = new JLabel("Due Date");
		dueDateLabel.setForeground(SystemColor.windowBorder);
		dueDateLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_dueDateLabel = new GridBagConstraints();
		gbc_dueDateLabel.anchor = GridBagConstraints.WEST;
		gbc_dueDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dueDateLabel.gridx = 3;
		gbc_dueDateLabel.gridy = 3;
		loanDetailPanel.add(dueDateLabel, gbc_dueDateLabel);

		JLabel rateHolderLabel = new JLabel("1.2%");
		rateHolderLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_rateHolderLabel = new GridBagConstraints();
		gbc_rateHolderLabel.anchor = GridBagConstraints.WEST;
		gbc_rateHolderLabel.gridwidth = 2;
		gbc_rateHolderLabel.insets = new Insets(0, 0, 0, 5);
		gbc_rateHolderLabel.gridx = 0;
		gbc_rateHolderLabel.gridy = 4;
		loanDetailPanel.add(rateHolderLabel, gbc_rateHolderLabel);

		dateLabel = new JLabel("21, September 2025");
		dateLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.anchor = GridBagConstraints.WEST;
		gbc_dateLabel.gridwidth = 2;
		gbc_dateLabel.gridx = 3;
		gbc_dateLabel.gridy = 4;
		loanDetailPanel.add(dateLabel, gbc_dateLabel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(6, 317, 399, 52);
		loanFormPanel.add(buttonPanel);

		JButton processButton = new JButton("Process request");
		processButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		processButton.addActionListener(e -> {
			updateLoanDetailPanel();
			processLoan();
		});
		buttonPanel.add(processButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonPanel.add(clearButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 6, 720, 12);
		bodyPanel.add(separator_1);
		
		JScrollPane groupMemberScrollPane = new JScrollPane();
		groupMemberScrollPane.setBounds(6, 266, 285, 174);
		bodyPanel.add(groupMemberScrollPane);
		
		groupMembersPanel = new JPanel();
		groupMemberScrollPane.setViewportView(groupMembersPanel);
		groupMembersPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel groupMemberLabel = new JLabel("Group Members");
		groupMemberLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		groupMemberLabel.setBounds(23, 238, 129, 16);
		bodyPanel.add(groupMemberLabel);
		
		JPanel userDetailsPanel = new JPanel();
		userDetailsPanel.setBounds(6, 6, 720, 99);
		contentPane.add(userDetailsPanel);
		GridBagLayout gbl_userDetailsPanel = new GridBagLayout();
		gbl_userDetailsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_userDetailsPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_userDetailsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_userDetailsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		userDetailsPanel.setLayout(gbl_userDetailsPanel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 0;
		userDetailsPanel.add(rigidArea_1, gbc_rigidArea_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 0;
		userDetailsPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setForeground(SystemColor.windowBorder);
		nameTitleLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_nameTitleLabel = new GridBagConstraints();
		gbc_nameTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_nameTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameTitleLabel.gridx = 1;
		gbc_nameTitleLabel.gridy = 1;
		userDetailsPanel.add(nameTitleLabel, gbc_nameTitleLabel);
		
		JLabel totalSharesTitleLabel = new JLabel("Total Shares");
		totalSharesTitleLabel.setForeground(SystemColor.windowBorder);
		totalSharesTitleLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_totalSharesTitleLabel = new GridBagConstraints();
		gbc_totalSharesTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_totalSharesTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_totalSharesTitleLabel.gridx = 4;
		gbc_totalSharesTitleLabel.gridy = 1;
		userDetailsPanel.add(totalSharesTitleLabel, gbc_totalSharesTitleLabel);
		
		JLabel groupNameLabel = new JLabel("<dynamic> <dynamic>");
		groupNameLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 16));
		GridBagConstraints gbc_groupNameLabel = new GridBagConstraints();
		gbc_groupNameLabel.anchor = GridBagConstraints.WEST;
		gbc_groupNameLabel.gridwidth = 2;
		gbc_groupNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_groupNameLabel.gridx = 1;
		gbc_groupNameLabel.gridy = 2;
		userDetailsPanel.add(groupNameLabel, gbc_groupNameLabel);
		
		sharesLabel = new JLabel("Ksh. .00");
		sharesLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		GridBagConstraints gbc_sharesLabel = new GridBagConstraints();
		gbc_sharesLabel.anchor = GridBagConstraints.WEST;
		gbc_sharesLabel.insets = new Insets(0, 0, 5, 0);
		gbc_sharesLabel.gridx = 4;
		gbc_sharesLabel.gridy = 2;
		userDetailsPanel.add(sharesLabel, gbc_sharesLabel);
		
		JLabel groupIDLabel = new JLabel("<dynamic>");
		groupIDLabel.setForeground(SystemColor.windowBorder);
		GridBagConstraints gbc_groupIDLabel = new GridBagConstraints();
		gbc_groupIDLabel.anchor = GridBagConstraints.WEST;
		gbc_groupIDLabel.gridwidth = 2;
		gbc_groupIDLabel.insets = new Insets(0, 0, 0, 5);
		gbc_groupIDLabel.gridx = 1;
		gbc_groupIDLabel.gridy = 3;
		userDetailsPanel.add(groupIDLabel, gbc_groupIDLabel);

		displayMembers();
	}

	private void displayMembers() {
		var groupMembers = GroupMember.getGroupMembersList();

		for (var member: groupMembers) {
			groupMembersPanel.add(new GroupMemberPanel(member));
		}
	}

	public void updateSharesStatus() {
		sharesEvent.loadDataForDatabase(
				String.format(
						"SELECT * FROM baraka_db.shares_contribution WHERE member_id = \"%s\";",
						activeMember.getMemberID()
				)
		);
		sharesLabel.setText("Ksh. "+ formatter.format(calculateTotalShares()));
		maxLoanLabel.setText("Ksh. "+ formatter.format(calculateMaxLoan()));
	}

	private void processLoan() {
		if(!validateData()) return;

		showLoadingScreen();

		try {
			String loanId = loanEvent.generateLoanId();
			String memberId = activeMember.getMemberID();
			double interestRate = getInterestRate();
			double amountBorrowed = Double.parseDouble(amountEntered.getText());
			Date dueDate = new java.sql.Date(simpleDateFormat.parse(calculateDueDate()).getTime());

			var loanInstance = new MemberLoan(loanId,memberId,interestRate,amountBorrowed,dueDate);

			loanEvent.submitLoanToDatabase(loanInstance);
			loanRepaymentButton.setEnabled(true);
			var sqlStatement = String.format(
					"SELECT * FROM baraka_db.loan WHERE member_id = \"%s\";",
					activeMember.getMemberID()
			);

			loanEvent.loadDataForDatabase(sqlStatement);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private boolean validateData() {
		var sqlStatement = String.format(
				"SELECT * FROM baraka_db.loan WHERE member_id = \"%s\";",
				activeMember.getMemberID()
		);
		loanEvent.loadDataForDatabase(sqlStatement);

		var loan = MemberLoan.getActiveLoan();
		double amountBorrowed = Double.parseDouble(amountEntered.getText());

		System.out.println(calculateMaxLoan());
		System.out.println(amountBorrowed);

		if (amountBorrowed > calculateMaxLoan()) {
			JOptionPane.showMessageDialog(null,"The amount entered exceed the maximum loan you can borrow.","Alert",JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (loan != null && !loan.isPaid()){
			JOptionPane.showMessageDialog(null,"You can not borrow another loan you have an active loan.","Alert",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private double calculateTotalShares() {
		var shares = Shares.getMemberShares();
		double totalShares = 0;

		for (Shares share : shares) {
			totalShares+=share.getAmountContributed();
		}
		return totalShares;
	}

	private double calculateMaxLoan() {
		return (activeMember.getAssociatedGroup() == null) ? calculateTotalShares()*3 : calculateTotalShares()*4;
	}

	private double getInterestRate() {
		return (activeMember.getAssociatedGroup() == null) ? 1.2 : 1.0;
	}

	private void updateLoanDetailPanel() {
		amountHolder.setText("Ksh. "+ formatter.format((Double.parseDouble(amountEntered.getText()))));
		monthlyPayLabel.setText("Ksh. "+ formatter.format(calculateMonthlyPayment()));
		dateLabel.setText(calculateDueDate());
	}

	private double calculateMonthlyPayment() {
		double amount =  Double.parseDouble(amountEntered.getText());
		System.out.println(amount);
		double period = getPeriodInMonths();
		double wholeInterest = calculateInterest() * period;
		double totalPay = wholeInterest + amount;
		return totalPay/period;
	}

	private double getPeriodInMonths() {
		if(periodComboBox.getSelectedItem() == null) return 0;
		double period;
		Object selectedItem = periodComboBox.getSelectedItem();
		if ("1 year".equals(selectedItem)) {
			period = 12.0;
		} else if ("2 years".equals(selectedItem)) {
			period = 24.0;
		} else if ("3 years".equals(selectedItem)) {
			period = 36.0;
		} else if ("4 years".equals(selectedItem)) {
			period = 48.0;
		} else {
			throw new IllegalStateException("Unexpected value: " + periodComboBox.getSelectedItem());
		}

		return period;
	}

	private double calculateInterest() {
		if(Objects.equals(amountEntered.getText(), "")) return 0;
		double period = getPeriodInMonths();
		double rate = getInterestRate();
		double amount = Double.parseDouble(amountEntered.getText());

		return (rate/100) * amount * period;
	}

	private String calculateDueDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, (int) getPeriodInMonths());
		return simpleDateFormat.format(calendar.getTime());
	}

	private void showLoadingScreen() {
		frame.setVisible(true);

		SwingWorker<Boolean, Integer> swingWorker = new SwingWorker<Boolean, Integer>() {

			@Override
			protected Boolean doInBackground() throws Exception {
				// WARN: do not update the GUI from within doInBackground(), use process() / done()!

				// Do something ...
				// prepareurl(p6, p_back, list, list.length);
				//
				for (int i = 0; i <= 100; i++) {
					Thread.sleep((int) (Math.random() * 60));
					// Use publish to send progress information to this.process() [optional]
					publish(i);
				}
				return true;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// handle published progress informations / update UI
				AtomicInteger percent = new AtomicInteger();
				chunks.forEach(percent::set);
				frame.percentageLabel.setText(String.format("%s%%", percent));
				int progress = chunks.get(chunks.size() - 1);
				if(progress == 10){
					frame.updateLabel.setText("Processing loan...");
				}

				if(progress == 20){
					frame.updateLabel.setText("Loading Modules...");
				}

				if(progress == 50){
					frame.updateLabel.setText("Connecting to Database...");
				}

				if(progress == 70){
					frame.updateLabel.setText("Loan Processed!");
				}

				frame.loadingBar.setValue(progress);
			}

			@Override
			protected void done() {
				frame.dispose();
			}
		};
		swingWorker.execute();
	} // end: startWorkerThread
}
