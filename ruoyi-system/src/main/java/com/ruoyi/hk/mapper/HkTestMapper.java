package com.ruoyi.hk.mapper;

import com.ruoyi.hk.domain.HkTest;

import java.util.List;


/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-09-20
 */
public interface HkTestMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public HkTest selectHkTestById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param hkTest 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HkTest> selectHkTestList(HkTest hkTest);

    /**
     * 新增【请填写功能名称】
     *
     * @param hkTest 【请填写功能名称】
     * @return 结果
     */
    public int insertHkTest(HkTest hkTest);

    /**
     * 修改【请填写功能名称】
     *
     * @param hkTest 【请填写功能名称】
     * @return 结果
     */
    public int updateHkTest(HkTest hkTest);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteHkTestById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHkTestByIds(Long[] ids);
}
