package com.ruoyi.hk.service;

import java.util.List;
import com.ruoyi.hk.domain.HkLeaveforminfo;

/**
 * 学生请假Service接口
 *
 * @author 段佳帅
 * @date 2022-09-20
 */
public interface IHkLeaveforminfoService
{
    /**
     * 查询学生请假
     *
     * @param id 学生请假主键
     * @return 学生请假
     */
    public HkLeaveforminfo selectHkLeaveforminfoById(Long id);

    /**
     * 查询学生请假列表
     *
     * @param hkLeaveforminfo 学生请假
     * @return 学生请假集合
     */
    public List<HkLeaveforminfo> selectHkLeaveforminfoList(HkLeaveforminfo hkLeaveforminfo);

    /**
     * 新增学生请假
     *
     * @param hkLeaveforminfo 学生请假
     * @return 结果
     */
    public int insertHkLeaveforminfo(HkLeaveforminfo hkLeaveforminfo);

    /**
     * 修改学生请假
     *
     * @param hkLeaveforminfo 学生请假
     * @return 结果
     */
    public int updateHkLeaveforminfo(HkLeaveforminfo hkLeaveforminfo);

    /**
     * 批量删除学生请假
     *
     * @param ids 需要删除的学生请假主键集合
     * @return 结果
     */
    public int deleteHkLeaveforminfoByIds(Long[] ids);

    /**
     * 删除学生请假信息
     *
     * @param id 学生请假主键
     * @return 结果
     */
    public int deleteHkLeaveforminfoById(Long id);
    /*
    * 获取学生姓名
    *
    * @param userid 学生学号
    *
    * */
    public String getHkLeaveforminfoUserNameById(Long userid);
}
