package com.ec.neoris.procedures.services;

import com.ec.neoris.procedures.AccountStatusRequestVo;
import com.ec.neoris.procedures.AccountStatusResponseVo;

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
