package com.sdyfy.web.controller.medical;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.sdyfy.medical.domain.Herb;
import com.sdyfy.medical.service.IHerbService;
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
 * 中药管理
 */
@Controller
@RequestMapping("/medical/herb")
public class HerbController extends BaseController
{
    private String prefix = "medical/herb";

    @Autowired
    private IHerbService herbService;

    @RequiresPermissions("medical:herb:view")
    @GetMapping()
    public String herb()
    {
        return prefix + "/herb";
    }

    @RequiresPermissions("medical:herb:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Herb herb)
    {
        startPage();
        List<Herb> list = herbService.selectHerbList(herb);
        return getDataTable(list);
    }

    @RequiresPermissions("medical:herb:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("medical:herb:add")
    @Log(title = "中药", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Herb herb)
    {
        if (!herbService.checkHerbNameUnique(herb))
        {
            return error("新增失败，中药名已存在");
        }
        try
        {
            return toAjax(herbService.insertHerb(herb));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:herb:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("herb", herbService.selectHerbById(id));
        return prefix + "/edit";
    }

    @RequiresPermissions("medical:herb:edit")
    @Log(title = "中药", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Herb herb)
    {
        if (!herbService.checkHerbNameUnique(herb))
        {
            return error("修改失败，中药名已存在");
        }
        try
        {
            return toAjax(herbService.updateHerb(herb));
        }
        catch (IllegalArgumentException ex)
        {
            return error(ex.getMessage());
        }
    }

    @RequiresPermissions("medical:herb:remove")
    @Log(title = "中药", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(herbService.deleteHerbByIds(ids));
    }
}
