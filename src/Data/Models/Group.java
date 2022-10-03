package Data.Models;

import java.sql.Timestamp;
import java.time.Instant;

public class Group {
    private String groupId;
    private String groupName = "";
    private Timestamp created;
    private Timestamp updated;


    public Group(String groupId) {
        setCreated(Timestamp.from(Instant.now()));

        setGroupId(groupId);
    }

    public Group(String groupId, String groupName, Timestamp created, Timestamp updated) {
        setCreated(Timestamp.from(Instant.now()));

        setGroupId(groupId);
        setGroupName(groupName);
        setCreated(created);
        setUpdated(updated);
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

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
