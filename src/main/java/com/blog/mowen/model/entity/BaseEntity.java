package com.blog.mowen.model.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name = "cdate")
    private LocalDateTime cdate;

    @Column(name = "edate")
    private LocalDateTime edate;

    @PrePersist
    public void prePersist() {
        cdate = LocalDateTime.now();
        edate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        edate = LocalDateTime.now();
    }
}
