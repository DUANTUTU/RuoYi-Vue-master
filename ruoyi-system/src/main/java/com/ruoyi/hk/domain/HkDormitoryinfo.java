package com.ruoyi.hk.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生宿舍对象 hk_dormitoryInfo
 *
 * @author æ®µä½³å¸
 * @date 2022-10-11
 */
public class HkDormitoryinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍号 */
    private Long dormitoryid;

    /** 所归属的班级 */
    @Excel(name = "所归属的班级")
    private Long classid;
    @Excel(name = "宿舍成员姓名")
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    /** $table.subTable.functionName信息 */
    private List<HkStudentinfo> hkStudentinfoList;

    public void setDormitoryid(Long dormitoryid)
    {
        this.dormitoryid = dormitoryid;
    }

    public Long getDormitoryid()
    {
        return dormitoryid;
    }
    public void setClassid(Long classid)
    {
        this.classid = classid;
    }

    public Long getClassid()
    {
        return classid;
    }

    public List<HkStudentinfo> getHkStudentinfoList()
    {
        return hkStudentinfoList;
    }

    public void setHkStudentinfoList(List<HkStudentinfo> hkStudentinfoList)
    {
        this.hkStudentinfoList = hkStudentinfoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dormitoryid", getDormitoryid())
            .append("classid", getClassid())
            .append("hkStudentinfoList", getHkStudentinfoList())
            .toString();
    }
}
