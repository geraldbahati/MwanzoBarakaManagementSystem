package Data.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupMember {
    private static final String tableTitle = "member";
    private static ArrayList<GroupMember> memberRecords;
    private static final String tableFields =
            "member_id, " +
            "first_name, " +
            "last_name" ;

    private String memberID;
    private String memberName;

    public GroupMember(String memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public static String getTableFields() {
        return tableFields;
    }

    public static String getTableName() {
        return tableTitle;
    }

    public static ArrayList<GroupMember> getGroupMembersList(){
        return memberRecords;
    }

    public static void fromDatabase(ResultSet resultSet) {
        try {
            memberRecords = new ArrayList<>();
            while (resultSet.next()) {
                var member = new GroupMember(
                        resultSet.getString("member_id"),
                        resultSet.getString("first_name") + " " + resultSet.getString("last_name")
                );
                memberRecords.add(member);
            }

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "GroupMember{" +
                "memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
