package com.sdyfy.medical.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 中药基础信息表
 */
public class Herb extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "中药名不能为空")
    @Size(max = 100, message = "中药名长度不能超过100个字符")
    private String herbName;

    @Size(max = 150, message = "拉丁学名长度不能超过150个字符")
    private String latinName;

    @Size(max = 50, message = "性长度不能超过50个字符")
    private String property;

    @Size(max = 50, message = "味长度不能超过50个字符")
    private String taste;

    @Size(max = 100, message = "归经长度不能超过100个字符")
    private String meridian;

    @NotBlank(message = "功效不能为空")
    private String functionDesc;

    private String usageNote;

    @Size(max = 100, message = "炮制后性味归经长度不能超过100个字符")
    private String processedPropertyMeridian;

    @Size(max = 100, message = "炮制方法长度不能超过100个字符")
    private String processingMethod;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getHerbName()
    {
        return herbName;
    }

    public void setHerbName(String herbName)
    {
        this.herbName = herbName;
    }

    public String getLatinName()
    {
        return latinName;
    }

    public void setLatinName(String latinName)
    {
        this.latinName = latinName;
    }

    public String getProperty()
    {
        return property;
    }

    public void setProperty(String property)
    {
        this.property = property;
    }

    public String getTaste()
    {
        return taste;
    }

    public void setTaste(String taste)
    {
        this.taste = taste;
    }

    public String getMeridian()
    {
        return meridian;
    }

    public void setMeridian(String meridian)
    {
        this.meridian = meridian;
    }

    public String getFunctionDesc()
    {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc)
    {
        this.functionDesc = functionDesc;
    }

    public String getUsageNote()
    {
        return usageNote;
    }

    public void setUsageNote(String usageNote)
    {
        this.usageNote = usageNote;
    }

    public String getProcessedPropertyMeridian()
    {
        return processedPropertyMeridian;
    }

    public void setProcessedPropertyMeridian(String processedPropertyMeridian)
    {
        this.processedPropertyMeridian = processedPropertyMeridian;
    }

    public String getProcessingMethod()
    {
        return processingMethod;
    }

    public void setProcessingMethod(String processingMethod)
    {
        this.processingMethod = processingMethod;
    }
}
