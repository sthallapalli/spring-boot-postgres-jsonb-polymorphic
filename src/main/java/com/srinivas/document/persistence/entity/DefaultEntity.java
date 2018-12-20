package com.srinivas.document.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */

@Data
@MappedSuperclass
public abstract class DefaultEntity<ID> implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

}