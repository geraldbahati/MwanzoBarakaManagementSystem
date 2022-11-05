package Presentation.Views;

import Data.Models.Member;
import Data.Models.Shares;
import Logic.MemberEvent;
import Logic.SharesEvent;
import Presentation.Widgets.MonthSharesPanel;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.GridLayout;

public class SharesReportFrame extends JFrame {

	private JPanel contentPane;

	private final String[] months = {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
	};
	private Member activeMember = null;
	private final SharesEvent sharesEvent = new SharesEvent();
	private JPanel bodyPanel;

	private void initState(){
		activeMember = MemberEvent.getMember();
	}


	/**
	 * Create the frame.
	 */
	public SharesReportFrame() {
		initState();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(623, 618);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(6, 6, 610, 64);
		contentPane.add(titlePanel);
		
		JLabel titleLabel = new JLabel("Shares Contribution for "+activeMember.getFirstName()+" "+activeMember.getLastName());
		titleLabel.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 24));
		titlePanel.add(titleLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 82, 610, 502);
		contentPane.add(scrollPane);
		
		bodyPanel = new JPanel();
		scrollPane.setViewportView(bodyPanel);
		bodyPanel.setLayout(new GridLayout(0, 1, 0, 0));

		createAppropriateUtils();
	}

	private final ArrayList<JLabel> monthTitleLabels = new ArrayList<>();
	private final ArrayList<GridBagConstraints> monthTitleConstraints = new ArrayList<>();

	private final ArrayList<JLabel> monthLabels = new ArrayList<>();
	private final ArrayList<GridBagConstraints> monthConstraints = new ArrayList<>();

	private final ArrayList<JLabel> totalTitleLabels = new ArrayList<>();
	private final ArrayList<GridBagConstraints> totalTitleConstraints = new ArrayList<>();

	private final ArrayList<JLabel> totalLabels =new ArrayList<>();
	private final ArrayList<GridBagConstraints> totalConstraints = new ArrayList<>();

	private final ArrayList<Component> aboveVerticalStructs = new ArrayList<>();
	private final ArrayList<GridBagConstraints> aboveConstraints = new ArrayList<>();

	private final ArrayList<Component> belowVerticalStructs = new ArrayList<>();
	private final ArrayList<GridBagConstraints> belowConstraints = new ArrayList<>();

	private final ArrayList<JLabel> sharesIDLabels = new ArrayList<>();
	private final ArrayList<GridBagConstraints> sharesIDConstraints = new ArrayList<>();

	private final ArrayList<JLabel> dateLabels = new ArrayList<>();
	private final ArrayList<GridBagConstraints> dateConstraints = new ArrayList<>();

	private final ArrayList<JLabel>  amountLabels = new ArrayList<>();
	private final ArrayList<GridBagConstraints> amountConstraints = new ArrayList<>();

	private final ArrayList<JSeparator> separators = new ArrayList<>();
	private final ArrayList<GridBagConstraints> separatorConstraints = new ArrayList<>();

	private void createAppropriateUtils() {
		int activeMonthIndex = 0;

		for (String month : months) {
			String sqlStatement = String.format(
					"SELECT * FROM baraka_db.shares_contribution WHERE member_id = \"%s\" AND  monthname(instance_created)='%s';",
					activeMember.getMemberID(),
					month
			);

			sharesEvent.loadDataForDatabase(sqlStatement);
			if(!Shares.getMemberShares().isEmpty()){
				double totalMonthlyShares = 0;

				var shares = Shares.getMemberShares();
				bodyPanel.add(new MonthSharesPanel(month,shares));
			}
		}
	}
}
