package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 岗位表 sys_post
 *
 * @author ruoyi
 */
@Data
public class SysPost extends BaseEntity<SysPost> {
    private static final long serialVersionUID = 1L;

    /**
     * 岗位序号
     */
    @TableId
    private Integer postId;

    /**
     * 岗位编码
     */
    @TableField(condition = SqlCondition.LIKE)
    private String postCode;

    /**
     * 岗位名称
     */
    @TableField(condition = SqlCondition.LIKE)
    private String postName;

    /**
     * 岗位排序
     */
    private Integer postSort;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 用户是否存在此岗位标识 默认不存在
     */
    @TableField(exist = false)
    private boolean flag = false;
}
