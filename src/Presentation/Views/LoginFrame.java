package Presentation.Views;

import Data.Models.Enums.Gender;
import Data.Models.Group;
import Data.Models.Member;
import Data.Models.MemberLoan;
import Logic.MemberEvent;
import Logic.SaveLoadEvent;
import Presentation.Widgets.TextBubbleBorder;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private final MemberEvent memberEvent = new MemberEvent();
	private final SaveLoadEvent saveLoadEvent = new SaveLoadEvent();
	private JComboBox membersComboBox;

	private void initState() {
		saveLoadEvent.deleteSavedFile();
		var sqlStatement = "SELECT * FROM baraka_db.member;";
		memberEvent.loadDataForDatabase(sqlStatement);
	}


	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		initState();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		AbstractBorder buttonBorder = new TextBubbleBorder(new Color(49, 62, 79),2,16,0);
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBounds(6, 6, 438, 56);
		contentPane.add(TitlePanel);
		
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(new Font("Noto Sans Myanmar", Font.BOLD, 20));
		TitlePanel.add(titleLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(6, 74, 438, 123);
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JLabel selectTitleLabel = new JLabel("Select a member Id");
		selectTitleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		selectTitleLabel.setBounds(27, 34, 142, 16);
		bodyPanel.add(selectTitleLabel);
		
		membersComboBox = new JComboBox(Member.getMemberRecords().toArray());
		membersComboBox.setBounds(194, 31, 223, 27);
		bodyPanel.add(membersComboBox);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(6, 195, 438, 71);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> updateUser());
		loginButton.setOpaque(true);
		loginButton.setBackground(new Color(49, 62, 79));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		loginButton.setBounds(53, 6, 119, 50);
		loginButton.setBorder(buttonBorder);
		buttonPanel.add(loginButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(e -> {
		});
		cancelButton.setOpaque(true);
		cancelButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		cancelButton.setBounds(261, 5, 119, 51);
		cancelButton.setBorder(buttonBorder);
		buttonPanel.add(cancelButton);
	}

	private void updateUser() {
		if(membersComboBox == null) return;
		Member member = (Member) membersComboBox.getSelectedItem();
		assert member != null;
		MemberEvent.setMember(member);
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
