package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 方剂-中药关系表
 */
public class PrescriptionHerbRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "方剂ID不能为空")
    private Long prescriptionId;

    @NotNull(message = "中药ID不能为空")
    private Long herbId;

    @NotBlank(message = "剂量不能为空")
    @Size(max = 50, message = "剂量长度不能超过50个字符")
    private String dosage;

    @Size(max = 50, message = "配伍角色长度不能超过50个字符")
    private String roleDesc;

    private String remarks;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getPrescriptionId()
    {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId)
    {
        this.prescriptionId = prescriptionId;
    }

    public Long getHerbId()
    {
        return herbId;
    }

    public void setHerbId(Long herbId)
    {
        this.herbId = herbId;
    }

    public String getDosage()
    {
        return dosage;
    }

    public void setDosage(String dosage)
    {
        this.dosage = dosage;
    }

    public String getRoleDesc()
    {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
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
