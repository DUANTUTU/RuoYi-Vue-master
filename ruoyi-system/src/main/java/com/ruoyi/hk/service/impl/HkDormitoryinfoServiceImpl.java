package com.ruoyi.hk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.hk.domain.HkStudentinfo;
import com.ruoyi.hk.mapper.HkDormitoryinfoMapper;
import com.ruoyi.hk.domain.HkDormitoryinfo;
import com.ruoyi.hk.service.IHkDormitoryinfoService;

/**
 * 学生宿舍Service业务层处理
 *
 * @author duan
 * @date 2022-10-11
 */
@Service
public class HkDormitoryinfoServiceImpl implements IHkDormitoryinfoService
{
    @Autowired
    private HkDormitoryinfoMapper hkDormitoryinfoMapper;

    /**
     * 查询学生宿舍
     *
     * @param dormitoryid 学生宿舍主键
     * @return 学生宿舍
     */
    @Override
    public HkDormitoryinfo selectHkDormitoryinfoByDormitoryid(Long dormitoryid)
    {
        return hkDormitoryinfoMapper.selectHkDormitoryinfoByDormitoryid(dormitoryid);
    }

    /**
     * 查询学生宿舍列表
     *
     * @param hkDormitoryinfo 学生宿舍
     * @return 学生宿舍
     */
    @Override
    public List<HkDormitoryinfo> selectHkDormitoryinfoList(HkDormitoryinfo hkDormitoryinfo)
    {
        return hkDormitoryinfoMapper.selectHkDormitoryinfoList(hkDormitoryinfo);
    }
    public List<HkStudentinfo> selectHkStudentinfoList(HkStudentinfo hkStudentinfo)
    {
        return hkDormitoryinfoMapper.selectHkStudentinfoList(hkStudentinfo);
    }
    /**
     * 新增学生宿舍
     *
     * @param hkDormitoryinfo 学生宿舍
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHkDormitoryinfo(HkDormitoryinfo hkDormitoryinfo)
    {
        int rows = hkDormitoryinfoMapper.insertHkDormitoryinfo(hkDormitoryinfo);
        insertHkStudentinfo(hkDormitoryinfo);
        return rows;
    }

    /**
     * 修改学生宿舍
     *
     * @param hkDormitoryinfo 学生宿舍
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHkDormitoryinfo(HkDormitoryinfo hkDormitoryinfo)
    {
        hkDormitoryinfoMapper.deleteHkStudentinfoByDormitoryId(hkDormitoryinfo.getDormitoryid());
        insertHkStudentinfo(hkDormitoryinfo);
        return hkDormitoryinfoMapper.updateHkDormitoryinfo(hkDormitoryinfo);
    }

    /**
     * 批量删除学生宿舍
     *
     * @param dormitoryids 需要删除的学生宿舍主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHkDormitoryinfoByDormitoryids(Long[] dormitoryids)
    {
        hkDormitoryinfoMapper.deleteHkStudentinfoByDormitoryIds(dormitoryids);
        return hkDormitoryinfoMapper.deleteHkDormitoryinfoByDormitoryids(dormitoryids);
    }

    /**
     * 删除学生宿舍信息
     *
     * @param dormitoryid 学生宿舍主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHkDormitoryinfoByDormitoryid(Long dormitoryid)
    {
        hkDormitoryinfoMapper.deleteHkStudentinfoByDormitoryId(dormitoryid);
        return hkDormitoryinfoMapper.deleteHkDormitoryinfoByDormitoryid(dormitoryid);
    }

    /**
     * 新增${subTable.functionName}信息
     *
     * @param hkDormitoryinfo 学生宿舍对象
     */
    public void insertHkStudentinfo(HkDormitoryinfo hkDormitoryinfo)
    {
        List<HkStudentinfo> hkStudentinfoList = hkDormitoryinfo.getHkStudentinfoList();
        Long dormitoryid = hkDormitoryinfo.getDormitoryid();
        if (StringUtils.isNotNull(hkStudentinfoList))
        {
            List<HkStudentinfo> list = new ArrayList<HkStudentinfo>();
            for (HkStudentinfo hkStudentinfo : hkStudentinfoList)
            {
                hkStudentinfo.setDormitoryid(dormitoryid);
                list.add(hkStudentinfo);
            }
            if (list.size() > 0)
            {
                hkDormitoryinfoMapper.batchHkStudentinfo(list);
            }
        }
    }
}
