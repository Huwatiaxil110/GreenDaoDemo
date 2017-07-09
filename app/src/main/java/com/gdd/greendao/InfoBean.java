package com.gdd.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class InfoBean {
    //表ID，是每一条记录的唯一标识,自增
    @Id(autoincrement = true)
    private Long tabid;
    /** 班型ID */
    private Integer classTypeId;
    /** 班型编码 */
    private String classTypeCode;
    /** 班型名称 */
    private String classTypeName;
    /** 分期 */
    private Integer period;
    /** 年级 */
    private Integer gradeId;
    /** 科目 */
    private Integer subjectId;
    /** 学科 */
    private Integer subjectProductId;
    @Generated(hash = 884779250)
    public InfoBean(Long tabid, Integer classTypeId, String classTypeCode,
            String classTypeName, Integer period, Integer gradeId,
            Integer subjectId, Integer subjectProductId) {
        this.tabid = tabid;
        this.classTypeId = classTypeId;
        this.classTypeCode = classTypeCode;
        this.classTypeName = classTypeName;
        this.period = period;
        this.gradeId = gradeId;
        this.subjectId = subjectId;
        this.subjectProductId = subjectProductId;
    }
    @Generated(hash = 134777477)
    public InfoBean() {
    }
    public Long getTabid() {
        return this.tabid;
    }
    public void setTabid(Long tabid) {
        this.tabid = tabid;
    }
    public Integer getClassTypeId() {
        return this.classTypeId;
    }
    public void setClassTypeId(Integer classTypeId) {
        this.classTypeId = classTypeId;
    }
    public String getClassTypeCode() {
        return this.classTypeCode;
    }
    public void setClassTypeCode(String classTypeCode) {
        this.classTypeCode = classTypeCode;
    }
    public String getClassTypeName() {
        return this.classTypeName;
    }
    public void setClassTypeName(String classTypeName) {
        this.classTypeName = classTypeName;
    }
    public Integer getPeriod() {
        return this.period;
    }
    public void setPeriod(Integer period) {
        this.period = period;
    }
    public Integer getGradeId() {
        return this.gradeId;
    }
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
    public Integer getSubjectId() {
        return this.subjectId;
    }
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
    public Integer getSubjectProductId() {
        return this.subjectProductId;
    }
    public void setSubjectProductId(Integer subjectProductId) {
        this.subjectProductId = subjectProductId;
    }

    @Override
    public String toString() {
        return "InfoBean{" +
                "tabid=" + tabid +
                ", classTypeId=" + classTypeId +
                ", classTypeCode='" + classTypeCode + '\'' +
                ", classTypeName='" + classTypeName + '\'' +
                ", period=" + period +
                ", gradeId=" + gradeId +
                ", subjectId=" + subjectId +
                ", subjectProductId=" + subjectProductId +
                '}';
    }
}
