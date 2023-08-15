package com.playdata.pdfolio.global.domain.entity;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;
    private Boolean isDeleted=false;
    public void deleteColumn(){
        if(isDeleted){
            throw new RuntimeException("이미 삭제된 컬럼..");
        }
        this.deletedAt = LocalDateTime.now();
        this.isDeleted = true;
    }
}