package com.ruoyi.hk.mapper;

import java.util.List;
import com.ruoyi.hk.domain.HkFacultyinfo;

/**
 * 教职工请假信息Mapper接口
 * 
 * @author 段佳帅
 * @date 2022-09-30
 */
public interface HkFacultyinfoMapper 
{
    /**
     * 查询教职工请假信息
     * 
     * @param id 教职工请假信息主键
     * @return 教职工请假信息
     */
    public HkFacultyinfo selectHkFacultyinfoById(Long id);

    /**
     * 查询教职工请假信息列表
     * 
     * @param hkFacultyinfo 教职工请假信息
     * @return 教职工请假信息集合
     */
    public List<HkFacultyinfo> selectHkFacultyinfoList(HkFacultyinfo hkFacultyinfo);

    /**
     * 新增教职工请假信息
     * 
     * @param hkFacultyinfo 教职工请假信息
     * @return 结果
     */
    public int insertHkFacultyinfo(HkFacultyinfo hkFacultyinfo);

    /**
     * 修改教职工请假信息
     * 
     * @param hkFacultyinfo 教职工请假信息
     * @return 结果
     */
    public int updateHkFacultyinfo(HkFacultyinfo hkFacultyinfo);

    /**
     * 删除教职工请假信息
     * 
     * @param id 教职工请假信息主键
     * @return 结果
     */
    public int deleteHkFacultyinfoById(Long id);

    /**
     * 批量删除教职工请假信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHkFacultyinfoByIds(Long[] ids);
}
