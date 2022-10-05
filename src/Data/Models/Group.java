package Data.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class Group {
    private static final String tableTitle = "group";
    private static final ArrayList<Group> groupRecords = new ArrayList<>();
    private static final String tableFields =
            "group_id, " +
            "group_name, " +
            "instance_created, " +
            "instance_updated";

    private String groupId;
    private String groupName = "";
    private Timestamp created;
    private Timestamp updated;

    public Group(String groupId) {
        setCreated(Timestamp.from(Instant.now()));

        setGroupId(groupId);
    }

    public Group(String groupId, String groupName) {
        setCreated(Timestamp.from(Instant.now()));

        setGroupId(groupId);
        setGroupName(groupName);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        setUpdated(Timestamp.from(Instant.now()));
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        setUpdated(Timestamp.from(Instant.now()));
        this.groupName = groupName;
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
                var group = new Group(
                        resultSet.getString("group_id"),
                        resultSet.getString("group_name")
                );
                group.setCreated(resultSet.getTimestamp("instance_created"));
                group.setUpdated(resultSet.getTimestamp("instance_updated"));

                groupRecords.add(group);
            }

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
