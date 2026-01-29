package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 医案-医家关系表
 */
public class PhysicianCaseRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "医案ID不能为空")
    private Long caseId;

    @NotNull(message = "医家ID不能为空")
    private Long physicianId;

    @NotBlank(message = "角色不能为空")
    @Size(max = 50, message = "角色长度不能超过50个字符")
    private String role;

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

    public Long getPhysicianId()
    {
        return physicianId;
    }

    public void setPhysicianId(Long physicianId)
    {
        this.physicianId = physicianId;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
