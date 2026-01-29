package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.PrescriptionHerbRelation;
import com.sdyfy.medical.service.IPrescriptionHerbRelationService;
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
 * 方剂-中药关系管理
 */
@Controller
@RequestMapping("/medical/prescriptionHerb")
public class PrescriptionHerbRelationController extends BaseController
{
    private String prefix = "medical/prescriptionHerb";

    @Autowired
    private IPrescriptionHerbRelationService relationService;

    @RequiresPermissions("medical:prescriptionHerb:view")
    @GetMapping()
    public String relation()
    {
        return prefix + "/relation";
    }

    @RequiresPermissions("medical:prescriptionHerb:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PrescriptionHerbRelation relation)
    {
        startPage();
        List<PrescriptionHerbRelation> list = relationService.selectPrescriptionHerbRelationList(relation);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:prescriptionHerb:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:prescriptionHerb:add")
    @Log(title = "方剂-中药关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated PrescriptionHerbRelation relation)
    {
        if (!relationService.checkRelationUnique(relation))
        {
            return error("新增失败，方剂与中药的关系已存在");
        }
        return toAjax(relationService.insertPrescriptionHerbRelation(relation));
    }

    @RequiresPermissions("medical:prescriptionHerb:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("relation", relationService.selectPrescriptionHerbRelationById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:prescriptionHerb:edit")
    @Log(title = "方剂-中药关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated PrescriptionHerbRelation relation)
    {
        if (!relationService.checkRelationUnique(relation))
        {
            return error("修改失败，方剂与中药的关系已存在");
        }
        return toAjax(relationService.updatePrescriptionHerbRelation(relation));
    }

    @RequiresPermissions("medical:prescriptionHerb:remove")
    @Log(title = "方剂-中药关系", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(relationService.deletePrescriptionHerbRelationByIds(ids));
    }
}
