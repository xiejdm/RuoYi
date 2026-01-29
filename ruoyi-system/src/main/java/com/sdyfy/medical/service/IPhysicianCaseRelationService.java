package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.PhysicianCaseRelation;
import java.util.List;

/**
 * 医案-医家关系服务
 */
public interface IPhysicianCaseRelationService
{
    PhysicianCaseRelation selectPhysicianCaseRelationById(Long id);

    List<PhysicianCaseRelation> selectPhysicianCaseRelationList(PhysicianCaseRelation relation);

    boolean checkRelationUnique(PhysicianCaseRelation relation);

    int insertPhysicianCaseRelation(PhysicianCaseRelation relation);

    int updatePhysicianCaseRelation(PhysicianCaseRelation relation);

    int deletePhysicianCaseRelationByIds(String ids);

    int deletePhysicianCaseRelationById(Long id);
}
