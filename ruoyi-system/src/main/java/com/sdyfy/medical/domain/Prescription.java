package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 孟河医派方剂表
 */
public class Prescription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "方剂名称不能为空")
    @Size(max = 100, message = "方剂名称长度不能超过100个字符")
    private String prescriptionName;

    @NotBlank(message = "功效不能为空")
    private String functionDesc;

    @NotBlank(message = "主治不能为空")
    private String indications;

    private String preparationMethod;

    @Size(max = 100, message = "出处长度不能超过100个字符")
    private String sourceClassic;

    private String remarks;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPrescriptionName()
    {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName)
    {
        this.prescriptionName = prescriptionName;
    }

    public String getFunctionDesc()
    {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc)
    {
        this.functionDesc = functionDesc;
    }

    public String getIndications()
    {
        return indications;
    }

    public void setIndications(String indications)
    {
        this.indications = indications;
    }

    public String getPreparationMethod()
    {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod)
    {
        this.preparationMethod = preparationMethod;
    }

    public String getSourceClassic()
    {
        return sourceClassic;
    }

    public void setSourceClassic(String sourceClassic)
    {
        this.sourceClassic = sourceClassic;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}
