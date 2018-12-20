package com.srinivas.document.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.srinivas.document.enums.DocumentType;
import com.srinivas.document.model.bankstatement.BankStatement;
import com.srinivas.document.model.payroll.Payroll;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BankStatement.class, name = "BANK_STATEMENT"),
    @JsonSubTypes.Type(value = Payroll.class, name = "PAYROLL")
})
public abstract class Document {

    private DocumentType type;

    protected Document(DocumentType documentType) {
        this.type = documentType;
    }

    public DocumentType getType() {
        return this.type;
    }

}
