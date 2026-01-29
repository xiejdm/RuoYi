package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.CaseRecord;
import com.sdyfy.medical.service.ICaseRecordService;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 医案管理
 */
@Controller
@RequestMapping("/medical/caseRecord")
public class CaseRecordController extends BaseController
{
    private String prefix = "medical/caseRecord";

    @Autowired
    private ICaseRecordService caseRecordService;

    @RequiresPermissions("medical:caseRecord:view")
    @GetMapping()
    public String caseRecord()
    {
        return prefix + "/caseRecord";
    }

    @RequiresPermissions("medical:caseRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CaseRecord caseRecord)
    {
        startPage();
        List<CaseRecord> list = caseRecordService.selectCaseRecordList(caseRecord);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:caseRecord:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:caseRecord:add")
    @Log(title = "医案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated CaseRecord caseRecord)
    {
        if (!caseRecordService.checkCaseCodeUnique(caseRecord))
        {
            return error("新增失败，医案编号已存在");
        }
        try
        {
            return toAjax(caseRecordService.insertCaseRecord(caseRecord));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:caseRecord:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("caseRecord", caseRecordService.selectCaseRecordById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:caseRecord:edit")
    @Log(title = "医案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated CaseRecord caseRecord)
    {
        if (!caseRecordService.checkCaseCodeUnique(caseRecord))
        {
            return error("修改失败，医案编号已存在");
        }
        try
        {
            return toAjax(caseRecordService.updateCaseRecord(caseRecord));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:caseRecord:remove")
    @Log(title = "医案", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(caseRecordService.deleteCaseRecordByIds(ids));
    }
}
