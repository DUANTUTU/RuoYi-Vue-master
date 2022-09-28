package com.ruoyi.web.controller.hk;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.hk.domain.HkTest;
import com.ruoyi.hk.service.IHkTestService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-09-20
 */
@RestController
@RequestMapping("/system/test")
public class HkTestController extends BaseController
{
    @Autowired
    private IHkTestService hkTestService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasAnyRoles('duan')")
    @GetMapping("/list")
    public TableDataInfo list(HkTest hkTest)
    {
        startPage();
        List<HkTest> list = hkTestService.selectHkTestList(hkTest);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasAnyRoles('duan')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HkTest hkTest)
    {
        List<HkTest> list = hkTestService.selectHkTestList(hkTest);
        ExcelUtil<HkTest> util = new ExcelUtil<HkTest>(HkTest.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasAnyRoles('duan')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hkTestService.selectHkTestById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasAnyRoles('duan')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HkTest hkTest)
    {
        return toAjax(hkTestService.insertHkTest(hkTest));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasAnyRoles('duan')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HkTest hkTest)
    {
        return toAjax(hkTestService.updateHkTest(hkTest));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasAnyRoles('duan')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hkTestService.deleteHkTestByIds(ids));
    }
}
