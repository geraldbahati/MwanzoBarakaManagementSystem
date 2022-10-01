package Data.Models;

import java.sql.Timestamp;

public class Group {
    private String groupId;
    private String groupName;
    private Timestamp created;
    private Timestamp updated;

    public Group(String groupId, String groupName, Timestamp created, Timestamp updated) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.created = created;
        this.updated = updated;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
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

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
