package Presentation.Views;

import Data.Models.Group;
import Data.Models.Member;
import Logic.GroupEvent;
import Logic.MemberEvent;
import Presentation.Widgets.TextBubbleBorder;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public class GroupRegFee extends JFrame {
	private final MemberEvent memberEvent = new MemberEvent();
	private final GroupEvent groupEvent = new GroupEvent();

	private Group createdGroup;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param group
	 */
	public GroupRegFee(Group group) {
		createdGroup = group;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(291, 444));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 16, 259, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel paymentHeaderLabel = new JLabel("Registration Fee Details");
		paymentHeaderLabel.setBounds(24, 5, 221, 28);
		paymentHeaderLabel.setFont(new Font("Hiragino Sans GB", Font.BOLD, 18));
		panel.add(paymentHeaderLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 21, 221, 12);
		panel.add(separator);
		
		JPanel infoDisplayPanel = new JPanel();
		AbstractBorder panelBorder = new TextBubbleBorder(new Color(49, 62, 79),2,30,0);
		infoDisplayPanel.setBorder(panelBorder);
		infoDisplayPanel.setForeground(SystemColor.text);
		infoDisplayPanel.setBackground(new Color(49, 62, 79));
		infoDisplayPanel.setBounds(16, 103, 259, 181);
		contentPane.add(infoDisplayPanel);
		infoDisplayPanel.setLayout(null);
		
		JLabel needLabel = new JLabel("You need to pay");
		needLabel.setForeground(SystemColor.text);
		needLabel.setBounds(30, 30, 132, 21);
		needLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		infoDisplayPanel.add(needLabel);
		
		JLabel regFeeLabel = new JLabel("Ksh. 5000");
		regFeeLabel.setForeground(SystemColor.text);
		regFeeLabel.setBounds(30, 56, 85, 21);
		regFeeLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		infoDisplayPanel.add(regFeeLabel);
		
		JTextArea txtrOnceThePayment = new JTextArea();
		txtrOnceThePayment.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtrOnceThePayment.setForeground(SystemColor.text);
		txtrOnceThePayment.setOpaque(false);
		txtrOnceThePayment.setWrapStyleWord(true);
		txtrOnceThePayment.setLineWrap(true);
		txtrOnceThePayment.setText("Once the payment is done from your end, we immediately initiate the process of group registration.");
		txtrOnceThePayment.setBounds(30, 89, 200, 72);
		infoDisplayPanel.add(txtrOnceThePayment);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(16, 334, 259, 62);
		contentPane.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(0, 0, 0, 0);
		buttonsPanel.add(verticalStrut);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(6, 13, 81, 40);
		AbstractBorder cancelButtonBorder = new TextBubbleBorder(Color.WHITE,2,16,0);
		cancelButton.setBorder(cancelButtonBorder);
		cancelButton.setForeground(new Color(56, 72, 92));
		cancelButton.setFocusable(false);
		cancelButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonsPanel.add(cancelButton);
		
		JButton payButton = new JButton("Pay Ksh. 5000");
		payButton.setOpaque(true);
		payButton.setBounds(117, 13, 136, 40);
		AbstractBorder payButtonBorder = new TextBubbleBorder(new Color(56, 72, 92),2,16,0);
		payButton.setBorder(payButtonBorder);
		payButton.setForeground(SystemColor.text);
		payButton.setBackground(new Color(56, 72, 92));
		payButton.setFocusable(false);
		payButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		payButton.addActionListener(e->{
			registerGroup();
		});
		buttonsPanel.add(payButton);
	}

	private void registerGroup() {
		groupEvent.submitGroupToDatabase(createdGroup);
		groupEvent.submitRegistrationFee(createdGroup);

		var groupMembers = Member.getCreatedMemberRecords();

		for (Object member : groupMembers) {
			memberEvent.submitMemberToDatabase((Member) member);
		}


		GroupFrame.disposeWindow();
		runHomePage();
	}

	private void runHomePage() {
		EventQueue.invokeLater(() -> {
			try {
				HomeFrame frame = new HomeFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		this.dispose();
	}

}
