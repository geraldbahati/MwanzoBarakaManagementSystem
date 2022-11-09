package Presentation.Widgets;

import Data.Models.LoanRepayment;
import Data.Models.MemberLoan;
import Logic.LoanEvent;
import Logic.RepaymentEvent;
import Presentation.Views.GeneralLoadingScreen;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LoanRepaymentPanel extends JPanel {
	private JTextField amountField;
	private JLabel monthAmountLabel;
	private JLabel amountPaidHolder;
	private JLabel balanceHolder;

	private final RepaymentEvent repaymentEvent = new RepaymentEvent();
	private final LoanEvent loanEvent = new LoanEvent();

	private MemberLoan loan = null;
	private final DecimalFormat formatter = new DecimalFormat("#,###.00");
	private final String pattern = "dd MMMM, yyyy";
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	private GeneralLoadingScreen frame;


	private void initState() {
		frame = new GeneralLoadingScreen();
		var activeLoan = MemberLoan.getActiveLoan();
		if (activeLoan == null) return;
		var sqlStatement = String.format(
				"SELECT * FROM baraka_db.loan_repayment WHERE loan_id = \"%s\";",
				activeLoan.getLoanId()
		);

		repaymentEvent.loadDataForDatabase(sqlStatement);
		loan = MemberLoan.getActiveLoan();
	}
	/**
	 * Create the panel.
	 */
	public LoanRepaymentPanel() {
		initState();
		if(loan == null) return;
		setLayout(null);

		AbstractBorder buttonBorder = new TextBubbleBorder(new Color(49, 62, 79),2,16,0);

		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(6, 6, 815, 55);
		add(titlePanel);
		
		JLabel titleLabel = new JLabel("Loan Repayment");
		titleLabel.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 24));
		titlePanel.add(titleLabel);
		
		JPanel loanDetailPanel = new JPanel();
		AbstractBorder loanDetailPanelBorder = new TextBubbleBorder(Color.WHITE,2,50,0);
		loanDetailPanel.setBorder(loanDetailPanelBorder);
		loanDetailPanel.setBackground(Color.WHITE);
		loanDetailPanel.setBounds(6, 112, 815, 227);
		add(loanDetailPanel);
		GridBagLayout gbl_loanDetailPanel = new GridBagLayout();
		gbl_loanDetailPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_loanDetailPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_loanDetailPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_loanDetailPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loanDetailPanel.setLayout(gbl_loanDetailPanel);
		
		JLabel loanTitleLabel = new JLabel("Loan ID");
		loanTitleLabel.setForeground(SystemColor.scrollbar);
		loanTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_loanTitleLabel = new GridBagConstraints();
		gbc_loanTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_loanTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loanTitleLabel.gridx = 0;
		gbc_loanTitleLabel.gridy = 0;
		loanDetailPanel.add(loanTitleLabel, gbc_loanTitleLabel);
		
		JLabel loanIdHolder = new JLabel(loan.getLoanId());
		loanIdHolder.setForeground(UIManager.getColor("Button.select"));
		loanIdHolder.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		GridBagConstraints gbc_loanIdHolder = new GridBagConstraints();
		gbc_loanIdHolder.anchor = GridBagConstraints.WEST;
		gbc_loanIdHolder.insets = new Insets(0, 0, 5, 5);
		gbc_loanIdHolder.gridx = 1;
		gbc_loanIdHolder.gridy = 0;
		loanDetailPanel.add(loanIdHolder, gbc_loanIdHolder);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 0;
		loanDetailPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel amountTitleLabel = new JLabel("Amount Borrowed");
		amountTitleLabel.setForeground(SystemColor.scrollbar);
		amountTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_amountTitleLabel = new GridBagConstraints();
		gbc_amountTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountTitleLabel.gridx = 3;
		gbc_amountTitleLabel.gridy = 0;
		loanDetailPanel.add(amountTitleLabel, gbc_amountTitleLabel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 4;
		gbc_horizontalStrut_1.gridy = 0;
		loanDetailPanel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel amountHolder = new JLabel("Ksh. "+formatter.format(loan.getAmountBorrowed()));
		amountHolder.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		GridBagConstraints gbc_amountHolder = new GridBagConstraints();
		gbc_amountHolder.anchor = GridBagConstraints.WEST;
		gbc_amountHolder.insets = new Insets(0, 0, 5, 5);
		gbc_amountHolder.gridx = 5;
		gbc_amountHolder.gridy = 0;
		loanDetailPanel.add(amountHolder, gbc_amountHolder);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 6;
		gbc_horizontalStrut_2.gridy = 0;
		loanDetailPanel.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JLabel monthRepTitleLabel = new JLabel("Monthly Repayment");
		monthRepTitleLabel.setForeground(SystemColor.scrollbar);
		monthRepTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_monthRepTitleLabel = new GridBagConstraints();
		gbc_monthRepTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_monthRepTitleLabel.gridx = 7;
		gbc_monthRepTitleLabel.gridy = 0;
		loanDetailPanel.add(monthRepTitleLabel, gbc_monthRepTitleLabel);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 8;
		gbc_horizontalStrut_3.gridy = 0;
		loanDetailPanel.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		JLabel monthHolder = new JLabel("Ksh. "+formatter.format(calculateMonthlyPayment()));
		monthHolder.setForeground(UIManager.getColor("EditorPane.selectionBackground"));
		monthHolder.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		GridBagConstraints gbc_monthHolder = new GridBagConstraints();
		gbc_monthHolder.anchor = GridBagConstraints.WEST;
		gbc_monthHolder.insets = new Insets(0, 0, 5, 0);
		gbc_monthHolder.gridx = 9;
		gbc_monthHolder.gridy = 0;
		loanDetailPanel.add(monthHolder, gbc_monthHolder);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		loanDetailPanel.add(verticalStrut, gbc_verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 2;
		loanDetailPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel dateTitleLabel = new JLabel("Date of Loan Borrowed");
		dateTitleLabel.setForeground(SystemColor.scrollbar);
		dateTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_dateTitleLabel = new GridBagConstraints();
		gbc_dateTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_dateTitleLabel.gridwidth = 2;
		gbc_dateTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateTitleLabel.gridx = 0;
		gbc_dateTitleLabel.gridy = 3;
		loanDetailPanel.add(dateTitleLabel, gbc_dateTitleLabel);
		
		JLabel interestRateLabel = new JLabel("Interest Rate");
		interestRateLabel.setForeground(SystemColor.scrollbar);
		interestRateLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_interestRateLabel = new GridBagConstraints();
		gbc_interestRateLabel.gridheight = 2;
		gbc_interestRateLabel.insets = new Insets(0, 0, 0, 5);
		gbc_interestRateLabel.gridx = 3;
		gbc_interestRateLabel.gridy = 3;
		loanDetailPanel.add(interestRateLabel, gbc_interestRateLabel);
		
		JLabel rateHolder = new JLabel(String.format("%.01f%%",loan.getInterestRate()));
		rateHolder.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		GridBagConstraints gbc_rateHolder = new GridBagConstraints();
		gbc_rateHolder.anchor = GridBagConstraints.WEST;
		gbc_rateHolder.gridwidth = 2;
		gbc_rateHolder.gridheight = 2;
		gbc_rateHolder.insets = new Insets(0, 0, 0, 5);
		gbc_rateHolder.gridx = 4;
		gbc_rateHolder.gridy = 3;
		loanDetailPanel.add(rateHolder, gbc_rateHolder);
		
		JLabel dueDateLabel = new JLabel("Due Date");
		dueDateLabel.setForeground(SystemColor.scrollbar);
		dueDateLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		GridBagConstraints gbc_dueDateLabel = new GridBagConstraints();
		gbc_dueDateLabel.anchor = GridBagConstraints.WEST;
		gbc_dueDateLabel.gridwidth = 3;
		gbc_dueDateLabel.insets = new Insets(0, 0, 5, 0);
		gbc_dueDateLabel.gridx = 7;
		gbc_dueDateLabel.gridy = 3;
		loanDetailPanel.add(dueDateLabel, gbc_dueDateLabel);
		
		JLabel dateHolder = new JLabel(simpleDateFormat.format(loan.getCreated()));
		dateHolder.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		GridBagConstraints gbc_dateHolder = new GridBagConstraints();
		gbc_dateHolder.anchor = GridBagConstraints.WEST;
		gbc_dateHolder.gridwidth = 2;
		gbc_dateHolder.insets = new Insets(0, 0, 0, 5);
		gbc_dateHolder.gridx = 0;
		gbc_dateHolder.gridy = 4;
		loanDetailPanel.add(dateHolder, gbc_dateHolder);
		
		JLabel dueDateHolder = new JLabel(simpleDateFormat.format(loan.getDueDate()));
		dueDateHolder.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		GridBagConstraints gbc_dueDateHolder = new GridBagConstraints();
		gbc_dueDateHolder.anchor = GridBagConstraints.WEST;
		gbc_dueDateHolder.gridwidth = 3;
		gbc_dueDateHolder.gridx = 7;
		gbc_dueDateHolder.gridy = 4;
		loanDetailPanel.add(dueDateHolder, gbc_dueDateHolder);
		
		JLabel lblNewLabel = new JLabel("Loan Detail");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(39, 71, 187, 29);
		add(lblNewLabel);
		
		JPanel balancePanel = new JPanel();
		balancePanel.setBounds(6, 351, 398, 204);
		add(balancePanel);
		GridBagLayout gbl_balancePanel = new GridBagLayout();
		gbl_balancePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_balancePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_balancePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_balancePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		balancePanel.setLayout(gbl_balancePanel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea.gridx = 0;
		gbc_rigidArea.gridy = 0;
		balancePanel.add(rigidArea, gbc_rigidArea);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 2;
		gbc_horizontalStrut_4.gridy = 0;
		balancePanel.add(horizontalStrut_4, gbc_horizontalStrut_4);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 0;
		balancePanel.add(horizontalStrut_5, gbc_horizontalStrut_5);
		
		JLabel fullChargeLabel = new JLabel("Expected Repayment");
		fullChargeLabel.setForeground(UIManager.getColor("CheckBox.disabledText"));
		fullChargeLabel.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 14));
		GridBagConstraints gbc_fullChargeLabel = new GridBagConstraints();
		gbc_fullChargeLabel.anchor = GridBagConstraints.WEST;
		gbc_fullChargeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullChargeLabel.gridx = 1;
		gbc_fullChargeLabel.gridy = 1;
		balancePanel.add(fullChargeLabel, gbc_fullChargeLabel);

		JLabel totalAmountHolder = new JLabel("Ksh. " + formatter.format(calculateTotalPayment()));
		totalAmountHolder.setFont(new Font("Noto Sans Kannada", Font.BOLD, 20));
		GridBagConstraints gbc_totalAmountHolder = new GridBagConstraints();
		gbc_totalAmountHolder.anchor = GridBagConstraints.WEST;
		gbc_totalAmountHolder.insets = new Insets(0, 0, 5, 0);
		gbc_totalAmountHolder.gridx = 4;
		gbc_totalAmountHolder.gridy = 1;
		balancePanel.add(totalAmountHolder, gbc_totalAmountHolder);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		balancePanel.add(verticalStrut_2, gbc_verticalStrut_2);
		
		JLabel amountPaidLabel = new JLabel("Amount Paid");
		amountPaidLabel.setForeground(UIManager.getColor("CheckBox.disabledText"));
		amountPaidLabel.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 14));
		GridBagConstraints gbc_amountPaidLabel = new GridBagConstraints();
		gbc_amountPaidLabel.anchor = GridBagConstraints.WEST;
		gbc_amountPaidLabel.insets = new Insets(0, 0, 5, 5);
		gbc_amountPaidLabel.gridx = 1;
		gbc_amountPaidLabel.gridy = 3;
		balancePanel.add(amountPaidLabel, gbc_amountPaidLabel);
		
		amountPaidHolder = new JLabel("Ksh. "+ formatter.format(calculateAmountRepaid()));
		amountPaidHolder.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 20));
		GridBagConstraints gbc_amountPaidHolder = new GridBagConstraints();
		gbc_amountPaidHolder.insets = new Insets(0, 0, 5, 0);
		gbc_amountPaidHolder.anchor = GridBagConstraints.WEST;
		gbc_amountPaidHolder.gridx = 4;
		gbc_amountPaidHolder.gridy = 3;
		balancePanel.add(amountPaidHolder, gbc_amountPaidHolder);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 4;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 4;
		balancePanel.add(separator, gbc_separator);
		
		JLabel balanceLabel = new JLabel("Balance: ");
		balanceLabel.setForeground(UIManager.getColor("CheckBox.disabledText"));
		balanceLabel.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 14));
		GridBagConstraints gbc_balanceLabel = new GridBagConstraints();
		gbc_balanceLabel.anchor = GridBagConstraints.EAST;
		gbc_balanceLabel.insets = new Insets(0, 0, 0, 5);
		gbc_balanceLabel.gridx = 1;
		gbc_balanceLabel.gridy = 5;
		balancePanel.add(balanceLabel, gbc_balanceLabel);
		
		balanceHolder = new JLabel("Ksh. "+ formatter.format(calculateBalance()));
		balanceHolder.setForeground(UIManager.getColor("Button.select"));
		balanceHolder.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 18));
		GridBagConstraints gbc_balanceHolder = new GridBagConstraints();
		gbc_balanceHolder.anchor = GridBagConstraints.WEST;
		gbc_balanceHolder.gridwidth = 3;
		gbc_balanceHolder.gridx = 2;
		gbc_balanceHolder.gridy = 5;
		balancePanel.add(balanceHolder, gbc_balanceHolder);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(423, 351, 398, 204);
		add(formPanel);
		GridBagLayout gbl_formPanel = new GridBagLayout();
		gbl_formPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_formPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_formPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_formPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formPanel.setLayout(gbl_formPanel);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
		gbc_rigidArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_1.gridx = 0;
		gbc_rigidArea_1.gridy = 0;
		formPanel.add(rigidArea_1, gbc_rigidArea_1);
		
		JLabel payTitleLabel = new JLabel("This Month Payment:");
		payTitleLabel.setForeground(Color.LIGHT_GRAY);
		payTitleLabel.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 16));
		GridBagConstraints gbc_payTitleLabel = new GridBagConstraints();
		gbc_payTitleLabel.gridwidth = 3;
		gbc_payTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_payTitleLabel.gridx = 1;
		gbc_payTitleLabel.gridy = 0;
		formPanel.add(payTitleLabel, gbc_payTitleLabel);
		
		monthAmountLabel = new JLabel("Ksh. "+formatter.format(calculateMonthlyPaid()));
		monthAmountLabel.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 18));
		GridBagConstraints gbc_monthAmountLabel = new GridBagConstraints();
		gbc_monthAmountLabel.insets = new Insets(0, 0, 5, 5);
		gbc_monthAmountLabel.gridx = 4;
		gbc_monthAmountLabel.gridy = 0;
		formPanel.add(monthAmountLabel, gbc_monthAmountLabel);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_6.gridx = 5;
		gbc_horizontalStrut_6.gridy = 0;
		formPanel.add(horizontalStrut_6, gbc_horizontalStrut_6);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea_2 = new GridBagConstraints();
		gbc_rigidArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_rigidArea_2.gridx = 2;
		gbc_rigidArea_2.gridy = 1;
		formPanel.add(rigidArea_2, gbc_rigidArea_2);
		
		JLabel fieldTitleLabel = new JLabel("Amount");
		fieldTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		GridBagConstraints gbc_fieldTitleLabel = new GridBagConstraints();
		gbc_fieldTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fieldTitleLabel.gridx = 1;
		gbc_fieldTitleLabel.gridy = 2;
		formPanel.add(fieldTitleLabel, gbc_fieldTitleLabel);
		
		amountField = new JTextField();
		GridBagConstraints gbc_amountField = new GridBagConstraints();
		gbc_amountField.insets = new Insets(0, 0, 5, 5);
		gbc_amountField.fill = GridBagConstraints.HORIZONTAL;
		gbc_amountField.gridx = 3;
		gbc_amountField.gridy = 2;
		formPanel.add(amountField, gbc_amountField);
		amountField.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 3;
		formPanel.add(verticalStrut_4, gbc_verticalStrut_4);
		
		JButton paymentButton = new JButton("Make Payment");
		paymentButton.addActionListener(e -> submitPayment());
		paymentButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		paymentButton.setForeground(new Color(49, 62, 79));
		paymentButton.setBorder(buttonBorder);
		GridBagConstraints gbc_paymentButton = new GridBagConstraints();
		gbc_paymentButton.insets = new Insets(0, 0, 0, 5);
		gbc_paymentButton.gridwidth = 5;
		gbc_paymentButton.gridx = 1;
		gbc_paymentButton.gridy = 4;
		formPanel.add(paymentButton, gbc_paymentButton);

	}

	private void submitPayment() {
		if(Objects.equals(amountField.getText(), "")) return;
		showLoadingScreen();
		double amountPaid = Double.parseDouble(amountField.getText());
		var repayment = new LoanRepayment(
				repaymentEvent.generateRepayId(),
				loan.getLoanId(),
				amountPaid
		);
		repaymentEvent.submitLoanToDatabase(repayment);
		updateStatus();
	}

	private double calculateMonthlyPaid() {
		var sqlStatement = String.format(
				"SELECT * FROM baraka_db.loan_repayment WHERE loan_id = \"%s\" and monthname(instance_created)='%s';",
				loan.getLoanId(),
				getCurrentMonth()
		);
		repaymentEvent.loadDataForDatabase(sqlStatement);

		return calculateAmountRepaid();
	}

	private void updateStatus() {
		monthAmountLabel.setText("Ksh. "+formatter.format(calculateMonthlyPaid()));

		String sqlStatement = String.format(
				"SELECT * FROM baraka_db.loan_repayment WHERE loan_id = \"%s\";",
				loan.getLoanId()
		);

		if(isLoanFullyPaid()) {
			String sqlUpdateStatement = String.format(
					"UPDATE baraka_db.loan SET is_paid = '1' WHERE (loan_id = \"%s\");",
					loan.getLoanId()
			);
		loanEvent.updateDatabase(sqlUpdateStatement);

		}
		amountPaidHolder.setText("Ksh. "+formatter.format(calculateAmountRepaid()));
		balanceHolder.setText("Ksh. "+formatter.format(calculateBalance()));
		repaymentEvent.loadDataForDatabase(sqlStatement);
		loan = MemberLoan.getActiveLoan();
	}

	private String getCurrentMonth() {
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		return currentMonth.toString();
	}

	private double calculateMonthlyPayment() {
		Period period = Period.between(loan.getCreated().toLocalDateTime().toLocalDate(), loan.getDueDate().toLocalDate());
		double months =  period.getYears()*12;
		double totalPay = calculateTotalPayment();
		return totalPay/months;
	}

	private double calculateInterest() {
		double period = Period.between(loan.getCreated().toLocalDateTime().toLocalDate(),
						loan.getDueDate().toLocalDate())
				.getYears()*12;
		double rate = loan.getInterestRate();
		double amount = loan.getAmountBorrowed();

		return (rate/100) * amount * period;
	}

	private double calculateTotalPayment() {
		return calculateInterest() + loan.getAmountBorrowed();
	}

	private double calculateAmountRepaid() {
		var repayments = LoanRepayment.getRepaymentsRecords();
		double totalRepay = 0;

		for (LoanRepayment repayment : repayments) {
			totalRepay += repayment.getAmountRepaid();
		}

		return totalRepay;
	}

	private double calculateBalance() {
		return calculateTotalPayment() - calculateAmountRepaid();
	}

	private boolean isLoanFullyPaid() {
		return calculateBalance() == 0;
	}

	private void showLoadingScreen() {
		frame.setVisible(true);

		SwingWorker<Boolean, Integer> swingWorker = new SwingWorker<>() {

			@Override
			protected Boolean doInBackground() throws Exception {
				// WARN: do not update the GUI from within doInBackground(), use process() / done()!

				// Do something ...
				// prepare url(p6, p_back, list, list.length);
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
				// handle published progress information / update UI
				AtomicInteger percent = new AtomicInteger();
				chunks.forEach(percent::set);
				frame.percentageLabel.setText(String.format("%s%%", percent));
				int progress = chunks.get(chunks.size() - 1);
				if (progress == 10) {
					frame.updateLabel.setText("Processing payment...");
				}

				if (progress == 20) {
					frame.updateLabel.setText("Loading Modules...");
				}

				if (progress == 50) {
					frame.updateLabel.setText("Connecting to Database...");
				}

				if (progress == 70) {
					frame.updateLabel.setText("Repayment Successful!");
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
