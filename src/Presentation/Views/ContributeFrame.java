package Presentation.Views;

import Data.Models.Member;
import Data.Models.Shares;
import Logic.MemberEvent;
import Logic.SharesEvent;
import Presentation.Widgets.SharesPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class ContributeFrame extends JFrame {

	private JPanel contentPane;
	private final JTextField amountEntered;

	private final SharesEvent sharesEvent = new SharesEvent();
	private Member activeMember = null;

	private final DecimalFormat formatter = new DecimalFormat("#,###.00");

	private void initState() {
		activeMember = MemberEvent.getMember();
		var sqlStatement = String.format(
				"SELECT * FROM baraka_db.shares_contribution WHERE member_id = \"%s\" AND  monthname(instance_created)='%s';",
				activeMember.getMemberID(),
				getCurrentMonth()
		);
		sharesEvent.loadDataForDatabase(sqlStatement);
	}
	/**
	 * Create the frame.
	 */
	public ContributeFrame(SharesPanel sharesPanel) {
		initState();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(524, 230);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel amountDisplayPanel = new JPanel();
		amountDisplayPanel.setBounds(5, 5, 512, 49);
		contentPane.add(amountDisplayPanel);
		amountDisplayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel detailLabel = new JLabel("This Month Contribution: ");
		detailLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		amountDisplayPanel.add(detailLabel);
		
		JLabel monthContLabel = new JLabel(calculateMonthShares());
		monthContLabel.setForeground(SystemColor.textHighlight);
		monthContLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		amountDisplayPanel.add(monthContLabel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(5, 55, 512, 91);
		contentPane.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter amount");
		lblNewLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 16));
		lblNewLabel.setBounds(115, 36, 130, 21);
		formPanel.add(lblNewLabel);
		
		amountEntered = new JTextField();
		amountEntered.setBounds(279, 22, 196, 42);
		formPanel.add(amountEntered);
		amountEntered.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 147, 512, 49);
		contentPane.add(panel);
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(e -> {
			if (Objects.equals(amountEntered.getText(), "") || activeMember == null) return;

			double amountContributed = Double.parseDouble(amountEntered.getText());
			var share = new Shares(
					sharesEvent.generateSharesId(),
					activeMember.getMemberID(),
					amountContributed
			);
			submitShares(share);
			dispose();
			sharesPanel.updateStatus();
		});
		panel.add(applyButton);
	}

	private String getCurrentMonth() {
		LocalDate currentDate = LocalDate.now();
		Month currentMonth = currentDate.getMonth();
		return currentMonth.toString();
	}

	private String calculateMonthShares() {
		var shares = Shares.getMemberShares();
		double totalShares = 0;

		for (Shares share : shares) {
			totalShares+=share.getAmountContributed();
		}
		return "Ksh. "+ formatter.format(totalShares);
	}

	private void submitShares(Shares shares) {
		sharesEvent.submitContributionToDatabase(shares);
	}
}
