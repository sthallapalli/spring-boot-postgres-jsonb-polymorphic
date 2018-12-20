package com.srinivas.document.model.bankstatement;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankInformation {

    private String bankName;
    private String iban;
    private String bic;
}
