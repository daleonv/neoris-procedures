package com.ec.test.procedures.services;

import com.ec.test.procedures.AccountStatusRequestVo;
import com.ec.test.procedures.AccountStatusResponseVo;

import java.util.List;

/**
 * Service interface for reports resources
 *
 * @author dalonv
 * @version 1.0
 */
public interface IReportService {

    /**
     * Return account status
     *
     * @param filters AccountStatusRequestVo
     * @return List<AccountStatusRequestVo>
     */
    List<AccountStatusResponseVo> findAccountStatus(AccountStatusRequestVo filters);

}
