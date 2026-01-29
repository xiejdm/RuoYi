package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.CasePrescriptionRelation;
import com.sdyfy.medical.service.ICasePrescriptionRelationService;
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
 * 医案-方剂关系管理
 */
@Controller
@RequestMapping("/medical/casePrescription")
public class CasePrescriptionRelationController extends BaseController
{
    private String prefix = "medical/casePrescription";

    @Autowired
    private ICasePrescriptionRelationService relationService;

    @RequiresPermissions("medical:casePrescription:view")
    @GetMapping()
    public String relation()
    {
        return prefix + "/relation";
    }

    @RequiresPermissions("medical:casePrescription:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CasePrescriptionRelation relation)
    {
        startPage();
        List<CasePrescriptionRelation> list = relationService.selectCasePrescriptionRelationList(relation);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:casePrescription:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:casePrescription:add")
    @Log(title = "医案-方剂关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated CasePrescriptionRelation relation)
    {
        if (!relationService.checkRelationUnique(relation))
        {
            return error("新增失败，医案与方剂关系已存在");
        }
        return toAjax(relationService.insertCasePrescriptionRelation(relation));
    }

    @RequiresPermissions("medical:casePrescription:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("relation", relationService.selectCasePrescriptionRelationById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:casePrescription:edit")
    @Log(title = "医案-方剂关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated CasePrescriptionRelation relation)
    {
        if (!relationService.checkRelationUnique(relation))
        {
            return error("修改失败，医案与方剂关系已存在");
        }
        return toAjax(relationService.updateCasePrescriptionRelation(relation));
    }

    @RequiresPermissions("medical:casePrescription:remove")
    @Log(title = "医案-方剂关系", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(relationService.deleteCasePrescriptionRelationByIds(ids));
    }
}
