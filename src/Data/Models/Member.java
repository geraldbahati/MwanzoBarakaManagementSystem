package Data.Models;

import Data.Models.Enums.Gender;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Member {
    private static final String tableTitle = "member";
    private static final String registrationFeeTableName = "member_registration";
    private static ArrayList<Member> memberRecords = new ArrayList<>();
    private static final ArrayList<Member> createdMemberInstances = new ArrayList<>();
    private static final String tableFields =
        "member_id, " +
        "first_name, " +
        "last_name, " +
        "gender, " +
        "date_of_birth, " +
        "mobile_number, " +
        "email, " +
        "group_id, " +
        "member_created, " +
        "member_updated";

    private static final String registrationFields =
            "member_id, " +
            "registration_fee, " +
            "instance_created, " +
            "instance_updated";

    private static final String pattern = "MM/dd/yyyy";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private static final double registrationFee = 3000.00;

    private String memberID;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;
    private String mobileNumber;
    private String email;
    private Group associatedGroup = null;
    private Timestamp created;
    private Timestamp updated;

    public Member(
            String memberID,
            String firstName,
            String lastName,
            Gender gender,
            Date dateOfBirth,
            String mobileNumber,
            String email,
            Group associatedGroup
    ) {
        setCreated(Timestamp.from(Instant.now()));
        setMemberID(memberID);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
        setMobileNumber(mobileNumber);
        setMobileNumber(mobileNumber);
        setDateOfBirth(dateOfBirth);
        setAssociatedGroup(associatedGroup);

        memberRecords.add(this);
        createdMemberInstances.add(this);
    }

    public Member(String memberID,
                  String firstName,
                  String lastName,
                  Gender gender,
                  Date dateOfBirth,
                  String mobileNumber,
                  String email,
                  Group associatedGroup,
                  Timestamp created,
                  Timestamp updated) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.associatedGroup = associatedGroup;
        this.created = created;
        this.updated = updated;
    }

    public static double getRegistrationFee() {
        return registrationFee;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        setUpdated(Timestamp.from(Instant.now()));
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        setUpdated(Timestamp.from(Instant.now()));
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        setUpdated(Timestamp.from(Instant.now()));
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        setUpdated(Timestamp.from(Instant.now()));
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        setUpdated(Timestamp.from(Instant.now()));
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        setUpdated(Timestamp.from(Instant.now()));
        this.email = email;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(getDateOfBirth().toLocalDate(),currentDate).getYears();
    }

    public Group getAssociatedGroup() {
        return associatedGroup;
    }

    public void setAssociatedGroup(Group associatedGroup) {
        setUpdated(Timestamp.from(Instant.now()));
        this.associatedGroup = associatedGroup;
    }

    public String getGender() {
        return gender.name();
    }

    public void setGender(Gender gender) {
        setUpdated(Timestamp.from(Instant.now()));
        this.gender = gender;
    }

    public static Object[] getMemberRecords() {
        return memberRecords.toArray();
    }

    public static ArrayList<Member> getCreatedMemberRecords() {
        return createdMemberInstances;
    }

    public static Member getActiveUser(){
        return memberRecords.get( memberRecords.size() - 1);
    }

    public static String generateMemberId() {
        if (memberRecords.size() == 0) return "M-001";
        var lastData = memberRecords.get(memberRecords.size() - 1);
        String lastMemberID = lastData.getMemberID();
        int newIndex = Integer.parseInt(lastMemberID.split("-")[1]) + 1;
        return "M-" + String.format("%03d",newIndex);
    }

    public String getRegistrationSQL() {
        StringBuilder tableValues = new StringBuilder();
        for(String ignored : registrationFields.split(",")){
            tableValues.append("?,");
        }
        tableValues.deleteCharAt(tableValues.length() - 1);

        return String.format("INSERT INTO %s (%s) VALUE (%s)", registrationFeeTableName, registrationFields, tableValues);
    }

    public String toSqlStatement() {
        StringBuilder tableValues = new StringBuilder();
        for(String ignored : tableFields.split(",")){
            tableValues.append("?,");
        }
        tableValues.deleteCharAt(tableValues.length() - 1);

        return String.format("INSERT INTO %s (%s) VALUE (%s)", tableTitle, tableFields, tableValues);
    }

    public static void fromDatabase(ResultSet resultSet) {
        memberRecords = new ArrayList<>();
        try {
            while (resultSet.next()) {
                var member = new Member(
                        resultSet.getString("member_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        Gender.valueOf(resultSet.getString("gender")),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getString("mobile_number"),
                        resultSet.getString("email"),
                        new Group(resultSet.getString("group_id")),
                        resultSet.getTimestamp("member_created"),
                        resultSet.getTimestamp("member_updated")
                );
                memberRecords.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s\t%s",
                memberID,
                (String.format("%s %s", firstName, lastName)));
    }

//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "memberID='" + memberID + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", gender=" + gender +
//                ", dateOfBirth=" + dateOfBirth +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", email='" + email + '\'' +
//                ", associatedGroup=" + associatedGroup +
//                '}';
//    }
}
