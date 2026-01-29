package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 孟河医派医案表
 */
public class CaseRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "医案编号不能为空")
    @Size(max = 50, message = "医案编号长度不能超过50个字符")
    private String caseCode;

    @NotBlank(message = "患者姓名不能为空")
    @Size(max = 50, message = "患者姓名长度不能超过50个字符")
    private String patientName;

    @NotBlank(message = "性别不能为空")
    @Size(max = 10, message = "性别长度不能超过10个字符")
    private String gender;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 150, message = "年龄不能超过150")
    private Integer age;

    @NotBlank(message = "疾病名称不能为空")
    @Size(max = 100, message = "疾病名称长度不能超过100个字符")
    private String diseaseName;

    @Size(max = 255, message = "中医病名/证名长度不能超过255个字符")
    private String tcmDiagnosis;

    @Size(max = 255, message = "证候长度不能超过255个字符")
    private String syndrome;

    @NotBlank(message = "主诉不能为空")
    private String chiefComplaint;

    @NotBlank(message = "现病史不能为空")
    private String presentIllness;

    @Size(max = 100, message = "舌象长度不能超过100个字符")
    private String tongue;

    @Size(max = 100, message = "脉象长度不能超过100个字符")
    private String pulse;

    @Size(max = 255, message = "治法长度不能超过255个字符")
    private String treatmentPrinciple;

    private String outcome;

    private String source;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCaseCode()
    {
        return caseCode;
    }

    public void setCaseCode(String caseCode)
    {
        this.caseCode = caseCode;
    }

    public String getPatientName()
    {
        return patientName;
    }

    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getDiseaseName()
    {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName)
    {
        this.diseaseName = diseaseName;
    }

    public String getTcmDiagnosis()
    {
        return tcmDiagnosis;
    }

    public void setTcmDiagnosis(String tcmDiagnosis)
    {
        this.tcmDiagnosis = tcmDiagnosis;
    }

    public String getSyndrome()
    {
        return syndrome;
    }

    public void setSyndrome(String syndrome)
    {
        this.syndrome = syndrome;
    }

    public String getChiefComplaint()
    {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint)
    {
        this.chiefComplaint = chiefComplaint;
    }

    public String getPresentIllness()
    {
        return presentIllness;
    }

    public void setPresentIllness(String presentIllness)
    {
        this.presentIllness = presentIllness;
    }

    public String getTongue()
    {
        return tongue;
    }

    public void setTongue(String tongue)
    {
        this.tongue = tongue;
    }

    public String getPulse()
    {
        return pulse;
    }

    public void setPulse(String pulse)
    {
        this.pulse = pulse;
    }

    public String getTreatmentPrinciple()
    {
        return treatmentPrinciple;
    }

    public void setTreatmentPrinciple(String treatmentPrinciple)
    {
        this.treatmentPrinciple = treatmentPrinciple;
    }

    public String getOutcome()
    {
        return outcome;
    }

    public void setOutcome(String outcome)
    {
        this.outcome = outcome;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }
}
