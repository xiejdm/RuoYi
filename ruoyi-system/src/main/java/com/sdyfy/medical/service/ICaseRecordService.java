package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.CaseRecord;
import java.util.List;

/**
 * 医案服务
 */
public interface ICaseRecordService
{
    CaseRecord selectCaseRecordById(Long id);

    List<CaseRecord> selectCaseRecordList(CaseRecord caseRecord);

    boolean checkCaseCodeUnique(CaseRecord caseRecord);

    int insertCaseRecord(CaseRecord caseRecord);

    int updateCaseRecord(CaseRecord caseRecord);

    int deleteCaseRecordByIds(String ids);

    int deleteCaseRecordById(Long id);
}
