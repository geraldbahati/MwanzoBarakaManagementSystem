package Data.Models;

import Data.Models.Enums.Gender;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

public class Member {
    private static final String tableTitle = "member";
    private static final ArrayList<Member> memberRecords = new ArrayList<>();
    private static final String tableFields =
        "first_name, " +
        "last_name, " +
        "gender, " +
        "date_of_birth, " +
        "mobile_number, " +
        "email, " +
        "member_created, " +
        "member_updated";
    private static final String pattern = "MM/dd/yyyy";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

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

    public Member(String memberID, String firstName, String lastName, Gender gender, Date dateOfBirth, String mobileNumber, String email) {
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

        memberRecords.add(this);
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



    public String toSqlStatement() {
        StringBuilder tableValues = new StringBuilder("");
        for(String ignored : tableFields.split(",")){
            tableValues.append("?,");
        }
        tableValues.deleteCharAt(tableValues.length() - 1);

        return String.format("INSERT INTO %s (%s) VALUE (%s)", tableTitle, tableFields, tableValues.toString());

    }

    public static void fromDatabase(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                var member = new Member(
                        resultSet.getString("member_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        Gender.valueOf(resultSet.getString("gender")),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getString("mobile_number"),
                        resultSet.getString("email")
                );
                member.setAssociatedGroup(new Group(resultSet.getString("group_id")));
                member.setCreated(resultSet.getTimestamp("member_created"));
                member.setUpdated(resultSet.getTimestamp("member_updated"));
            }

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + simpleDateFormat.format(dateOfBirth) +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", associatedGroup=" + associatedGroup +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
