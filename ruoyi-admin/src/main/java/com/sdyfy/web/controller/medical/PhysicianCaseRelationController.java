package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.PhysicianCaseRelation;
import com.sdyfy.medical.service.IPhysicianCaseRelationService;
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
 * 医案-医家关系管理
 */
@Controller
@RequestMapping("/medical/physicianCase")
public class PhysicianCaseRelationController extends BaseController
{
    private String prefix = "medical/physicianCase";

    @Autowired
    private IPhysicianCaseRelationService relationService;

    @RequiresPermissions("medical:physicianCase:view")
    @GetMapping()
    public String relation()
    {
        return prefix + "/relation";
    }

    @RequiresPermissions("medical:physicianCase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PhysicianCaseRelation relation)
    {
        startPage();
        List<PhysicianCaseRelation> list = relationService.selectPhysicianCaseRelationList(relation);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:physicianCase:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:physicianCase:add")
    @Log(title = "医案-医家关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated PhysicianCaseRelation relation)
    {
        if (!relationService.checkRelationUnique(relation))
        {
            return error("新增失败，医案与医家关系已存在");
        }
        return toAjax(relationService.insertPhysicianCaseRelation(relation));
    }

    @RequiresPermissions("medical:physicianCase:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("relation", relationService.selectPhysicianCaseRelationById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:physicianCase:edit")
    @Log(title = "医案-医家关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated PhysicianCaseRelation relation)
    {
        if (!relationService.checkRelationUnique(relation))
        {
            return error("修改失败，医案与医家关系已存在");
        }
        return toAjax(relationService.updatePhysicianCaseRelation(relation));
    }

    @RequiresPermissions("medical:physicianCase:remove")
    @Log(title = "医案-医家关系", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(relationService.deletePhysicianCaseRelationByIds(ids));
    }
}
