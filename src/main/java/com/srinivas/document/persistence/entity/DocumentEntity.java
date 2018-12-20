package com.srinivas.document.persistence.entity;

import com.srinivas.document.enums.DocumentType;
import com.srinivas.document.model.common.Document;
import com.srinivas.document.persistence.type.JsonbType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


@Data
@Entity
@Builder
@Table(name = "document", schema = "document")
@TypeDef(name = "jsonb", typeClass = JsonbType.class,
        parameters = {@Parameter(name = JsonbType.CLASS, value = "com.srinivas.document.model.common.Document")})
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity extends DefaultEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "data", nullable = false)
    @Type(type = "jsonb")
    private Document data;

    @Embedded
    @Builder.Default
    private AuditEntity audit = new AuditEntity();

}