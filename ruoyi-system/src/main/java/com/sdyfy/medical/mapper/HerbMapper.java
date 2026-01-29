package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.Herb;
import java.util.List;

/**
 * 中药Mapper
 */
public interface HerbMapper
{
    Herb selectHerbById(Long id);

    List<Herb> selectHerbList(Herb herb);

    Herb selectHerbByName(String herbName);

    int insertHerb(Herb herb);

    int updateHerb(Herb herb);

    int deleteHerbById(Long id);

    int deleteHerbByIds(Long[] ids);
}
