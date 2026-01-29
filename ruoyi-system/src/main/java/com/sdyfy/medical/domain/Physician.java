package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 孟河医派医家表
 */
public class Physician extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "医家姓名不能为空")
    @Size(max = 50, message = "医家姓名长度不能超过50个字符")
    private String physicianName;

    @NotNull(message = "代际不能为空")
    private Integer generation;

    @Size(max = 50, message = "师承长度不能超过50个字符")
    private String teacher;

    private String academicThought;

    private String specialty;

    private String representativeWorks;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPhysicianName()
    {
        return physicianName;
    }

    public void setPhysicianName(String physicianName)
    {
        this.physicianName = physicianName;
    }

    public Integer getGeneration()
    {
        return generation;
    }

    public void setGeneration(Integer generation)
    {
        this.generation = generation;
    }

    public String getTeacher()
    {
        return teacher;
    }

    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public String getAcademicThought()
    {
        return academicThought;
    }

    public void setAcademicThought(String academicThought)
    {
        this.academicThought = academicThought;
    }

    public String getSpecialty()
    {
        return specialty;
    }

    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }

    public String getRepresentativeWorks()
    {
        return representativeWorks;
    }

    public void setRepresentativeWorks(String representativeWorks)
    {
        this.representativeWorks = representativeWorks;
    }
}
