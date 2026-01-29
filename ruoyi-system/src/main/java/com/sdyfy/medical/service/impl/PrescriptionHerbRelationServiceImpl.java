package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.PrescriptionHerbRelation;
import com.sdyfy.medical.mapper.PrescriptionHerbRelationMapper;
import com.sdyfy.medical.service.IPrescriptionHerbRelationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 方剂-中药关系服务
 */
@Service
public class PrescriptionHerbRelationServiceImpl implements IPrescriptionHerbRelationService
{
    @Autowired
    private PrescriptionHerbRelationMapper relationMapper;

    @Override
    public PrescriptionHerbRelation selectPrescriptionHerbRelationById(Long id)
    {
        return relationMapper.selectPrescriptionHerbRelationById(id);
    }

    @Override
    public List<PrescriptionHerbRelation> selectPrescriptionHerbRelationList(PrescriptionHerbRelation relation)
    {
        return relationMapper.selectPrescriptionHerbRelationList(relation);
    }

    @Override
    public boolean checkRelationUnique(PrescriptionHerbRelation relation)
    {
        if (relation.getPrescriptionId() == null || relation.getHerbId() == null)
        {
            return UserConstants.NOT_UNIQUE;
        }
        Long id = StringUtils.isNull(relation.getId()) ? -1L : relation.getId();
        PrescriptionHerbRelation info = relationMapper.selectRelationByPrescriptionAndHerb(relation.getPrescriptionId(),
                relation.getHerbId());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertPrescriptionHerbRelation(PrescriptionHerbRelation relation)
    {
        relation.setCreateTime(DateUtils.getNowDate());
        relation.setUpdateTime(DateUtils.getNowDate());
        return relationMapper.insertPrescriptionHerbRelation(relation);
    }

    @Override
    public int updatePrescriptionHerbRelation(PrescriptionHerbRelation relation)
    {
        relation.setUpdateTime(DateUtils.getNowDate());
        return relationMapper.updatePrescriptionHerbRelation(relation);
    }

    @Override
    public int deletePrescriptionHerbRelationByIds(String ids)
    {
        return relationMapper.deletePrescriptionHerbRelationByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deletePrescriptionHerbRelationById(Long id)
    {
        return relationMapper.deletePrescriptionHerbRelationById(id);
    }
}
