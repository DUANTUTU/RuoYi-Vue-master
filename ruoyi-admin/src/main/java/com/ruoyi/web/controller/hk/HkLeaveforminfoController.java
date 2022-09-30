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
import com.ruoyi.hk.domain.HkLeaveforminfo;
import com.ruoyi.hk.service.IHkLeaveforminfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生请假Controller
 *
 * @author 段佳帅
 * @date 2022-09-20
 */
@RestController
@RequestMapping("/hk/leaveforminfo")
public class HkLeaveforminfoController extends BaseController
{
    @Autowired
    private IHkLeaveforminfoService hkLeaveforminfoService;

    /**
     * 查询学生请假列表
     */
   // @PreAuthorize("@ss.hasPermi('hk:leaveforminfo:list')")
    @PreAuthorize("@ss.hasRole('user01')")
    @GetMapping("/list")
    public TableDataInfo list(HkLeaveforminfo hkLeaveforminfo)
    {
        startPage();
        List<HkLeaveforminfo> list = hkLeaveforminfoService.selectHkLeaveforminfoList(hkLeaveforminfo);
        return getDataTable(list);
    }

    /**
     * 导出学生请假列表
     */
    @PreAuthorize("@ss.hasPermi('hk:leaveforminfo:export')")
    @Log(title = "学生请假", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HkLeaveforminfo hkLeaveforminfo)
    {
        List<HkLeaveforminfo> list = hkLeaveforminfoService.selectHkLeaveforminfoList(hkLeaveforminfo);
        ExcelUtil<HkLeaveforminfo> util = new ExcelUtil<HkLeaveforminfo>(HkLeaveforminfo.class);
        util.exportExcel(response, list, "学生请假数据");
    }

    /**
     * 获取学生请假详细信息
     */
    //@PreAuthorize("@ss.hasPermi('hk:leaveforminfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hkLeaveforminfoService.selectHkLeaveforminfoById(id));
    }
    /**
     * 获取学生请假详细信息
     */
  //  @PreAuthorize("@ss.hasPermi('hk:leaveforminfo:query')")
    @GetMapping(value = "/username/{userId}")
    public AjaxResult getHkLeaveforminfoUserName(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(hkLeaveforminfoService.getHkLeaveforminfoUserNameById(userId));
    }

    /**
     * 新增学生请假
     */
    @PreAuthorize("@ss.hasPermi('hk:leaveforminfo:add')")
    @Log(title = "学生请假", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HkLeaveforminfo hkLeaveforminfo)
    {
        return toAjax(hkLeaveforminfoService.insertHkLeaveforminfo(hkLeaveforminfo));
    }

    /**
     * 修改学生请假
     */
    @PreAuthorize("@ss.hasPermi('hk:leaveforminfo:edit')")
    @Log(title = "学生请假", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HkLeaveforminfo hkLeaveforminfo)
    {
        return toAjax(hkLeaveforminfoService.updateHkLeaveforminfo(hkLeaveforminfo));
    }

    /**
     * 删除学生请假
     */
    @PreAuthorize("@ss.hasPermi('hk:leaveforminfo:remove')")
    @Log(title = "学生请假", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hkLeaveforminfoService.deleteHkLeaveforminfoByIds(ids));
    }
}
