package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.PhysicianCaseRelation;
import java.util.List;

/**
 * 医案-医家关系Mapper
 */
public interface PhysicianCaseRelationMapper
{
    PhysicianCaseRelation selectPhysicianCaseRelationById(Long id);

    List<PhysicianCaseRelation> selectPhysicianCaseRelationList(PhysicianCaseRelation relation);

    PhysicianCaseRelation selectRelationByCaseAndPhysician(Long caseId, Long physicianId);

    int insertPhysicianCaseRelation(PhysicianCaseRelation relation);

    int updatePhysicianCaseRelation(PhysicianCaseRelation relation);

    int deletePhysicianCaseRelationById(Long id);

    int deletePhysicianCaseRelationByIds(Long[] ids);
}
