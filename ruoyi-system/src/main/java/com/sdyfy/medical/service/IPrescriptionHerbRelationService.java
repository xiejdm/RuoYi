package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.PrescriptionHerbRelation;
import java.util.List;

/**
 * 方剂-中药关系服务
 */
public interface IPrescriptionHerbRelationService
{
    PrescriptionHerbRelation selectPrescriptionHerbRelationById(Long id);

    List<PrescriptionHerbRelation> selectPrescriptionHerbRelationList(PrescriptionHerbRelation relation);

    boolean checkRelationUnique(PrescriptionHerbRelation relation);

    int insertPrescriptionHerbRelation(PrescriptionHerbRelation relation);

    int updatePrescriptionHerbRelation(PrescriptionHerbRelation relation);

    int deletePrescriptionHerbRelationByIds(String ids);

    int deletePrescriptionHerbRelationById(Long id);
}
