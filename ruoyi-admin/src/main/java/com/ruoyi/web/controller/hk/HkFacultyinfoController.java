package com.ruoyi.web.controller.hk;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.hk.domain.HkFacultyinfo;
import com.ruoyi.hk.service.IHkFacultyinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教职工请假信息Controller
 *
 * @author 段佳帅
 * @date 2022-09-30
 */
@RestController
@RequestMapping("/hk/facultyinfo")
public class HkFacultyinfoController extends BaseController
{
    @Autowired
    private IHkFacultyinfoService hkFacultyinfoService;

    /**
     * 查询教职工请假信息列表
     */
    @PreAuthorize("@ss.hasPermi('hk:facultyinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(HkFacultyinfo hkFacultyinfo)
    {
        startPage();
        List<HkFacultyinfo> list = hkFacultyinfoService.selectHkFacultyinfoList(hkFacultyinfo);
        return getDataTable(list);
    }

    /**
     * 导出教职工请假信息列表
     */
    @PreAuthorize("@ss.hasPermi('hk:facultyinfo:export')")
    @Log(title = "教职工请假信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HkFacultyinfo hkFacultyinfo)
    {
        List<HkFacultyinfo> list = hkFacultyinfoService.selectHkFacultyinfoList(hkFacultyinfo);
        ExcelUtil<HkFacultyinfo> util = new ExcelUtil<HkFacultyinfo>(HkFacultyinfo.class);
        util.exportExcel(response, list, "教职工请假信息数据");
    }

    /**
     * 获取教职工请假信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('hk:facultyinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hkFacultyinfoService.selectHkFacultyinfoById(id));
    }

    /**
     * 新增教职工请假信息
     */
    @PreAuthorize("@ss.hasPermi('hk:facultyinfo:add')")
    @Log(title = "教职工请假信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HkFacultyinfo hkFacultyinfo)
    {
        return toAjax(hkFacultyinfoService.insertHkFacultyinfo(hkFacultyinfo));
    }

    /**
     * 修改教职工请假信息
     */
    @PreAuthorize("@ss.hasPermi('hk:facultyinfo:edit')")
    @Log(title = "教职工请假信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HkFacultyinfo hkFacultyinfo)
    {
        return toAjax(hkFacultyinfoService.updateHkFacultyinfo(hkFacultyinfo));
    }

    /**
     * 删除教职工请假信息
     */
    @PreAuthorize("@ss.hasPermi('hk:facultyinfo:remove')")
    @Log(title = "教职工请假信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hkFacultyinfoService.deleteHkFacultyinfoByIds(ids));
    }
}
