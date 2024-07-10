package com.ec.test.procedures;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatusRequestVo {
    private Date initialDate;
    private Date endDate;
    private Long customerId;

}
