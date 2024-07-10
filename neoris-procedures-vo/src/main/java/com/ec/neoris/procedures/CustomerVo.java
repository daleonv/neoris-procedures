package com.ec.neoris.procedures;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVo {
    private String names;
    private String address;
    private String phone;
    private String password;
    private String status;

}
