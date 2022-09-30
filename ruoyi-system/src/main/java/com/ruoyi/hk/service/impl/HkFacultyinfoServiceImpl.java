package com.ruoyi.hk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hk.mapper.HkFacultyinfoMapper;
import com.ruoyi.hk.domain.HkFacultyinfo;
import com.ruoyi.hk.service.IHkFacultyinfoService;

/**
 * 教职工请假信息Service业务层处理
 * 
 * @author 段佳帅
 * @date 2022-09-30
 */
@Service
public class HkFacultyinfoServiceImpl implements IHkFacultyinfoService 
{
    @Autowired
    private HkFacultyinfoMapper hkFacultyinfoMapper;

    /**
     * 查询教职工请假信息
     * 
     * @param id 教职工请假信息主键
     * @return 教职工请假信息
     */
    @Override
    public HkFacultyinfo selectHkFacultyinfoById(Long id)
    {
        return hkFacultyinfoMapper.selectHkFacultyinfoById(id);
    }

    /**
     * 查询教职工请假信息列表
     * 
     * @param hkFacultyinfo 教职工请假信息
     * @return 教职工请假信息
     */
    @Override
    public List<HkFacultyinfo> selectHkFacultyinfoList(HkFacultyinfo hkFacultyinfo)
    {
        return hkFacultyinfoMapper.selectHkFacultyinfoList(hkFacultyinfo);
    }

    /**
     * 新增教职工请假信息
     * 
     * @param hkFacultyinfo 教职工请假信息
     * @return 结果
     */
    @Override
    public int insertHkFacultyinfo(HkFacultyinfo hkFacultyinfo)
    {
        return hkFacultyinfoMapper.insertHkFacultyinfo(hkFacultyinfo);
    }

    /**
     * 修改教职工请假信息
     * 
     * @param hkFacultyinfo 教职工请假信息
     * @return 结果
     */
    @Override
    public int updateHkFacultyinfo(HkFacultyinfo hkFacultyinfo)
    {
        return hkFacultyinfoMapper.updateHkFacultyinfo(hkFacultyinfo);
    }

    /**
     * 批量删除教职工请假信息
     * 
     * @param ids 需要删除的教职工请假信息主键
     * @return 结果
     */
    @Override
    public int deleteHkFacultyinfoByIds(Long[] ids)
    {
        return hkFacultyinfoMapper.deleteHkFacultyinfoByIds(ids);
    }

    /**
     * 删除教职工请假信息信息
     * 
     * @param id 教职工请假信息主键
     * @return 结果
     */
    @Override
    public int deleteHkFacultyinfoById(Long id)
    {
        return hkFacultyinfoMapper.deleteHkFacultyinfoById(id);
    }
}
