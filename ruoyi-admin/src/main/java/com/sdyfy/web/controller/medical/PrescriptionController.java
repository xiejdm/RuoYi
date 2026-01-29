package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.Prescription;
import com.sdyfy.medical.service.IPrescriptionService;
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
 * 方剂管理
 */
@Controller
@RequestMapping("/medical/prescription")
public class PrescriptionController extends BaseController
{
    private String prefix = "medical/prescription";

    @Autowired
    private IPrescriptionService prescriptionService;

    @RequiresPermissions("medical:prescription:view")
    @GetMapping()
    public String prescription()
    {
        return prefix + "/prescription";
    }

    @RequiresPermissions("medical:prescription:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Prescription prescription)
    {
        startPage();
        List<Prescription> list = prescriptionService.selectPrescriptionList(prescription);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:prescription:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:prescription:add")
    @Log(title = "方剂", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Prescription prescription)
    {
        if (!prescriptionService.checkPrescriptionNameUnique(prescription))
        {
            return error("新增失败，方剂名称已存在");
        }
        try
        {
            return toAjax(prescriptionService.insertPrescription(prescription));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:prescription:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("prescription", prescriptionService.selectPrescriptionById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:prescription:edit")
    @Log(title = "方剂", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Prescription prescription)
    {
        if (!prescriptionService.checkPrescriptionNameUnique(prescription))
        {
            return error("修改失败，方剂名称已存在");
        }
        try
        {
            return toAjax(prescriptionService.updatePrescription(prescription));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:prescription:remove")
    @Log(title = "方剂", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(prescriptionService.deletePrescriptionByIds(ids));
    }
}
