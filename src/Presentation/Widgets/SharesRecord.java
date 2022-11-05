package Presentation.Widgets;

import Data.Models.Shares;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JSeparator;

public class SharesRecord extends JPanel {

	/**
	 * Create the panel.
	 */
	public SharesRecord(Shares shares) {
		setLayout(null);
		
		JPanel detailPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) detailPanel.getLayout();
		flowLayout.setHgap(60);
		detailPanel.setBounds(6, 0, 547, 31);
		add(detailPanel);
		
		JLabel memberIDHolder = new JLabel(shares.getContributionId());
		detailPanel.add(memberIDHolder);
		memberIDHolder.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));

		String pattern = "dd MMMM, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		JLabel dateHolder = new JLabel(simpleDateFormat.format(shares.getCreated()));
		detailPanel.add(dateHolder);
		dateHolder.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));

		DecimalFormat formatter = new DecimalFormat("#,###.00");
		JLabel amountLabel = new JLabel("Ksh. "+ formatter.format(shares.getAmountContributed()));
		detailPanel.add(amountLabel);
		amountLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 36, 547, 12);
		add(separator);

	}

}
