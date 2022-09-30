package com.ruoyi.hk.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 hk_studentinfo
 *
 * @author ruoyi
 * @date 2022-09-29
 */
public class HkStudentinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 班级id */
    @Excel(name = "班级id")
    private Long classid;

    /** 电话 */
    @Excel(name = "电话")
    private String tel;

    /** 学院id */
    @Excel(name = "学院id")
    private Long collegeid;

    /** 宿舍id */
    @Excel(name = "宿舍id")
    private Long dormitoryid;

    /** 学生所处于状态  1正常 0异常 */
    @Excel(name = "学生所处于状态  1正常 0异常")
    private String status;

    /** 学号 */
    @Excel(name = "学号")
    private Long userid;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setClassid(Long classid)
    {
        this.classid = classid;
    }

    public Long getClassid()
    {
        return classid;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getTel()
    {
        return tel;
    }
    public void setCollegeid(Long collegeid)
    {
        this.collegeid = collegeid;
    }

    public Long getCollegeid()
    {
        return collegeid;
    }
    public void setDormitoryid(Long dormitoryid)
    {
        this.dormitoryid = dormitoryid;
    }

    public Long getDormitoryid()
    {
        return dormitoryid;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("age", getAge())
                .append("sex", getSex())
                .append("grade", getGrade())
                .append("classid", getClassid())
                .append("tel", getTel())
                .append("collegeid", getCollegeid())
                .append("dormitoryid", getDormitoryid())
                .append("status", getStatus())
                .append("userid", getUserid())
                .toString();
    }
}
