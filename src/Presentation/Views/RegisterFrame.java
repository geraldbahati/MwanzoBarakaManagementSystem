package Presentation.Views;

import Data.Models.Enums.Gender;
import Data.Models.Member;
import Logic.MemberEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class RegisterFrame extends JFrame implements ActionListener {
    private final String pattern = "dd/MM/yyyy";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


    // Components of the Form
    private final Container formContainer;
    private final JLabel titleLabel;

    private final JLabel memberIdLabel;
    private final JLabel memberId;

    private final JLabel firstNameLabel;
    private final JTextField firstNameTextField;

    private final JLabel lastNameLabel;
    private final JTextField lastNameTextField;

    private final JLabel mobileNumberLabel;
    private final JTextField mobileNumberTextField;

    private final JLabel genderLabel;
    private final JRadioButton male;
    private final JRadioButton female;

    private final ButtonGroup genderButtonGroup;
    private final JLabel dateOfBirthLabel;
    private final JComboBox<String> date;
    private final JComboBox<String> month;
    private final JComboBox<String> year;
    private final JLabel emailLabel;
    private final JTextField emailTextField;
    private final JCheckBox term;
    private final JButton submitButton;
    private final JButton resetButton;
    private final JTextArea displayTextArea;
    private final JLabel feedbackLabel;
    private final JTextArea resultTextArea;

    private final String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private final String[] months
            = { "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private final String[] years
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };

    // constructor, to initialize the components
    // with default values.
    public RegisterFrame() {
        this.setTitle("Registration Form");
        this.setBounds(300, 90, 900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        formContainer = getContentPane();
        formContainer.setLayout(null);

        titleLabel = new JLabel("Registration Form");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        titleLabel.setSize(300, 30);
        titleLabel.setLocation(300, 30);
        formContainer.add(titleLabel);

        memberIdLabel = new JLabel("Member ID: ");
        memberIdLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        memberIdLabel.setSize(120, 20);
        memberIdLabel.setLocation(100, 100);
        formContainer.add(memberIdLabel);

        memberId = new JLabel("");
        memberId.setFont(new Font("Arial", Font.PLAIN, 18));
        memberId.setSize(100, 20);
        memberId.setLocation(220, 100);
        formContainer.add(memberId);

        firstNameLabel = new JLabel("First name");
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        firstNameLabel.setSize(100, 20);
        firstNameLabel.setLocation(100, 150);
        formContainer.add(firstNameLabel);

        firstNameTextField = new JTextField();
        firstNameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNameTextField.setSize(190, 20);
        firstNameTextField.setLocation(200, 150);
        formContainer.add(firstNameTextField);

        lastNameLabel = new JLabel("Last name");
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lastNameLabel.setSize(100, 20);
        lastNameLabel.setLocation(100, 200);
        formContainer.add(lastNameLabel);

        lastNameTextField = new JTextField();
        lastNameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameTextField.setSize(190, 20);
        lastNameTextField.setLocation(200, 200);
        formContainer.add(lastNameTextField);

        mobileNumberLabel = new JLabel("Mobile");
        mobileNumberLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mobileNumberLabel.setSize(100, 20);
        mobileNumberLabel.setLocation(100, 250);
        formContainer.add(mobileNumberLabel);

        mobileNumberTextField = new JTextField();
        mobileNumberTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        mobileNumberTextField.setSize(150, 20);
        mobileNumberTextField.setLocation(200, 250);
        formContainer.add(mobileNumberTextField);

        genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        genderLabel.setSize(100, 20);
        genderLabel.setLocation(100, 300);
        formContainer.add(genderLabel);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 300);
        formContainer.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 300);
        formContainer.add(female);

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);

        dateOfBirthLabel = new JLabel("DOB");
        dateOfBirthLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOfBirthLabel.setSize(100, 20);
        dateOfBirthLabel.setLocation(100, 350);
        formContainer.add(dateOfBirthLabel);

        date = new JComboBox<>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(70, 20);
        date.setLocation(200, 350);
        formContainer.add(date);

        month = new JComboBox<String>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(80, 20);
        month.setLocation(270, 350);
        formContainer.add(month);

        year = new JComboBox<>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(90, 20);
        year.setLocation(340, 350);
        formContainer.add(year);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailLabel.setSize(100, 20);
        emailLabel.setLocation(100, 400);
        formContainer.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailTextField.setSize(280, 20);
        emailTextField.setLocation(200, 400);
        formContainer.add(emailTextField);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 450);
        formContainer.add(term);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(150, 500);
        submitButton.addActionListener(this);
        formContainer.add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(270, 500);
        resetButton.addActionListener(this);
        formContainer.add(resetButton);

        displayTextArea = new JTextArea();
        displayTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        displayTextArea.setSize(300, 400);
        displayTextArea.setLocation(500, 100);
        displayTextArea.setLineWrap(true);
        displayTextArea.setEditable(false);
        formContainer.add(displayTextArea);

        feedbackLabel = new JLabel("");
        feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        feedbackLabel.setSize(500, 25);
        feedbackLabel.setLocation(100, 530);
        formContainer.add(feedbackLabel);

        resultTextArea = new JTextArea();
        resultTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        resultTextArea.setSize(200, 75);
        resultTextArea.setLocation(580, 175);
        resultTextArea.setLineWrap(true);
        formContainer.add(resultTextArea);

        this.setVisible(true);
    }

    private Date getMemberDOB() {
        String monthSelected = (String) month.getSelectedItem();
        String correspondingMonthIndex = null;

        assert monthSelected != null;
        if(!monthSelected.equals(""))
            correspondingMonthIndex = switch (monthSelected) {
                case "Jan" -> "1";
                case "Feb" -> "2";
                case "Mar" -> "3";
                case "Apr" -> "4";
                case "May" -> "5";
                case "Jun" -> "6";
                case "Jul" -> "7";
                case "Aug" -> "8";
                case "Sep" -> "9";
                case "Oct" -> "10";
                case "Nov" -> "11";
                case "Dec" -> "12";
                default -> "";
            };

        if (correspondingMonthIndex == null) return null;
        String stringDate =  (String) date.getSelectedItem()
        + "/" + correspondingMonthIndex
        + "/" + (String) year.getSelectedItem();
        try {
            return new Date(simpleDateFormat.parse(stringDate).getTime());
        } catch (Exception e){
            return null;
        }
    }

    private void runHomePage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeFrame frame = new HomeFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.dispose();
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submitButton) {
            if (term.isSelected()) {
                Gender gender = null;
                final String firstName = firstNameTextField.getText();
                final String lastName = lastNameTextField.getText();
                final String mobileNumber = mobileNumberTextField.getText();
                final String dateOfBirth = simpleDateFormat.format(getMemberDOB());
                final String email = emailTextField.getText();

                String data1;
                String data
                        = "Name : "
                        + firstName +
                        " " +
                        lastName + "\n"
                        + "Mobile : "
                        + mobileNumber + "\n";
                if (male.isSelected()) {
                    gender = Gender.Male;
                    data1 = "Gender : Male"
                            + "\n";
                }else{
                    gender = Gender.Female;
                    data1 = "Gender : Female"
                            + "\n";
                }
                String data2
                        = "DOB : "
                        + dateOfBirth
                        + "\n";

                String data3 = "Email : " + emailTextField.getText();
                displayTextArea.setText(data + data1 + data2 + data3);
                displayTextArea.setEditable(false);

                var memberInstance = new Member("",firstName,lastName, gender, getMemberDOB(),mobileNumber,email);
                System.out.println(memberInstance);
                System.out.println(memberInstance.toSqlStatement());
                new MemberEvent().submitMemberToDatabase(memberInstance);
                runHomePage();
                feedbackLabel.setText("Registration Successfully..");
            }
            else {
                displayTextArea.setText("");
                resultTextArea.setText("");
                feedbackLabel.setText("Please accept the terms & conditions..");
            }
        }

        else if (e.getSource() == resetButton) {
            String defaultValue = "";
            firstNameTextField.setText(defaultValue);
            lastNameTextField.setText(defaultValue);
            emailTextField.setText(defaultValue);
            mobileNumberTextField.setText(defaultValue);
            feedbackLabel.setText(defaultValue);
            displayTextArea.setText(defaultValue);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            resultTextArea.setText(defaultValue);
        }
    }
}

