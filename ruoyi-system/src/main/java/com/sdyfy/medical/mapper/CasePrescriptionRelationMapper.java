package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.CasePrescriptionRelation;
import java.util.List;

/**
 * 医案-方剂关系Mapper
 */
public interface CasePrescriptionRelationMapper
{
    CasePrescriptionRelation selectCasePrescriptionRelationById(Long id);

    List<CasePrescriptionRelation> selectCasePrescriptionRelationList(CasePrescriptionRelation relation);

    CasePrescriptionRelation selectRelationByCaseAndPrescription(Long caseId, Long prescriptionId);

    int insertCasePrescriptionRelation(CasePrescriptionRelation relation);

    int updateCasePrescriptionRelation(CasePrescriptionRelation relation);

    int deleteCasePrescriptionRelationById(Long id);

    int deleteCasePrescriptionRelationByIds(Long[] ids);
}
