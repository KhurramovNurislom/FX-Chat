package uz.lb.models;

import uz.lb.enums.MessageContentType;
import java.sql.Date;

public class Message {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MessageContentType getContentType() {
        return contentType;
    }

    public void setContentType(MessageContentType contentType) {
        this.contentType = contentType;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserFromToId() {
        return userFromToId;
    }

    public void setUserFromToId(Long userFromToId) {
        this.userFromToId = userFromToId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Long id;
    private MessageContentType contentType;
    private Long messageId;
    private Long userFromToId;
    private Long toUserId;
    private Boolean visible = Boolean.TRUE;
    private Date createdAt;
    private Date updatedAt;
}
