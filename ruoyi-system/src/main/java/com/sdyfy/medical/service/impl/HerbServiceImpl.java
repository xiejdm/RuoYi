package com.sdyfy.medical.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.sdyfy.medical.domain.Herb;
import com.sdyfy.medical.mapper.HerbMapper;
import com.sdyfy.medical.service.IHerbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 中药服务
 */
@Service
public class HerbServiceImpl implements IHerbService
{
    @Autowired
    private HerbMapper herbMapper;

    @Override
    public Herb selectHerbById(Long id)
    {
        return herbMapper.selectHerbById(id);
    }

    @Override
    public List<Herb> selectHerbList(Herb herb)
    {
        return herbMapper.selectHerbList(herb);
    }

    @Override
    public boolean checkHerbNameUnique(Herb herb)
    {
        Long id = StringUtils.isNull(herb.getId()) ? -1L : herb.getId();
        Herb info = herbMapper.selectHerbByName(herb.getHerbName());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != id.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertHerb(Herb herb)
    {
        validateHerb(herb);
        herb.setCreateTime(DateUtils.getNowDate());
        herb.setUpdateTime(DateUtils.getNowDate());
        return herbMapper.insertHerb(herb);
    }

    @Override
    public int updateHerb(Herb herb)
    {
        validateHerb(herb);
        herb.setUpdateTime(DateUtils.getNowDate());
        return herbMapper.updateHerb(herb);
    }

    @Override
    public int deleteHerbByIds(String ids)
    {
        return herbMapper.deleteHerbByIds(Convert.toLongArray(ids));
    }

    @Override
    public int deleteHerbById(Long id)
    {
        return herbMapper.deleteHerbById(id);
    }

    private void validateHerb(Herb herb)
    {
        if (StringUtils.isNotEmpty(herb.getProcessingMethod()) && StringUtils.isEmpty(herb.getProcessedPropertyMeridian()))
        {
            throw new IllegalArgumentException("填写炮制方法时需同步选择炮制后性味归经");
        }
        if (StringUtils.isNotEmpty(herb.getProcessedPropertyMeridian()) && StringUtils.isEmpty(herb.getProcessingMethod()))
        {
            throw new IllegalArgumentException("填写炮制后性味归经时需同步选择炮制方法");
        }
    }
}
