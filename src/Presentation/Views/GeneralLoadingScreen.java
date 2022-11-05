package Presentation.Views;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class GeneralLoadingScreen extends JFrame {

	private JPanel contentPane;
	public JLabel percentageLabel;
	public JLabel updateLabel;
	public JProgressBar loadingBar;


	/**
	 * Create the frame.
	 */
	public GeneralLoadingScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(450, 174));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 134);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(194, 5, 50, 50);
		ImageIcon loadingIconImage = new ImageIcon(new ImageIcon("/Users/geraldbahati/Desktop/programming/MwanzoBarakaManagementSystem/src/Data/Utilities/loading-bar.png")
				.getImage()
				.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		imageLabel.setIcon(loadingIconImage);
		panel.add(imageLabel);
		
		loadingBar = new JProgressBar();
		loadingBar.setBounds(6, 108, 426, 20);
		panel.add(loadingBar);
		
		updateLabel = new JLabel("Loading...");
		updateLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 14));
		updateLabel.setBounds(24, 79, 260, 27);
		panel.add(updateLabel);

		percentageLabel = new JLabel();
		percentageLabel.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 14));
		percentageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		percentageLabel.setBounds(330, 82, 82, 20);
		panel.add(percentageLabel);


	}

}
