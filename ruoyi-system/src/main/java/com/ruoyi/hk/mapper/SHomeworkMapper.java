package com.ruoyi.hk.mapper;

import com.ruoyi.hk.domain.SHomework;

import java.util.List;


/**
 * 作业Mapper接口
 *
 * @author BahetCoder
 * @date 2021-06-04
 */
public interface SHomeworkMapper
{
    /**
     * 查询作业
     *
     * @param id 作业ID
     * @return 作业
     */
    public SHomework selectSHomeworkById(Long id);

    /**
     * 查询作业列表
     *
     * @param sHomework 作业
     * @return 作业集合
     */
    public List<SHomework> selectSHomeworkList(SHomework sHomework);

    /**
     * 新增作业
     *
     * @param sHomework 作业
     * @return 结果
     */
    public int insertSHomework(SHomework sHomework);

    /**
     * 修改作业
     *
     * @param sHomework 作业
     * @return 结果
     */
    public int updateSHomework(SHomework sHomework);

    /**
     * 删除作业
     *
     * @param id 作业ID
     * @return 结果
     */
    public int deleteSHomeworkById(Long id);

    /**
     * 批量删除作业
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSHomeworkByIds(String[] ids);
}
