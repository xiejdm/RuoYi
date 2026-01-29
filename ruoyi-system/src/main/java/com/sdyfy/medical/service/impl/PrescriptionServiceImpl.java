package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.Prescription;
import com.sdyfy.medical.mapper.PrescriptionMapper;
import com.sdyfy.medical.service.IPrescriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 方剂服务
 */
@Service
public class PrescriptionServiceImpl implements IPrescriptionService
{
    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @Override
    public Prescription selectPrescriptionById(Long id)
    {
        return prescriptionMapper.selectPrescriptionById(id);
    }

    @Override
    public List<Prescription> selectPrescriptionList(Prescription prescription)
    {
        return prescriptionMapper.selectPrescriptionList(prescription);
    }

    @Override
    public boolean checkPrescriptionNameUnique(Prescription prescription)
    {
        Long id = StringUtils.isNull(prescription.getId()) ? -1L : prescription.getId();
        Prescription info = prescriptionMapper.selectPrescriptionByName(prescription.getPrescriptionName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertPrescription(Prescription prescription)
    {
        validatePrescription(prescription);
        prescription.setCreateTime(DateUtils.getNowDate());
        prescription.setUpdateTime(DateUtils.getNowDate());
        return prescriptionMapper.insertPrescription(prescription);
    }

    @Override
    public int updatePrescription(Prescription prescription)
    {
        validatePrescription(prescription);
        prescription.setUpdateTime(DateUtils.getNowDate());
        return prescriptionMapper.updatePrescription(prescription);
    }

    @Override
    public int deletePrescriptionByIds(String ids)
    {
        return prescriptionMapper.deletePrescriptionByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deletePrescriptionById(Long id)
    {
        return prescriptionMapper.deletePrescriptionById(id);
    }

    private void validatePrescription(Prescription prescription)
    {
        if (StringUtils.isNotEmpty(prescription.getPreparationMethod())
                && prescription.getPreparationMethod().length() > 300)
        {
            throw new IllegalArgumentException("制备方法长度不能超过300个字符");
        }
        if (StringUtils.isNotEmpty(prescription.getRemarks()) && prescription.getRemarks().length() > 500)
        {
            throw new IllegalArgumentException("备注长度不能超过500个字符");
        }
    }
}
