package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.PrescriptionHerbRelation;
import java.util.List;

/**
 * 方剂-中药关系Mapper
 */
public interface PrescriptionHerbRelationMapper
{
    PrescriptionHerbRelation selectPrescriptionHerbRelationById(Long id);

    List<PrescriptionHerbRelation> selectPrescriptionHerbRelationList(PrescriptionHerbRelation relation);

    PrescriptionHerbRelation selectRelationByPrescriptionAndHerb(Long prescriptionId, Long herbId);

    int insertPrescriptionHerbRelation(PrescriptionHerbRelation relation);

    int updatePrescriptionHerbRelation(PrescriptionHerbRelation relation);

    int deletePrescriptionHerbRelationById(Long id);

    int deletePrescriptionHerbRelationByIds(Long[] ids);
}
