package com.ruoyi.system.api.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 系统访问记录表 sys_logininfor
 *
 * @author ruoyi
 */
@Data
public class SysLogininfor extends BaseEntity<SysLogininfor> {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer infoId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 状态 0成功 1失败
     */
    private String status;

    /**
     * 地址
     */
    private String ipaddr;

    /**
     * 描述
     */
    private String msg;

    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date accessTime;

}