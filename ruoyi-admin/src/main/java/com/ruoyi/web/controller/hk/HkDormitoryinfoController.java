package com.ruoyi.web.controller.hk;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.hk.domain.HkStudentinfo;
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
import com.ruoyi.hk.domain.HkDormitoryinfo;
import com.ruoyi.hk.service.IHkDormitoryinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生宿舍Controller
 *
 * @author æ®µä½³å¸
 * @date 2022-10-11
 */
@RestController
@RequestMapping("/hk/dormitoryInfo")
public class HkDormitoryinfoController extends BaseController
{
    @Autowired
    private IHkDormitoryinfoService hkDormitoryinfoService;

    /**
     * 查询学生宿舍列表
     */
    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(HkDormitoryinfo hkDormitoryinfo)
    {
        startPage();
        List<HkDormitoryinfo> list = hkDormitoryinfoService.selectHkDormitoryinfoList(hkDormitoryinfo);
        return getDataTable(list);
    }
    /*查询学生信息
    *
    * */
//    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:list')")
    @GetMapping("/Studentlist")
    @Anonymous
    public TableDataInfo Studentlist(HkStudentinfo hkStudentinfo)
    {
        startPage();
       List<HkStudentinfo> list=hkDormitoryinfoService.selectHkStudentinfoList(hkStudentinfo);
        return getDataTable(list);
    }
    /**
     * 导出学生宿舍列表
     */
    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:export')")
    @Log(title = "学生宿舍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HkDormitoryinfo hkDormitoryinfo)
    {
        List<HkDormitoryinfo> list = hkDormitoryinfoService.selectHkDormitoryinfoList(hkDormitoryinfo);
        ExcelUtil<HkDormitoryinfo> util = new ExcelUtil<HkDormitoryinfo>(HkDormitoryinfo.class);
        util.exportExcel(response, list, "学生宿舍数据");
    }

    /**
     * 获取学生宿舍详细信息
     */
    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:query')")
    @GetMapping(value = "/{dormitoryid}")
    public AjaxResult getInfo(@PathVariable("dormitoryid") Long dormitoryid)
    {
        return AjaxResult.success(hkDormitoryinfoService.selectHkDormitoryinfoByDormitoryid(dormitoryid));
    }

    /**
     * 新增学生宿舍
     */
    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:add')")
    @Log(title = "学生宿舍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HkDormitoryinfo hkDormitoryinfo)
    {
        return toAjax(hkDormitoryinfoService.insertHkDormitoryinfo(hkDormitoryinfo));
    }

    /**
     * 修改学生宿舍
     */
    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:edit')")
    @Log(title = "学生宿舍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HkDormitoryinfo hkDormitoryinfo)
    {
        return toAjax(hkDormitoryinfoService.updateHkDormitoryinfo(hkDormitoryinfo));
    }

    /**
     * 删除学生宿舍
     */
    @PreAuthorize("@ss.hasPermi('hk:dormitoryInfo:remove')")
    @Log(title = "学生宿舍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dormitoryids}")
    public AjaxResult remove(@PathVariable Long[] dormitoryids)
    {
        return toAjax(hkDormitoryinfoService.deleteHkDormitoryinfoByDormitoryids(dormitoryids));
    }
}
