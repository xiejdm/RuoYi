package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.Physician;
import java.util.List;

/**
 * 医家服务
 */
public interface IPhysicianService
{
    Physician selectPhysicianById(Long id);

    List<Physician> selectPhysicianList(Physician physician);

    boolean checkPhysicianNameUnique(Physician physician);

    int insertPhysician(Physician physician);

    int updatePhysician(Physician physician);

    int deletePhysicianByIds(String ids);

    int deletePhysicianById(Long id);
}
