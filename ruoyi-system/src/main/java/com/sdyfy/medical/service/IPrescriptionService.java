package com.sdyfy.medical.service;

import com.sdyfy.medical.domain.Prescription;
import java.util.List;

/**
 * 方剂服务
 */
public interface IPrescriptionService
{
    Prescription selectPrescriptionById(Long id);

    List<Prescription> selectPrescriptionList(Prescription prescription);

    boolean checkPrescriptionNameUnique(Prescription prescription);

    int insertPrescription(Prescription prescription);

    int updatePrescription(Prescription prescription);

    int deletePrescriptionByIds(String ids);

    int deletePrescriptionById(Long id);
}
