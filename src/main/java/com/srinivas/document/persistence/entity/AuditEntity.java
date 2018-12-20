package com.srinivas.document.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


@Data
@Embeddable
public class AuditEntity {

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updateAt;

    @PrePersist
    public void prePersist() {
        Date date = new Date();
        this.createdAt = date;
        this.updateAt = date;
    }

    @PreUpdate
    public void preUpdate() {
        this.createdAt = new Date();
    }
}
