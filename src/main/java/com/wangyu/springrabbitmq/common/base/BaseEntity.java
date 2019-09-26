package com.wangyu.springrabbitmq.common.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基类
 *
 * @Author wangyu
 * @Date 2019/9/26 10:37
 * @Version 1.0
 */
public class BaseEntity implements Serializable {

  /**
   * ID
   */
  private String id;

  /**
   * 创建时间
   */
  private Date createDate;

  /**
   * 修改时间
   */
  private Date modifyDate;

  /**
   * 删除标识 true: 删除 false:未删除
   */
  private Boolean delFlag;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Boolean getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(Boolean delFlag) {
    this.delFlag = delFlag;
  }
}
