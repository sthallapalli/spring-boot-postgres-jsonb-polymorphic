package com.srinivas.document.model.bankstatement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.srinivas.document.enums.DocumentType;
import com.srinivas.document.model.common.Amount;
import com.srinivas.document.model.common.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankStatement extends Document {

    private String accountHolder;
    private BankInformation bankInformation;

    private Date startDate;
    private Date endDate;

    private Amount residue;
    private Amount overdraftLimit;
    private List<Amount> returnDebit;

    private Income incomes;
    private Outcome outcomes;

    public BankStatement() {
        super(DocumentType.BANK_STATEMENT);
    }
}
