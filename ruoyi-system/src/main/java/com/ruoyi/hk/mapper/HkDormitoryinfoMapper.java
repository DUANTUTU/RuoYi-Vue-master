package com.ruoyi.hk.mapper;

import java.util.List;
import com.ruoyi.hk.domain.HkDormitoryinfo;
import com.ruoyi.hk.domain.HkStudentinfo;

/**
 * 学生宿舍Mapper接口
 *
 * @author æ®µä½³å¸
 * @date 2022-10-11
 */
public interface HkDormitoryinfoMapper
{
    /**
     * 查询学生宿舍
     *
     * @param dormitoryid 学生宿舍主键
     * @return 学生宿舍
     */
    public HkDormitoryinfo selectHkDormitoryinfoByDormitoryid(Long dormitoryid);

    /**
     * 查询学生宿舍列表
     *
     * @param hkDormitoryinfo 学生宿舍
     * @return 学生宿舍集合
     */
    public List<HkDormitoryinfo> selectHkDormitoryinfoList(HkDormitoryinfo hkDormitoryinfo);
    /*
    * 查询所有学生的信息
    *
    * */
    public List<HkStudentinfo> selectHkStudentinfoList(HkStudentinfo hkStudentinfo);
    /**
     * 新增学生宿舍
     *
     * @param hkDormitoryinfo 学生宿舍
     * @return 结果
     */
    public int insertHkDormitoryinfo(HkDormitoryinfo hkDormitoryinfo);

    /**
     * 修改学生宿舍
     *
     * @param hkDormitoryinfo 学生宿舍
     * @return 结果
     */
    public int updateHkDormitoryinfo(HkDormitoryinfo hkDormitoryinfo);

    /**
     * 删除学生宿舍
     *
     * @param dormitoryid 学生宿舍主键
     * @return 结果
     */
    public int deleteHkDormitoryinfoByDormitoryid(Long dormitoryid);

    /**
     * 批量删除学生宿舍
     *
     * @param dormitoryids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHkDormitoryinfoByDormitoryids(Long[] dormitoryids);

    /**
     * 批量删除${subTable.functionName}
     *
     * @param dormitoryids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHkStudentinfoByDormitoryIds(Long[] dormitoryids);

    /**
     * 批量新增${subTable.functionName}
     *
     * @param hkStudentinfoList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchHkStudentinfo(List<HkStudentinfo> hkStudentinfoList);


    /**
     * 通过学生宿舍主键删除${subTable.functionName}信息
     *
     * @param dormitoryid 学生宿舍ID
     * @return 结果
     */
    public int deleteHkStudentinfoByDormitoryId(Long dormitoryid);
}
