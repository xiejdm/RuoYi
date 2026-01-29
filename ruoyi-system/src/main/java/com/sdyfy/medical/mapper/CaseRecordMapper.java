package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.CaseRecord;
import java.util.List;

/**
 * 医案Mapper
 */
public interface CaseRecordMapper
{
    CaseRecord selectCaseRecordById(Long id);

    List<CaseRecord> selectCaseRecordList(CaseRecord caseRecord);

    CaseRecord selectCaseRecordByCaseCode(String caseCode);

    int insertCaseRecord(CaseRecord caseRecord);

    int updateCaseRecord(CaseRecord caseRecord);

    int deleteCaseRecordById(Long id);

    int deleteCaseRecordByIds(Long[] ids);
}
