package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.Physician;
import com.sdyfy.medical.mapper.PhysicianMapper;
import com.sdyfy.medical.service.IPhysicianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医家服务
 */
@Service
public class PhysicianServiceImpl implements IPhysicianService
{
    @Autowired
    private PhysicianMapper physicianMapper;

    @Override
    public Physician selectPhysicianById(Long id)
    {
        return physicianMapper.selectPhysicianById(id);
    }

    @Override
    public List<Physician> selectPhysicianList(Physician physician)
    {
        return physicianMapper.selectPhysicianList(physician);
    }

    @Override
    public boolean checkPhysicianNameUnique(Physician physician)
    {
        Long id = StringUtils.isNull(physician.getId()) ? -1L : physician.getId();
        Physician info = physicianMapper.selectPhysicianByName(physician.getPhysicianName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertPhysician(Physician physician)
    {
        validatePhysician(physician);
        physician.setCreateTime(DateUtils.getNowDate());
        physician.setUpdateTime(DateUtils.getNowDate());
        return physicianMapper.insertPhysician(physician);
    }

    @Override
    public int updatePhysician(Physician physician)
    {
        validatePhysician(physician);
        physician.setUpdateTime(DateUtils.getNowDate());
        return physicianMapper.updatePhysician(physician);
    }

    @Override
    public int deletePhysicianByIds(String ids)
    {
        return physicianMapper.deletePhysicianByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deletePhysicianById(Long id)
    {
        return physicianMapper.deletePhysicianById(id);
    }

    private void validatePhysician(Physician physician)
    {
        if (physician.getGeneration() != null && physician.getGeneration() <= 0)
        {
            throw new IllegalArgumentException("代际必须为正整数");
        }
    }
}
