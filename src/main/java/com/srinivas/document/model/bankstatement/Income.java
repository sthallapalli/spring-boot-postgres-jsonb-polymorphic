package com.srinivas.document.model.bankstatement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.srinivas.document.model.common.Amount;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Income {

    private List<Amount> salary;
    private List<Amount> childrenAllowance;
}
