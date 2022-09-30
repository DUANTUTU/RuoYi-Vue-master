package com.ruoyi.hk.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教职工请假信息对象 hk_facultyinfo
 *
 * @author 段佳帅
 * @date 2022-09-30
 */
public class HkFacultyinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假事Id */
    private Long id;

    /** 请假人员ID */
    @Excel(name = "请假人员ID")
    private Long userid;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date begintime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishtime;

    /** 原因 */
    @Excel(name = "原因")
    private String reason;
    @Excel(name="姓名")
    private String name;
    /** 状态 */
    @Excel(name = "状态")
    private String sataus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }
    public void setBegintime(Date begintime)
    {
        this.begintime = begintime;
    }

    public Date getBegintime()
    {
        return begintime;
    }
    public void setFinishtime(Date finishtime)
    {
        this.finishtime = finishtime;
    }

    public Date getFinishtime()
    {
        return finishtime;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }
    public void setSataus(String sataus)
    {
        this.sataus = sataus;
    }

    public String getSataus()
    {
        return sataus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("begintime", getBegintime())
            .append("finishtime", getFinishtime())
            .append("reason", getReason())
            .append("sataus", getSataus())
            .toString();
    }
}
