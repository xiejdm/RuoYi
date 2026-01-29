package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.Physician;
import java.util.List;

/**
 * 医家Mapper
 */
public interface PhysicianMapper
{
    Physician selectPhysicianById(Long id);

    List<Physician> selectPhysicianList(Physician physician);

    Physician selectPhysicianByName(String physicianName);

    int insertPhysician(Physician physician);

    int updatePhysician(Physician physician);

    int deletePhysicianById(Long id);

    int deletePhysicianByIds(Long[] ids);
}
