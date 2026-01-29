package com.sdyfy.medical.mapper;

import com.sdyfy.medical.domain.Prescription;
import java.util.List;

/**
 * 方剂Mapper
 */
public interface PrescriptionMapper
{
    Prescription selectPrescriptionById(Long id);

    List<Prescription> selectPrescriptionList(Prescription prescription);

    Prescription selectPrescriptionByName(String prescriptionName);

    int insertPrescription(Prescription prescription);

    int updatePrescription(Prescription prescription);

    int deletePrescriptionById(Long id);

    int deletePrescriptionByIds(Long[] ids);
}
