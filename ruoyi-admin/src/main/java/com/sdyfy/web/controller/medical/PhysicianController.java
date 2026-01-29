package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.Physician;
import com.sdyfy.medical.service.IPhysicianService;
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
 * 医家管理
 */
@Controller
@RequestMapping("/medical/physician")
public class PhysicianController extends BaseController
{
    private String prefix = "medical/physician";

    @Autowired
    private IPhysicianService physicianService;

    @RequiresPermissions("medical:physician:view")
    @GetMapping()
    public String physician()
    {
        return prefix + "/physician";
    }

    @RequiresPermissions("medical:physician:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Physician physician)
    {
        startPage();
        List<Physician> list = physicianService.selectPhysicianList(physician);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:physician:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:physician:add")
    @Log(title = "医家", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Physician physician)
    {
        if (!physicianService.checkPhysicianNameUnique(physician))
        {
            return error("新增失败，医家姓名已存在");
        }
        try
        {
            return toAjax(physicianService.insertPhysician(physician));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:physician:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("physician", physicianService.selectPhysicianById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:physician:edit")
    @Log(title = "医家", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Physician physician)
    {
        if (!physicianService.checkPhysicianNameUnique(physician))
        {
            return error("修改失败，医家姓名已存在");
        }
        try
        {
            return toAjax(physicianService.updatePhysician(physician));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:physician:remove")
    @Log(title = "医家", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(physicianService.deletePhysicianByIds(ids));
    }
}
