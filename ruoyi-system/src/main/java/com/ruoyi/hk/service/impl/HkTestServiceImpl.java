package com.ruoyi.hk.service.impl;

import java.util.List;

import com.ruoyi.hk.domain.HkTest;
import com.ruoyi.hk.mapper.HkTestMapper;
import com.ruoyi.hk.service.IHkTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-20
 */
@Service
public class HkTestServiceImpl implements IHkTestService
{
    @Autowired
    private HkTestMapper hkTestMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public HkTest selectHkTestById(Long id)
    {
        return hkTestMapper.selectHkTestById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param hkTest 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<HkTest> selectHkTestList(HkTest hkTest)
    {
        return hkTestMapper.selectHkTestList(hkTest);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param hkTest 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHkTest(HkTest hkTest)
    {
        return hkTestMapper.insertHkTest(hkTest);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param hkTest 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHkTest(HkTest hkTest)
    {
        return hkTestMapper.updateHkTest(hkTest);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteHkTestByIds(Long[] ids)
    {
        return hkTestMapper.deleteHkTestByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteHkTestById(Long id)
    {
        return hkTestMapper.deleteHkTestById(id);
    }
}
