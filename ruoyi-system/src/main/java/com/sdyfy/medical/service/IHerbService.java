package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.Herb;
import java.util.List;

/**
 * 中药服务
 */
public interface IHerbService
{
    Herb selectHerbById(Long id);

    List<Herb> selectHerbList(Herb herb);

    boolean checkHerbNameUnique(Herb herb);

    int insertHerb(Herb herb);

    int updateHerb(Herb herb);

    int deleteHerbByIds(String ids);

    int deleteHerbById(Long id);
}
