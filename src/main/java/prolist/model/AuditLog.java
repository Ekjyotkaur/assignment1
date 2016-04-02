package prolist.model;

import java.time.LocalDateTime;

/**
 * Created by yli on 23/02/2016.
 */
public class AuditLog extends SeriablizableEntity {

    public enum Changes {
        CREATE, MODIFY, DELETE
    }

    private Long proposalId;

    private LocalDateTime modifiedTime;

    private User user;

    private Changes typeOfChange;

    private String fields;

    public AuditLog() {
    }

    public AuditLog(Long proposalId) {
        this.proposalId = proposalId;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {

        if (proposalId == null)
            throw new IllegalArgumentException("Proposal Id cannot be null");
        this.proposalId = proposalId;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Changes getTypeOfChange() {
        return typeOfChange;
    }

    public void setTypeOfChange(Changes typeOfChange) {

        if(!typeOfChange.equals("CREATE") || !typeOfChange.equals("MODIFY")||!typeOfChange.equals("DELETE"))
            throw new IllegalArgumentException("Invalid Audit Change");

        this.typeOfChange = typeOfChange;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
