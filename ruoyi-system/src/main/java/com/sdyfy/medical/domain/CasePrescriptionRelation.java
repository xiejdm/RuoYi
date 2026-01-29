package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 医案-方剂关系表
 */
public class CasePrescriptionRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "医案ID不能为空")
    private Long caseId;

    @NotNull(message = "方剂ID不能为空")
    private Long prescriptionId;

    @NotBlank(message = "用法不能为空")
    @Size(max = 100, message = "用法长度不能超过100个字符")
    private String usageMethod;

    private String dosageAdjustment;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getCaseId()
    {
        return caseId;
    }

    public void setCaseId(Long caseId)
    {
        this.caseId = caseId;
    }

    public Long getPrescriptionId()
    {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId)
    {
        this.prescriptionId = prescriptionId;
    }

    public String getUsageMethod()
    {
        return usageMethod;
    }

    public void setUsageMethod(String usageMethod)
    {
        this.usageMethod = usageMethod;
    }

    public String getDosageAdjustment()
    {
        return dosageAdjustment;
    }

    public void setDosageAdjustment(String dosageAdjustment)
    {
        this.dosageAdjustment = dosageAdjustment;
    }
}
