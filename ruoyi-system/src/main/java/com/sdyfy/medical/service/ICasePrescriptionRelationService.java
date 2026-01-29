package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.CasePrescriptionRelation;
import java.util.List;

/**
 * 医案-方剂关系服务
 */
public interface ICasePrescriptionRelationService
{
    CasePrescriptionRelation selectCasePrescriptionRelationById(Long id);

    List<CasePrescriptionRelation> selectCasePrescriptionRelationList(CasePrescriptionRelation relation);

    boolean checkRelationUnique(CasePrescriptionRelation relation);

    int insertCasePrescriptionRelation(CasePrescriptionRelation relation);

    int updateCasePrescriptionRelation(CasePrescriptionRelation relation);

    int deleteCasePrescriptionRelationByIds(String ids);

    int deleteCasePrescriptionRelationById(Long id);
}
