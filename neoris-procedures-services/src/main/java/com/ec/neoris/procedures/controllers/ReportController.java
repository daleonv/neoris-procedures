package com.ec.neoris.procedures.controllers;

import com.ec.neoris.procedures.AccountStatusRequestVo;
import com.ec.neoris.procedures.AccountStatusResponseVo;
import com.ec.neoris.procedures.config.Response;
import com.ec.neoris.procedures.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reportes")
@Lazy
public class ReportController {
    @Lazy
    @Autowired
    private IReportService reportService;

    @PostMapping("")
    public ResponseEntity<Response<List<AccountStatusResponseVo>>> findAccountStatus(@RequestBody AccountStatusRequestVo filter) {
        return new ResponseEntity<>(Response.<List<AccountStatusResponseVo>>builder()
                .data(reportService.findAccountStatus(filter))
                .code(HttpStatus.OK.value())
                .build(), HttpStatus.OK);
    }

}
