package Presentation.Widgets;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class GroupMemberPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GroupMemberPanel() {
		setLayout(null);
		
		JPanel detailPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) detailPanel.getLayout();
		flowLayout.setHgap(50);
		detailPanel.setBounds(6, 6, 273, 34);
		add(detailPanel);
		
		JLabel memberIdLabel = new JLabel("M-001");
		memberIdLabel.setForeground(SystemColor.textHighlight);
		memberIdLabel.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		detailPanel.add(memberIdLabel);
		
		JLabel memberNameLabel = new JLabel("Gerald Bahati");
		memberNameLabel.setFont(new Font("Noto Sans Myanmar", Font.PLAIN, 16));
		detailPanel.add(memberNameLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 41, 273, 12);
		add(separator);

	}
}
