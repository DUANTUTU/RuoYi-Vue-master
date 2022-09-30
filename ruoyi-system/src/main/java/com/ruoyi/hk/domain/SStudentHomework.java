package com.ruoyi.hk.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 查看作业对象 s_student_homework
 *
 * @author BahetCoder
 * @date 2021-06-04
 */
public class SStudentHomework extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学生id */
    @Excel(name = "学生id")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /**班级ID*/
    private Long stuclassid;

    /**班级名称*/
    private String stuclassname;

    /** 作业id */
    @Excel(name = "作业id")
    private Long homeworkId;

    /** 作业标题 */
    @Excel(name = "作业标题")
    private String homeworkTitle;

    /** 作业内容 */
    @Excel(name = "作业内容")
    private String homeworkContent;

    /** 作业评分 */
    @Excel(name = "作业评分")
    private BigDecimal homeworkScore;


    /** 状态(0已完成，1已批改) */
    @Excel(name = "状态(0已完成，1已批改)")
    private int state;

    /**
     * 教师ID
     */
    private Long teacherId;

    public Long getTeacherId() {
        return teacherId;
    }

    public Long getStuclassid() { return stuclassid; }

    public void setStuclassid(Long stuclassid) { this.stuclassid = stuclassid; }

    public String getStuclassname() { return stuclassname; }

    public void setStuclassname(String stuclassname) { this.stuclassname = stuclassname; }

    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentId()
    {
        return studentId;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public void setHomeworkId(Long homeworkId)
    {
        this.homeworkId = homeworkId;
    }

    public Long getHomeworkId()
    {
        return homeworkId;
    }
    public void setHomeworkTitle(String homeworkTitle)
    {
        this.homeworkTitle = homeworkTitle;
    }

    public String getHomeworkTitle()
    {
        return homeworkTitle;
    }
    public void setHomeworkContent(String homeworkContent)
    {
        this.homeworkContent = homeworkContent;
    }

    public String getHomeworkContent()
    {
        return homeworkContent;
    }
    public void setHomeworkScore(BigDecimal homeworkScore)
    {
        this.homeworkScore = homeworkScore;
    }

    public BigDecimal getHomeworkScore()
    {
        return homeworkScore;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("studentId", getStudentId())
                .append("stuclassid",getStuclassid())
                .append("stucalssname",getStuclassname())
                .append("studentName", getStudentName())
                .append("homeworkId", getHomeworkId())
                .append("homeworkTitle", getHomeworkTitle())
                .append("homeworkContent", getHomeworkContent())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("homeworkScore", getHomeworkScore())
                .append("remark", getRemark())
                .append("state", getState())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
