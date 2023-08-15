package com.playdata.pdfolio.global.domain.entity;


import com.playdata.pdfolio.global.exception.CommonException;
import com.playdata.pdfolio.global.exception.CommonExceptionMessage;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;
    private Boolean isDeleted=false;
    public void deleteColumn(){
        if(isDeleted){
            throw new CommonException(CommonExceptionMessage.COLUMN_ALREADY_DELETED);
        }
        this.deletedAt = LocalDateTime.now();
        this.isDeleted = true;
    }
}