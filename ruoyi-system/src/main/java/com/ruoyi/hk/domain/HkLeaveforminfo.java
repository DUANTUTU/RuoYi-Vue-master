package com.ruoyi.hk.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生请假对象 hk_leaveforminfo
 * 
 * @author 段佳帅
 * @date 2022-09-20
 */
public class HkLeaveforminfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假事务id */
    private Long id;

    /** 请假人员Id */
    @Excel(name = "请假人员Id")
    private Long userid;

    /** 请假起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date begintime;

    /** 请假结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishtime;

    /** 请假原因 */
    @Excel(name = "请假原因")
    private String reason;

    /** 状态 */
    @Excel(name = "状态")
    private Long sataus;

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
    public void setSataus(Long sataus) 
    {
        this.sataus = sataus;
    }

    public Long getSataus() 
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
