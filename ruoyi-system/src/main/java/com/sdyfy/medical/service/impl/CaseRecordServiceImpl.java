package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.CaseRecord;
import com.sdyfy.medical.mapper.CaseRecordMapper;
import com.sdyfy.medical.service.ICaseRecordService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医案服务
 */
@Service
public class CaseRecordServiceImpl implements ICaseRecordService
{
    private static final Set<String> ALLOWED_GENDERS = new HashSet<>(Arrays.asList("0", "1", "2", "M", "F"));

    @Autowired
    private CaseRecordMapper caseRecordMapper;

    @Override
    public CaseRecord selectCaseRecordById(Long id)
    {
        return caseRecordMapper.selectCaseRecordById(id);
    }

    @Override
    public List<CaseRecord> selectCaseRecordList(CaseRecord caseRecord)
    {
        return caseRecordMapper.selectCaseRecordList(caseRecord);
    }

    @Override
    public boolean checkCaseCodeUnique(CaseRecord caseRecord)
    {
        Long id = StringUtils.isNull(caseRecord.getId()) ? -1L : caseRecord.getId();
        CaseRecord info = caseRecordMapper.selectCaseRecordByCaseCode(caseRecord.getCaseCode());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertCaseRecord(CaseRecord caseRecord)
    {
        validateCaseRecord(caseRecord);
        caseRecord.setCreateTime(DateUtils.getNowDate());
        caseRecord.setUpdateTime(DateUtils.getNowDate());
        return caseRecordMapper.insertCaseRecord(caseRecord);
    }

    @Override
    public int updateCaseRecord(CaseRecord caseRecord)
    {
        validateCaseRecord(caseRecord);
        caseRecord.setUpdateTime(DateUtils.getNowDate());
        return caseRecordMapper.updateCaseRecord(caseRecord);
    }

    @Override
    public int deleteCaseRecordByIds(String ids)
    {
        return caseRecordMapper.deleteCaseRecordByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deleteCaseRecordById(Long id)
    {
        return caseRecordMapper.deleteCaseRecordById(id);
    }

    private void validateCaseRecord(CaseRecord caseRecord)
    {
        if (caseRecord.getAge() != null && (caseRecord.getAge() < 0 || caseRecord.getAge() > 150))
        {
            throw new IllegalArgumentException("年龄必须在0到150之间");
        }
        if (StringUtils.isNotEmpty(caseRecord.getGender()) && !ALLOWED_GENDERS.contains(caseRecord.getGender()))
        {
            throw new IllegalArgumentException("性别取值不合法");
        }
        if (StringUtils.isNotEmpty(caseRecord.getTcmDiagnosis()) && StringUtils.isEmpty(caseRecord.getSyndrome()))
        {
            throw new IllegalArgumentException("填写中医病名/证名时必须填写证候");
        }
    }
}
