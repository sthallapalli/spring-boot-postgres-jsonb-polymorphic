package com.srinivas.document.model.payroll;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.srinivas.document.enums.DocumentType;
import com.srinivas.document.model.bankstatement.BankInformation;
import com.srinivas.document.model.common.Amount;
import com.srinivas.document.model.common.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payroll extends Document {

    private Employee employee;
    private Employer employer;
    private String payoutMonth;
    private Amount payout;
    private Amount netSalary;
    private String socialInsuranceNumber;

    private BankInformation bankInformation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date entryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date exitDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date payoutStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date payoutEndDate;

    public Payroll() {
        super(DocumentType.PAYROLL);
    }
}
