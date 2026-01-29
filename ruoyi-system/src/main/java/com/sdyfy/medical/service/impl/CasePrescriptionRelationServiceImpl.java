package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.CasePrescriptionRelation;
import com.sdyfy.medical.mapper.CasePrescriptionRelationMapper;
import com.sdyfy.medical.service.ICasePrescriptionRelationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医案-方剂关系服务
 */
@Service
public class CasePrescriptionRelationServiceImpl implements ICasePrescriptionRelationService
{
    @Autowired
    private CasePrescriptionRelationMapper relationMapper;

    @Override
    public CasePrescriptionRelation selectCasePrescriptionRelationById(Long id)
    {
        return relationMapper.selectCasePrescriptionRelationById(id);
    }

    @Override
    public List<CasePrescriptionRelation> selectCasePrescriptionRelationList(CasePrescriptionRelation relation)
    {
        return relationMapper.selectCasePrescriptionRelationList(relation);
    }

    @Override
    public boolean checkRelationUnique(CasePrescriptionRelation relation)
    {
        if (relation.getCaseId() == null || relation.getPrescriptionId() == null)
        {
            return UserConstants.NOT_UNIQUE;
        }
        Long id = StringUtils.isNull(relation.getId()) ? -1L : relation.getId();
        CasePrescriptionRelation info = relationMapper.selectRelationByCaseAndPrescription(relation.getCaseId(),
                relation.getPrescriptionId());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertCasePrescriptionRelation(CasePrescriptionRelation relation)
    {
        relation.setCreateTime(DateUtils.getNowDate());
        relation.setUpdateTime(DateUtils.getNowDate());
        return relationMapper.insertCasePrescriptionRelation(relation);
    }

    @Override
    public int updateCasePrescriptionRelation(CasePrescriptionRelation relation)
    {
        relation.setUpdateTime(DateUtils.getNowDate());
        return relationMapper.updateCasePrescriptionRelation(relation);
    }

    @Override
    public int deleteCasePrescriptionRelationByIds(String ids)
    {
        return relationMapper.deleteCasePrescriptionRelationByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deleteCasePrescriptionRelationById(Long id)
    {
        return relationMapper.deleteCasePrescriptionRelationById(id);
    }
}
