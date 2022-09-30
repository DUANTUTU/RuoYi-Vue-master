package com.ruoyi.hk.mapper;

import com.ruoyi.hk.domain.SStudentHomework;

import java.util.List;


/**
 * 查看作业Mapper接口
 *
 * @author BahetCoder
 * @date 2021-06-04
 */
public interface SStudentHomeworkMapper
{
    /**
     * 查询查看作业
     *
     * @param id 查看作业ID
     * @return 查看作业
     */
    public SStudentHomework selectSStudentHomeworkById(Long id);

    /**
     * 查询查看作业列表
     *
     * @param sStudentHomework 查看作业
     * @return 查看作业集合
     */
    public List<SStudentHomework> selectSStudentHomeworkList(SStudentHomework sStudentHomework);

    /**
     * 新增查看作业
     *
     * @param sStudentHomework 查看作业
     * @return 结果
     */
    public int insertSStudentHomework(SStudentHomework sStudentHomework);

    /**
     * 修改查看作业
     *
     * @param sStudentHomework 查看作业
     * @return 结果
     */
    public int updateSStudentHomework(SStudentHomework sStudentHomework);

    /**
     * 删除查看作业
     *
     * @param id 查看作业ID
     * @return 结果
     */
    public int deleteSStudentHomeworkById(Long id);

    /**
     * 批量删除查看作业
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSStudentHomeworkByIds(String[] ids);

    public SStudentHomework selectSStudentHomeworkByHomeworkId(Long id);
}
