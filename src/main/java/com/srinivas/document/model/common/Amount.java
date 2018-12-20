package com.srinivas.document.model.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.srinivas.document.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Amount {

    private Double amount;
    private String currency = CurrencyType.EURO.name();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
}
