package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.PhysicianCaseRelation;
import com.sdyfy.medical.mapper.PhysicianCaseRelationMapper;
import com.sdyfy.medical.service.IPhysicianCaseRelationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医案-医家关系服务
 */
@Service
public class PhysicianCaseRelationServiceImpl implements IPhysicianCaseRelationService
{
    @Autowired
    private PhysicianCaseRelationMapper relationMapper;

    @Override
    public PhysicianCaseRelation selectPhysicianCaseRelationById(Long id)
    {
        return relationMapper.selectPhysicianCaseRelationById(id);
    }

    @Override
    public List<PhysicianCaseRelation> selectPhysicianCaseRelationList(PhysicianCaseRelation relation)
    {
        return relationMapper.selectPhysicianCaseRelationList(relation);
    }

    @Override
    public boolean checkRelationUnique(PhysicianCaseRelation relation)
    {
        if (relation.getCaseId() == null || relation.getPhysicianId() == null)
        {
            return UserConstants.NOT_UNIQUE;
        }
        Long id = StringUtils.isNull(relation.getId()) ? -1L : relation.getId();
        PhysicianCaseRelation info = relationMapper.selectRelationByCaseAndPhysician(relation.getCaseId(),
                relation.getPhysicianId());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertPhysicianCaseRelation(PhysicianCaseRelation relation)
    {
        relation.setCreateTime(DateUtils.getNowDate());
        relation.setUpdateTime(DateUtils.getNowDate());
        return relationMapper.insertPhysicianCaseRelation(relation);
    }

    @Override
    public int updatePhysicianCaseRelation(PhysicianCaseRelation relation)
    {
        relation.setUpdateTime(DateUtils.getNowDate());
        return relationMapper.updatePhysicianCaseRelation(relation);
    }

    @Override
    public int deletePhysicianCaseRelationByIds(String ids)
    {
        return relationMapper.deletePhysicianCaseRelationByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deletePhysicianCaseRelationById(Long id)
    {
        return relationMapper.deletePhysicianCaseRelationById(id);
    }
}
