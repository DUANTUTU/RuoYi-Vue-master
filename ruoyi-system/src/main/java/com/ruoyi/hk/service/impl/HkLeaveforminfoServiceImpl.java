package com.ruoyi.hk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hk.mapper.HkLeaveforminfoMapper;
import com.ruoyi.hk.domain.HkLeaveforminfo;
import com.ruoyi.hk.service.IHkLeaveforminfoService;

/**
 * 学生请假Service业务层处理
 *
 * @author 段佳帅
 * @date 2022-09-20
 */
@Service
public class HkLeaveforminfoServiceImpl implements IHkLeaveforminfoService
{
    @Autowired
    private HkLeaveforminfoMapper hkLeaveforminfoMapper;

    /**
     * 查询学生请假
     *
     * @param id 学生请假主键
     * @return 学生请假
     */
    @Override
    public HkLeaveforminfo selectHkLeaveforminfoById(Long id)
    {
        return hkLeaveforminfoMapper.selectHkLeaveforminfoById(id);
    }

    /**
     * 查询学生请假列表
     *
     * @param hkLeaveforminfo 学生请假
     * @return 学生请假
     */
    @Override
    public List<HkLeaveforminfo> selectHkLeaveforminfoList(HkLeaveforminfo hkLeaveforminfo)
    {
        return hkLeaveforminfoMapper.selectHkLeaveforminfoList(hkLeaveforminfo);
    }

    /**
     * 新增学生请假
     *
     * @param hkLeaveforminfo 学生请假
     * @return 结果
     */
    @Override
    public int insertHkLeaveforminfo(HkLeaveforminfo hkLeaveforminfo)
    {
        return hkLeaveforminfoMapper.insertHkLeaveforminfo(hkLeaveforminfo);
    }

    /**
     * 修改学生请假
     *
     * @param hkLeaveforminfo 学生请假
     * @return 结果
     */
    @Override
    public int updateHkLeaveforminfo(HkLeaveforminfo hkLeaveforminfo)
    {
        return hkLeaveforminfoMapper.updateHkLeaveforminfo(hkLeaveforminfo);
    }

    /**
     * 批量删除学生请假
     *
     * @param ids 需要删除的学生请假主键
     * @return 结果
     */
    @Override
    public int deleteHkLeaveforminfoByIds(Long[] ids)
    {
        return hkLeaveforminfoMapper.deleteHkLeaveforminfoByIds(ids);
    }

    /**
     * 删除学生请假信息
     *
     * @param id 学生请假主键
     * @return 结果
     */
    @Override
    public int deleteHkLeaveforminfoById(Long id)
    {
        return hkLeaveforminfoMapper.deleteHkLeaveforminfoById(id);
    }

    @Override
    public String getHkLeaveforminfoUserNameById(Long userid) {
        return hkLeaveforminfoMapper.getHkLeaveforminfoUserName(userid);
    }
}
